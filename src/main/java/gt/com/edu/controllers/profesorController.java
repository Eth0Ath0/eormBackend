package gt.com.edu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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


import gt.com.edu.model.services.IProfesorService;

import gt.com.edu.models.entity.Profesor;
import gt.com.edu.security.entity.Usuario;
import gt.com.edu.security.repositoty.UsuarioRepository;

@RestController
@RequestMapping("/api/profesores")
@CrossOrigin(origins={"http://localhost:4200","*"})
public class profesorController {
	
	
	@Autowired
	private IProfesorService profesorService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/listar")
	public List<Profesor> listarProfesores(){
		return profesorService.findAll();
	
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/usuarios")
	public List<Usuario> listarUsuarios(){
		return usuarioRepository.findAll();
	
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/buscar/{id}")
	public Profesor show(@PathVariable Long  id) {
		return profesorService.findById(id);
		
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Profesor create(@RequestBody Profesor profesor) {
		return profesorService.save(profesor);
		
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/actualizar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Profesor update(@RequestBody Profesor profesor , @PathVariable Long id) {
		
		
		Profesor profesorActual=profesorService.findById(id);
		
		profesorActual.setId(profesor.getId());
		profesorActual.setPrimer_nombre_profesor(profesor.getPrimer_nombre_profesor());
		profesorActual.setSegundo_nombre_profesor(profesor.getSegundo_nombre_profesor());
		profesorActual.setPrimer_apellido_profesor(profesor.getPrimer_apellido_profesor());
		profesorActual.setSegundo_apellido_profesor(profesor.getSegundo_apellido_profesor());
		profesorActual.setDpi_profesor(profesor.getDpi_profesor());
		profesorActual.setFecha_nacimiento_profesor(profesor.getFecha_nacimiento_profesor());
		profesorActual.setEdad_profesor(profesor.getEdad_profesor());
		profesorActual.setSexo_profesor(profesor.getSexo_profesor());
		profesorActual.setDireccion_profesor(profesor.getDireccion_profesor());
		profesorActual.setTelefono_profesor(profesor.getTelefono_profesor());
		profesorActual.setEmail_profesor(profesor.getEmail_profesor());
		profesorActual.setUsuario(profesor.getUsuario());
		
		return profesorService.save(profesorActual);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
    profesorService.delete(id);
		
		
		
	}

}
