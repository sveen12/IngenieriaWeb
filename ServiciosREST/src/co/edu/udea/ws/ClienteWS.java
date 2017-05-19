package co.edu.udea.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.udea.www.Exception.MyException;
import com.udea.www.bl.ClienteBL;
import com.udea.www.dto.ClienteDTO;

import co.edu.udea.dto.Cliente;

@Path("cliente")
@Component
public class ClienteWS {
	@Autowired
	private ClienteBL clienteBL;
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void guardar (	
			@FormParam("cedula") String cedula, 
			@FormParam("nombres") String nombres,
			@FormParam("apellidos") String apellidos,
			@FormParam("email") String email,
			@FormParam("usuarioCrea") String usuarioCrea)
					throws MyException{		
		System.out.println("_______________________________________________________");
		System.out.println(cedula);
		System.out.println(nombres);
		System.out.println(apellidos);
		System.out.println(email);
		System.out.println(usuarioCrea);
		System.out.println("_______________________________________________________");
		try{
			clienteBL.guardar(cedula, nombres, apellidos, email, usuarioCrea);
		}catch(MyException e){
			throw new MyException("Error creando el usuario.");
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)		
	public ArrayList<ClienteDTO> obtener () throws MyException{
		List<ClienteDTO> respuesta;
		try{
			 respuesta = clienteBL.obtener();
			 System.out.println("___________________________________________");
			 System.out.println(respuesta.size());
			 System.out.println("___________________________________________");
			
			/**for (ClienteDTO clienteDTO: clienteBL.obtener()){
				Cliente cliente = new Cliente(clienteDTO.getCedula(), 
						clienteDTO.getNombres(), clienteDTO.getApellidos(), 
						clienteDTO.getEmail());
				
				respuesta.add(cliente);
			}**/
		}catch(MyException e){
			throw new MyException("Problema consultando clientes");
		}
		return (ArrayList<ClienteDTO>)respuesta;
	}
}
