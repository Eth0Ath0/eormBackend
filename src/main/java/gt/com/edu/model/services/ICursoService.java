package gt.com.edu.model.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import gt.com.edu.models.entity.Curso;


public interface ICursoService {
	
	 //listar curso
		public List<Curso> findAll();
		
		public Page<Curso> findAll(Pageable pageable);
		//buscar curso por id
		public Curso findById(Long id);
	    //guardar curso 
		public Curso save(Curso curso);
	    //eliminar curso
		public void delete(Long id);

}
