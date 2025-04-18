package main.java.com.pragma.powerup.infrastructure.out.jpa.adapter;

import main.java.com.pragma.powerup.domain.model.Rol;
import main.java.com.pragma.powerup.domain.spi.persistence.IRolPersistencePort;
import main.java.com.pragma.powerup.infrastructure.exception.NoDataFoundException;
import main.java.com.pragma.powerup.infrastructure.out.jpa.entity.RolEntity;
import main.java.com.pragma.powerup.infrastructure.out.jpa.mapper.IRolEntityMapper;
import main.java.com.pragma.powerup.infrastructure.out.jpa.repository.IRolRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class RolJpaAdapter implements IRolPersistencePort {


    private  final IRolRepository rolRepository;
    private  final IRolEntityMapper rolEntityMapper;


    @Override
    public Rol guardarRol(Rol rol) {
        RolEntity rolEntity = rolRepository.save(rolEntityMapper.toEntity(rol));
        return rolEntityMapper.toRolModel(rolEntity);
    }

    @Override
    public Rol obtenerRolById(Long id) {
        Optional<RolEntity> optionalRolEntity = rolRepository.findById(id);
        RolEntity rolEntity = optionalRolEntity.orElse(null);
        return rolEntityMapper.toRolModel(rolEntity);
    }

    @Override
    public List<Rol> obtenerTodosRoles() {
        List<RolEntity> rolEntityList = rolRepository.findAll();
        if(rolEntityList.isEmpty()){
           throw  new NoDataFoundException();
        }
        return rolEntityMapper.toRolModelList(rolEntityList);
    }

    @Override
    public void eliminarRolById(Long id) {
            rolRepository.eliminarById(id);
    }
}
