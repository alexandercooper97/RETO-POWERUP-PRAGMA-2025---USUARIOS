package main.java.com.pragma.powerup.domain.spi.persistence;

import main.java.com.pragma.powerup.domain.model.Rol;
import main.java.com.pragma.powerup.domain.model.Usuario;

import java.util.List;

public interface IRolPersistencePort {

    Rol guardarRol(Rol rol);

    Rol obtenerRolById(Long id);

    List<Rol> obtenerTodosRoles();

    void eliminarRolById(Long id);
}
