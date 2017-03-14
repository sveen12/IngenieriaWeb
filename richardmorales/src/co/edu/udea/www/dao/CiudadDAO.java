package co.edu.udea.www.dao;

import java.util.List;

import co.edu.udea.www.dto.CiudadDTO;
import co.edu.udea.www.exception.MyException;

/**
 * 
 * @author estudiantelis
 *
 */
public interface CiudadDAO {
	
	/**
	 * Entrega la lista completa de las ciudades
	 * @return Retorna la lista con ciudades
	 * @throws MyException
	 */
	public List<CiudadDTO> obtener() throws MyException;

}
