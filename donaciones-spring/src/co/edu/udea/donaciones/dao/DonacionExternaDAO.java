package co.edu.udea.donaciones.dao;

import java.util.List;

import co.edu.udea.donaciones.dto.DonacionExternaDTO;
import co.edu.udea.donaciones.exception.MyException;

/**
 * Interfaz para la gestion de donaciones externas
 * @author Richard
 * @version 0.1
 *
 */
public interface DonacionExternaDAO {

	/**
	 * Guarda una donación 
	 * @param donacionExternaDTO donacion que se quiere guardar
	 * @throws MyException
	 */
	public void guardar(DonacionExternaDTO donacionExternaDTO) throws MyException;
	
	/**
	 * Lista de donaciones externas
	 * @return retorna una lista con las donaciones externas
	 * @throws MyException
	 */
	public List<DonacionExternaDTO> obtener() throws MyException;
	
}
