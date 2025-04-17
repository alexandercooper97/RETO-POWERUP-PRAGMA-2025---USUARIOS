package main.java.com.pragma.powerup.application.dto.response;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class UsuarioResponseDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String documentoDeIdentidad;
    private String celular;
    private LocalDate fechaNacimiento;
    //private String fechaNacimiento; // Formato: "yyyy-MM-dd" (ISO)
    private String correo;
    private String clave; // OJO: Solo si es estrictamente necesario exponerla
    private RolResponseDto rol; // DTO específico para el rol

    // Versión segura (recomendada) - Sin exposición de contraseña
    public static class SafeVersion {
        private Long id;
        private String nombre;
        private String apellido;
        private String documentoDeIdentidad;
        private String celular;
        private LocalDate fechaNacimiento;
        private String correo;
        private RolResponseDto rol;
        // Excluye 'clave' por seguridad
    }
}