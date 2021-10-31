package gt.com.edu.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import gt.com.edu.security.entity.Usuario;
import lombok.Data;
@Data
@Entity
@Table(name="estudiantes")
public class Estudiante implements Serializable {
	
	private static final long serialVersionUID = 1L;
	  @Id
	  @Column(name="codigo_personal",nullable=false)
	  private String codigo_personal;
	  private String primer_nombre_estudiante;
	  private String segundo_nombre_estudiante;
	  private String primer_apellido_estudiante;
	  private String segundo_apellido_estudiante;
	  //@Temporal(TemporalType.DATE)
	  @JsonFormat(pattern = "yyyy/MM/dd")
	  private Date fecha_nacimiento;
	  private Integer edad_estudiante;
	  private String sexo_estudiante;
	  private String idioma_estudiante;
	  private String lateralidad_estudiante;
	  private String direccion_estudiante;
	  private String Observacion;
	  
	  //relación entre estudiantes y responsables
	    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	    @JoinColumn(name="responsable_id")
	    @ManyToOne(fetch =FetchType.LAZY)
	    private Responsable responsable;
	  
	  //relación entre estudiantes y grado
	    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	    @JoinColumn(name="grado_id")
	    @ManyToOne(fetch =FetchType.LAZY)
	    private Grado grado;
	  //relación entre estudiantes y aulas
	    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	    @JoinColumn(name="aula_id")
	    @ManyToOne(fetch =FetchType.LAZY)
	    private Aula aula;
	  
	//relación entre estudiantes y usuarios
	    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	    @JoinColumn(name="usuario_id")
	    @OneToOne(fetch =FetchType.LAZY)
	    private Usuario usuario;
	  
	  //relación entre estudiante y matricula
	   // @JsonIgnoreProperties({"estudiante","hibernateLazyInitializer","handler"})
	  //@OneToMany(fetch = FetchType.LAZY, mappedBy = "estudiante", cascade = CascadeType.ALL)
	  //private List<Matricula>matriculas;
	  
	//relación entre estudiante y calificaciones
	  //@JsonIgnoreProperties({"estudiante","hibernateLazyInitializer","handler"})
	  //@OneToMany(fetch = FetchType.LAZY, mappedBy = "estudiante", cascade = CascadeType.ALL)
	  //private List<Calificacion>calificaciones;
	  
	
		  
	 //public Estudiante() {
		//    this.matriculas=new ArrayList<>();
		  //  this.calificaciones=new ArrayList<>();
		   
	//}
	  
	  
}
