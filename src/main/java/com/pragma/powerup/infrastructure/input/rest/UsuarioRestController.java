package main.java.com.pragma.powerup.infrastructure.input.rest;

import main.java.com.pragma.powerup.application.dto.request.UsuarioRequestDto;
import main.java.com.pragma.powerup.application.dto.response.UsuarioResponseDto;
import main.java.com.pragma.powerup.application.handler.IUsuarioHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@SecurityRequirement(name = "jwt")
public class UsuarioRestController {

    private final IUsuarioHandler usuarioHandler;

    @Operation(summary = "Crear un nuevo propietario",
            description = "Solo accesible por administradores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Propietario creado exitosamente",
                    content = @Content(schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
            @ApiResponse(responseCode = "403", description = "Acceso no autorizado"),
            @ApiResponse(responseCode = "409", description = "El usuario ya existe")
    })
    @PostMapping("/owners")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UsuarioResponseDto> crearPropietario(@Valid @RequestBody UsuarioRequestDto usuarioRequestDto) {
        UsuarioResponseDto response = usuarioHandler.crearPropietario(usuarioRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Crear un nuevo empleado",
            description = "Solo accesible por propietarios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Empleado creado exitosamente",
                    content = @Content(schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
            @ApiResponse(responseCode = "403", description = "Acceso no autorizado"),
            @ApiResponse(responseCode = "409", description = "El usuario ya existe")
    })
    @PostMapping("/employees")
    @PreAuthorize("hasRole('PROPIETARIO')")
    public ResponseEntity<UsuarioResponseDto> crearEmpleado(@Valid @RequestBody UsuarioRequestDto usuarioRequestDto) {
        UsuarioResponseDto response = usuarioHandler.crearEmpleado(usuarioRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // REst para Historia de Usuario 08
    @Operation(summary = "Registrar un nuevo cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente registrado exitosamente",
                    content = @Content(schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
            @ApiResponse(responseCode = "409", description = "El usuario ya existe")
    })
    @PostMapping("/clients")
    public ResponseEntity<UsuarioResponseDto> registrarCliente(@Valid @RequestBody UsuarioRequestDto usuarioRequestDto) {
        UsuarioResponseDto response = usuarioHandler.registrarCliente(usuarioRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Obtener todos los usuarios (paginated)",
            description = "Solo accesible por administradores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de usuarios obtenida",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = UsuarioResponseDto.class)))),
            @ApiResponse(responseCode = "204", description = "No hay usuarios registrados"),
            @ApiResponse(responseCode = "403", description = "Acceso no autorizado")
    })
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Page<UsuarioResponseDto>> getTodosUsuarios(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "nombre") String sortBy) {
        Page<UsuarioResponseDto> usuarios = usuarioHandler.getTodosUsuarios(
                PageRequest.of(page, size, Sort.by(sortBy)));
        return usuarios.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(usuarios);
    }

    @Operation(summary = "Obtener usuario por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario encontrado",
                    content = @Content(schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> getUsuarioById(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioHandler.getUsuarioById(id));
    }

    @Operation(summary = "Obtener usuario por email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario encontrado",
                    content = @Content(schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioResponseDto> getUsuarioByCorreo(@PathVariable String email) {
        return ResponseEntity.ok(usuarioHandler.getUsuarioByCorreo(email));
    }

    @Operation(summary = "Verificar existencia de usuario por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Existencia verificada",
                    content = @Content(schema = @Schema(implementation = Boolean.class)))
    })
    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existeUsuarioById(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioHandler.existeUsuarioById(id));
    }

    @Operation(summary = "Eliminar usuario por ID",
            description = "Solo accesible por administradores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Usuario eliminado"),
            @ApiResponse(responseCode = "403", description = "Acceso no autorizado"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> eliminarUsuarioById(@PathVariable Long id) {
        usuarioHandler.eliminarUsuarioById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Actualizar usuario",
            description = "Solo accesible por el propio usuario o administradores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario actualizado",
                    content = @Content(schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
            @ApiResponse(responseCode = "403", description = "Acceso no autorizado"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    @PutMapping("/{id}")
    @PreAuthorize("#id == authentication.principal.id or hasRole('ADMIN')")
    public ResponseEntity<UsuarioResponseDto> actualizarUsuario(
            @PathVariable Long id,
            @Valid @RequestBody UsuarioRequestDto usuarioRequestDto) {
        return ResponseEntity.ok(usuarioHandler.actualizarUsuario(id, usuarioRequestDto));
    }
}