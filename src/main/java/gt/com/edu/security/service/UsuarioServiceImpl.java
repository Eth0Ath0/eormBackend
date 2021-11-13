package gt.com.edu.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gt.com.edu.security.dao.IUsuarioDao;
import gt.com.edu.security.entity.Usuario;
@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	
	@Autowired
	public IUsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>)usuarioDao.findAll();
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return usuarioDao.findAll(pageable);
	}
	
/*
	@Override
	public Usuario findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
*/

	
	/*@Override
	public Usuario findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
*/

	@Override
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
		
	}


@Override
public Usuario findById(Long id) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public void delete(Long id) {
	// TODO Auto-generated method stub
	
}

}


