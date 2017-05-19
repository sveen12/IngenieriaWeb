package co.edu.udea.donaciones.bl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.donaciones.dao.CitaDAO;
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
	public boolean registrarUsuario(
			String documento,
			String direccion,
			int edad,
			String estadoCivil,
			String estadoSalud,
			String fechaNacimiento,
			String nombres,
			String apellidos,
			int peso,
			String rh,
			String usuario,
			String contrasena) throws MyException{
		
		if(documento == null || documento.equals("")){
			throw new MyException("El donante debe tener un documento.");
		}else if(direccion == null || "".equals(direccion)){
			throw new MyException("La direccion no puede ser vacia.");			
		}else if(edad < 18){
			throw new MyException("El donante no puede tener menos de 18 años.");
		}else if(edad > 65){
			throw new MyException("El donante no puede tener mas de 65 años.");
		}else if(estadoCivil == null || "".equals(estadoCivil)){
			throw new MyException("El estado civil no puede ser vacio.");			
		}else if(estadoSalud == null || "".equals(estadoSalud)){
			throw new MyException("El estado de salud no puede ser vacio.");			
		}else if(fechaNacimiento == null || "".equals(fechaNacimiento)){
			throw new MyException("La fecha de nacimiento no puede ser vacia.");			
		}else if(nombres == null || "".equals(nombres)){
			throw new MyException("El nombre no puede ser vacio.");			
		}else if(apellidos == null || "".equals(apellidos)){
			throw new MyException("El apellido no puede ser vacio.");			
		}else if(rh == null || "".equals(rh)){
			throw new MyException("El RH no puede ser vacio.");			
		}else if(peso < 50){
			throw new MyException("El donante no posee el peso suficiente (50Kg)");
		}else if(usuario == null || "".equals(usuario)){
			throw new MyException("El usuario no puede ser vacio.");			
		}else if(contrasena == null || "".equals(contrasena)){
			throw new MyException("La contraseña no puede estar vacia.");
		}
		
		if( donanteDAO.obtener(documento) != null ){
			throw new MyException("Ya hay un donante con el mismo documento.");
		}
		RHDTO rhdto = rhDAO.obtener(rh);
		
		if( rhdto == null){
			throw new MyException("El tipo de sangre ingresado no existe en el sistema.");
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
		Date fechaNacimientoDate;
		
        try {
        	fechaNacimientoDate = formatter.parse(fechaNacimiento);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new MyException("Error generando fecha.");			
		}
        
        DonanteDTO donanteDTO = new DonanteDTO();
        
        donanteDTO.setApellidos(apellidos);
        donanteDTO.setDireccion(direccion);
        donanteDTO.setDocumento(documento);
        donanteDTO.setEdad(String.valueOf(edad));
        donanteDTO.setEstadoCivil(estadoCivil);
        donanteDTO.setEstadoSalud(estadoSalud);
        donanteDTO.setFechaNacimiento(fechaNacimientoDate);
        donanteDTO.setNombres(nombres);
        donanteDTO.setPeso(peso);
        donanteDTO.setRh(rhdto);		
		
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
	public boolean asignarCita(int id, String documento) throws MyException{
		if(id<0){
			throw new MyException("Ingrese un id valudo");
		} else if(documento == null || documento.equals("")){
			throw new MyException("El documento no puede ser vacio");
		}
		
		CitaDTO citaDTO =
				citaDAO.obtener(id);
		if(citaDTO == null){
			throw new MyException("La cita no existe en el sistema");
		}else if(citaDTO.getEstadoCita().equals("asignada")){
			throw new MyException("La cita ya se encuentra asignada.");
		}
		
		DonanteDTO donanteDTO = 
				donanteDAO.obtener(documento);		
		
		if(donanteDTO == null){
			throw new MyException("El donante no existe");
		}
		
		UsuarioRegistradoDTO usuarioRegistradoDTO = 
				usuarioRegistradoDAO.obtener(donanteDTO);
		if(usuarioRegistradoDTO == null){
			throw new MyException("El usuario registrado no existe");
		}
		
		
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
	public boolean cancelarCita(int id) throws MyException{
		if (id <0 ){
			throw new MyException("Ingrese un id valido");
		}
		CitaDTO citaDTO = citaDAO.obtener(id);		
		
		if(citaDTO==null){
			throw new MyException("La cita no existe en el sistema.");
		}
		
		return citaDAO.cancelar(citaDTO);
	}
	
	/**
	 * Consultar la lista de citas disponibles
	 * @param fechaInicio fecha desde la cual se quieren ver citas
	 * @return citas disponibles desde la fecha dada
	 * @throws MyException
	 */
	public List<CitaDTO> consultarCitas(String fechaInicio) throws MyException{
		if(fechaInicio == null || fechaInicio.equals("")){
			throw new MyException("Ingrese una fecha valida.");
		}
		return citaDAO.citasDisponibles(fechaInicio);
	}

	/**
	 * Valida que un usuario este registrado en el sistema
	 * @param usuario que se validara
	 * @param contrasena que se validara
	 * @return retorna el usuario si existe
	 * @throws MyException
	 */
	public UsuarioRegistradoDTO validarUsuario(String usuario, String contrasena) throws MyException{
		
		if(usuario == null || "".equals(usuario)){
			throw new MyException("El usuario no puede ser vacio.");
			
		}else if(contrasena == null || "".equals(contrasena)){
			throw new MyException("La contraseña no puede estar vacia.");
		}
		
		UsuarioRegistradoDTO usuarioRegistrado = usuarioRegistradoDAO.loguear(usuario, contrasena);
		if(usuarioRegistrado == null){
			throw new MyException("Ingrese correctamente su usuario o contraseña");
		}
		
		return usuarioRegistrado;
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
