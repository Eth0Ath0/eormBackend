package gt.com.edu.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gt.com.edu.models.dao.IEstudianteDao;
import gt.com.edu.models.entity.Estudiante;
@Service
public class EstudianteServiceImpl implements IEstudianteService{
    @Autowired
    private IEstudianteDao estudianteDao;
	@Override
	@Transactional(readOnly = true)
	
	public List<Estudiante> findAll() {
		// listar estudiantes
	return (List<Estudiante>) estudianteDao.findAll();
	}
	@Override
	@Transactional(readOnly = true)
	    //buscar estudiante por ID
	public Estudiante findById(String id) {
		
		return estudianteDao.findById(id).orElse(null);
	}
	@Override
	
	    // Guardar estudiante creado
	public Estudiante save(Estudiante estudiante) {
		
		return estudianteDao.save(estudiante);
	}
	@Override
	public void delete(String id) {
		
		estudianteDao.deleteById(id);
	}
	

}
