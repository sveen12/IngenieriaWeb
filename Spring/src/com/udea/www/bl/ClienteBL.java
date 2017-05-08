package com.udea.www.bl;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.udea.www.Exception.MyException;
import com.udea.www.dao.imp.ClienteDAOImp;
import com.udea.www.dao.imp.UsuarioDAOImp;
import com.udea.www.dto.ClienteDTO;
import com.udea.www.dto.UsuarioDTO;

@Transactional
public class ClienteBL {
	private ClienteDAOImp clienteDAO;
	private UsuarioDAOImp usuarioDAO;




	/**
	 * Obtiene la lista de clientes en el sistema
	 * @return
	 * @throws MyException
	 */
	public List<ClienteDTO> obtener () throws MyException {
		return clienteDAO.obtener();
	}
	
	/**
	 * Guarda un cliente en el sistema dados los siguientes datos.
	 * @param cedula
	 * @param nombres
	 * @param apellidos
	 * @param email
	 * @param usuarioCrea
	 * @throws MyException
	 */
	public void guardar(String cedula, 
						String nombres,
						String apellidos,
						String email,
						String usuarioCrea) throws MyException{
		
		if(cedula == null || "".equals(cedula)){
			throw new MyException("La cedula no puede estar vacía");
			
		}else
		if(nombres == null || "".equals(nombres)){
			throw new MyException("Los nombres no pueden estar vacios");
			
		}else
		if(apellidos == null || "".equals(apellidos)){
			throw new MyException("Los apellidos no pueden estar vacios");
			
		}else
		if(email == null || "".equals(email)){
			throw new MyException("El correo no puede estar vacio");
			
		}
		
		UsuarioDTO usuario = usuarioDAO.obtener(usuarioCrea);
		if(usuario == null){
			throw new MyException("UsuarioCrea no existe en el sistema");
		}
		
		// Mirar que no exista un cliente con la misma cedula
		
		ClienteDTO cliente = new ClienteDTO();
		cliente.setCedula(cedula);
		cliente.setNombres(nombres);
		cliente.setApellidos(apellidos);
		cliente.setEmail(email);
		cliente.setUsuarioCrea(usuario);
		cliente.setFechaCreacion(new Date());
		cliente.setEliminado(new Boolean(false));
		
		clienteDAO.guardar(cliente);
		
	}
	
	
	
	public UsuarioDAOImp getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAOImp usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	public ClienteDAOImp getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAOImp clienteDAO) {
		this.clienteDAO = clienteDAO;
	}
	
	

}
