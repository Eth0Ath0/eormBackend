package gt.com.edu.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name="cursos")
public class Curso implements Serializable {
	
		private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String nombre_curso;
	
	//relación entre cursos y calificaciones
	  //@JsonIgnoreProperties({"curso","hibernateLazyInitializer","handler"})
	  //@OneToMany(fetch = FetchType.LAZY, mappedBy = "curso", cascade = CascadeType.ALL)
	  //private List<Calificacion>calificaciones;
	  
	//relación entre cursos y clases
	  //@JsonIgnoreProperties({"curso","hibernateLazyInitializer","handler"})
	  //@OneToMany(fetch = FetchType.LAZY, mappedBy = "curso", cascade = CascadeType.ALL)
	  //private List<Clase>clases;
	  
	  
	 //public Curso() {
		   // this.calificaciones=new ArrayList<>();
		   // this.clases=new ArrayList<>();
	//}

}
