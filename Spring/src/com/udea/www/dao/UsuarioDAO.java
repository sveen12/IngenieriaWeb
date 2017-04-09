package com.udea.www.dao;

import java.util.List;

import com.udea.www.Exception.MyException;
import com.udea.www.dto.UsuarioDTO;

/**
 * 
 * @author Richard Morales
 *
 */
public interface UsuarioDAO {
	/**
	 * Para obtener la lista de usuarios
	 * @return retorna la lista de usuarios
	 * @throws MyException
	 */
	public List<UsuarioDTO> obtener() throws MyException;
	
	/**
	 * Obtener un usuario logueado
	 * @param login Usuario que se logueara
	 * @return Retorna un usuario
	 * @throws MyException
	 */
	public UsuarioDTO obtener(String login) throws MyException;
}
