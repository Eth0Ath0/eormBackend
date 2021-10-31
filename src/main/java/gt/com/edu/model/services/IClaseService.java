package gt.com.edu.model.services;

import java.util.List;

import gt.com.edu.models.entity.Clase;

public interface IClaseService {
	
	        //listar clase
			List<Clase> findAll();
			//buscar clase por id
			Clase findById(Long id);
		    //guardar clase 
			Clase save(Clase clase);
		    //eliminar clase
			void delete(Long id);

}
