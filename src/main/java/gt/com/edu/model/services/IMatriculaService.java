package gt.com.edu.model.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import gt.com.edu.models.entity.Matricula;
public interface IMatriculaService {
	
	    //listar matricula
		public List<Matricula> findAll();
		
		public Page<Matricula> findAll(Pageable pageable);
		//buscar matricula por id
		public Matricula findById(Long id);
	    //guardar matricula
		public Matricula save(Matricula matricula);
	    //eliminar matricula
		public void delete(Long id);

}
