package gt.com.edu.security.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gt.com.edu.security.entity.Rol;


public interface IRolService {
	
	
    public List<Rol> findAll();
	
	public Page<Rol> findAll(Pageable pageable);
    
	public Rol findById(Long id);
    
	public Rol save(Rol rol);
   
	public void delete(Long id);

}
