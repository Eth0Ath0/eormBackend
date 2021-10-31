package gt.com.edu.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import gt.com.edu.models.entity.Estudiante;
import gt.com.edu.models.entity.Responsable;

public interface IResponsableDao extends JpaRepository<Responsable, Long> {
	
	@Query("FROM Estudiante e WHERE e.responsable.id=?1")
	public List<Estudiante> estudiantes(Long id);

}
