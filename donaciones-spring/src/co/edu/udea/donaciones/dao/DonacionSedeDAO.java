package co.edu.udea.donaciones.dao;

import java.util.List;

import co.edu.udea.donaciones.dto.DonacionSedeDTO;
import co.edu.udea.donaciones.exception.MyException;

/**
 * Interfaz para la gestion de donaciones de sede
 * @author Richard
 * @version 0.1
 *
 */
public interface DonacionSedeDAO {
	/**
	 * Guarda una donación por sede
	 * @param donacionSedeDTO donacion que se quiere guardar
	 * @throws MyException
	 */
	public boolean guardar(DonacionSedeDTO donacionSedeDTO) throws MyException;
	
	/**
	 * Lista de donaciones externas
	 * @return retorna una lista con las donaciones por sede
	 * @throws MyException
	 */
	public List<DonacionSedeDTO> obtener() throws MyException;
}
