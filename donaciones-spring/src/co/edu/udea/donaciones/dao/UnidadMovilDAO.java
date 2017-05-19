package co.edu.udea.donaciones.dao;

import co.edu.udea.donaciones.dto.UnidadMovilDTO;
import co.edu.udea.donaciones.exception.MyException;

/**
 * Interfaz para la gestion de unidades móviles
 * @author Richard
 * @version 0.1
 *
 */
public interface UnidadMovilDAO {
	
	/**
	 * Para guardar una unidad movil en el sistema
	 * @param unidadMovilDTO unidad movil que se guardara
	 * @return true si se guarda correctamente la unidad
	 * @throws MyException
	 */
	public boolean guardar(UnidadMovilDTO unidadMovilDTO) throws MyException;
	
	/**
	 * Para guardar una unidad movil en el sistema
	 * @param unidadMovilDTO unidad movil que se guardara
	 * @return true si se guarda correctamente la unidad
	 * @throws MyException
	 */
	public UnidadMovilDTO obtener(int id) throws MyException;
}
