package gt.com.edu.model.services;

import java.util.List;

import gt.com.edu.models.entity.Calificacion;

public interface ICalificacionService {
	 //listar calificacion
	List<Calificacion> findAll();
	//buscar calificacion por id
	Calificacion findById(Long id);
    //guardar calificacion 
	Calificacion save(Calificacion calificacion);
    //eliminar calificacion
	void delete(Long id);
}
