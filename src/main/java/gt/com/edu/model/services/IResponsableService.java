package gt.com.edu.model.services;

import java.util.List;

import gt.com.edu.models.entity.Estudiante;
import gt.com.edu.models.entity.Responsable;

public interface IResponsableService {

	//listar responsables
	List<Responsable> findAll();
	//buscar responsable por id
	Responsable findById(Long id);
    //guardar responsable
	Responsable save(Responsable responsable);
    //eliminar responsable
	void delete(Long id);
	
	List<Estudiante> obtenerEstudiantes(Long id);

}
