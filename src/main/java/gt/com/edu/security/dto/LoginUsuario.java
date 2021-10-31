package gt.com.edu.security.dto;


import javax.validation.constraints.NotBlank;

import lombok.Data;
@Data
public class LoginUsuario {
	

@NotBlank
private String nombreUsuario;
@NotBlank
private String password;

public String getNombreUsuario() {
    return nombreUsuario;
}

public void setNombreUsuario(String nombreUsuario) {
    this.nombreUsuario = nombreUsuario;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}
}