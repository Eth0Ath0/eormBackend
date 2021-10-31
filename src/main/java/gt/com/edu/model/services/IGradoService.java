package gt.com.edu.model.services;

import java.util.List;

import gt.com.edu.models.entity.Grado;


public interface IGradoService {
	
	 //listar grado
	List<Grado> findAll();
	//buscar grado por id
	Grado findById(Long id);
    //guardar grado 
	Grado save(Grado grado);
    //eliminar grado
	void delete(Long id);
}
