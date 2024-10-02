/**
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
public class PersonaDAO implements  IPersonaDAO{

    private final IConexion conexionBD;
    private final IDomicilioDAO domicilioDAO;

    public PersonaDAO() {
        this.conexionBD = new Conexion();
        this.domicilioDAO = new DomicilioDAO();
    }

    /**
     * 
     * @param persona
     * @throws DAOException 
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
            preparedStatement.setDate(3, new java.sql.Date
        (persona.getFechaNacimiento().getTime()));
            preparedStatement.setString(4, persona.getCorreo());
            preparedStatement.setBigDecimal(5, persona.getSaldo()); // Cambiado de 6 a 5
            preparedStatement.setInt(6, persona.getDomicilio().getId());
            preparedStatement.setString(7, persona.getGeneratedKey());

            preparedStatement.executeUpdate();

            // Dentro del método agregar en PersonaDAO
            resultado = preparedStatement.getGeneratedKeys();
            if (resultado.next()) {
                persona.setId(resultado.getInt(1)); // Asignar el ID generado al objeto Persona
            }

        } catch (SQLException ex) {
            throw new DAOException("Error al agregar la persona: " + 
                    ex.getMessage());
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
                throw new DAOException("Error al cerrar los recursos: " + 
                        e.getMessage());
            }
        }
    }

    /**
     * 
     * @param persona
     * @throws DAOException 
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
            preparedStatement.setDate(3, new java.sql.Date(persona.
                    getFechaNacimiento().getTime()));
            preparedStatement.setString(4, persona.getCorreo());
            preparedStatement.setBigDecimal(5, persona.getSaldo()); // Cambiado de 6 a 5
            preparedStatement.setInt(6, persona.getDomicilio().getId());
            preparedStatement.setString(7, persona.getGeneratedKey());
            preparedStatement.setInt(8, persona.getId()); // Cambiado de 9 a 8

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException("Error al actualizar la persona: " + 
                    ex.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Error al cerrar los recursos: " + 
                        e.getMessage());
            }
        }
    }

    /**
     * 
     * @param correo
     * @return
     * @throws DAOException 
     */
    @Override
    public Persona consultar(String correo) throws DAOException {
        String sentenciaSQL = "SELECT * FROM Persona WHERE correo = ?";

        try (Connection conexion = conexionBD.crearConexion();
             PreparedStatement preparedStatement = 
                     conexion.prepareStatement(sentenciaSQL)) {

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
                    System.out.println(persona.toString()); 

                    return persona;
                } else {
                    // Si no se encuentra, devolvemos null
                    return null;
                }
            }

        } catch (SQLException ex) {
            throw new DAOException("Error al consultar la persona", ex);
        }
    }


    /**
     * 
     * @param idPersona
     * @param nuevoSaldo
     * @throws DAOException 
     */
    @Override
    public void actualizarSaldo(int idPersona, BigDecimal nuevoSaldo) 
            throws DAOException {
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
                throw new DAOException("No se encontró la persona con ID: " 
                        + idPersona);
            }
        } catch (SQLException ex) {
            throw new DAOException("Error al actualizar el saldo: " 
                    + ex.getMessage(), ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Error al cerrar los recursos: " 
                        + e.getMessage(), e);
            }
        }
    }
    
    
    /**
     * 
     * @param id
     * @return 
     * @throws Excepciones.DAOException 
     */
    @Override
    public BigDecimal consultarSaldo(int id) throws DAOException {
        BigDecimal saldo = null;
        String sql = "SELECT saldo FROM Persona WHERE id = ?";

        try (Connection conn = conexionBD.crearConexion(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
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
     * 
     * @param correo
     * @param contrasena
     * @return
     * @throws DAOException 
     */
    @Override
    public Persona consultarPorCorreoYContrasena(String correo, 
            String contrasena) throws DAOException {
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultado = null;

        try {
            conexion = conexionBD.crearConexion();
            String sentenciaSQL = "SELECT id, nombre, contraseña, "
                    + "fecha_nacimiento, correo, saldo, id_domicilio, "
                    + "generated_key FROM Persona WHERE correo = ? "
                    + "AND contraseña = ?";
            preparedStatement = conexion.prepareStatement(sentenciaSQL);

            preparedStatement.setString(1, correo);
            preparedStatement.setString(2, contrasena);

            resultado = preparedStatement.executeQuery();

            if (resultado.next()) {
                // Creamos el objeto Persona
                Persona persona = new Persona();
                persona.setId(resultado.getInt("id"));
                persona.setNombre(resultado.getString("nombre"));
                persona.setContraseña(resultado.getString("contraseña"));
                persona.setFechaNacimiento(resultado.
                        getDate("fecha_nacimiento"));
                persona.setCorreo(resultado.getString("correo"));
                persona.setSaldo(resultado.getBigDecimal("saldo"));
                persona.setGeneratedKey(resultado.getString("generated_key"));

                // Obtener domicilio asociado
                int idDomicilio = resultado.getInt("id_domicilio");
                Domicilio domicilio = domicilioDAO.consultar(idDomicilio);
                persona.setDomicilio(domicilio);

                return persona;
            } else {
                throw new DAOException("No se encontró la persona con el correo"
                        + "y contraseña proporcionados.");
            }

        } catch (SQLException ex) {
            throw new DAOException("Error al consultar la persona: " 
                    + ex.getMessage());
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
                throw new DAOException("Error al cerrar los recursos: " 
                        + e.getMessage());
            }
        }
    }
    
    /**
     * 
     * @param idPersona
     * @return 
     * @throws Excepciones.DAOException 
     */
    @Override
    public Persona obtenerPersonaPorId(int idPersona) throws DAOException {
        String query = "SELECT * FROM Persona WHERE id = ?";
        Persona persona = null;

        try (Connection conn = conexionBD.crearConexion(); 
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idPersona); 

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    persona = new Persona(); // Crear una nueva instancia de Persona
                    persona.setId(rs.getInt("id"));
                    persona.setNombre(rs.getString("nombre"));
                    persona.setContraseña(rs.getString("contraseña"));
                    persona.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                    persona.setCorreo(rs.getString("correo"));
                    persona.setDomicilio(domicilioDAO.consultar(rs.getInt("id_domicilio")));
                    persona.setSaldo(rs.getBigDecimal("saldo"));
                    persona.setGeneratedKey(rs.getString("generated_key"));
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Error al obtener la persona por id", e);
        }

        return persona; // Devolver la persona (o null si no se encontró)
    }

}
