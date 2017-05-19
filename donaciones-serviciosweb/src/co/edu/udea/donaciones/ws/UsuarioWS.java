package co.edu.udea.donaciones.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.donaciones.bl.UsuarioRegistradoBL;
import co.edu.udea.donaciones.dto.CitaDTO;
import co.edu.udea.donaciones.dto.UsuarioRegistradoDTO;
import co.edu.udea.donaciones.exception.MyException;


/**
 * Esta clase es un webservice en donde se implementan todos los metodos
 * relacionados con los usuario.
 * Aquí se tienen las acciones que los usuarios pueden realizar en el sistema
 * 
 * @author Richard
 *
 */
@Component
@Path("usuario")
public class UsuarioWS {

	@Autowired
	UsuarioRegistradoBL usuarioRegistradoBL;
	
	@POST
	@Produces(MediaType.TEXT_HTML)	
	@Path("registrar")
	public String registrarUsuario (
			@QueryParam("dto") String documento,
			@QueryParam("dir") String direccion,
			@QueryParam("edad") int edad,
			@QueryParam("civil") String estadoCivil,
			@QueryParam("salud") String estadoSalud,
			@QueryParam("nac") String fechaNacimiento,
			@QueryParam("nombres") String nombres,
			@QueryParam("apellidos") String apellidos,
			@QueryParam("peso") int peso,
			@QueryParam("rh") String rh,
			@QueryParam("usr") String usuario,
			@QueryParam("cont") String contrasena)
					throws MyException{		
		boolean registroExitoso = false;
		try{
			registroExitoso = 
					usuarioRegistradoBL.registrarUsuario(documento, direccion, edad, estadoCivil, estadoSalud, fechaNacimiento, nombres, apellidos, peso, rh, usuario, contrasena);
		}catch(MyException e){
			return e.getMessage();
		}	
		
		String mensaje = "";
		
		if(registroExitoso){
			mensaje = "Usuario registrado correctamente";
		}
		return mensaje;
	}

	@GET
	@Path("citas/disponibles")
	@Produces(MediaType.APPLICATION_JSON)	
	public ArrayList<CitaDTO> citasDisponibles(@QueryParam("fecha") String fechaInicio) throws MyException{
		List<CitaDTO> citas = new ArrayList<CitaDTO>();
		try {
			citas = usuarioRegistradoBL.consultarCitas(fechaInicio);
			System.out.println(citas.size());
			return (ArrayList<CitaDTO>)citas;
		} catch (MyException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			e.getMessage();
		}		
		
		return (ArrayList<CitaDTO>)citas;
	}
	
	@PUT
	@Produces(MediaType.TEXT_HTML)	
	@Path("citas/asignar")
	public String asignarCita (
			@QueryParam("id") int id,
			@QueryParam("documentoDonante") String documentoDonante){
		String mensaje = "";
		try {
			if(usuarioRegistradoBL.asignarCita(id, documentoDonante)){
				mensaje = "Correcto";
			}
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		return mensaje;
	}
	
	@PUT
	@Produces(MediaType.TEXT_HTML)	
	@Path("citas/cancelar")
	public String cancelarCita(@QueryParam("id") int id) {
		String mensaje = "";
		
		try {
			if(usuarioRegistradoBL.cancelarCita(id)){
				mensaje = "Correcto";
			}
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		
		return mensaje;
	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)	
	@Path("autenticar")
	public String autenticar (	
			@QueryParam("usuario") String usuario, 
			@QueryParam("contrasena") String contrasena)
					throws MyException{		
		UsuarioRegistradoDTO usuarioRegistradoDTO;
		try{
			usuarioRegistradoDTO = 
					usuarioRegistradoBL.validarUsuario(usuario, contrasena);
		}catch(MyException e){
			return e.getMessage();
		}		
		return usuarioRegistradoDTO.getDocumentoUsuario().getNombres();
	}	
}
