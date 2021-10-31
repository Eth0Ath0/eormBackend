package gt.com.edu.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gt.com.edu.security.dao.IRolDao;

import gt.com.edu.security.entity.Rol;

@Service
public class RolServiceImpl implements IRolService{

	@Autowired
	public IRolDao rolDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Rol> findAll() {
		// TODO Auto-generated method stub
		return (List<Rol>)rolDao.findAll();
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public Page<Rol> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return rolDao.findAll(pageable);
	}

	

	@Override
	public Rol findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rol save(Rol rol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	
}
