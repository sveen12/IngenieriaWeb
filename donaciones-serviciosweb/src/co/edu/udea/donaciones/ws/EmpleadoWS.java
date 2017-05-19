package co.edu.udea.donaciones.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import co.edu.udea.donaciones.bl.EmpleadoBL;
import co.edu.udea.donaciones.dto.EmpleadoDTO;
import co.edu.udea.donaciones.dto.PreguntaDTO;
import co.edu.udea.donaciones.dto.RespuestaDTO;
import co.edu.udea.donaciones.exception.MyException;


/**
 * Esta clase es un webservice en donde se implementan todos los metodos
 * relacionados con los empleados.
 * Aquí se tienen las acciones que los empleados pueden realizar en el sistema
 * 
 * @author Richard
 *
 */
@Component
@Path("empleado")
public class EmpleadoWS {
	@Autowired
	EmpleadoBL empleadoBL;
	
	@POST
	@Produces(MediaType.TEXT_HTML)	
	@Path("autenticar")
	public String autenticar (	
			@QueryParam("usuario") String usuario, 
			@QueryParam("contrasena") String contrasena)
					throws MyException{		
		EmpleadoDTO empleadoDTO;
		try{
			empleadoDTO = 
					empleadoBL.validarEmpleado(usuario, contrasena);
		}catch(MyException e){
			return e.getMessage();
		}		
		return empleadoDTO.getNombres() ;
	}	

	@POST
	@Produces(MediaType.TEXT_HTML)	
	@Path("administrador/registrar")
	public String registrarUsuario (
			@QueryParam("dto") String documento,
			@QueryParam("dir") String direccion,
			@QueryParam("nom") String nombres,
			@QueryParam("ape") String apellidos,
			@QueryParam("tel") String telefono,
			@QueryParam("usr") String usuario,
			@QueryParam("cont") String contrasena,
			@QueryParam("cargo") String cargo,
			@QueryParam("umovil") int unidadmovil,
			@QueryParam("ucrea") String usuarioRegistraUsuario)
					throws MyException{		
		boolean registroExitoso = false;
		
		try{
			registroExitoso = 
					empleadoBL.registrarEmpleado(documento, direccion, nombres, apellidos, telefono, usuario, contrasena, cargo, unidadmovil, usuarioRegistraUsuario);
		}catch(MyException e){
			return e.getMessage();
		}	
		
		String mensaje = "";
		
		if(registroExitoso){
			mensaje = "Empleado registrado correctamente";
		}
		return mensaje;
	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)	
	@Path("administrador/unidadmovil/registrar")
	public String registrarUnidadMovil (
			@QueryParam("nombre") String nombre,
			@QueryParam("ubicacion") String ubicacion,
			@QueryParam("ucrea") String usuarioRegistraUsuario)
					throws MyException{		
		boolean registroExitoso = false;
		
		try{
			registroExitoso = 
					empleadoBL.registrarUnidadMovil(nombre, ubicacion, usuarioRegistraUsuario);
		}catch(MyException e){
			return e.getMessage();
		}	
		
		String mensaje = "";
		
		if(registroExitoso){
			mensaje = "Unidad movil registrada correctamente";
		}
		return mensaje;
	}

	@POST
	@Produces(MediaType.TEXT_HTML)	
	@Path("administrador/cita/programar")
	public String programarCita (
			@QueryParam("fecha") String fecha,
			@QueryParam("hora") String hora,			 
			@QueryParam("enfer") String usuarioEnfermero,
			@QueryParam("admin") String usuarioAdministrador)
					throws MyException{		
		boolean programarCita = false;
		
		try{
			programarCita = 
					empleadoBL.programarCitas(fecha, hora, usuarioEnfermero, usuarioAdministrador);
			
		}catch(MyException e){
			return e.getMessage();
		}	
		
		String mensaje = "";
		
		if(programarCita){
			mensaje = "Cita programada correctamente";
		}
		return mensaje;
	}

		
	@GET
	@Path("enfermero/respuestas")
	@Produces(MediaType.TEXT_HTML)	
	public String consultarRespuestas(
			@QueryParam("ced") String cedula,
			@QueryParam("pre") int pregunta) throws MyException{
		
		RespuestaDTO respuestas = null;
		try {
			respuestas = empleadoBL.consultarRespuesta(cedula, pregunta);
			return respuestas.getDescripcion();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
	}

	
	@POST
	@Produces(MediaType.TEXT_HTML)	
	@Path("enfermero/donaciones/registrarde")
	public String registrarDE (
			@QueryParam("doc") String cedula,
			@QueryParam("cant") int cantidad,
			@QueryParam("enfer") String usuarioEnfermero)
					throws MyException{		
		boolean registroExitoso = false;
		
		try{
			registroExitoso = 
					empleadoBL.registrarDE(cedula, cantidad, usuarioEnfermero);
		}catch(MyException e){
			return e.getMessage();
		}	
		
		String mensaje = "";
		
		if(registroExitoso){
			mensaje = "Donacion externa registrada correctamente";
		}
		return mensaje;
	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)	
	@Path("enfermero/donaciones/registrardur")
	public String registrarDUR (
			@QueryParam("doc") String cedula,
			@QueryParam("cant") int cantidad,
			@QueryParam("enfer") String usuarioEnfermero)
					throws MyException{		
		boolean registroExitoso = false;
		
		try{
			registroExitoso = 
					empleadoBL.registrarDUR(cedula, cantidad, usuarioEnfermero);
		}catch(MyException e){
			return e.getMessage();
		}	
		
		String mensaje = "";
		
		if(registroExitoso){
			mensaje = "Donacion por usuario registrada correctamente";
		}
		return mensaje;
	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)	
	@Path("administrador/donaciones/registrards")
	public String registrarDS (
			@QueryParam("recibo") int idSedeRecibo, 
			@QueryParam("cantidad") int cantidad,
			@QueryParam("rh") String rh,
			@QueryParam("administrador") String usuarioAdministrador)
					throws MyException{		
		boolean registroExitoso = false;
		
		try{
			registroExitoso = 
					empleadoBL.registrarDS(idSedeRecibo, cantidad, rh, usuarioAdministrador);
		}catch(MyException e){
			return e.getMessage();
		}	
		
		String mensaje = "";
		
		if(registroExitoso){
			mensaje = "Donacion por sede registrada correctamente";
		}
		return mensaje;
	}
	
	
	@GET
	@Path("enfermero/preguntas")
	@Produces(MediaType.APPLICATION_JSON)	
	public ArrayList<PreguntaDTO> obtenerPreguntas(
			@QueryParam("enfer") String usuario,
			@QueryParam("ver") String version) throws MyException{
		List<PreguntaDTO> listaPreguntas = new ArrayList<PreguntaDTO>();
		try {
			listaPreguntas = empleadoBL.obtenerPreguntas(usuario, version);
			
			return (ArrayList<PreguntaDTO>)listaPreguntas;
		} catch (MyException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			e.getMessage();
		}		
		
		return (ArrayList<PreguntaDTO>)listaPreguntas;
	}
	
	@POST
	@Path("enfermero/registrardonante")
	@Produces(MediaType.TEXT_HTML)	
	public String registrarDonante(
			@QueryParam("documento") String documento,
			@QueryParam("direccion") String direccion,
			@QueryParam("edad") int edad,
			@QueryParam("civil") String estadoCivil,
			@QueryParam("salud") String estadoSalud,
			@QueryParam("nacimiento") String fechaNacimiento,
			@QueryParam("nombres") String nombres,
			@QueryParam("apellidos") String apellidos,
			@QueryParam("peso") int peso,
			@QueryParam("rh") String rh) throws MyException{
		boolean registroExitoso = false;
		
		try{
			registroExitoso = 
					empleadoBL.registrarDonante(documento, direccion, edad, estadoCivil, estadoSalud, fechaNacimiento, nombres, apellidos, peso, rh);
		}catch(MyException e){
			return e.getMessage();
		}	
		
		String mensaje = "";
		
		if(registroExitoso){
			mensaje = "Donante registrado correctamente";
		}
		return mensaje;
	}
	
	
	@POST
	@Path("/enfermero/respuestas")
	@Produces(MediaType.TEXT_HTML)	
	public String guardarRespuestas(	
			@QueryParam("preg") int idPregunta,
			@QueryParam("doc") String documentoDonante,
			@QueryParam("desc") String descripcion,
			@QueryParam("ucrea") String usuarioCrea) {
	    //emailManager.sendEmail(email);
		
		boolean registroExitoso = false;
		
		try{
			registroExitoso = 
					empleadoBL.guardarRespuesta(idPregunta, documentoDonante, descripcion, usuarioCrea);
		}catch(MyException e){
			return e.getMessage();
		}	
		
		String mensaje = "";
		
		if(registroExitoso){
			mensaje = "Respuesta guardada correctamente";
		}
		return mensaje;
	}
}
