package gt.com.edu.security.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gt.com.edu.models.entity.Clase;
import gt.com.edu.security.entity.Usuario;
import gt.com.edu.security.repositoty.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {
	 @Autowired
	    UsuarioRepository usuarioRepository;

	    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
	        return usuarioRepository.findByNombreUsuario(nombreUsuario);
	    }

	    public boolean existsByNombreUsuario(String nombreUsuario){
	        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
	    }

	    public boolean existsByEmail(String email){
	        return usuarioRepository.existsByEmail(email);
	    }

	    public void save(Usuario usuario){
	        usuarioRepository.save(usuario);
	    }
	    
	   

}
