package gt.com.edu.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gt.com.edu.models.dao.IMatriculaDao;
import gt.com.edu.models.entity.Matricula;
@Service
public class MatriculaServiceImpl implements IMatriculaService {
@Autowired
	public IMatriculaDao matriculaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Matricula> findAll() {
		// TODO Auto-generated method stub
		return (List<Matricula>) matriculaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Matricula findById(Long id) {
		// TODO Auto-generated method stub
		return matriculaDao.findById(id).orElse(null);
	}

	@Override
	public Matricula save(Matricula matricula) {
		// TODO Auto-generated method stub
		return matriculaDao.save(matricula);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		matriculaDao.deleteById(id);
	}

}
