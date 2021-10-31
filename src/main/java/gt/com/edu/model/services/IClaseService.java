package gt.com.edu.model.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import gt.com.edu.models.entity.Clase;

public interface IClaseService {
	
	        //listar clase
			public List<Clase> findAll();
			public Page<Clase> findAll(Pageable pageable);
			//buscar clase por id
			public Clase findById(Long id);
		    //guardar clase 
			public Clase save(Clase clase);
		    //eliminar clase
			public void delete(Long id);

}
