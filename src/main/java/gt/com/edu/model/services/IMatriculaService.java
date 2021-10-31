package gt.com.edu.model.services;

import java.util.List;

import gt.com.edu.models.entity.Matricula;
public interface IMatriculaService {
	
	    //listar matricula
		List<Matricula> findAll();
		//buscar matricula por id
		Matricula findById(Long id);
	    //guardar matricula
		Matricula save(Matricula matricula);
	    //eliminar matricula
		void delete(Long id);

}
