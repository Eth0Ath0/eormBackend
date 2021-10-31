package gt.com.edu.model.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gt.com.edu.models.dao.IClaseDao;
import gt.com.edu.models.entity.Clase;

@Service
public class ClaseServiceImpl implements IClaseService {
@Autowired
    public IClaseDao iclaseDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Clase> findAll() {
		// TODO Auto-generated method stub
		return (List<Clase>)iclaseDao.findAll();
	}
	
	
	
	@Override
	@Transactional(readOnly = true)
	public Page<Clase> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return iclaseDao.findAll(pageable);
	}


	@Override
	@Transactional(readOnly = true)
	public Clase findById(Long id) {
		// TODO Auto-generated method stub
		return iclaseDao.findById(id).orElse(null);
	}

	@Override
	public Clase save(Clase clase) {
		// TODO Auto-generated method stub
		return iclaseDao.save(clase);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		iclaseDao.deleteById(id);
	}

	
}
