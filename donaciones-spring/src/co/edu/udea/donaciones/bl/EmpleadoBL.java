package co.edu.udea.donaciones.bl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.donaciones.dao.imp.DonacionExternaDAOImp;
import co.edu.udea.donaciones.dao.imp.DonacionSedeDAOImp;
import co.edu.udea.donaciones.dao.imp.DonacionUsuarioRegistradoDAOImp;
import co.edu.udea.donaciones.dao.imp.EmpleadoDAOImp;
import co.edu.udea.donaciones.dao.imp.ExamenDAOImp;
import co.edu.udea.donaciones.dao.imp.PreguntaDAOImp;
import co.edu.udea.donaciones.dao.imp.RespuestaDAOImp;
import co.edu.udea.donaciones.dao.imp.RhDAOImp;
import co.edu.udea.donaciones.dao.imp.UsuarioRegistradoDAOImp;
import co.edu.udea.donaciones.dto.DatosDonacionDTO;
import co.edu.udea.donaciones.dto.DonacionExternaDTO;
import co.edu.udea.donaciones.dto.DonacionSedeDTO;
import co.edu.udea.donaciones.dto.DonacionUsuarioRegistradoDTO;
import co.edu.udea.donaciones.dto.DonanteDTO;
import co.edu.udea.donaciones.dto.EPSDTO;
import co.edu.udea.donaciones.dto.EmpleadoDTO;
import co.edu.udea.donaciones.dto.ExamenDTO;
import co.edu.udea.donaciones.dto.PreguntaDTO;
import co.edu.udea.donaciones.dto.RHDTO;
import co.edu.udea.donaciones.dto.RespuestaDTO;
import co.edu.udea.donaciones.dto.SedeDTO;
import co.edu.udea.donaciones.dto.UsuarioRegistradoDTO;
import co.edu.udea.donaciones.exception.MyException;

/**
 * Clase con logica de negocio para los empleados
 * @author Richard
 *
 */
@Transactional
public class EmpleadoBL {
	private EmpleadoDAOImp empleadoDAO;
	private DonacionExternaDAOImp donacionExternaDAO;
	private DonacionUsuarioRegistradoDAOImp donacionUsuarioRegistradoDAO;
	private DonacionSedeDAOImp donacionSedeDAO;
	private RhDAOImp rhDAO;
	private UsuarioRegistradoDAOImp usuarioRegistradoDAO;
	private PreguntaDAOImp preguntaDAO;
	private ExamenDAOImp examenDAO;
	private RespuestaDAOImp respuestaDAO;
	
	/**
	 * Validar el logueo de un empleado 
	 * @param usuario del empleado que se logueara
	 * @param contrasena de quien se logueara
	 * @return retorna el usuario si existe con los datos dados
	 * @throws MyException
	 */
	public EmpleadoDTO validarEmpleado(String usuario, String contrasena) throws MyException{
		
		if(usuario == null || "".equals(usuario)){
			throw new MyException("El usuario no puede ser vacio.");
			
		}else if(contrasena == null || "".equals(contrasena)){
			throw new MyException("La contraseña no puede estar vacia.");
		}
		
		EmpleadoDTO empleado = empleadoDAO.loguear(usuario, contrasena);
		if(empleado == null){
			throw new MyException("Ingrese correctamente su login o contraseña");
		}
		return empleado;
	}
	
	/**
	 * Metodo para registrar una donacion externa
	 * @param donanteDTO datos del donante que donara
	 * @param datosDonacionDTO datos especificos de la donacion
	 * @param enfermero enfermero quien registra la donacion
	 * @throws MyException
	 */
	public void registrarDE(DonanteDTO donanteDTO, 
			DatosDonacionDTO datosDonacionDTO,
			EmpleadoDTO enfermero) throws MyException{
		if(donanteDTO == null){
			throw new MyException("El donante no puede ser vacio.");			
		}else if(datosDonacionDTO == null){
			throw new MyException("Los datos de donación no pueden ser vacios.");			
		}else if(enfermero == null){
			throw new MyException("El enfermero no puede ser vacio");			
		}else if(Integer.parseInt(donanteDTO.getEdad()) < 18){
			throw new MyException("El donante no puede tener menos de 18 años.");
		}else if(Integer.parseInt(donanteDTO.getEdad()) > 65){
			throw new MyException("El donante no puede tener mas de 65 años.");
		}else if(donanteDTO.getPeso() < 50){
			throw new MyException("El donante no posee el peso suficiente (50Kg)");
		}else if(!donanteDTO.getEstadoSalud().equals("Normal")){
			throw new MyException("El donante no tiene buen estado de salud.");
		}else if(!enfermero.getIdCargo().getNombre().equals("enfermero")){
			throw new MyException("Solo se puede registrar por enfermero.");
		}
		
		//El atributo "apto" puede ser apto o noapto
		donanteDTO.setApto("apto");
		//El estado de donación puede ser "realizada" o "en proceso"
		datosDonacionDTO.setEstadoDonacion("realizada");
		
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
		String hoy = formatter.format(new Date());   
		Date fechaHoy;
		
        try {
			fechaHoy = formatter.parse(hoy);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new MyException("Error generando fecha.");			
		}
        
        donanteDTO.setUltimaDonacion(fechaHoy);
        
		datosDonacionDTO.setFecha(fechaHoy);
		datosDonacionDTO.setIdRH(donanteDTO.getRh());
		
		DonacionExternaDTO donacionExternaDTO = new DonacionExternaDTO();
		
		donacionExternaDTO.setIdDatosDonacion(datosDonacionDTO);
		donacionExternaDTO.setIdDonante(donanteDTO);
		donacionExternaDTO.setIdUnidadMovil(enfermero.getIdUnidadMovil());		
		
		donacionExternaDAO.guardar(donacionExternaDTO);
	}
	
	/**
	 * Metodo para registrar una donacion de un usuario registrado
	 * @param usuarioRegistradoDTO usuario que donara
	 * @param datosDonacionDTO datos especificos de la donacion
	 * @param enfermero enfermero quien registra la donacion
	 * @throws MyException
	 */
	public void registrarDUR(UsuarioRegistradoDTO usuarioRegistradoDTO, 
			DatosDonacionDTO datosDonacionDTO,
			EmpleadoDTO enfermero) throws MyException{
		if(usuarioRegistradoDTO == null){
			throw new MyException("El donante no puede ser vacio.");			
		}else if(datosDonacionDTO == null){
			throw new MyException("Los datos de donación no pueden ser vacios.");			
		}else if(enfermero == null){
			throw new MyException("Los datos de donación no pueden ser vacios.");			
		}else if(Integer.parseInt(usuarioRegistradoDTO.getDocumentoUsuario().getEdad()) < 18){
			throw new MyException("El donante no puede tener menos de 18 años.");
		}else if(Integer.parseInt(usuarioRegistradoDTO.getDocumentoUsuario().getEdad()) > 65){
			throw new MyException("El donante no puede tener mas de 65 años.");
		}else if(usuarioRegistradoDTO.getDocumentoUsuario().getPeso() < 50){
			throw new MyException("El donante no posee el peso suficiente (50Kg)");
		}else if(!usuarioRegistradoDTO.getDocumentoUsuario().getEstadoSalud().equals("Normal")){
			throw new MyException("El donante no tiene buen estado de salud.");
		}else if(!enfermero.getIdCargo().getNombre().equals("enfermero")){
			throw new MyException("Solo se puede registrar por enfermero.");
		}
		
		//El atributo "apto" puede ser apto o noapto
		usuarioRegistradoDTO.getDocumentoUsuario().setApto("apto");
		//El estado de donación puede ser "realizada" o "en proceso"
		datosDonacionDTO.setEstadoDonacion("realizada");
		
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
		String hoy = formatter.format(new Date());   
		Date fechaHoy;
		
        try {
			fechaHoy = formatter.parse(hoy);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new MyException("Error generando fecha.");			
		}
        
        usuarioRegistradoDTO.getDocumentoUsuario().setUltimaDonacion(fechaHoy);
        
		datosDonacionDTO.setFecha(fechaHoy);
		datosDonacionDTO.setIdRH(usuarioRegistradoDTO.getDocumentoUsuario().getRh());
		
		DonacionUsuarioRegistradoDTO donacionUsuarioRegistradoDTO = new DonacionUsuarioRegistradoDTO();
		
		donacionUsuarioRegistradoDTO.setIdDatosDonacion(datosDonacionDTO);
		donacionUsuarioRegistradoDTO.setIdUsuarioRegistrado(usuarioRegistradoDTO);
		donacionUsuarioRegistradoDTO.setIdSede(enfermero.getIdSede());		
		
		donacionUsuarioRegistradoDAO.guardar(donacionUsuarioRegistradoDTO);
	}	
	

	/**
	 * Este metodo sirve para registrar una donacion intersede
	 * @param sedeRecibo sede que recibe la donacion
	 * @param datosDonacionDTO datos especificos de la donacion
	 * @param administrador quien registra la donacion
	 * @throws MyException
	 */
	public void registrarDS(SedeDTO sedeRecibo, 
			DatosDonacionDTO datosDonacionDTO,
			EmpleadoDTO administrador) throws MyException{
		if(sedeRecibo == null){
			throw new MyException("La sede de envio no puede ser vacio.");			
		}else if(datosDonacionDTO == null){
			throw new MyException("Los datos de donación no pueden ser vacios.");			
		}else if(administrador == null){
			throw new MyException("Los datos del administrador no pueden ser vacios.");			
		}else if(!administrador.getIdCargo().getNombre().equals("administrador")){
			throw new MyException("Solo se puede registrar por administrador.");
		}
		
		//El estado de donación puede ser "realizada" o "en proceso"
		datosDonacionDTO.setEstadoDonacion("realizada");
		
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
		String hoy = formatter.format(new Date());   
		Date fechaHoy;
		
        try {
			fechaHoy = formatter.parse(hoy);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new MyException("Error generando fecha.");			
		}        
        
		datosDonacionDTO.setFecha(fechaHoy);
		
		DonacionSedeDTO donacionSedeDTO = new DonacionSedeDTO();
		
		donacionSedeDTO.setIdDatosDonacion(datosDonacionDTO);
		donacionSedeDTO.setIdSedeEnvio(administrador.getIdSede());
		donacionSedeDTO.setIdSedeRecibo(sedeRecibo);
		
		donacionSedeDAO.guardar(donacionSedeDTO);
	}
	
	/**
	 * Con este metodo se obtienen las preguntas de un examen de eps
	 * @param enfermero quien solicita las preguntas
	 * @return lista con las preguntas
	 * @throws MyException
	 */
	public List<PreguntaDTO> obtenerPreguntas(EmpleadoDTO enfermero) throws MyException{
		if(enfermero == null){
			throw new MyException("El empleado no puede estar vacio");
		}else if(!enfermero.getIdCargo().getNombre().equals("enfermero")){
			throw new MyException("Debe ser enfermero para realizar esta acción");
		}
		
		System.out.println(enfermero.getIdSede().getIdEPS().getNombre());
		EPSDTO eps = enfermero.getIdSede().getIdEPS();
		List<ExamenDTO> examenes = 
				examenDAO.obtener(eps);
		if(examenes.isEmpty()){
			throw new MyException("No hay preguntas registradas por la eps");
		}
				
		return preguntaDAO.obtener(examenes.get(0));
	}
	
	/**
	 * Este metodo guarda las respuestas ingresadas al sistema
	 * @param respuestas lista con las respuestas
	 * @param enfermero quien registra las respuestas
	 * @return true si se guardan correctamente
	 * @throws MyException
	 */
	public boolean guardarRespuestas(List<RespuestaDTO> respuestas, EmpleadoDTO enfermero) throws MyException{
		
		if(respuestas == null){
			throw new MyException("Las respuestas no pueden estar vacias");
		}else if(enfermero == null){
			throw new MyException("El empleado no puede estar vacio");
		}else if(!enfermero.getIdCargo().getNombre().equals("enfermero")){
			throw new MyException("Debe ser enfermero para realizar esta acción");
		}else if(respuestas.isEmpty()){
			throw new MyException("Debe ingresar las respuestas");
		}
		
		for(RespuestaDTO respuesta : respuestas){
			respuestaDAO.guardar(respuesta);
		}
		
		return true;
	}
	
	
	
	public DonacionSedeDAOImp getDonacionSedeDAO() {
		return donacionSedeDAO;
	}

	public void setDonacionSedeDAO(DonacionSedeDAOImp donacionSedeDAO) {
		this.donacionSedeDAO = donacionSedeDAO;
	}

	public DonacionUsuarioRegistradoDAOImp getDonacionUsuarioRegistradoDAO() {
		return donacionUsuarioRegistradoDAO;
	}

	public void setDonacionUsuarioRegistradoDAO(DonacionUsuarioRegistradoDAOImp donacionUsuarioRegistradoDAO) {
		this.donacionUsuarioRegistradoDAO = donacionUsuarioRegistradoDAO;
	}

	public UsuarioRegistradoDAOImp getUsuarioRegistradoDAO() {
		return usuarioRegistradoDAO;
	}

	public void setUsuarioRegistradoDAO(UsuarioRegistradoDAOImp usuarioRegistradoDAO) {
		this.usuarioRegistradoDAO = usuarioRegistradoDAO;
	}

	public EmpleadoDAOImp getEmpleadoDAO() {
		return empleadoDAO;
	}

	public void setEmpleadoDAO(EmpleadoDAOImp empleadoDAO) {
		this.empleadoDAO = empleadoDAO;
	}
	public DonacionExternaDAOImp getDonacionExternaDAO() {
		return donacionExternaDAO;
	}

	public void setDonacionExternaDAO(DonacionExternaDAOImp donacionExternaDAO) {
		this.donacionExternaDAO = donacionExternaDAO;
	}

	public RhDAOImp getRhDAO() {
		return rhDAO;
	}

	public void setRhDAO(RhDAOImp rhDAO) {
		this.rhDAO = rhDAO;
	}
	

	public PreguntaDAOImp getPreguntaDAO() {
		return preguntaDAO;
	}

	public void setPreguntaDAO(PreguntaDAOImp preguntaDAO) {
		this.preguntaDAO = preguntaDAO;
	}

	public ExamenDAOImp getExamenDAO() {
		return examenDAO;
	}

	public void setExamenDAO(ExamenDAOImp examenDAO) {
		this.examenDAO = examenDAO;
	}

	public RespuestaDAOImp getRespuestaDAO() {
		return respuestaDAO;
	}

	public void setRespuestaDAO(RespuestaDAOImp respuestaDAO) {
		this.respuestaDAO = respuestaDAO;
	}


	
}
