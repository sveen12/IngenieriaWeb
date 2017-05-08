package co.edu.udea.donaciones.dao;

import java.util.List;

import co.edu.udea.donaciones.dto.UsuarioRegistradoDTO;
import co.edu.udea.donaciones.exception.MyException;

/**
 * Interfaz para la gestion de usuarios registrados
 * @author Richard
 * @version 0.1
 *
 */
public interface UsuarioRegistradoDAO {
	/**
	 * Para obtener la lista de usuarios registados
	 * @return retorna la lista de usuarios
	 * @throws MyException
	 */
	public List<UsuarioRegistradoDTO> obtener() throws MyException;
	
	/**
	 * Loguear un usuario
	 * @param usuario Usuario que se logueara
	 * @param contrasena Usuario que se logueara
	 * @return Retorna un usuario
	 * @throws MyException
	 */
	public UsuarioRegistradoDTO loguear(String usuario,String contrasena) throws MyException;
	
	/**
	 * Guarda un usuario
	 * @param usuarioRegistrado El usuario que se quiere guardar
	 * @throws MyException
	 */
	public boolean guardar(UsuarioRegistradoDTO usuarioRegistrado) throws MyException;
}
