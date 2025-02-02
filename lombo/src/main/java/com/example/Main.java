

package com.example;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UsuarioBean usuarioBean = new UsuarioBeanImpl();

       // Crear un nuevo usuario
       Usuario nuevoUsuario = new Usuario();
       nuevoUsuario.setNombre("Juan Perez");
       nuevoUsuario.setMail("juan.perez@example.com");

       try {
           // Insertar el nuevo usuario en la base de datos
           usuarioBean.insertUsuario(nuevoUsuario);
            // Obtenemos la lista de usuarios desde la base de datos
            List<Usuario> usuarios = usuarioBean.getUsuarios();

            // Mostramos los usuarios en consola
            System.out.println("Lista de Usuarios:");
            for (Usuario usuario : usuarios) {
                System.out.println("ID: " + usuario.getId() + 
                                   ", Nombre: " + usuario.getNombre() + 
                                   ", Email: " + usuario.getMail());
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener los usuarios: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

/*package com.example;

public class Main {
    public static void main(String[] args) {
        Usuario usuario=new Usuario();
        usuario.setNombre("Jorge");
    }
} */
