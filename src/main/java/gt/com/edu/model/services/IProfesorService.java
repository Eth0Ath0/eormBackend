package gt.com.edu.model.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import gt.com.edu.models.entity.Profesor;

public interface IProfesorService {
	
	        //listar profesor
			public List<Profesor> findAll();
			
			public Page<Profesor> findAll(Pageable pageable);
			//buscar profesor por id
			public Profesor findById(Long id);
		    //guardar profesor 
			public Profesor save(Profesor profesor);
		    //eliminar profesor
			public void delete(Long id);

}
