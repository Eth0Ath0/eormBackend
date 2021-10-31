package gt.com.edu.model.services;

import java.util.List;

import gt.com.edu.models.entity.Curso;


public interface ICursoService {
	
	 //listar curso
		List<Curso> findAll();
		//buscar curso por id
		Curso findById(Long id);
	    //guardar curso 
		Curso save(Curso curso);
	    //eliminar curso
		void delete(Long id);

}
