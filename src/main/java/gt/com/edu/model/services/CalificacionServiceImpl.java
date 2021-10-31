package gt.com.edu.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gt.com.edu.models.dao.ICalificacionDao;
import gt.com.edu.models.entity.Calificacion;

@Service
public class CalificacionServiceImpl implements ICalificacionService{

	@Autowired
	public ICalificacionDao icalificacionDao;

	@Override
	@Transactional(readOnly = true)
	public List<Calificacion> findAll() {
		// TODO Auto-generated method stub
		return (List<Calificacion>)icalificacionDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Calificacion findById(Long id) {
		// TODO Auto-generated method stub
		return icalificacionDao.findById(id).orElse(null);
	}

	@Override
	public Calificacion save(Calificacion calificacion) {
		// TODO Auto-generated method stub
		return icalificacionDao.save(calificacion);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		icalificacionDao.deleteById(id);
	}
	
	
	
	
}
