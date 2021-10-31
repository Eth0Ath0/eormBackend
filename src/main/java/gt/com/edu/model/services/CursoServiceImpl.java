package gt.com.edu.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gt.com.edu.models.dao.ICursoDao;
import gt.com.edu.models.entity.Curso;

@Service

public class CursoServiceImpl implements ICursoService{
@Autowired
public ICursoDao icursoDao;

@Override
@Transactional(readOnly = true)
public List<Curso> findAll() {
	// TODO Auto-generated method stub
	return (List<Curso>) icursoDao.findAll();
}

@Override
@Transactional(readOnly = true)
public Curso findById(Long id) {
	// TODO Auto-generated method stub
	return icursoDao.findById(id).orElse(null);
}

@Override
public Curso save(Curso curso) {
	// TODO Auto-generated method stub
	return icursoDao.save(curso);
}

@Override
public void delete(Long id) {
	// TODO Auto-generated method stub
	icursoDao.deleteById(id);
}


}
