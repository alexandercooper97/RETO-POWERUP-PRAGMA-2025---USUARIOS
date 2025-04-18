package main.java.com.pragma.powerup.domain.spi.persistence;

import main.java.com.pragma.powerup.domain.model.Usuario;

import java.util.List;

public interface IUsuarioPersistencePort {

    Usuario guardarUsuario(Usuario usuario);

    Usuario getUsuarioById(Long id);

    Usuario getUsuarioByCorreo(String correo);

    Boolean existeUsuarioById(Long id);

    List<Usuario> getTodosUsuarios();

    void eliminarUsuarioById(Long id);

}
