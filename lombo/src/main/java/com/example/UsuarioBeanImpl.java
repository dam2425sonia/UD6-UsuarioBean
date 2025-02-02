package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioBeanImpl implements UsuarioBean{
    //Sobreescribimos los métodos de la interfaz

    //Definimos el método para conectarnos a la BBDD
    public static Connection getConnection() throws SQLException{
        String BBDD= "jdbc:mysql://localhost:3306/lombo";
        String USER="root";
        String PASSWORD="Dam2425*";

        return DriverManager.getConnection(BBDD, USER, PASSWORD);

    }

    @Override
    public List<Usuario> getUsuarios() throws SQLException{
        //Vamos a consultar todos los usuarios que existen el la BBDD
        List<Usuario> usuarios= new ArrayList<>();
        String sql = "SELECT id, nombre, mail FROM usuarios"; // Ajusta según la estructura de tu tabla

        // Conexión a la base de datos
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            // Recorremos los resultados y llenamos la lista
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setMail(rs.getString("mail"));
                usuarios.add(usuario);
            }
        }

        return usuarios;
    
    }

    @Override
    public void insertUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nombre, mail) VALUES (?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getMail());
            
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuario insertado con éxito");
            } else {
                System.out.println("No se pudo insertar el usuario");
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar el usuario: " + e.getMessage());
            throw e;  // Re-lanzamos la excepción para que la capa superior la maneje
        }
    }
}
