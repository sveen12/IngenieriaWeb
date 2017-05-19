package co.edu.udea.donaciones.dao;

import java.util.List;

import co.edu.udea.donaciones.dto.EPSDTO;
import co.edu.udea.donaciones.dto.SedeDTO;
import co.edu.udea.donaciones.exception.MyException;

public interface SedeDAO {
	
	/**
	 * Consulta una sede en el sistema
	 * @param id id de la sede
	 * @return Retorna la sede requerida
	 * @throws MyException
	 */
	public SedeDTO obtener(int id) throws MyException;
	
	/**
	 * Consulta una sede en el sistema
	 * @param epsdto eps para obtener las sedes
	 * @return Retorna la sede requerida
	 * @throws MyException
	 */
	public List<SedeDTO> obtener(EPSDTO epsdto) throws MyException;
	
	/**
	 * Guarda una sede en el sistema
	 * @param sedeDTO La sede que se quiere guardar
	 * @throws MyException
	 */
	public boolean guardar(SedeDTO sedeDTO) throws MyException;

}
