package main.java.com.pragma.powerup.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Rol {
    public static final Long ID_ADMIN = 1L;
    public static final Long ID_PROPIETARIO = 2L;
    public static final Long ID_EMPLEADO = 3L;
    public static final Long ID_CLIENTE = 4L;

    private Long id;
    private String nombre;
    private String descripcion;
}