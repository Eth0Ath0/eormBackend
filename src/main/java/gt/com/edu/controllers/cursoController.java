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
import gt.com.edu.model.services.ICursoService;
import gt.com.edu.models.entity.Curso;


@RestController
@RequestMapping("/api/cursos")
@CrossOrigin()
public class cursoController {
	
	@Autowired
	private ICursoService cursoService;
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/listar")
	public List<Curso> index(){
		return cursoService.findAll();
	
		
	}
	
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/listar/page/{page}")
	public Page<Curso> index(@PathVariable Integer page){
		Pageable pageable=PageRequest.of(page, 5);
		return cursoService.findAll(pageable);
	
		
	}
	
	
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/buscar/{id}")
	public Curso show(@PathVariable Long  id) {
		return cursoService.findById(id);
		
	}
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Curso create(@RequestBody Curso curso) {
		return cursoService.save(curso);
		
	}
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@PutMapping("/actualizar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Curso update(@RequestBody Curso curso, @PathVariable Long id) {
		
		Curso cursoActual=cursoService.findById(id);
		
		cursoActual.setId(curso.getId());
		cursoActual.setNombre_curso(curso.getNombre_curso());
		
		return cursoService.save(cursoActual);
	}
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
	cursoService.delete(id);
		
		
		
	}

}
