package co.edu.udea.donaciones.dao;

import java.util.List;

import co.edu.udea.donaciones.dto.ExamenDTO;
import co.edu.udea.donaciones.dto.PreguntaDTO;
import co.edu.udea.donaciones.exception.MyException;

/**
 * Interfaz para la gestion de preguntas
 * @author Richard
 * @version 0.1
 *
 */
public interface PreguntaDAO {
	/**
	 * Para obtener la lista de preguntas por examen en el sistema
	 * @return retorna la lista de preguntas
	 * @throws MyException
	 */
	public List<PreguntaDTO> obtener(ExamenDTO examen) throws MyException;
	

	/**
	 * Guarda una pregunta en el sistema
	 * @param donanteDTO La pregunta que se quiere guardar
	 * @throws MyException
	 */
	public void guardar(PreguntaDTO preguntaDTO) throws MyException;
}
