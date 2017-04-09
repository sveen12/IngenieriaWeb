package com.udea.www.dao;

import java.util.List;

import com.udea.www.Exception.MyException;
import com.udea.www.dto.ClienteDTO;

/**
 * 
 * @author Richard Morales
 *
 */
public interface ClienteDAO {
	/**
	 * Entrega la lista clientes ordenados por su fecha de creación 
	 * @return retorna la lista de clientes
	 * @throws MyException
	 */
	public List<ClienteDTO> obtener() throws MyException;
	
	/**
	 * Guarda un cliente
	 * @param cliente El cliente que se quiere guardar
	 * @throws MyException
	 */
	public void guardar(ClienteDTO cliente) throws MyException;
}
