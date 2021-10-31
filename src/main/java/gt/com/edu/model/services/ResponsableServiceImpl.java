package gt.com.edu.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gt.com.edu.models.dao.IResponsableDao;
import gt.com.edu.models.entity.Estudiante;
import gt.com.edu.models.entity.Responsable;

@Service
public class ResponsableServiceImpl implements IResponsableService {
	@Autowired
	private IResponsableDao responsableDao;
	@Override
	@Transactional(readOnly = true)
	public List<Responsable> findAll() {
		// listar responsables
	return (List<Responsable>) responsableDao.findAll();
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public Page<Responsable> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return responsableDao.findAll(pageable);
	}
	
	
	
	@Override
	@Transactional(readOnly = true)
	    //buscar responsable por ID
	public Responsable findById(Long id) {
		
		return responsableDao.findById(id).orElse(null);
	}
	@Override
	
	    // Guardar responsable creado
	public Responsable save(Responsable responsable) {
		
		return responsableDao.save(responsable);
	}
	@Override
	public void delete(Long id) {
		
		responsableDao.deleteById(id);
	}

	@Override
	public List<Estudiante> obtenerEstudiantes(Long id) {
		// TODO Auto-generated method stub
		return responsableDao.estudiantes(id);
	}

	
	
	
	

}
