package gt.com.edu.model.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import gt.com.edu.models.entity.Calificacion;

public interface ICalificacionService {
	 //listar calificacion
	public List<Calificacion> findAll();
	public Page<Calificacion> findAll(Pageable pageable);
	//buscar calificacion por id
	public Calificacion findById(Long id);
    //guardar calificacion 
	public Calificacion save(Calificacion calificacion);
    //eliminar calificacion
	public void delete(Long id);
}
