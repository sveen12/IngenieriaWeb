package co.edu.udea.donaciones.dao;

import java.util.List;

import co.edu.udea.donaciones.dto.CitaDTO;
import co.edu.udea.donaciones.dto.DonanteDTO;
import co.edu.udea.donaciones.dto.UsuarioRegistradoDTO;
import co.edu.udea.donaciones.exception.MyException;

/**
 * Interfaz para la gestion de citas
 * @author Richard
 * @version 0.1
 *
 */
public interface CitaDAO {
	/**
	 * Confirmar una cita en el sistema
	 * @param cita es la cita que se confirmara
	 * @throws MyException
	 */
	public void confirmar(CitaDTO cita) throws MyException;
	
	/**
	 * Asignar una cita en el sistema
	 * @param cita es la cita que se guardara
	 * @throws MyException
	 */
	public boolean asignar(CitaDTO cita) throws MyException;
	
	/**
	 * Cancelar una cita en el sistema con 48 horas de antelacion
	 * @param cita es la cita que se cancelara
	 * @throws MyException
	 */
	public boolean cancelar(CitaDTO cita) throws MyException;
	
	/**
	 * COnsulta una cita en el sistema
	 * @param cedula del paciente que tiene asignada la cita
	 * @return Retorna la cita del paciente
	 * @throws MyException
	 */
	public CitaDTO obtener(UsuarioRegistradoDTO cedula) throws MyException;
	
	/**
	 * COnsulta una cita en el sistema
	 * @param cedula del paciente que tiene asignada la cita
	 * @return Retorna la cita del paciente
	 * @throws MyException
	 */
	public List<CitaDTO> citasDisponibles(String fechaInicio ) throws MyException;
	
	/**
	 * Un administrador programara las citas disponibles en la agenda
	 * @param cita es la cita que se cancelara
	 * @throws MyException
	 */
	public boolean programarCita(CitaDTO citaDTO ) throws MyException;
}
