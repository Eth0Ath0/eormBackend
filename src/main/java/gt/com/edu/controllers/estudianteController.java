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
import gt.com.edu.model.services.IEstudianteService;
import gt.com.edu.model.services.IGradoService;
import gt.com.edu.model.services.IResponsableService;
import gt.com.edu.models.entity.Aula;
import gt.com.edu.models.entity.Estudiante;
import gt.com.edu.models.entity.Grado;
import gt.com.edu.models.entity.Responsable;
import gt.com.edu.security.entity.Usuario;
import gt.com.edu.security.repositoty.UsuarioRepository;


@RestController
@RequestMapping("/api/estudiantes")
@CrossOrigin(origins={"http://localhost:4200","*"})
public class estudianteController {

	@Autowired
	private IEstudianteService estudianteservice;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private IResponsableService responsableService;
	
	
	@Autowired
	private IGradoService gradoService;
	
	@Autowired
	private IAulaService aulaService;
	
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/listar")
	public List<Estudiante> listarEstudiantes(){
		return estudianteservice.findAll();
	
		
	}
	
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/listar/page/{page}")
	public Page<Estudiante> listarEstudiantes(@PathVariable Integer page){
		Pageable pageable=PageRequest.of(page, 5);
		return estudianteservice.findAll(pageable);
	
		
	}
	
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/usuarios")
	public List<Usuario> listarUsuarios(){
		return usuarioRepository.findAll();
	
		
	}
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/responsables")
	public List<Responsable> listarResponsables(){
		return responsableService.findAll();
	
		
	}
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/grados")
	public List<Grado> listarGrados(){
		return gradoService.findAll();
	
		
	}
	
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/aulas")
	public List<Aula> listarAulas(){
		return aulaService.findAll();
	
		
	}
	
	
	
	
	
	
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/buscar/{codigo_personal}")
	public Estudiante show(@PathVariable String  codigo_personal) {
		return estudianteservice.findById(codigo_personal);
		
	}
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Estudiante create(@RequestBody Estudiante estudiante) {
		return estudianteservice.save(estudiante);
		
	}
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@PutMapping("/actualizar/{codigo_personal}")
	@ResponseStatus(HttpStatus.CREATED)
	public Estudiante update(@RequestBody Estudiante estudiante, @PathVariable String codigo_personal) {
		
		Estudiante estudianteActual=estudianteservice.findById(codigo_personal);
		estudianteActual.setCodigo_personal(estudiante.getCodigo_personal());
		estudianteActual.setPrimer_nombre_estudiante(estudiante.getPrimer_nombre_estudiante());
		estudianteActual.setSegundo_nombre_estudiante(estudiante.getPrimer_nombre_estudiante());
		estudianteActual.setPrimer_apellido_estudiante(estudiante.getPrimer_apellido_estudiante());
		estudianteActual.setSegundo_apellido_estudiante(estudiante.getSegundo_apellido_estudiante());
		estudianteActual.setDireccion_estudiante(estudiante.getDireccion_estudiante());
		estudianteActual.setEdad_estudiante(estudiante.getEdad_estudiante());
		estudianteActual.setFecha_nacimiento(estudiante.getFecha_nacimiento());
		estudianteActual.setIdioma_estudiante(estudiante.getIdioma_estudiante());
		estudianteActual.setLateralidad_estudiante(estudiante.getLateralidad_estudiante());
		estudianteActual.setObservacion(estudiante.getObservacion());
		estudianteActual.setSexo_estudiante(estudiante.getSexo_estudiante());
		//llaves foráneas
		estudianteActual.setUsuario(estudiante.getUsuario());
		estudianteActual.setResponsable(estudiante.getResponsable());
		estudianteActual.setGrado(estudiante.getGrado());
		estudianteActual.setAula(estudiante.getAula());
		
		return estudianteservice.save(estudianteActual);
	}
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@DeleteMapping("/eliminar/{codigo_personal}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String codigo_personal) {
		estudianteservice.delete(codigo_personal);
		
		
		
	}

}
