package co.edu.udea.donaciones.bl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.donaciones.dao.imp.CitaDAOImp;
import co.edu.udea.donaciones.dao.imp.DonanteDAOImp;
import co.edu.udea.donaciones.dao.imp.RhDAOImp;
import co.edu.udea.donaciones.dao.imp.UsuarioRegistradoDAOImp;
import co.edu.udea.donaciones.dto.CitaDTO;
import co.edu.udea.donaciones.dto.DonanteDTO;
import co.edu.udea.donaciones.dto.EmpleadoDTO;
import co.edu.udea.donaciones.dto.RHDTO;
import co.edu.udea.donaciones.dto.RespuestaDTO;
import co.edu.udea.donaciones.dto.UsuarioRegistradoDTO;
import co.edu.udea.donaciones.exception.MyException;
/**
 * Clase con logica de negocio para los usuarios
 * @author Richard
 *
 */
@Transactional
public class UsuarioRegistradoBL {
	private UsuarioRegistradoDAOImp usuarioRegistradoDAO;
	private DonanteDAOImp donanteDAO;
	private RhDAOImp rhDAO;
	private CitaDAOImp citaDAO;
	

	/**
	 * Con este metodo los usuarios se pueden registrar
	 * @param donanteDTO datos del usuario que se registrara
	 * @param usuario de quien se registrara
	 * @param contrasena de quien se registrara
	 * @return true si se registro correctamente
	 * @throws MyException
	 */
	public boolean registrarUsuario(DonanteDTO donanteDTO, String usuario, String contrasena) throws MyException{
		if(usuario == null || "".equals(usuario)){
			throw new MyException("El login no puede ser vacio.");			
		}else if(contrasena == null || "".equals(contrasena)){
			throw new MyException("La contraseña no puede estar vacia.");
		}else if(donanteDTO==null){
			throw new MyException("El donante no puede ser vacio.");
		}else if(Integer.parseInt(donanteDTO.getEdad()) < 18){
			throw new MyException("El donante no puede tener menos de 18 años.");
		}else if(Integer.parseInt(donanteDTO.getEdad()) > 65){
			throw new MyException("El donante no puede tener mas de 65 años.");
		}else if(donanteDTO.getPeso() < 50){
			throw new MyException("El donante no posee el peso suficiente (50Kg)");
		}else if(!donanteDTO.getEstadoSalud().equals("Normal")){
			throw new MyException("El donante no tiene buen estado de salud.");
		}else if(donanteDTO.getDocumento().equals("")){
			throw new MyException("El donante no tiene buen estado de salud.");
		}
		
		UsuarioRegistradoDTO usuarioRegistradoDTO = new UsuarioRegistradoDTO();
		
		usuarioRegistradoDTO.setDocumentoUsuario(donanteDTO);
		usuarioRegistradoDTO.setUsuario(usuario);
		usuarioRegistradoDTO.setContrasena(contrasena);		
		
		
		return usuarioRegistradoDAO.guardar(usuarioRegistradoDTO);
	}
	
	/**
	 * Le asigna una cita al usuario dado
	 * @param citaDTO cita que se asignara
	 * @param usuarioRegistradoDTO usuario al que se le asignara la cita
	 * @return true si se pudo asignar la cita
	 * @throws MyException
	 */
	public boolean asignarCita(CitaDTO citaDTO, UsuarioRegistradoDTO usuarioRegistradoDTO) throws MyException{
		
		citaDTO.setIdUsuarioRegistrado(usuarioRegistradoDTO);
		citaDTO.setEstadoCita("asignada");
		
		return citaDAO.asignar(citaDTO);
	}
	
	/**
	 * Cancelar una cita determinada
	 * @param citaDTO cita que se cancelará
	 * @return true si se cancela correctamente la cita
	 * @throws MyException
	 */
	public boolean cancelarCita(CitaDTO citaDTO) throws MyException{
		return citaDAO.cancelar(citaDTO);
	}
	

	
	
	public CitaDAOImp getCitaDAO() {
		return citaDAO;
	}

	public void setCitaDAO(CitaDAOImp citaDAO) {
		this.citaDAO = citaDAO;
	}
	
	public UsuarioRegistradoDAOImp getUsuarioRegistradoDAO() {
		return usuarioRegistradoDAO;
	}

	public void setUsuarioRegistradoDAO(UsuarioRegistradoDAOImp usuarioRegistradoDAO) {
		this.usuarioRegistradoDAO = usuarioRegistradoDAO;
	}

	public DonanteDAOImp getDonanteDAO() {
		return donanteDAO;
	}

	public void setDonanteDAO(DonanteDAOImp donanteDAO) {
		this.donanteDAO = donanteDAO;
	}

	public RhDAOImp getRhDAO() {
		return rhDAO;
	}

	public void setRhDAO(RhDAOImp rhDAO) {
		this.rhDAO = rhDAO;
	}
}
