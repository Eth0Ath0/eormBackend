package gt.com.edu.model.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import gt.com.edu.models.entity.Contenido;


public interface IContenidoService {
	
	//listar contenido
	public List<Contenido> findAll();
	public Page<Contenido> findAll(Pageable pageable);
	//buscar  contenido por id
	public Contenido findById(Long id);
    //guardar contenido 
	public Contenido save(Contenido contenido);
    //eliminar contenido
	public void delete(Long id);

}
