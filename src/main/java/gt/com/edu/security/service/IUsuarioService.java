package gt.com.edu.security.service;

import java.util.List;

import gt.com.edu.security.entity.Usuario;

public interface IUsuarioService {
	
	List<Usuario> findAll();
	
	Usuario findById(Integer id);
    
	Usuario save(Usuario usuario);
   
	void delete(Integer id);


}
