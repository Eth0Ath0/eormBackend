package gt.com.edu.models.dao;

import org.springframework.data.repository.CrudRepository;

import gt.com.edu.models.entity.Profesor;

public interface IProfesorDao extends CrudRepository<Profesor, Long> {

}
