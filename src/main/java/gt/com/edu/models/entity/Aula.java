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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name="aulas")
public class Aula implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id_aula;
	public Integer capacidad_aula;
	public String nombre_aula;
	public String seccion_aula;
	
	
	 //relación entre aulas y grados
	   @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	  
	   @ManyToOne(fetch =FetchType.LAZY)
	   @JoinColumn(name="grado_id")
	   private Grado grado;
	  
     // relacion entre aulas y estudiantes
	 //@JsonIgnoreProperties({"aula","hibernateLazyInitializer","handler"})
	 //@OneToMany(fetch = FetchType.LAZY,mappedBy ="aula" , cascade = CascadeType.ALL)
		//private List<Estudiante>estudiantes;
	 
	

		
	//relación entre aulas y clases
	  //@JsonIgnoreProperties({"aula","hibernateLazyInitializer","handler"})
	  //@OneToMany(fetch = FetchType.LAZY, mappedBy = "aula", cascade = CascadeType.ALL)
	  //private List<Clase>clases;
	  
		
		// public Aula() {
			//    this.estudiantes=new ArrayList<>();
			  //  this.clases=new ArrayList<>();
			   
		//}
	 
	 
	 
}
