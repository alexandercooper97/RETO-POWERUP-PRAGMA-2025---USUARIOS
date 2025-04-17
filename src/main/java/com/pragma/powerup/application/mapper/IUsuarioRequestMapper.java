package main.java.com.pragma.powerup.application.mapper;

import main.java.com.pragma.powerup.application.dto.request.UsuarioRequestDto;
import main.java.com.pragma.powerup.domain.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUsuarioRequestMapper {

    @Mapping(target = "rol.id", source = "rol")
    Usuario toUsuario(UsuarioRequestDto usuarioRequestDto);


}
