package gt.com.edu.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gt.com.edu.models.dao.IGradoDao;
import gt.com.edu.models.entity.Grado;

@Service
public class GradoServiceImpl implements IGradoService {
	@Autowired
	public IGradoDao igradoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Grado> findAll() {
		// TODO Auto-generated method stub
		return (List<Grado>) igradoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Grado findById(Long id) {
		// TODO Auto-generated method stub
		return igradoDao.findById(id).orElse(null);
	}

	@Override
	public Grado save(Grado grado) {
		// TODO Auto-generated method stub
		return igradoDao.save(grado);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		igradoDao.deleteById(id);
	}
	
	

}
