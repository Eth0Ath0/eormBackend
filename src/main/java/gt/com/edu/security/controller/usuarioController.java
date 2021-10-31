package gt.com.edu.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gt.com.edu.security.entity.Usuario;
import gt.com.edu.security.service.IUsuarioService;


@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins={"http://localhost:4200","*"})
public class usuarioController {
	
@Autowired
	public IUsuarioService usuarioService;
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/listar")
	public List<Usuario> listarUsuarios(){
		return usuarioService.findAll();
	
		
	}
	
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/listar/page/{page}")
	public Page<Usuario> listarUsuarios(@PathVariable Integer page){
		Pageable pageable=PageRequest.of(page, 5);
		return usuarioService.findAll(pageable);
	
		
	}
	
	
	
	
	

}
