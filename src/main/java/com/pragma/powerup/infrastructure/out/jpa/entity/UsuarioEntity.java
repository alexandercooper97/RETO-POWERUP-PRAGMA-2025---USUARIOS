package main.java.com.pragma.powerup.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "usuario_id", nullable = false)
    private Long id;

    @Column(name="nombre", length = 220)
    private String nombre;

    @Column(name="apellido", length = 220)
    private String apellido;

    @Column(name="documento_de_identidad",  unique = true)
    private String documentoDeIdentidad;

    @Column(name="celular", length = 13)
    private String celular;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name="correo", unique = true)
    private String correo;


    @Column(name = "clave", nullable = false)
    private String clave;

    @NotNull(message = "El rol es obligatorio")
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "rol_id", nullable = false)
    private RolEntity rol;


    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", documentoIdentidad=" + documentoDeIdentidad +
                ", celular='" + celular + '\'' +
                ", email='" + correo + '\'' +
                ", clave='" + clave + '\'' +
                ", rol=" + rol +
                '}';
    }
    /*
    public String getFechaNacimientoFormateada() {
    return fechaNacimiento != null ? "**-**-" + fechaNacimiento.getYear() : "null";
     }
     */
}
