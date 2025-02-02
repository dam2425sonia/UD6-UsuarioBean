package com.example;

import lombok.Data;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class Usuario implements Serializable {
    private int id;
    private String nombre;
    private String apellido;
    private String mail;
    private String telf;

    //Constructor por defecto
    public Usuario(){

    }

    public Usuario (int id, String nombre, String apellido, String mail, String telf){
        this.id=id;
        this.nombre=nombre;
        this.apellido=apellido;
        this.mail=mail;
        this.telf=telf;
    }

    public Usuario(ResultSet resultSet) throws SQLException{
        this.id=resultSet.getInt(1);
        this.nombre=resultSet.getString(2);
        this.apellido=resultSet.getString(3);
        this.mail=resultSet.getString(4);
        this.telf=resultSet.getString(5);
    }

    
}
