package gt.com.edu.model.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import gt.com.edu.models.entity.Estudiante;
import gt.com.edu.models.entity.Responsable;

public interface IResponsableService {

	//listar responsables
	public List<Responsable> findAll();
	
	public Page<Responsable> findAll(Pageable pageable);
	
	//buscar responsable por id
	public Responsable findById(Long id);
    //guardar responsable
	public Responsable save(Responsable responsable);
    //eliminar responsable
	public void delete(Long id);
	
	List<Estudiante> obtenerEstudiantes(Long id);

}
