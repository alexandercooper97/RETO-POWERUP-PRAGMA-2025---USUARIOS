package main.java.com.pragma.powerup.domain.usecase;

import main.java.com.pragma.powerup.domain.api.IUsuarioServicePort;
import main.java.com.pragma.powerup.domain.exception.DomainException;
import main.java.com.pragma.powerup.domain.model.RestaurantEmployeeModel;
import main.java.com.pragma.powerup.domain.model.RestaurantModel;
import main.java.com.pragma.powerup.domain.model.Rol;
import main.java.com.pragma.powerup.domain.model.Usuario;
import main.java.com.pragma.powerup.domain.spi.feignclients.IRestaurantEmployeeFeignClientPort;
import main.java.com.pragma.powerup.domain.spi.feignclients.IRestaurantFeingClientPort;
import main.java.com.pragma.powerup.domain.spi.passwordencoder.IUsuarioPasswordEncoderPort;
import main.java.com.pragma.powerup.domain.spi.persistence.IUsuarioPersistencePort;
import main.java.com.pragma.powerup.domain.spi.token.IToken;


import java.util.Arrays;
import java.util.List;


public class UsuarioUseCase implements IUsuarioServicePort {
    private final IUsuarioPersistencePort usuarioPersistencePort;

    private  final IUsuarioPasswordEncoderPort usuarioPasswordEncoderPort;

    private  final IRestaurantEmployeeFeignClientPort restaurantEmployeeFeignClientPort;

    private final IToken token;

    private final IRestaurantFeingClientPort restaurantFeingClientPort;

    public UsuarioUseCase(IUsuarioPersistencePort usuarioPersistencePort, IUsuarioPasswordEncoderPort usuarioPasswordEncoderPort, IRestaurantEmployeeFeignClientPort restaurantEmployeeFeignClientPort, IToken token, IRestaurantFeingClientPort restaurantFeingClientPort) {
        this.usuarioPersistencePort = usuarioPersistencePort;
        this.usuarioPasswordEncoderPort = usuarioPasswordEncoderPort;
        this.restaurantEmployeeFeignClientPort = restaurantEmployeeFeignClientPort;
        this.token = token;
        this.restaurantFeingClientPort = restaurantFeingClientPort;
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        validarRolesAutenYnoAuten(usuario);
        usuario.setClave(usuarioPasswordEncoderPort.encode(usuario.getClave()));
        usuarioPersistencePort.saveUser(usuario);
    }

    private void validarRolesAutenYnoAuten(Usuario usuario){
        String bearerToken = token.getBearerToken();
        Rol rol = new Rol();
        String rolS = "";
        if(!(bearerToken==null)) {

            rolS = token.getUsuarioAutenticadoRol(bearerToken);
            System.out.println(rolS);
        }

        if(rolS.equals("PROPIETARIO")){
            //Puede crear empleados
            rol.setId(3L);
        }else if(rolS.equals("ADMIN")){
            //Puede crear propietarios
            rol.setId(2L);
        }else{
            if(usuario.getRol().getId()==null){
                rol.setId(4L);
            }else
            if(usuario.getRol().getId()==1){
                //Registro de un Admin
                System.out.println("Se esta registrando un ADMIN");
            }

        }
        /*
        Si el campo del Rol tiene un valor (no es nulo)
        este puede ser asignado al usuario.
        Esta validación es necesaria porque solamente al usuario con perfil de Administrador
        se le envía el parámetro del rol en el cuerpo del mensaje JSON.
         */
        if(!(rol.getId()==null)){
            usuario.setRol(rol);
        }
    }


    @Override
    public Usuario getUsuarioById(Long id) {

        return usuarioPersistencePort.getUserById(id);
    }

    @Override
    public Usuario getUsuarioByCorreo(String correo) {

        return usuarioPersistencePort.getUserByCorreo(correo);
    }

    @Override
    public Boolean existeUsuarioById(Long id) {
        return usuarioPersistencePort.existsUserById(id);
    }


    @Override
    public List<Usuario> getTodosUsuarios() {
        return usuarioPersistencePort.getAllUsers();
    }

    @Override
    public void eliminarUsuarioById(Long id) {
        usuarioPersistencePort.eliminarUsuarioById(id);
    }

}
