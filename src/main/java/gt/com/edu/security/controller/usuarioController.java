package gt.com.edu.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import gt.com.edu.models.entity.Curso;
import gt.com.edu.security.entity.Usuario;
import gt.com.edu.security.service.IUsuarioService;
import gt.com.edu.security.service.UsuarioServiceImpl;


@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin()
public class usuarioController {
	
@Autowired
	public IUsuarioService usuarioService;
@Autowired
    public UsuarioServiceImpl usuarioServiceImpl;
	
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
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/buscar/{id}")
	public Usuario show(@PathVariable Long  id) {
		return usuarioService.findById(id);
		
	}
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
		
	}
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@PutMapping("/actualizar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id) {
		
		Usuario usuarioActual=usuarioService.findById(id);
		
		usuarioActual.setId(usuario.getId());
		usuarioActual.setNombre(usuario.getNombre());
		usuarioActual.setNombreUsuario(usuario.getNombreUsuario());
		usuarioActual.setPassword(usuario.getPassword());
		usuarioActual.setEmail(usuario.getEmail());
		usuarioActual.setRoles(usuario.getRoles());
		
		
		return usuarioService.save(usuarioActual);
	}
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
	usuarioService.delete(id);
		
		
		
	}

	
	
	
	
	

}
