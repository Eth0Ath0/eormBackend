package gt.com.edu.security.dao;

import org.springframework.data.repository.CrudRepository;

import gt.com.edu.security.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Integer>{

}
