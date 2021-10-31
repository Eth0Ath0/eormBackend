package gt.com.edu.model.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import gt.com.edu.models.entity.Estudiante;

public interface IEstudianteService {
	//Método para listar estudiantes
	public List<Estudiante> findAll();
	Page<Estudiante> findAll(Pageable pageable);
    //Método para listar por ID
	public Estudiante findById(String id);
	//Método para guardar estudiante
	public Estudiante save(Estudiante estudiante);
	//Método eliminar estudiante
	public void delete(String id);
	
	


	

}
