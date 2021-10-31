package gt.com.edu.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import gt.com.edu.security.entity.Rol;

public interface IRolDao extends JpaRepository<Rol, Integer>{

}
