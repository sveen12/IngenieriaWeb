package com.udea.www.dao;

import java.util.List;

import com.udea.www.Exception.MyException;
import com.udea.www.dto.CiudadDTO;

/**
 * 
 * @author Richard Morales
 *
 */
public interface CiudadDAO {
	/**
	 * Metodo para obtener la lista de ciudades
	 * @return retorna las ciudades
	 * @throws MyException
	 */
	public List<CiudadDTO> obtener() throws MyException;
	
	/**
	 * Metodo para obtener una ciudad por su codigo
	 * @param codigo de la ciudad
	 * @return Retorna la ciudad con el codigo enviado
	 * @throws MyException
	 */
	public CiudadDTO obtener(long codigo) throws MyException;
}
