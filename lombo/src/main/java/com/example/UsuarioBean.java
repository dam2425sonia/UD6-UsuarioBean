package com.example;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioBean {
    //Dos funciones:

    //Función para listar un conjunto de usuarios
    public List<Usuario> getUsuarios() throws SQLException;

    //Función para escribir el usuario
    public void insertUsuario(Usuario usuario) throws SQLException;

    
} 


