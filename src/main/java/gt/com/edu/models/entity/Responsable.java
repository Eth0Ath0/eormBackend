package gt.com.edu.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name="responsables")
public class Responsable implements Serializable {
	
	private static final long serialVersionUID = 1L;
	  @Id
	  @Column(name="id_responsable",nullable=false)
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id_responsable;
	  private String primer_nombre_responsable;
	  private String segundo_nombre_responsable;
	  private String primer_apellido_responsable;
	  private String segundo_apellido_responsable;
	  private Integer dpi_responsable;
	  //@Temporal(TemporalType.DATE)
	  @JsonFormat(pattern = "yyyy/MM/dd")
	  private Date fecha_nacimiento_responsable;
	  private Integer edad_responsable;
	  private String sexo_responsable;
	  private String direccion_responsable;
	  private String telefono_responsable;
	  private String email_responsable;
	  
	   
	    
	

}
