package co.edu.udea.donaciones.dao;

import java.util.List;

import co.edu.udea.donaciones.dto.EmpleadoDTO;
import co.edu.udea.donaciones.exception.MyException;

/**
 * Interfaz para la gestion de empleados
 * @author Richard
 * @version 0.1
 *
 */
public interface EmpleadoDAO {
	/**
	 * Para obtener la lista de empleados registados
	 * @return retorna la lista de empleados
	 * @throws MyException
	 */
	public List<EmpleadoDTO> obtener() throws MyException;
	
	/**
	 * Loguear un empleado
	 * @param usuario Empleado que se logueara
	 * @param contrasena contraseña del que se logueara
	 * @return Retorna un empleado
	 * @throws MyException
	 */
	public EmpleadoDTO loguear(String usuario,String contrasena) throws MyException;
	
	/**
	 * Guarda un enfermero en el sistema
	 * @param emfermero El enfermero que se quiere guardar
	 * @throws MyException
	 */
	public boolean registrarEmpleado(EmpleadoDTO empleado) throws MyException;
}
