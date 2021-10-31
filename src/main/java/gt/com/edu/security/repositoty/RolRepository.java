package gt.com.edu.security.repositoty;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gt.com.edu.security.entity.Rol;
import gt.com.edu.security.enums.RolNombre;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

	 Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
