package co.edu.udea.donaciones.dao;

import java.util.List;

import co.edu.udea.donaciones.dto.DonanteDTO;
import co.edu.udea.donaciones.exception.MyException;

/**
 * Interfaz para la gestion de donantes
 * @author Richard
 * @version 0.1
 *
 */
public interface DonanteDAO {
	/**
	 * Para obtener la lista de donantes en el sistema 
	 * @return retorna la lista de donantes
	 * @throws MyException
	 */
	public List<DonanteDTO> obtener() throws MyException;
	
	/**
	 * Obtener un usuario por su cedula
	 * @param cedula Cedula del usuario que se buscara
	 * @return Retorna un usuario con la cedula dada
	 * @throws MyException
	 */
	public DonanteDTO obtener(String cedula) throws MyException;
	
	/**
	 * Guarda un donante
	 * @param donanteDTO El donante que se quiere guardar
	 * @throws MyException
	 */
	public boolean guardar(DonanteDTO donanteDTO) throws MyException;
}
