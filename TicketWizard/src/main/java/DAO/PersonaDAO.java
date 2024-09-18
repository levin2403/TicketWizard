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
public class PersonaDAO implements IPersonaDAO {

    private final IConexion conexionBD;
    private final IDomicilioDAO domicilioDAO;

    public PersonaDAO() {
        this.conexionBD = new Conexion();
        this.domicilioDAO = new DomicilioDAO();
    }

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
            String sentenciaSQL = "INSERT INTO Persona (nombre, contraseña, fecha_nacimiento, correo, saldo, id_domicilio, generated_key) VALUES (?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = conexion.prepareStatement(sentenciaSQL, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, persona.getNombre());
            preparedStatement.setString(2, persona.getContraseña());
            preparedStatement.setDate(3, new java.sql.Date(persona.getFechaNacimiento().getTime()));
            preparedStatement.setString(4, persona.getCorreo());
            preparedStatement.setBigDecimal(5, persona.getSaldo()); // Cambiado de 6 a 5
            preparedStatement.setInt(6, persona.getDomicilio().getId()); 
            preparedStatement.setString(7, persona.getGeneratedKey());

            preparedStatement.executeUpdate();

            resultado = preparedStatement.getGeneratedKeys();
            if (resultado.next()) {
                persona.setId(resultado.getInt(1));
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

    @Override
    public void actualizar(Persona persona) throws DAOException {
        Connection conexion = null;
        PreparedStatement preparedStatement = null;

        try {
            conexion = conexionBD.crearConexion();

            // Actualizamos el domicilio asociado primero
            domicilioDAO.actualizar(persona.getDomicilio());

            // Ahora actualizamos la persona
            String sentenciaSQL = "UPDATE Persona SET nombre = ?, contraseña = ?, fecha_nacimiento = ?, correo = ?, saldo = ?, id_domicilio = ?, generated_key = ? WHERE id = ?";
            preparedStatement = conexion.prepareStatement(sentenciaSQL);

            preparedStatement.setString(1, persona.getNombre());
            preparedStatement.setString(2, persona.getContraseña());
            preparedStatement.setDate(3, new java.sql.Date(persona.getFechaNacimiento().getTime()));
            preparedStatement.setString(4, persona.getCorreo());
            preparedStatement.setBigDecimal(5, persona.getSaldo()); // Cambiado de 6 a 5
            preparedStatement.setInt(6, persona.getDomicilio().getId());
            preparedStatement.setString(7, persona.getGeneratedKey());
            preparedStatement.setInt(8, persona.getId()); // Cambiado de 9 a 8

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

    @Override
    public Persona consultar(String correo) throws DAOException {
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultado = null;

        try {
            conexion = conexionBD.crearConexion();
            String sentenciaSQL = "SELECT id, nombre, contraseña, fecha_nacimiento, correo, saldo, id_domicilio, generated_key FROM Persona WHERE correo = ?";
            preparedStatement = conexion.prepareStatement(sentenciaSQL);

            preparedStatement.setString(1, correo);

            resultado = preparedStatement.executeQuery();

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

                // Ahora obtenemos el domicilio asociado a la persona
                int idDomicilio = resultado.getInt("id_domicilio");
                Domicilio domicilio = domicilioDAO.consultar(new Domicilio(idDomicilio));
                persona.setDomicilio(domicilio);

                return persona;

            } else {
                throw new DAOException("No se encontró la persona con el correo: " + correo);
            }

        } catch (SQLException ex) {
            throw new DAOException("Error al consultar la persona: " + ex.getMessage());
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
}