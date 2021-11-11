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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import gt.com.edu.model.services.IResponsableService;
import gt.com.edu.models.entity.Estudiante;
import gt.com.edu.models.entity.Responsable;
@RestController
@RequestMapping("/api/responsables")
@CrossOrigin()
public class responsableController {
	@Autowired
	private IResponsableService responsableservice;
	
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/listar")
	public List<Responsable> index(){
		return responsableservice.findAll();
	
		
	}
	
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/listar/page/{page}")
	public Page<Responsable> index(@PathVariable Integer page){
		Pageable pageable=PageRequest.of(page, 5);
		return responsableservice.findAll(pageable);
	
		
	}
	
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/estudiantesPorResponsable")
	public List<Estudiante> estudiantesPorResponsable(@RequestParam("id") String id){
		return responsableservice.obtenerEstudiantes(Long.parseLong(id));
	
		
	}

	
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/buscar/{id}")
	public Responsable show(@PathVariable Long  id) {
		return responsableservice.findById(id);
		
	}
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Responsable create(@RequestBody Responsable responsable) {
		return responsableservice.save(responsable);
		
	}
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@PutMapping("/actualizar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Responsable update(@RequestBody Responsable responsable, @PathVariable Long id) {
		
		Responsable responsableActual=responsableservice.findById(id);
		responsableActual.setId_responsable(responsable.getId_responsable());
		responsableActual.setPrimer_nombre_responsable(responsable.getPrimer_nombre_responsable());
		responsableActual.setSegundo_nombre_responsable(responsable.getSegundo_nombre_responsable());
		responsableActual.setPrimer_apellido_responsable(responsable.getPrimer_apellido_responsable());
		responsableActual.setSegundo_apellido_responsable(responsable.getSegundo_apellido_responsable());
		responsableActual.setDpi_responsable(responsable.getDpi_responsable());
		responsableActual.setFecha_nacimiento_responsable(responsable.getFecha_nacimiento_responsable());
		responsableActual.setEdad_responsable(responsable.getEdad_responsable());
		responsableActual.setSexo_responsable(responsable.getSexo_responsable());
		responsableActual.setDireccion_responsable(responsable.getDireccion_responsable());
		responsableActual.setTelefono_responsable(responsable.getTelefono_responsable());
		responsableActual.setEmail_responsable(responsable.getEmail_responsable());
		return responsableservice.save(responsableActual);
	}
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		responsableservice.delete(id);
		
		
		
	}


}
