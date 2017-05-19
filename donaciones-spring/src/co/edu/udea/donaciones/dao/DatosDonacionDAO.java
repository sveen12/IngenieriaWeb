package co.edu.udea.donaciones.dao;

import co.edu.udea.donaciones.dto.DatosDonacionDTO;
import co.edu.udea.donaciones.exception.MyException;

public interface DatosDonacionDAO {

	/**
	 * Guarda los datos de una donaci�n
	 * @param datosDonacionDTO Los datos de la donaci�n
	 * @throws MyException
	 */
	public DatosDonacionDTO guardar(DatosDonacionDTO datosDonacionDTO) throws MyException;
	
	/**
	 * Obtiene los datos de una donacion dada
	 * @param id id de los datos de donacion que se quieren obtener
	 * @throws MyException
	 */
	public DatosDonacionDTO obtener(int id) throws MyException;
}
