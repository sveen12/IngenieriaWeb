package co.edu.udea.donaciones.dao;

import java.util.List;

import co.edu.udea.donaciones.dto.DonacionUsuarioRegistradoDTO;
import co.edu.udea.donaciones.exception.MyException;

/**
 * Interfaz para la gestion de donaciones por usuario
 * @author Richard
 * @version 0.1
 *
 */
public interface DonacionUsuarioRegistradoDAO {
	/**
	 * Guarda una donación por usuario registrado
	 * @param donacionUsuarioRegistradoDTO donacion que se quiere guardar
	 * @throws MyException
	 */
	public void guardar(DonacionUsuarioRegistradoDTO donacionUsuarioRegistradoDTO) throws MyException;
	
	/**
	 * Lista de donaciones por usuario
	 * @return retorna una lista con las donaciones por usuario registrado
	 * @throws MyException
	 */
	public List<DonacionUsuarioRegistradoDTO> obtener() throws MyException;
	
	/**
	 * Lista de donaciones de un determinado usuario
	 * @return retorna una lista con las donaciones por usuario registrado con la cedula dada
	 * @throws MyException
	 */
	public List<DonacionUsuarioRegistradoDTO> obtener(String cedula) throws MyException;
}
