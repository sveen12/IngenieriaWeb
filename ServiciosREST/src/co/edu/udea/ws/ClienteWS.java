package co.edu.udea.ws;

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
	public void guardar (	
			@QueryParam("cedula") String cedula, 
			@QueryParam("nombres") String nombres,
			@QueryParam("apellidos") String apellidos,
			@QueryParam("email") String email,
			@QueryParam("usuarioCrea") String usuarioCrea)
					throws MyException{		
		try{
			clienteBL.guardar(cedula, nombres, apellidos, email, usuarioCrea);
		}catch(MyException e){
			throw new MyException("Error creando el usuario.");
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)		
	public List<Cliente> obtener () throws MyException{
		List<Cliente> respuesta = new ArrayList<Cliente>();
		try{
			for (ClienteDTO clienteDTO: clienteBL.obtener()){
				Cliente cliente = new Cliente(clienteDTO.getCedula(), 
						clienteDTO.getNombres(), clienteDTO.getApellidos(), 
						clienteDTO.getEmail());
				
				respuesta.add(cliente);
			}
		}catch(MyException e){
			throw new MyException("Problema consultando clientes");
		}
		return respuesta;
	}
}
