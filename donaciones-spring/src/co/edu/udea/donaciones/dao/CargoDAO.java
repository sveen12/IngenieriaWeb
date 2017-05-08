package co.edu.udea.donaciones.dao;

import java.util.List;

import co.edu.udea.donaciones.dto.CargoDTO;
import co.edu.udea.donaciones.exception.MyException;

/**
 * Interfaz para la gestion de cargos
 * @author Richard
 * @version 0.1
 *
 */
public interface CargoDAO {
	
	/**
	 * Obtiene la lista de cargos en el sistema
	 * @return retorna una lista con los cargos del sistema
	 * @throws MyException
	 */
	public List<CargoDTO> obtener() throws MyException;
}
