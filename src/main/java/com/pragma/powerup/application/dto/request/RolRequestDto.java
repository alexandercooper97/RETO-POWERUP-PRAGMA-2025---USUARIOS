package main.java.com.pragma.powerup.application.dto.request;

import main.java.com.pragma.powerup.domain.model.Rol;
import main.javacom.pragma.powerup.domain.model.Usuario;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.NotBlank;
import java.util.List;
@Getter
@Setter
public class RolRequestDto {
    @NotBlank(message = "Nombre (obligatorio)")
    private String nombre;
    @NotBlank(message = "Descripcion (Obligatoria)")
    private  String descripcion;
}
