package co.edu.udea.donaciones.dao;

import java.util.List;

import co.edu.udea.donaciones.dto.RHDTO;
import co.edu.udea.donaciones.exception.MyException;

/**
 * Interfaz para la gestion de rh
 * @author Richard
 * @version 0.1
 *
 */
public interface RHDAO {
	/**
	 * Para obtener el rh
	 * @return retorna el rh
	 * @throws MyException
	 */
	public RHDTO obtener(String rh) throws MyException;
}
