package gt.com.edu.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gt.com.edu.models.dao.IContenidoDao;
import gt.com.edu.models.entity.Contenido;

@Service
public class ContenidoServiceImpl implements IContenidoService{
	
	@Autowired
	public IContenidoDao icontenidoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Contenido> findAll() {
		// TODO Auto-generated method stub
		return (List<Contenido>)icontenidoDao.findAll();
	}

	@Override
	public Contenido findById(Long id) {
		// TODO Auto-generated method stub
		return icontenidoDao.findById(id).orElse(null);
	}

	@Override
	public Contenido save(Contenido contenido) {
		// TODO Auto-generated method stub
		return icontenidoDao.save(contenido);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		icontenidoDao.deleteById(id);
	}
	
	

}
