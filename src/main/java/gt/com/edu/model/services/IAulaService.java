package gt.com.edu.model.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gt.com.edu.models.entity.Aula;



public interface IAulaService {
	 //listar aula
		public List<Aula> findAll();
		
		public Page<Aula> findAll(Pageable pageable);
		//buscar aula por id
		public Aula findById(Long id);
	    //guardar aula 
		public Aula save(Aula aula);
	    //eliminar aula
		public void delete(Long id);

}
