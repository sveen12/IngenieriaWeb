package com.udea.www.bl;

import org.springframework.transaction.annotation.Transactional;

import com.udea.www.Exception.MyException;
import com.udea.www.dao.imp.UsuarioDAOImp;
import com.udea.www.dto.UsuarioDTO;

@Transactional
public class UsuarioBL {
	UsuarioDAOImp usuarioDAO;

	
	/**
	 * Aqui se valida por medio de un login y contraseņa que un usuario
	 * exista en el sistema
	 * @param login Nombre de usuario
	 * @param contrasena COntraseņa en el sistema
	 * @return retorna el usuario si existe
	 * @throws MyException
	 */
	public UsuarioDTO validarUsuario(String login, String contrasena) throws MyException{
		
		if(login == null || "".equals(login)){
			throw new MyException("El login no puede ser vacio.");
			
		}else if(contrasena == null || "".equals(contrasena)){
			throw new MyException("La contraseņa no puede estar vacia.");
		}
		
		UsuarioDTO usuario = usuarioDAO.validarUsuario(login, contrasena);
		if(usuario == null){
			throw new MyException("Ingrese correctamente su login o contraseņa");
		}
		return usuario;
	}	
	
	
	
	public UsuarioDAOImp getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAOImp usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	
	
}
