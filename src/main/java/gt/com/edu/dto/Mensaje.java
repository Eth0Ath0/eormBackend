package gt.com.edu.dto;

import lombok.Data;

@Data
public class Mensaje {
	private String mensaje;

	public Mensaje(String mensaje) {
		//super();
		this.mensaje = mensaje;
	}
	
	

}
