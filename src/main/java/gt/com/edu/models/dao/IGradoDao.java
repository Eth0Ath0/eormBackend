package gt.com.edu.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import gt.com.edu.models.entity.Grado;

public interface IGradoDao extends JpaRepository<Grado, Long> {

}
