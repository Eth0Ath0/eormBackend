package gt.com.edu.models.entity;

import java.io.Serializable;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name="matriculas") 

public class Matricula implements Serializable {

	private static final long serialVersionUID = 1L;
	  @Id
	  @Column(name="id_matricula",nullable=false)
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id_matricula;
	  //@Temporal(TemporalType.DATE)
	  @JsonFormat(pattern = "dd/MM/yyyy")
	  private Date fecha_matricula;
	  private String observaciones;
	  
	  
	  //relación entre matricula y estudiantes
	    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	    @JoinColumn(name="codigo_personal")
	    @ManyToOne(fetch =FetchType.LAZY)
	    private Estudiante estudiante;
	  
	  
	 
	  
}
