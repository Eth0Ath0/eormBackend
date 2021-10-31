package gt.com.edu.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
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
import org.springframework.web.multipart.MultipartFile;

import gt.com.edu.model.services.IClaseService;
import gt.com.edu.model.services.IContenidoService;
import gt.com.edu.model.services.StorageService;
import gt.com.edu.models.entity.Clase;
import gt.com.edu.models.entity.Contenido;

@RestController
@RequestMapping("/api/contenidos")
@CrossOrigin(origins={"http://localhost:4200","*"})
public class contenidoController {
	
	@Autowired
	private IContenidoService contenidoService;
	
	

	
	@Autowired
	StorageService service;
	
	@Autowired
	private IClaseService claseService;
	
	@PreAuthorize("hasRole('ADMIN') AND hasRole('PROFESOR') OR hasRole('ESTUDIANTES')")
	@GetMapping("/listar")
	public List<Contenido> listarContenidos(){
		return contenidoService.findAll();
	
		
	}
	
	@PreAuthorize("hasRole('ADMIN') AND hasRole('PROFESOR') OR hasRole('ESTUDIANTES')")
	@GetMapping("/listar/page/{page}")
	public Page<Contenido> listarContenidos(@PathVariable Integer page){
		Pageable pageable=PageRequest.of(page, 5);
		return contenidoService.findAll(pageable);
	
		
	}
	
	
	
	
	@PreAuthorize("hasRole('ADMIN') AND hasRole('PROFESOR') OR hasRole('ESTUDIANTE')")
	@GetMapping("/clases")
	public List<Clase> listarClases(){
		return claseService.findAll();
	
		
	}
	
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/buscar/{id}")
	public Contenido show(@PathVariable Long  id) {
		return contenidoService.findById(id);
		
	}
	/*@PreAuthorize("hasRole('ADMIN') AND hasRole('PROFESOR') ")
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Contenido create(@RequestBody Contenido contenido) {
		return contenidoService.save(contenido);
		
	}*/
	
	
	
	//cargar un archivo al bucket AWS
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam( value ="file") MultipartFile file, @RequestParam("id_clase")String id_clase,@RequestParam("nombre_contenido")String nombre_contenido) {
		
    	Clase clase= claseService.findById(Long.parseLong(id_clase));
    	
    	String nombreArchivo=service.uploadFile(file);
    	
    	Contenido contenido=new Contenido();
    	java.util.Date fecha = new Date();
    	contenido.setArchivo(nombreArchivo);
    	contenido.setNombre_contenido(nombre_contenido);
    	contenido.setFecha_creacion(fecha);
    	contenido.setClase(clase);
    	
    	
    	contenidoService.save(contenido);
    	
			return new ResponseEntity<>(contenido.getNombre_contenido(), HttpStatus.OK);
	}
	
	
	
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR') ")
	@PutMapping("/actualizar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Contenido update(@RequestBody Contenido contenido, @PathVariable Long id) {
		
		
		Contenido contenidoActual=contenidoService.findById(id);
		
		contenidoActual.setId(contenido.getId());
		contenidoActual.setNombre_contenido(contenido.getNombre_contenido());
		contenidoActual.setFecha_creacion(contenido.getFecha_creacion());
		contenidoActual.setArchivo(contenido.getArchivo());
		contenidoActual.setClase(contenido.getClase());
		
		return contenidoService.save(contenidoActual);
	}
	
	
	//descarga archivo del bucket AWS
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR') OR ('ESTUDIANTE')")
	@GetMapping("/download/{fileName}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName){
		
	byte[] data=service.downloadFile(fileName);
	ByteArrayResource resource= new ByteArrayResource(data);
	return ResponseEntity
            .ok()
            .contentLength(data.length)
            .header("Content-type", "application/octet-stream")
            .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
            .body(resource);	
		
	}

	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR') ")
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
    contenidoService.delete(id);
		
		
		
	}
	
	// eliminar archivo del bucket AWS
	    @PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR') ")
	    @DeleteMapping("/delete/{fileName}")
	    public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
	        return new ResponseEntity<>(service.deleteFile(fileName), HttpStatus.OK);
	    }
	
	

}
