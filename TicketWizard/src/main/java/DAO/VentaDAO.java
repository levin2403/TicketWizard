/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.Boleto;
import Entidades.Persona;
import Entidades.Venta;
import Excepciones.DAOException;
import InterfacesDAO.IVentaDAO;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author skevi
 */
public class VentaDAO implements IVentaDAO{
    
    private static final Logger logger = Logger.getLogger(EventoDAO.class.getName());
    private final Conexion conexion;
    private final PersonaDAO personaDAO;
    private final BoletoDAO boletoDAO;

    public VentaDAO() {
        this.conexion = new Conexion();
        this.personaDAO = new PersonaDAO();
        this.boletoDAO = new BoletoDAO();
    }

    /**
     * 
     * @param idPersona
     * @param limit
     * @param offset
     * @param id_evento
     * @return 
     * @throws Excepciones.DAOException 
     */
    @Override
    public List<Venta> obtenerVentasPaginadas(int idPersona, int id_evento, int limit, 
            int offset) throws DAOException {
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT v.* FROM Venta v "
                   + "INNER JOIN Boleto b ON v.id_boleto = b.id "
                   + "WHERE v.id_persona != ? AND b.id_evento = ? "
                   + "LIMIT ? OFFSET ?";

        try (Connection conn = conexion.crearConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idPersona); // Excluir el ID de la persona en sesión
            pstmt.setInt(2, id_evento); // Filtrar por ID del evento
            pstmt.setInt(3, limit);     // Límite de resultados por página
            pstmt.setInt(4, offset);    // Offset (para paginación)

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Venta venta = new Venta();
                venta.setId(rs.getInt("id"));
                venta.setPersona(personaDAO.
                        obtenerPersonaPorId(rs.getInt("id_persona")));
                venta.setBoleto(boletoDAO.
                        obtenerBoletoPorId(rs.getInt("id_boleto")));
                venta.setPrecio_reventa(rs.getBigDecimal("precio_venta"));
                venta.setFecha_limite(rs.getDate("fecha_limite_venta"));
                venta.setEstado(rs.getString("estado"));
                ventas.add(venta);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo obtener las ventas paginadas ", 
                    ex);
            throw new DAOException("Error al obtener las ventas paginadas ", 
                    ex);
        }
        logger.info("Boletos para venta obtenidos con éxito");
        return ventas;
    }
    
    
    /**
     * 
     * @param idPersona
     * @param precioMin
     * @param precioMax
     * @param limit
     * @param offset
     * @param id_evento
     * @return 
     * @throws Excepciones.DAOException 
     */
    @Override
    public List<Venta> obtenerVentasPaginadasPorPrecio(int idPersona, int id_evento, 
            BigDecimal precioMin, BigDecimal precioMax, int limit, 
            int offset) throws DAOException {
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT v.* FROM Venta v "
                   + "INNER JOIN Boleto b ON v.id_boleto = b.id "
                   + "WHERE v.id_persona != ? AND b.id_evento = ? "
                   + "AND v.precio_reventa BETWEEN ? AND ? "
                   + "LIMIT ? OFFSET ?";

        try (Connection conn = conexion.crearConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idPersona);       // Excluir el ID de la persona en sesión
            pstmt.setInt(2, id_evento);       // Filtrar por ID del evento
            pstmt.setBigDecimal(3, precioMin); // Precio mínimo
            pstmt.setBigDecimal(4, precioMax); // Precio máximo
            pstmt.setInt(5, limit);           // Límite de resultados por página
            pstmt.setInt(6, offset);          // Offset (para paginación)

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Venta venta = new Venta();
                venta.setId(rs.getInt("id"));
                venta.setPersona(personaDAO.
                        obtenerPersonaPorId(rs.getInt("id_persona")));
                venta.setBoleto(boletoDAO.
                        obtenerBoletoPorId(rs.getInt("id_boleto")));
                venta.setPrecio_reventa(rs.getBigDecimal("precio_venta"));
                venta.setFecha_limite(rs.getDate("fecha_limite_venta"));
                venta.setEstado(rs.getString("estado"));
                ventas.add(venta);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al obtener las ventas por rango en "
                    + "DAO", ex);
            throw new DAOException("Error al obtener las ventas");
        }

        logger.info("Boletos para venta obtenidos con éxito");
        return ventas;
    }

    /**
     * 
     * @param id_comprador
     * @return
     * @throws DAOException 
     */
    @Override
    public Venta obtenerVentaApartada(int id_comprador) throws DAOException {
        Venta venta = null;
        String sql = "SELECT va.id, va.id_venta, v.id_persona, v.id_boleto, "
                + "v.precio_reventa, v.fecha_limite_venta "
                   + "FROM VentaApartada va "
                   + "INNER JOIN Venta v ON va.id_venta = v.id "
                   + "WHERE v.id_persona = ?";

        try (Connection conn = conexion.crearConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id_comprador);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                venta = new Venta();
                venta.setId(rs.getInt("id_venta")); // ID de la venta original
                venta.setPersona(personaDAO.
                        obtenerPersonaPorId(rs.getInt("id_persona")));
                venta.setBoleto(boletoDAO.
                        obtenerBoletoPorId(rs.getInt("id_boleto")));
                venta.setPrecio_reventa(rs.getBigDecimal("precio_reventa"));
                venta.setFecha_limite(rs.getDate("fecha_limite_venta"));
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al obtener la venta apartada para "
                    + "el comprador con ID: " + id_comprador, ex);
            throw new DAOException("Error al obtener la venta apartada");
        }

        if (venta != null) {
            logger.info("Venta apartada obtenida con éxito para el comprador "
                    + "con ID: " + id_comprador);
        } else {
            logger.info("No se encontró ninguna venta apartada para el "
                    + "comprador con ID: " + id_comprador);
        }

        return venta;
    }

    /**
     * 
     * @param venta
     * @throws DAOException 
     */
    @Override
    public void RegistrarVenta(Venta venta) throws DAOException {
        Connection conn = null;
        PreparedStatement pstmtVenta = null;

        try {
            // Obtener conexión utilizando la clase Conexion
            Conexion conexion = new Conexion();
            conn = conexion.crearConexion();

            // Verificar si la conexión es válida
            if (conn == null) {
                logger.log(Level.SEVERE, "No se pudo establecer la conexión a "
                        + "la base de datos.");
                throw new DAOException("Error al establecer la conexión a la "
                        + "base de datos.");
            }

            // Deshabilitar auto-commit para gestionar la transacción manualmente
            conn.setAutoCommit(false);

            // Insertar la nueva venta
            String sqlInsertVenta = "INSERT INTO Venta (id_persona, id_boleto, "
                    + "precio_reventa, fecha_limite_venta) "
                                  + "VALUES (?, ?, ?, ?)";
            pstmtVenta = conn.prepareStatement(sqlInsertVenta);

            // Configurar los parámetros de la venta
            pstmtVenta.setInt(1, venta.getPersona().getId());          // id_persona
            pstmtVenta.setInt(2, venta.getBoleto().getId());           // id_boleto
            pstmtVenta.setBigDecimal(3, venta.getPrecio_reventa());    // precio_reventa
            pstmtVenta.setDate(4, 
                    new java.sql.Date(venta.getFecha_limite().getTime()));  // fecha_limite_venta

            // Ejecutar la inserción
            pstmtVenta.executeUpdate();

            // Confirmar la transacción si todo sale bien
            conn.commit();
            logger.info("Venta registrada con éxito.");

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al registrar la venta: {0}", 
                    e.getMessage());
            if (conn != null) {
                try {
                    // Si ocurre un error, se realiza el rollback
                    conn.rollback();
                    logger.log(Level.INFO, "Se ha realizado un rollback de la "
                            + "transacción.");
                } catch (SQLException ex) {
                    logger.log(Level.SEVERE, "Error al realizar el rollback: "
                            + "{0}", ex.getMessage());
                }
            }
            throw new DAOException("Error al registrar la venta.");
        } finally {
            // Cerrar recursos en el orden adecuado
            try {
                if (pstmtVenta != null) pstmtVenta.close();
                if (conn != null) conn.setAutoCommit(true); // Restaurar el auto-commit
                if (conn != null) conn.close();
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Error al cerrar los recursos: "
                        + "{0}", e.getMessage());
            }
        }
    }


    /**
     * 
     * @param vendedor
     * @param comprador
     * @param boleto
     * @param precio
     * @param numero_serie
     * @throws DAOException 
     */
    @Override
    public void RealizarVentaApartada(Persona vendedor, Persona comprador, 
                                       Boleto boleto, BigDecimal precio, 
                                       String numero_serie) throws DAOException {
        Connection conn = null;
        CallableStatement cstmt = null;

        try {
            // Obtener conexión utilizando la clase Conexion
            Conexion conexion = new Conexion();
            conn = conexion.crearConexion();

            // Verificar si la conexión es válida
            if (conn == null) {
                logger.log(Level.SEVERE, "No se pudo establecer la "
                        + "conexión a la base de datos.");
                throw new DAOException("No se pudo establecer la "
                        + "conexión a la base de datos.");
            }

            // Preparar el llamado al stored procedure
            String sql = "{CALL RealizarVentaApartada(?, ?, ?, ?, ?)}";
            cstmt = conn.prepareCall(sql);
            cstmt.setInt(1, vendedor.getId());
            cstmt.setInt(2, comprador.getId());
            cstmt.setInt(3, boleto.getId());
            cstmt.setBigDecimal(4, precio);
            cstmt.setString(5, numero_serie);

            // Ejecutar el stored procedure
            cstmt.executeUpdate();
            logger.info("Venta apartada realizada con éxito.");

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al realizar la venta apartada: {0}", 
                    e.getMessage());
            throw new DAOException("Error al realizar la venta apartada");

        } finally {
            // Cerrar los recursos en el orden correcto
            try {
                if (cstmt != null) cstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Error al cerrar los recursos: {0}", 
                        e.getMessage());
            }
        }
    }


    /**
     * 
     * @param vendedor
     * @param comprador
     * @param boleto
     * @param precio
     * @param numero_serie
     * @throws DAOException 
     */
    @Override
    public void RealizarVenta(Persona vendedor, Persona comprador, 
                              Boleto boleto, BigDecimal precio, 
                              String numero_serie) throws DAOException {
        Connection conn = null;
        CallableStatement cstmt = null;

        try {
            // Obtener conexión utilizando la clase Conexion
            Conexion conexion = new Conexion();
            conn = conexion.crearConexion();

            // Verificar si la conexión es válida
            if (conn == null) {
                logger.log(Level.SEVERE, "No se pudo establecer la conexión a "
                        + "la base de datos.");
                throw new DAOException("No se pudo establecer la conexión a la "
                        + "base de datos.");
            }

            // Preparar el llamado al stored procedure
            String sql = "{CALL RealizarVenta(?, ?, ?, ?, ?)}";
            cstmt = conn.prepareCall(sql);
            cstmt.setInt(1, vendedor.getId());
            cstmt.setInt(2, comprador.getId());
            cstmt.setInt(3, boleto.getId());
            cstmt.setBigDecimal(4, precio);
            cstmt.setString(5, numero_serie);

            // Ejecutar el stored procedure
            cstmt.executeUpdate();
            logger.info("Venta realizada con éxito.");

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al realizar la venta: {0}", 
                    e.getMessage());
            throw new DAOException("Error al realizar la venta");

        } finally {
            // Cerrar los recursos en el orden correcto
            try {
                if (cstmt != null) cstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Error al cerrar los recursos: {0}", 
                        e.getMessage());
            }
        }
    }


    @Override
    public void ApartarVenta(Persona comprador, Venta venta) 
            throws DAOException {
        Connection conn = null;
        CallableStatement cstmt = null;

        try {
            // Obtener conexión utilizando la clase Conexion
            Conexion conexion = new Conexion();
            conn = conexion.crearConexion();

            // Verificar si la conexión es válida
            if (conn == null) {
                logger.log(Level.SEVERE, "No se pudo establecer la conexión "
                        + "a la base de datos.");
                throw new DAOException("No se pudo establecer la conexión a "
                        + "la base de datos.");
            }

            // Preparar el llamado al stored procedure
            String sql = "{CALL ApartarVenta(?, ?)}";
            cstmt = conn.prepareCall(sql);
            cstmt.setInt(1, comprador.getId());
            cstmt.setInt(2, venta.getId());

            // Ejecutar el stored procedure
            cstmt.executeUpdate();
            logger.info("Venta apartada realizada con éxito.");

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al apartar la venta: {0}", 
                    e.getMessage());
            throw new DAOException("Error al apartar la venta");

        } finally {
            // Cerrar los recursos en el orden correcto
            try {
                if (cstmt != null) cstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Error al cerrar los recursos: {0}", 
                        e.getMessage());
            }
        }
    }

    
    
    
    
 }

    

