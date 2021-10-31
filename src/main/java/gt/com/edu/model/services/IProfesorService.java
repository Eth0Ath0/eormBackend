package gt.com.edu.model.services;

import java.util.List;
import gt.com.edu.models.entity.Profesor;

public interface IProfesorService {
	
	        //listar profesor
			List<Profesor> findAll();
			//buscar profesor por id
			Profesor findById(Long id);
		    //guardar profesor 
			Profesor save(Profesor profesor);
		    //eliminar profesor
			void delete(Long id);

}
