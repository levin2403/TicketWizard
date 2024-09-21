/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.Venue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author skevi
 */
public class VenueDAO {
    
    private Conexion conexion;

    public VenueDAO() {
        this.conexion = new Conexion();
    }

    public Venue obtenerVenuePorId(int id) {
        Venue venue = null;
        String sql = "SELECT * FROM Venue WHERE id = ?";

        try (Connection conn = conexion.crearConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                venue = new Venue();
                venue.setId(rs.getInt("id"));
                venue.setNombre(rs.getString("nombre"));
                venue.setCiudad(rs.getString("ciudad"));
                venue.setEstado(rs.getString("estado"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Manejo de errores
        }
        return venue;
    }
    
}
