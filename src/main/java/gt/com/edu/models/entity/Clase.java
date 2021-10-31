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
@Table(name="clases")
public class Clase implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String Descripcion;
	
	 
	  //relación entre clases y profesores
	    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	    @JoinColumn(name="profesor_id")
	    @ManyToOne(fetch =FetchType.LAZY)
	    private Profesor profesor;
	  
	  //relación entre clases y aulas
	    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	    @JoinColumn(name="aula_id")
	    @ManyToOne(fetch =FetchType.LAZY)
	    private Aula aula;
	  
	  //relación entre clases y cursos
	    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	    @JoinColumn(name="curso_id")
	    @ManyToOne(fetch =FetchType.LAZY)
	    private Curso curso;
	  
	  
	//relación entre clases y contenidos
	  //@JsonIgnoreProperties({"clase","hibernateLazyInitializer","handler"})
	  //@OneToMany(fetch = FetchType.LAZY, mappedBy = "clase", cascade = CascadeType.ALL)
	  //private List<Contenido>contenidos;
	  
	
		  
	 //public Clase() {
		//    this.contenidos=new ArrayList<>();
		    
		   
	//}
	  

}

