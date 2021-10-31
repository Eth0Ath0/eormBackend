package gt.com.edu.controllers;

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

import gt.com.edu.model.services.IAulaService;
import gt.com.edu.model.services.IClaseService;
import gt.com.edu.model.services.ICursoService;
import gt.com.edu.model.services.IProfesorService;
import gt.com.edu.models.entity.Aula;
import gt.com.edu.models.entity.Clase;
import gt.com.edu.models.entity.Curso;
import gt.com.edu.models.entity.Profesor;

@RestController
@RequestMapping("/api/clases")
@CrossOrigin(origins={"http://localhost:4200","*"})
public class claseController {
	
	@Autowired
	private IClaseService claseService;
	@Autowired
	private IProfesorService profesorService;
	@Autowired
	private ICursoService cursoService;
	@Autowired
	private IAulaService aulaService;
	
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/listar")
	public List<Clase> listarClases(){
		return claseService.findAll();
	
		
	}
	
	
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/listar/page/{page}")
	public Page<Clase> listarClases(@PathVariable Integer page){
		Pageable pageable=PageRequest.of(page, 5);
		return claseService.findAll(pageable);
	
		
	}
	
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/profesores")
	public List<Profesor> listarProfesores(){
		return profesorService.findAll();
	
		
	}
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/cursos")
	public List<Curso> listarCursos(){
		return cursoService.findAll();
	
		
	}
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/aulas")
	public List<Aula> listarAulas(){
		return aulaService.findAll();
	
		
	}
	
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/buscar/{id}")
	public Clase show(@PathVariable Long  id) {
		return claseService.findById(id);
		
	}
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Clase create(@RequestBody Clase clase) {
		return claseService.save(clase);
		
	}
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@PutMapping("/actualizar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Clase update(@RequestBody Clase clase, @PathVariable Long id) {
		
		Clase claseActual=claseService.findById(id);
		
		claseActual.setId(clase.getId());
		claseActual.setDescripcion(clase.getDescripcion());
		claseActual.setProfesor(clase.getProfesor());
		claseActual.setCurso(clase.getCurso());
		claseActual.setAula(clase.getAula());
		
		return claseService.save(claseActual);
	}
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
	claseService.delete(id);
		
		
		
	}

}
