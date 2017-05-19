package co.edu.udea.donaciones.dao;

import java.util.List;

import co.edu.udea.donaciones.dto.DonanteDTO;
import co.edu.udea.donaciones.dto.PreguntaDTO;
import co.edu.udea.donaciones.dto.RespuestaDTO;
import co.edu.udea.donaciones.exception.MyException;

/**
 * Interfaz para la gestion de respuestas
 * @author Richard
 * @version 0.1
 *
 */
public interface RespuestaDAO {
	/**
	 * Para obtener la lista de respuestas de un usuario en el sistema
	 * @param cedula Documento del donante 
	 * @return retorna la lista de respuestas de un usuario
	 * @throws MyException
	 */
	public List<RespuestaDTO> obtener(DonanteDTO donanteDTO) throws MyException;
	
	/**
	 * Obtiene la respuesta a determinada pregunta de un usuario
	 * @param preguntaDTO pregunta de la que se quiere obtener respuesta
	 * @param donanteDTO donante del que se quiere obtener la respuesta
	 * @return respuesta del donante para determinada pregunta
	 * @throws MyException
	 */
	public RespuestaDTO obtener(PreguntaDTO preguntaDTO,DonanteDTO donanteDTO) throws MyException;
	
	/**
	 * Guarda una respuesta de un usuario
	 * @param respuestaDTOs Las respuestas que se quieren guardar
	 * @throws MyException
	 */
	public void guardar(RespuestaDTO respuestaDTOs) throws MyException;

}
