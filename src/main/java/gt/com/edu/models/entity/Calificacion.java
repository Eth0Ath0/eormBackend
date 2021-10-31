package gt.com.edu.models.entity;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name="calificaciones")
public class Calificacion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public Integer nota_bim1;
	public Integer nota_bim2;
	public Integer nota_bim3;
	public Integer nota_bim4;
	public Double promedio_final;
	public Double promedio_final1() {
	return promedio_final=(double) ((nota_bim1+nota_bim2+nota_bim3+nota_bim4)/4);
		
	}
	
	public Double promedio_final2() {
		Double total=0.00;
		total=(double) ((nota_bim1+nota_bim2+nota_bim3+nota_bim4)/4);
		return total;
	}
	
	 //relación entre calificaciones y estudiantes
	    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	    @JoinColumn(name="estudiante_id")
	    @ManyToOne(fetch =FetchType.LAZY)
	    private Estudiante estudiante;
	  //relación entre calificaciones y cursos
	    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	    @JoinColumn(name="curso_id")
	    @ManyToOne(fetch =FetchType.LAZY)
	    //@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	    private Curso curso;
}
