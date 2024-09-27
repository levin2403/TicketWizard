/**
 * PersonaDAO.java.
 *
 * Clase que maneja la interacción con la base de datos para la entidad Persona.
 * Implementa la interfaz IPersonaDAO.
 * Proporciona métodos para agregar, actualizar, consultar y gestionar datos de la persona.
 *
 */
package DAO;

import Conexion.Conexion;
import Conexion.IConexion;
import Entidades.Domicilio;
import Entidades.Persona;
import Excepciones.DAOException;
import InterfacesDAO.IDomicilioDAO;
import InterfacesDAO.IPersonaDAO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */

/**
 * Implementación de la interfaz IPersonaDAO para gestionar la entidad Persona
 * en la base de datos.
 */
public class PersonaDAO implements IPersonaDAO {

    private final IConexion conexionBD;
    private final IDomicilioDAO domicilioDAO;

    /**
     * Constructor de la clase PersonaDAO. Inicializa la conexión a la base de
     * datos y crea una instancia de DomicilioDAO.
     */
    public PersonaDAO() {
        this.conexionBD = new Conexion();
        this.domicilioDAO = new DomicilioDAO();
    }

    /**
     * Agrega una nueva persona a la base de datos.
     *
     * @param persona La persona a agregar.
     * @throws DAOException Si ocurre un error al agregar la persona.
     */
    @Override
    public void agregar(Persona persona) throws DAOException {
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultado = null;

        try {
            conexion = conexionBD.crearConexion();
            // Primero, agregamos el domicilio y obtenemos el ID
            domicilioDAO.agregar(persona.getDomicilio());

            // Ahora, agregamos la persona usando el id_domicilio recién generado
            String sentenciaSQL = "INSERT INTO Persona (nombre, contraseña, "
                    + "fecha_nacimiento, correo, saldo, id_domicilio, "
                    + "generated_key) VALUES (?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = conexion.prepareStatement(sentenciaSQL,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, persona.getNombre());
            preparedStatement.setString(2, persona.getContraseña());
            preparedStatement.setDate(3, new java.sql.Date(persona.getFechaNacimiento().getTime()));
            preparedStatement.setString(4, persona.getCorreo());
            preparedStatement.setBigDecimal(5, persona.getSaldo());
            preparedStatement.setInt(6, persona.getDomicilio().getId());
            preparedStatement.setString(7, persona.getGeneratedKey());

            preparedStatement.executeUpdate();

            // Obtener el ID generado para la persona
            resultado = preparedStatement.getGeneratedKeys();
            if (resultado.next()) {
                persona.setId(resultado.getInt(1)); // Asignar el ID generado al objeto Persona
            }

        } catch (SQLException ex) {
            throw new DAOException("Error al agregar la persona: " + ex.getMessage());
        } finally {
            try {
                if (resultado != null) {
                    resultado.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Error al cerrar los recursos: " + e.getMessage());
            }
        }
    }

    /**
     * Actualiza los datos de una persona en la base de datos.
     *
     * @param persona La persona con los nuevos datos.
     * @throws DAOException Si ocurre un error al actualizar la persona.
     */
    @Override
    public void actualizar(Persona persona) throws DAOException {
        Connection conexion = null;
        PreparedStatement preparedStatement = null;

        try {
            conexion = conexionBD.crearConexion();
            // Actualizamos el domicilio asociado primero
            domicilioDAO.actualizar(persona.getDomicilio());

            // Ahora actualizamos la persona
            String sentenciaSQL = "UPDATE Persona SET nombre = ?, "
                    + "contraseña = ?, fecha_nacimiento = ?, "
                    + "correo = ?, saldo = ?, id_domicilio = ?, "
                    + "generated_key = ? WHERE id = ?";
            preparedStatement = conexion.prepareStatement(sentenciaSQL);

            preparedStatement.setString(1, persona.getNombre());
            preparedStatement.setString(2, persona.getContraseña());
            preparedStatement.setDate(3, new java.sql.Date(persona.getFechaNacimiento().getTime()));
            preparedStatement.setString(4, persona.getCorreo());
            preparedStatement.setBigDecimal(5, persona.getSaldo());
            preparedStatement.setInt(6, persona.getDomicilio().getId());
            preparedStatement.setString(7, persona.getGeneratedKey());
            preparedStatement.setInt(8, persona.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException("Error al actualizar la persona: " + ex.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Error al cerrar los recursos: " + e.getMessage());
            }
        }
    }

    /**
     * Consulta una persona en la base de datos por su correo.
     *
     * @param correo El correo de la persona a consultar.
     * @return La persona encontrada.
     * @throws DAOException Si ocurre un error al consultar la persona o si no
     * se encuentra.
     */
    @Override
    public Persona consultar(String correo) throws DAOException {
        String sentenciaSQL = "SELECT * FROM Persona WHERE correo = ?";

        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement preparedStatement = conexion.prepareStatement(sentenciaSQL)) {

            preparedStatement.setString(1, correo);

            try (ResultSet resultado = preparedStatement.executeQuery()) {
                if (resultado.next()) {
                    // Creamos el objeto Persona
                    Persona persona = new Persona();
                    persona.setId(resultado.getInt("id"));
                    persona.setNombre(resultado.getString("nombre"));
                    persona.setContraseña(resultado.getString("contraseña"));
                    persona.setFechaNacimiento(resultado.getDate("fecha_nacimiento"));
                    persona.setCorreo(resultado.getString("correo"));
                    persona.setSaldo(resultado.getBigDecimal("saldo"));
                    persona.setGeneratedKey(resultado.getString("generated_key"));

                    // Ahora obtenemos el domicilio asociado a la persona, si existe
                    int idDomicilio = resultado.getInt("id_domicilio");
                    if (idDomicilio > 0) {
                        Domicilio domicilio = domicilioDAO.consultar(idDomicilio);
                        persona.setDomicilio(domicilio);
                    }
                    return persona;
                } else {
                    throw new DAOException("No se encontró la persona con el correo: " + correo);
                }
            }

        } catch (SQLException ex) {
            throw new DAOException("Error al consultar la persona", ex);
        }
    }

    /**
     * Actualiza el saldo de una persona en la base de datos.
     *
     * @param idPersona El ID de la persona cuyo saldo se actualizará.
     * @param nuevoSaldo El nuevo saldo a establecer.
     * @throws DAOException Si ocurre un error al actualizar el saldo.
     */
    @Override
    public void actualizarSaldo(int idPersona, BigDecimal nuevoSaldo) throws DAOException {
        Connection conexion = null;
        PreparedStatement preparedStatement = null;

        try {
            conexion = conexionBD.crearConexion();
            String sentenciaSQL = "UPDATE Persona SET saldo = ? WHERE id = ?";
            preparedStatement = conexion.prepareStatement(sentenciaSQL);

            preparedStatement.setBigDecimal(1, nuevoSaldo);
            preparedStatement.setInt(2, idPersona);

            int filasActualizadas = preparedStatement.executeUpdate();
            if (filasActualizadas == 0) {
                throw new DAOException("No se encontró la persona con ID: " + idPersona);
            }
        } catch (SQLException ex) {
            throw new DAOException("Error al actualizar el saldo: " + ex.getMessage(), ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Error al cerrar los recursos: " + e.getMessage(), e);
            }
        }
    }

    /**
     * Consulta el saldo de una persona en la base de datos por su ID.
     *
     * @param id El ID de la persona cuyo saldo se consulta.
     * @return El saldo de la persona, o null si no se encuentra.
     * @throws DAOException Si ocurre un error al consultar el saldo.
     */
    @Override
    public BigDecimal consultarSaldo(int id) throws DAOException {
        BigDecimal saldo = null;
        String sql = "SELECT saldo FROM Persona WHERE id = ?";

        try (Connection conn = conexionBD.crearConexion(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    saldo = rs.getBigDecimal("saldo");
                }
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }

        return saldo;
    }

    /**
     * Consulta una persona en la base de datos por su ID.
     *
     * @param id El ID de la persona a consultar.
     * @return La persona encontrada.
     * @throws DAOException Si ocurre un error al consultar la persona o si no
     * se encuentra.
     */
    public Persona consultarPorId(int id) throws DAOException {
        String sentenciaSQL = "SELECT * FROM Persona WHERE id = ?";

        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement preparedStatement = conexion.prepareStatement(sentenciaSQL)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultado = preparedStatement.executeQuery()) {
                if (resultado.next()) {
                    // Creamos el objeto Persona
                    Persona persona = new Persona();
                    persona.setId(resultado.getInt("id"));
                    persona.setNombre(resultado.getString("nombre"));
                    persona.setContraseña(resultado.getString("contraseña"));
                    persona.setFechaNacimiento(resultado.getDate("fecha_nacimiento"));
                    persona.setCorreo(resultado.getString("correo"));
                    persona.setSaldo(resultado.getBigDecimal("saldo"));
                    persona.setGeneratedKey(resultado.getString("generated_key"));

                    // Ahora obtenemos el domicilio asociado a la persona, si existe
                    int idDomicilio = resultado.getInt("id_domicilio");
                    if (idDomicilio > 0) {
                        Domicilio domicilio = domicilioDAO.consultar(idDomicilio);
                        persona.setDomicilio(domicilio);
                    }
                    return persona;
                } else {
                    throw new DAOException("No se encontró la persona con ID: " + id);
                }
            }

        } catch (SQLException ex) {
            throw new DAOException("Error al consultar la persona", ex);
        }
    }

    /**
     * No se realizaron operaciones.
     * @param correo
     * @param contrasena
     * @return
     * @throws DAOException
     */
    @Override
    public Persona consultarPorCorreoYContrasena(String correo, String contrasena) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * No se realizaron operaciones.
     * @param idPersona
     * @return
     * @throws DAOException
     */
    @Override
    public Persona obtenerPersonaPorId(int idPersona) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
