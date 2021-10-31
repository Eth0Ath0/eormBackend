package gt.com.edu.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gt.com.edu.models.dao.IProfesorDao;
import gt.com.edu.models.entity.Profesor;

@Service
public class ProfesorServiceImpl implements IProfesorService {

	@Autowired
	public IProfesorDao iprofesorDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Profesor> findAll() {
		// TODO Auto-generated method stub
		return (List<Profesor>) iprofesorDao.findAll();
	}
	
	
	
	@Override
	@Transactional(readOnly = true)
	public Page<Profesor> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return iprofesorDao.findAll(pageable);
	}

	

	@Override
	@Transactional(readOnly = true)
	public Profesor findById(Long id) {
		// TODO Auto-generated method stub
		return iprofesorDao.findById(id).orElse(null);
	}

	@Override
	public Profesor save(Profesor profesor) {
		// TODO Auto-generated method stub
		return iprofesorDao.save(profesor);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		iprofesorDao.deleteById(id);
	}

	
	
}
