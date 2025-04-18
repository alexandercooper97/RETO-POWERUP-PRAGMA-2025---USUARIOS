package main.java.com.pragma.powerup.domain.api;

import main.java.com.pragma.powerup.domain.model.Usuario;

import java.util.List;

public interface IUsuarioServicePort {

    void guardarUsuario(Usuario usuario);

    void guardarRestauranteEmpleado(Usuario usuario);

    Usuario getUsuarioById(Long id);

    Usuario getUsuarioByCorreo(String correo);

    Boolean existeUsuarioById(Long id);
+
    List<Usuario> getTodosUsuarios();

    void eliminarUsuarioById(Long id);
}
