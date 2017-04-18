package com.udea.www.bl;

import com.udea.www.Exception.MyException;
import com.udea.www.dao.imp.UsuarioDAOImp;
import com.udea.www.dto.UsuarioDTO;

public class UsuarioBL {
	UsuarioDAOImp usuarioDAO;

	
	/**
	 * Aqui se valida por medio de un login y contraseña que un usuario
	 * exista en el sistema
	 * @param login Nombre de usuario
	 * @param contrasena COntraseña en el sistema
	 * @return retorna el usuario si existe
	 * @throws MyException
	 */
	public UsuarioDTO validarUsuario(String login, String contrasena) throws MyException{
		
		if(login == null || "".equals(login)){
			throw new MyException("El login no puede ser vacio.");
			
		}else if(contrasena == null || "".equals(contrasena)){
			throw new MyException("La contraseña no puede estar vacia.");
		}
		
		UsuarioDTO usuario = usuarioDAO.validarUsuario(login, contrasena);
		if(usuario == null){
			throw new MyException("Ingrese correctamente su login o contraseña");
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
