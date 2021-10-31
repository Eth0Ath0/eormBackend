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
@Table(name="grados")
public class Grado implements Serializable {
	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id_grado;
	public String nombre_grado;
	
	//relación entre grados y estudiantes
	//@JsonIgnoreProperties({"grado","hibernateLazyInitializer","handler"})
	//@OneToMany(fetch = FetchType.LAZY,mappedBy ="grado" , cascade = CascadeType.ALL)

	//private List<Estudiante>estudiantes;
	
	//relación entre grados y aulas
	//@JsonIgnoreProperties({"grado","hibernateLazyInitializer","handler"})
	//@OneToMany(fetch = FetchType.LAZY,mappedBy ="grado" , cascade = CascadeType.ALL)

	//private List<Aula>aulas;
	  
	 //public Grado() {
		//    this.estudiantes=new ArrayList<>();
		  //  this.aulas=new ArrayList<>();
//	}
	 
	  
	 
}
