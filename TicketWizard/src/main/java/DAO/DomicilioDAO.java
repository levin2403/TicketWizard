/**
 * DomicilioDAO.java.
 *
 * Clase que implementa los métodos de acceso a datos de la entidad Domicilio.
 */
package DAO;

import Conexion.Conexion;
import Conexion.IConexion;
import Entidades.Domicilio;
import Excepciones.DAOException;
import InterfacesDAO.IDomicilioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class DomicilioDAO implements IDomicilioDAO {

    private final IConexion conexionBD;

    /**
     * Constructor de DomicilioDAO. Inicializa la conexión a la base de datos
     * mediante un objeto de tipo IConexion.
     */
    public DomicilioDAO() {
        this.conexionBD = new Conexion();
    }

    /**
     * Método para agregar un domicilio a la base de datos.
     *
     * @param domicilio El objeto Domicilio que se desea agregar.
     * @throws DAOException Si ocurre un error al agregar el domicilio.
     */
    @Override
    public void agregar(Domicilio domicilio) throws DAOException {
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultado = null;

        try {
            conexion = conexionBD.crearConexion();
            String sentenciaSQL = "INSERT INTO Direccion (ciudad, colonia, "
                    + "calle, num_exterior, num_interior, codigo_postal) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            preparedStatement = conexion.prepareStatement(sentenciaSQL,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, domicilio.getCiudad());
            preparedStatement.setString(2, domicilio.getColonia());
            preparedStatement.setString(3, domicilio.getCalle());
            preparedStatement.setInt(4, domicilio.getNum_exterior());
            preparedStatement.setObject(5, domicilio.getNum_interior(),
                    java.sql.Types.INTEGER);
            preparedStatement.setInt(6, domicilio.getCodigo_postal());

            preparedStatement.executeUpdate();

            resultado = preparedStatement.getGeneratedKeys();
            if (resultado.next()) {
                domicilio.setId(resultado.getInt(1));
            }

        } catch (SQLException ex) {
            throw new DAOException("Error al agregar el domicilio: "
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
     * Método para actualizar un domicilio existente en la base de datos.
     *
     * @param domicilio El objeto Domicilio que contiene los datos actualizados.
     * @throws DAOException Si ocurre un error al actualizar el domicilio.
     */
    @Override
    public void actualizar(Domicilio domicilio) throws DAOException {
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultado = null;

        try {
            conexion = conexionBD.crearConexion();
            String sentenciaSQL = "UPDATE Direccion SET ciudad = ?, colonia "
                    + "= ?, calle = ?, num_exterior = ?, num_interior = ?, "
                    + "codigo_postal = ? WHERE id = ?";
            preparedStatement = conexion.prepareStatement(sentenciaSQL);

            preparedStatement.setString(1, domicilio.getCiudad());
            preparedStatement.setString(2, domicilio.getColonia());
            preparedStatement.setString(3, domicilio.getCalle());
            preparedStatement.setInt(4, domicilio.getNum_exterior());
            preparedStatement.setObject(5, domicilio.getNum_interior(),
                    java.sql.Types.INTEGER); // Puede ser null
            preparedStatement.setInt(6, domicilio.getCodigo_postal());
            preparedStatement.setInt(7, domicilio.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException("Error al actualizar el domicilio: "
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
     * Método para consultar un domicilio por su ID.
     *
     * @param id El ID del domicilio que se desea consultar.
     * @return El objeto Domicilio correspondiente al ID.
     * @throws DAOException Si ocurre un error al consultar el domicilio o si no
     * se encuentra.
     */
    @Override
    public Domicilio consultar(int id) throws DAOException {
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultado = null;

        try {
            conexion = conexionBD.crearConexion();
            String sentenciaSQL = "SELECT * FROM Direccion WHERE id = ?";
            preparedStatement = conexion.prepareStatement(sentenciaSQL);
            preparedStatement.setInt(1, id);

            resultado = preparedStatement.executeQuery();

            if (resultado.next()) {
                // Crear y devolver la entidad Domicilio
                Domicilio domicilioResult = new Domicilio();
                domicilioResult.setId(resultado.getInt("id"));
                domicilioResult.setCiudad(resultado.getString("ciudad"));
                domicilioResult.setColonia(resultado.getString("colonia"));
                domicilioResult.setCalle(resultado.getString("calle"));
                domicilioResult.setNum_exterior(resultado.getInt("num_exterior"));

                // Manejar el valor de num_interior como int, asignando 0 si es 
                // NULL
                Object numInteriorObj = resultado.getObject("num_interior");
                int numInterior = (numInteriorObj != null) ? (Integer) numInteriorObj : 0;
                domicilioResult.setNum_interior(numInterior);

                domicilioResult.setCodigo_postal(resultado.getInt("codigo_postal"));

                return domicilioResult;
            } else {
                throw new DAOException("No se encontró el domicilio con ID: "
                        + id);
            }

        } catch (SQLException ex) {
            throw new DAOException("Error al consultar el domicilio: "
                    + ex.getMessage(), ex);
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
}
