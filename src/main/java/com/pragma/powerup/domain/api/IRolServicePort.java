package main.java.com.pragma.powerup.domain.api;

import main.java.com.pragma.powerup.domain.model.Rol;

import java.util.List;

public interface IRolServicePort {

    void guardarRol(Rol rol);

    Rol obtenerById(Long id);

    List<Rol> obtenerTodosRoles();

    void eliminarRolById(Long id);
}
