/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.Persona_Boleto;
import Entidades.Tipo_boleto;
import Excepciones.DAOException;
import InterfacesDAO.IPersona_boletoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skevi
 */
public class Persona_BoletoDAO implements IPersona_boletoDAO{

    private final Conexion conexion;
    private final BoletoDAO boletoDAO;

    public Persona_BoletoDAO() {
        this.conexion = new Conexion();
        this.boletoDAO = new BoletoDAO();
    }
    
    
    
    /**
     * Busca los los boletos pertenecientes a una persona dentro de la tabla
     * Persona_Boleto, busca los boletos de manera paginada
     * 
     * @param idPersona id de la persona a la que le pertenecen los boletos 
     * @param limit limite de boletos por consulta 
     * @param offset numero de pagina para la consulta
     * @return lista de boletos perteneciente a una persona 
     * @throws DAOException En caso de alguna SQLException durante la consulta
     */
    @Override
    public List<Persona_Boleto> buscarBoletos(int idPersona, int limit, 
            int offset) throws DAOException {
        List<Persona_Boleto> boletos = new ArrayList<>();
        String query = "SELECT id_boleto, fecha_adquisicion, hora_adquisicion, "
                   + "tipo_adquisicion, estado " +
                   "FROM Persona_Boleto " +
                   "WHERE id_persona = ? " +
                   "AND estado != 'EN VENTA' " +  
                   "LIMIT ? OFFSET ?";

        try (Connection conn = conexion.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idPersona);  // Asignar el id de la persona
            stmt.setInt(2, limit);      // Límite de resultados
            stmt.setInt(3, offset);     // Desplazamiento de resultados

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // Crear objeto PersonaBoleto y asignar sus valores desde 
                    // el ResultSet
                    Persona_Boleto boleto = new Persona_Boleto();
                    boleto.setBoleto(boletoDAO.
                            obtenerBoletoPorId(rs.getInt("id_boleto")));
                    boleto.setFecha_adquisicion
                           (rs.getDate("fecha_adquisicion"));
                    boleto.setHora_adquisicion(rs.getTime("hora_adquisicion"));
                    boleto.setTipo_adquisicion(Tipo_boleto.
                            valueOf(rs.getString("tipo_adquisicion")));
                    boleto.setEstado(rs.getString("estado"));
                    boletos.add(boleto);  // Agregar a la lista
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Error al buscar los boletos de la persona."
                    , e);
        }

        return boletos;  // Devolver la lista de boletos
    }


    /**
     * 
     * Este metodo se encarga de buscar los eventos pertenecientes a una persona
     * buscando mediante el "id" (dueño del boleto) y el nombre del evento
     * al cual pertenecen los boletos
     * 
     * @param idPersona
     * @param limit limite de boletos por consulta
     * @param offset numero de la pagina
     * @param evento nombre del evento del cual se quieren obtener los boletos
     * @return lista con los boletos pertencientes a la persona buscados por el 
     *         nombre del evento al que pertencen los boletos 
     * @throws DAOException En caso de alguna SQLException durante la consulta
     */
    @Override
    public List<Persona_Boleto> buscarBoletosPorEvento(int idPersona, int limit, 
            int offset, String evento) throws DAOException {
        List<Persona_Boleto> boletos = new ArrayList<>();

        String query = "SELECT pb.id_boleto, pb.fecha_adquisicion, "
                + "pb.hora_adquisicion, pb.tipo_adquisicion, pb.estado " +
                   "FROM Persona_Boleto pb " +
                   "INNER JOIN Boleto b ON pb.id_boleto = b.id " +
                   "INNER JOIN Evento e ON b.id_evento = e.id " +
                   "WHERE pb.id_persona = ? AND e.nombre LIKE ? " +
                   "LIMIT ? OFFSET ?";

        try (Connection conn = conexion.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Asignar los parámetros de la consulta
            stmt.setInt(1, idPersona);   // ID de la persona
            stmt.setString(2, "%" + evento + "%");   // Nombre del evento
            stmt.setInt(3, limit);       // Límite de resultados
            stmt.setInt(4, offset);      // Desplazamiento de resultados

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // Crear objeto Boleto y asignar los valores del ResultSet
                    Persona_Boleto boleto = new Persona_Boleto();
                    boleto.setBoleto(boletoDAO.
                            obtenerBoletoPorId(rs.getInt("id_boleto")));
                    boleto.setFecha_adquisicion
                           (rs.getDate("fecha_adquisicion"));
                    boleto.setHora_adquisicion(rs.getTime("hora_adquisicion"));
                    boleto.setTipo_adquisicion(Tipo_boleto.
                            valueOf(rs.getString("tipo_adquisicion")));
                    boleto.setEstado(rs.getString("estado"));
                    boletos.add(boleto);  // Agregar a la lista
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Error al buscar boletos por evento.", e);
        }

        return boletos;  // Retornar la lista de boletos filtrados por evento
    }
    
}
