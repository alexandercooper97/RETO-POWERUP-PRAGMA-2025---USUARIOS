package main.java.com.pragma.powerup.application.dto.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
public class UsuarioRequestDto {
    
    @NotBlank(message = "Por favor ingresa tu nombre")
    @Size(min = 3, message = "El nombre debe contener mínimo 3 caracteres")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El nombre solo puede contener letras")
    private String nombre;
    
    @NotBlank(message = "Por favor ingresa tu apellido")
    @Size(min = 2, message = "El apellido debe contener mínimo 2 caracteres")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El apellido solo puede contener letras")
    private String apellido;
    
    @NotBlank(message = "El documento de identidad es requerido")
    @Pattern(regexp = "\\d+", message = "El documento debe contener solo números")
    @Size(min = 4, max = 20, message = "El documento debe tener entre 4 y 20 dígitos")
    private String documentoDeIdentidad;
    
    @NotBlank(message = "Por favor ingresa tu correo electrónico")
    @Email(message = "Debes ingresar un correo electrónico válido")
    private String correo;
    
    @NotBlank(message = "El número celular es requerido")
    @Pattern(regexp = "^\\+?\\d{7,13}$", message = "El celular debe tener entre 7 y 13 dígitos (opcional el símbolo + al inicio)")
    private String celular;
    
    @NotNull(message = "La fecha de nacimiento es requerida")
    @Past(message = "La fecha de nacimiento debe ser válida")
    private LocalDate fechaNacimiento;
    
    @NotBlank(message = "Debes crear una contraseña")
    @Size(min = 8, message = "La contraseña debe tener mínimo 8 caracteres")
    private String clave;
    
    private Long rol = 2L; // Valor por defecto para rol "propietario"

    // Validación personalizada para mayoría de edad
    @AssertTrue(message = "Debes ser mayor de edad")
    public boolean isMayorDeEdad() {
        if (this.fechaNacimiento == null) {
            return false;
        }
        return Period.between(this.fechaNacimiento, LocalDate.now()).getYears() >= 18;
    }
}
