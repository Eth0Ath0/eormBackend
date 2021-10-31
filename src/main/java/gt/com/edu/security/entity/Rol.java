package gt.com.edu.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import gt.com.edu.security.enums.RolNombre;
import lombok.Data;
@Data
@Entity
@Table(name="roles")
public class Rol {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    @NotNull
	    @Enumerated(EnumType.STRING)
	    private RolNombre rolNombre;

	    public Rol() {
	    }

	    public Rol(@NotNull RolNombre rolNombre) {
	        this.rolNombre = rolNombre;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public RolNombre getRolNombre() {
	        return rolNombre;
	    }

	    public void setRolNombre(RolNombre rolNombre) {
	        this.rolNombre = rolNombre;
	    }
	

}
