package gt.com.edu.models.dao;

import org.springframework.data.repository.CrudRepository;

import gt.com.edu.models.entity.Estudiante;

public interface IEstudianteDao extends CrudRepository <Estudiante, String >{

}
