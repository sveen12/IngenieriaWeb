package co.edu.udea.donaciones.dao;

import java.util.List;

import co.edu.udea.donaciones.dto.EPSDTO;
import co.edu.udea.donaciones.dto.ExamenDTO;
import co.edu.udea.donaciones.dto.PreguntaDTO;
import co.edu.udea.donaciones.exception.MyException;

/**
 * Interfaz para la gestion de examenes
 * @author Richard
 * @version 0.1
 *
 */
public interface ExamenDAO {
	/**
	 * Para obtener la lista de examenes por eps
	 * @return retorna la lista de examenes
	 * @throws MyException
	 */
	public List<ExamenDTO> obtener(EPSDTO epsDTO) throws MyException;
	

}
