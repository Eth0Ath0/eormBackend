package gt.com.edu.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gt.com.edu.models.dao.IAulaDao;
import gt.com.edu.models.entity.Aula;
@Service
public class AulaServiceImpl implements IAulaService {
@Autowired
    public IAulaDao iaulaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Aula> findAll() {
		// TODO Auto-generated method stub
		return (List<Aula>) iaulaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Aula findById(Long id) {
		// TODO Auto-generated method stub
		return iaulaDao.findById(id).orElse(null);
	}

	@Override
	public Aula save(Aula aula) {
		// TODO Auto-generated method stub
		return iaulaDao.save(aula);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		iaulaDao.deleteById(id);
	}

}
