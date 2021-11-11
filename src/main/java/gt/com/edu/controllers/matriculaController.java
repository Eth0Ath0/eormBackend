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

import gt.com.edu.model.services.IEstudianteService;
import gt.com.edu.model.services.IMatriculaService;
import gt.com.edu.models.entity.Estudiante;
import gt.com.edu.models.entity.Matricula;


@RestController
@RequestMapping("/api/matriculas")
@CrossOrigin()
//@CrossOrigin(origins={"http://localhost:4200","*"})
public class matriculaController {
	
	@Autowired
	private IMatriculaService matriculaService;
	
	@Autowired
	private IEstudianteService estudianteService;
	
	
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/listar")
	public List<Matricula> listarMatriculas(){
		return matriculaService.findAll();
	
		
	}
	
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/listar/page/{page}")
	public Page<Matricula> listarMatriculas(@PathVariable Integer page){
		Pageable pageable=PageRequest.of(page, 5);
		return matriculaService.findAll(pageable);
	
		
	}
	
	
	
	
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/estudiantes")
	public List<Estudiante> listarEstudiantes(){
		return estudianteService.findAll();
	
		
	}
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/buscar/{id}")
	public Matricula show(@PathVariable Long  id) {
		return matriculaService.findById(id);
		
	}
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Matricula create(@RequestBody Matricula matricula) {
		return matriculaService.save(matricula);
		
	}
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@PutMapping("/actualizar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Matricula update(@RequestBody Matricula matricula, @PathVariable Long id) {
		
		Matricula matriculaActual=matriculaService.findById(id);
		
		matriculaActual.setId_matricula(matricula.getId_matricula());
		matriculaActual.setFecha_matricula(matricula.getFecha_matricula());
		matriculaActual.setObservaciones(matricula.getObservaciones());
		matriculaActual.setEstudiante(matricula.getEstudiante());
		
		return matriculaService.save(matriculaActual);
	}
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
		matriculaService.delete(id);
		
		
		
	}


}
