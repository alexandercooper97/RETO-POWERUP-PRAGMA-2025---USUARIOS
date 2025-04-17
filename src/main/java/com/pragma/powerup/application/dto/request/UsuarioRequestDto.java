package main.java.com.pragma.powerup.application.dto.request;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UsuarioRequestDto {
    @NotBlank(message = "Nombre (obligatorio)")
    @Size(min = 3, message = "El Nombre debe tener al menos 3 caracteres")
    private String nombre;
    
    @NotBlank(message = "Apellido (obligatorio)")
    @Size(min = 2, message = "El apellido debe tener al menos 2 caracteres")
    private String apellido;
    
    @NotBlank(message = "DNI (obligatorio)")
    @Pattern(regexp = "\\d+", message = "Ingresar DNI numerico")
    @Size(min = 4, message = "El DNI debe tener al menos 4 digitos")
    
    private String documentoDeIdentidad;
        @NotBlank(message = "EMAIL (obligatorio)")
    @Email(message = "Email debe ser correcto")
    private String correo;
    
    @NotBlank(message = "Celular (obligatorio)")
    @Pattern(regexp = "^\\+?\\d{1,11}$", message = "Celular debe contener máximo 12 caracteres y el símbolo '+' al inicio")
    private  String celular;
    
    @NotBlank(message = "Contrseña (obligatoria)")
    private String clave;
    private Long rol;


}
