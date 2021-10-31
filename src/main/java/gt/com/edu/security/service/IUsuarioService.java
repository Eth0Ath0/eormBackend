package gt.com.edu.security.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gt.com.edu.security.entity.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findAll();
	
	public Page<Usuario> findAll(Pageable pageable);
	
	public Usuario findById(Integer id);
    
	public Usuario save(Usuario usuario);
   
	public void delete(Integer id);


}
