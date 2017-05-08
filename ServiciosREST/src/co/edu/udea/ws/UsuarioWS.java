package co.edu.udea.ws;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.udea.www.Exception.MyException;
import com.udea.www.bl.UsuarioBL;
import com.udea.www.dto.UsuarioDTO;

@Path("usuario")
//Como se agrego la ruta del Ws en el configuration.xml de spring
//para que se hiciera en ella un component scan, entonces asi se registra ante spring
@Component
public class UsuarioWS {
	//Se puede usar porque es un componente spring
	@Autowired
	private UsuarioBL usuarioBL;
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String autenticar (	
			@QueryParam("login") String login, 
			@QueryParam("contrasena") String contrasena)
					throws MyException{		
		try{
			UsuarioDTO user = usuarioBL.validarUsuario(login, contrasena);
		}catch(MyException e){
			return e.getMessage();
		}
		
		return "";
	}
}
