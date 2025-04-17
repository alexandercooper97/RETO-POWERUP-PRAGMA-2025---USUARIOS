package main.javacom.pragma.powerup.application.dto.response;

import main.java.com.pragma.powerup.domain.model.Rol;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponseDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String documentoDeIdentidad;
    private  String celular;
    private String fechaNacimiento;
    private String correo;
    private String clave;
    private Rol rol;
}
