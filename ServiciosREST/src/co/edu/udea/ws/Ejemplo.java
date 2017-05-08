package co.edu.udea.ws;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

//Se define la ruta en donde se encuentra el servicio (URL)
@Path("saludo")
public class Ejemplo {
	
	//SE dice a que tipo de peticion responde
	@GET
	//Se dice que tipo de dato retorna
	@Produces(MediaType.TEXT_HTML)
	public String saludar(){
		return "Hola buenas";
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("2")
	public String saludar2(){
		return "Hola buenas 2";
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)	
	@Path("3")
	public String saludar3(@QueryParam("a")String nombre){
		return "Hola buenas " + nombre;
	}
}
