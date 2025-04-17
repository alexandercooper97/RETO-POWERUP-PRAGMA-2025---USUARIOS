package main.java.com.pragma.powerup.application.mapper;

import main.java.com.pragma.powerup.application.dto.request.RolRequestDto;
import main.java.com.pragma.powerup.domain.model.Rol;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRolRequestMapper {

    Rol toRol(RolRequestDto rolRequestDto);

}
