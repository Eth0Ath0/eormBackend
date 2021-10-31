package gt.com.edu.model.services;

import java.util.List;

import gt.com.edu.models.entity.Contenido;


public interface IContenidoService {
	
	//listar contenido
	List<Contenido> findAll();
	//buscar  contenido por id
	Contenido findById(Long id);
    //guardar contenido 
	Contenido save(Contenido contenido);
    //eliminar contenido
	void delete(Long id);

}
