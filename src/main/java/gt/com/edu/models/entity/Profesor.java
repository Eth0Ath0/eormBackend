package gt.com.edu.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name="profesores")
public class Profesor implements Serializable{

	private static final long serialVersionUID = 1L;
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  private String primer_nombre_profesor;
	  private String segundo_nombre_profesor;
	  private String primer_apellido_profesor;
	  private String segundo_apellido_profesor;
	  private Long dpi_profesor;
	 // @Temporal(TemporalType.DATE)
	  @JsonFormat(pattern = "yyyy/MM/dd")
	  private Date fecha_nacimiento_profesor;
	  private Integer edad_profesor;
	  private String sexo_profesor;
	  public String direccion_profesor;
	  public String telefono_profesor;
	  public String email_profesor;
	 
	//relación entre profesores y usuarios
	    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	    @JoinColumn(name="usuario_id")
	    @OneToOne(fetch =FetchType.LAZY)
	    private Usuario usuario;
	
	//relación entre profesores y clases
	  //@JsonIgnoreProperties({"profesor","hibernateLazyInitializer","handler"})
	  //@OneToMany(fetch = FetchType.LAZY, mappedBy = "profesor", cascade = CascadeType.ALL)
	  //private List<Clase>clases;
	  
	
		  
	 //public Profesor() {
		//    this.clases=new ArrayList<>();
		    		   
	//}
	  
}
