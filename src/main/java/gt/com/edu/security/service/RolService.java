package gt.com.edu.security.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gt.com.edu.security.entity.Rol;
import gt.com.edu.security.enums.RolNombre;
import gt.com.edu.security.repositoty.RolRepository;

@Service
@Transactional
public class RolService {
	
	 @Autowired
	    RolRepository rolRepository;

	    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
	        return rolRepository.findByRolNombre(rolNombre);
	    }

	    public void save(Rol rol){
	        rolRepository.save(rol);
	    }
}
