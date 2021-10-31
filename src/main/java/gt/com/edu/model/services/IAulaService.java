package gt.com.edu.model.services;

import java.util.List;

import gt.com.edu.models.entity.Aula;



public interface IAulaService {
	 //listar aula
		List<Aula> findAll();
		//buscar aula por id
		Aula findById(Long id);
	    //guardar aula 
		Aula save(Aula aula);
	    //eliminar aula
		void delete(Long id);

}
