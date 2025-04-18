package main.java.com.pragma.powerup.domain.model;

public class Usuario {

    private Long id;
    private String nombre;
    private String apellido;
    private String documentoDeIdentidad;
    private String celular;
    private LocalDate fechaNacimiento;
    private String correo;
    private String clave;
    private Rol rol;

    public Usuario() {
    }

    public Usuario(Long id, String nombre, String apellido, String documentoDeIdentidad, String celular, String correo, String clave, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documentoDeIdentidad = documentoDeIdentidad;
        this.celular = celular;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.clave = clave;
        this.rol = rol;
    }

    /* ##################################################################################
       ##                                                                              ##
       ##          GETTER y SETTER  para Id                                            ##
       ##                                                                              ##
       ##################################################################################
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /* ##################################################################################
       ##                                                                              ##
       ##          GETTER y SETTER  para NOMBRE                                        ##
       ##                                                                              ##
       ##################################################################################
     */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    /* ##################################################################################
       ##                                                                              ##
       ##          GETTER y SETTER  para APELLIDO                                      ##
       ##                                                                              ##
       ##################################################################################
     */

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    /* ##################################################################################
       ##                                                                              ##
       ##          GETTER y SETTER  para DOCUMENTO DE IDENTIDAD                        ##
       ##                                                                              ##
       ##################################################################################
     */

    public String getDocumentoDeIdentidad() {
        return documentoDeIdentidad;
    }

    public void setDocumentoDeIdentidad(String documentoDeIdentidad) {
        this.documentoDeIdentidad = documentoDeIdentidad;
    }



    /* ##################################################################################
       ##                                                                              ##
       ##          GETTER y SETTER  para CELULAR                                       ##
       ##                                                                              ##
       ##################################################################################
     */
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }



    /* ##################################################################################
       ##                                                                              ##
       ##          GETTER y SETTER  para FECHA DE NACIMIENTO                           ##
       ##                                                                              ##
       ##################################################################################
     */
    public LocalDate getFechaNacimiento() {return fechaNacimiento;}
    public void setFechaNacimiento(LocalDate fechaNacimiento) {this.fechaNacimiento = fechaNacimiento;}



    /* ##################################################################################
       ##                                                                              ##
       ##          GETTER y SETTER  para FECHA DE CORREO                               ##
       ##                                                                              ##
       ##################################################################################
     */
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }



    /* ##################################################################################
       ##                                                                              ##
       ##          GETTER y SETTER  para CLAVE                                         ##
       ##                                                                              ##
       ##################################################################################
     */
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }



    /* ##################################################################################
       ##                                                                              ##
       ##          GETTER y SETTER  para ROL                                           ##
       ##                                                                              ##
       ##################################################################################
     */
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) { this.rol = rol;}

}
