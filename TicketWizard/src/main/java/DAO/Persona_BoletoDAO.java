/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.Persona_Boleto;
import Excepciones.DAOException;
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
public class Persona_BoletoDAO {
    
    private static final Logger logger = Logger.getLogger(EventoDAO.class.getName());
    private final Conexion conexion;
    private final PersonaDAO personaDAO;
    private final BoletoDAO boletoDAO;

    public Persona_BoletoDAO() {
        this.conexion = new Conexion();
        this.personaDAO = new PersonaDAO();
        this.boletoDAO = new BoletoDAO();
    }
    
    
    public List<Persona_Boleto> obtenerPersonaBoletosPaginados(int limit, int offset) 
            throws DAOException{
    List<Persona_Boleto> listaPersonaBoletos = new ArrayList<>();
    String sql = "SELECT * FROM Persona_Boleto LIMIT ? OFFSET ?"; 

    try (Connection conn = conexion.crearConexion(); // Abre la conexión
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, limit); // Límite de registros por página
            stmt.setInt(2, offset);       // Desde dónde empezar los registros

            ResultSet rs = stmt.executeQuery();

            // Itera sobre los resultados y los agrega a la lista
            while (rs.next()) {
                Persona_Boleto personaBoleto = new Persona_Boleto();
                personaBoleto.setId(rs.getInt("id"));
                personaBoleto.setPersona(personaDAO.obtenerPersonaPorId((rs.getInt("id_persona"))));
                personaBoleto.setBoleto(boletoDAO.obtenerBoletoPorId(rs.getInt("id_boleto")));
                personaBoleto.setFecha_adquisicion(rs.getDate("fecha_adquisicion"));
                personaBoleto.setHora_adquisicion(rs.getTime("hora_adquisicion"));

                listaPersonaBoletos.add(personaBoleto);
            }

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al obtener los boletos asiciados a una persona", ex);
        }
        logger.log(Level.INFO, "Exito al obtener los boletos asociados a una persona");
        return listaPersonaBoletos;
    }
    
    
}
