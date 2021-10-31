package gt.com.edu.model.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gt.com.edu.models.entity.Grado;


public interface IGradoService {
	
	 //listar grado
	public List<Grado> findAll();
	public Page<Grado> findAll(Pageable pageable);
	//buscar grado por id
	public Grado findById(Long id);
    //guardar grado 
	public Grado save(Grado grado);
    //eliminar grado
	public void delete(Long id);
}
