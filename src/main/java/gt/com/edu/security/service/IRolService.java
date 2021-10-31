package gt.com.edu.security.service;

import java.util.List;

import gt.com.edu.security.entity.Rol;

public interface IRolService {
	
	
List<Rol> findAll();
	
	Rol findById(Integer id);
    
	Rol save(Rol rol);
   
	void delete(Integer id);

}
