package co.edu.udea.donaciones.bl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.donaciones.dao.DatosDonacionDAO;
import co.edu.udea.donaciones.dao.DonanteDAO;
import co.edu.udea.donaciones.dao.UnidadMovilDAO;
import co.edu.udea.donaciones.dao.imp.CargoDAOImp;
import co.edu.udea.donaciones.dao.imp.CitaDAOImp;
import co.edu.udea.donaciones.dao.imp.DatosDonacionDAOImp;
import co.edu.udea.donaciones.dao.imp.DonacionExternaDAOImp;
import co.edu.udea.donaciones.dao.imp.DonacionSedeDAOImp;
import co.edu.udea.donaciones.dao.imp.DonacionUsuarioRegistradoDAOImp;
import co.edu.udea.donaciones.dao.imp.DonanteDAOImp;
import co.edu.udea.donaciones.dao.imp.EmpleadoDAOImp;
import co.edu.udea.donaciones.dao.imp.ExamenDAOImp;
import co.edu.udea.donaciones.dao.imp.PreguntaDAOImp;
import co.edu.udea.donaciones.dao.imp.RespuestaDAOImp;
import co.edu.udea.donaciones.dao.imp.RhDAOImp;
import co.edu.udea.donaciones.dao.imp.SedeDAOImp;
import co.edu.udea.donaciones.dao.imp.UnidadMovilDAOImp;
import co.edu.udea.donaciones.dao.imp.UsuarioRegistradoDAOImp;
import co.edu.udea.donaciones.dto.CargoDTO;
import co.edu.udea.donaciones.dto.CitaDTO;
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
import co.edu.udea.donaciones.dto.UnidadMovilDTO;
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
	private UnidadMovilDAOImp unidadMovilDAO;
	private CitaDAOImp citaDAO;
	private CargoDAOImp cargoDAO;
	private DonanteDAOImp donanteDAO;
	private SedeDAOImp sedeDAO;
	private DatosDonacionDAOImp datosDonacionDAO;
	

	/**
	 * Metodo por medio del cual un administrador registra un empleado 
	 * @param empleadoDTO que se registrara
	 * @param usuarioRegistra usuario que registra el empleado
	 * @return true si se registra satisfactoriamente
	 * @throws MyException
	 */
	public boolean registrarEmpleado(
			 String documento,
			 String direccion,
			 String nombres,
			 String apellidos,
			 String telefono,
			 String usuario,
			 String contrasena,
			 String cargo,
			 int unidadmovil,
			 String usuarioRegistraUsuario) throws MyException{
		
		if(usuarioRegistraUsuario==null || usuarioRegistraUsuario.equals("")){
			throw new MyException("Ingrese un usuario que registra valido.");
		}	
		
		EmpleadoDTO usuarioRegistra = 
				empleadoDAO.obtener(usuarioRegistraUsuario);
		if(usuarioRegistra == null){
			throw new MyException("El usuario que registra no se encontro en el sistema.");	
		}
		
		if(!usuarioRegistra.getIdCargo().getNombre().equals("administrador"))
		{
			throw new MyException("El administrador es el unico que puede registrar usuarios.");
		}
		
		if(documento == null || documento.equals("")){
			throw new MyException("El empleado debe tener un documento.");
		}else if(direccion == null || "".equals(direccion)){
			throw new MyException("La direccion no puede ser vacia.");			
		}else if(nombres == null || "".equals(nombres)){
			throw new MyException("El nombre no puede ser vacio.");			
		}else if(apellidos == null || "".equals(apellidos)){
			throw new MyException("El apellido no puede ser vacio.");			
		}else if(telefono == null || "".equals(telefono)){
			throw new MyException("El telefono no puede ser vacio.");			
		}else if(usuario == null || "".equals(usuario)){
			throw new MyException("El usuario no puede ser vacio.");			
		}else if(contrasena == null || "".equals(contrasena)){
			throw new MyException("La contraseña no puede estar vacia.");
		}else if(cargo == null || "".equals(cargo)){
			throw new MyException("El cargo no puede ser vacio.");			
		}else if(unidadmovil <=0 ){
			throw new MyException("Ingrese una unidad movil correcta.");			
		}	
		
		 
		 if(empleadoDAO.obtener(usuario)!=null){
			 throw new MyException("Ya existe un empleado con el mismo usuario.");
		 }
		 CargoDTO cargoDTO = cargoDAO.obtener(cargo);
		 
		 if(cargoDTO == null){
			 throw new MyException("El cargo asignado al empleado no existe.");
		 }
		 
		 UnidadMovilDTO unidadMovilDTO = unidadMovilDAO.obtener(unidadmovil);
		 
		 if(unidadMovilDTO == null){
			 throw new MyException("La unidad movil asignada no existe.");
		 }
		 
		 EmpleadoDTO empleadoDTO = new EmpleadoDTO();
		 
		 empleadoDTO.setApellidos(apellidos);
		 empleadoDTO.setContrasena(contrasena);
		 empleadoDTO.setDireccion(direccion);
		 empleadoDTO.setDocumento(documento);
		 empleadoDTO.setIdCargo(cargoDTO);
		 empleadoDTO.setIdSede(usuarioRegistra.getIdSede());
		 empleadoDTO.setIdUnidadMovil(unidadMovilDTO);
		 empleadoDTO.setNombres(nombres);
		 empleadoDTO.setTelefono(telefono);
		 empleadoDTO.setUsuario(usuario);

		return empleadoDAO.registrarEmpleado(empleadoDTO);
	}
	
	/**
	 * Con este metodo se registran las distintas unidades moviles
	 * @param unidadMovilDTO unidad movil que se registrara
	 * @param usuarioRegistra usuario que registra la unidad movil
	 * @return true si se registra correctamente
	 * @throws MyException
	 */
	public boolean registrarUnidadMovil(
			String nombre,
			String ubicacion,			
			String usuarioRegistraUsuario) throws MyException{
		
		if(usuarioRegistraUsuario==null || usuarioRegistraUsuario.equals("") ){
			throw new MyException("Ingrese un usuario que registra valido.");
		}	
		
		EmpleadoDTO usuarioRegistra = 
				empleadoDAO.obtener(usuarioRegistraUsuario);
		if(usuarioRegistra == null){
			throw new MyException("El usuario que registra no existe.");
		}
		if(!usuarioRegistra.getIdCargo().getNombre().equals("administrador"))
		{
			throw new MyException("El administrador es el unico que puede registrar unidades moviles.");
		}
		
		if(nombre == null || nombre.equals("") ){
			throw new MyException("El nombre no puede estar vacio.");
		}else if(ubicacion == null || "".equals(ubicacion)){
			throw new MyException("La ubicacion no puede estar vacia.");			
		}
		
		UnidadMovilDTO unidadMovilDTO = new UnidadMovilDTO();
		
		unidadMovilDTO.setIdSede(usuarioRegistra.getIdSede());
		unidadMovilDTO.setNombre(nombre);
		unidadMovilDTO.setUbicacion(ubicacion);
		
		return unidadMovilDAO.guardar(unidadMovilDTO);
	}
	
	/**
	 * Metodo para programar citas en el sistema por un administrador
	 * @param citaDTO la cita que se programara
	 * @param enfermero al que se le programa la cita
	 * @param administrador que programa la cita
	 * @return true si se programo la cita satisfactoriamente
	 * @throws MyException
	 */
	public boolean programarCitas(
			String fecha,
			String hora,			 
			String usuarioEnfermero,
			String usuarioAdministrador) throws MyException{
		
		if(usuarioEnfermero==null || usuarioEnfermero.equals("")){
			throw new MyException("Ingrese el enfermero que asignara a la cita.");
		}else if(usuarioAdministrador==null || usuarioAdministrador.equals("")){
			throw new MyException("Ingrese el administrador asigna la cita.");
		}
		
		EmpleadoDTO enfermero = empleadoDAO.obtener(usuarioEnfermero);
		EmpleadoDTO administrador = empleadoDAO.obtener(usuarioAdministrador);
		
		if(enfermero==null){
			throw new MyException("El enfermero asignado no existe.");
		}else if(administrador==null){
			throw new MyException("El administrador asignado no existe.");
		}else if( fecha == null || fecha.equals("")){
			throw new MyException("La fecha no puede estar vacia.");
		}else if( hora == null || hora.equals("") ){
			throw new MyException("La hora no puede estar vacia.");
		}
		
		if(!administrador.getIdCargo().getNombre().equals("administrador"))
		{
			throw new MyException("El administrador es el unico que puede programar una cita.");
		}if(!enfermero.getIdCargo().getNombre().equals("enfermero")){
			throw new MyException("Solo se le puede programar una cita a un enfermero");
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
		Date fechaCita;
		
        try {
        	fechaCita = formatter.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new MyException("Error generando fecha.");			
		}
        
        CitaDTO citaDTO = new CitaDTO();
        
        citaDTO.setFecha(fechaCita);
        citaDTO.setHora(hora);
        citaDTO.setIdEnfermero(enfermero);
        citaDTO.setIdSede(enfermero.getIdSede());		
		citaDTO.setIdEnfermero(enfermero);
		citaDTO.setIdSede(enfermero.getIdSede());
		
		return citaDAO.programarCita(citaDTO);
	}
	
	/**
	 * Con este metodo se consultan  las respuestas de un usuario dado
	 * @param donanteDTO donante del que se obtendran las respuestas
	 * @return retorna la lista de respuestas del donante dado
	 * @throws MyException
	 */
	public RespuestaDTO consultarRespuesta (String cedula, int id) throws MyException{
		
		if(cedula == null || cedula.equals("")){
			throw new MyException("Ingrese la cedula de un donante registrado.");
		}
		
		DonanteDTO donanteDTO = donanteDAO.obtener(cedula);
		PreguntaDTO preguntaDTO = preguntaDAO.obtener(id);
		
		if(donanteDTO == null){
			throw new MyException("El donante no existe");
		}else if( preguntaDTO == null){
			throw new MyException("La pregunta no existe");
		}
		
		RespuestaDTO respuesta = respuestaDAO.obtener(preguntaDTO,donanteDTO);
		
		if(respuesta == null){
			throw new MyException("No hay respuestas registradas del usuario solicitado con dicha pregunta.");
		}
		
		return respuesta;
	}
	
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
	public boolean registrarDE(
			String cedula, 
			int cantidad,
			String usuarioEnfermero) throws MyException{
		
		if(cedula == null || cedula.equals("")){
			throw new MyException("El donante no puede ser vacio");	
		}else if(usuarioEnfermero == null || usuarioEnfermero.equals("")){
			throw new MyException("El enfermero no puede ser vacio");	
		}else if(cantidad <= 0){
			throw new MyException("Cantidad a registrar debe ser mayor a 0");
		}
		
		DonanteDTO donanteDTO = donanteDAO.obtener(cedula);
		EmpleadoDTO enfermero = empleadoDAO.obtener(usuarioEnfermero);		

		if(donanteDTO == null){
			throw new MyException("El donante no existe.");			
		}else if(enfermero == null){
			throw new MyException("El enfermero no existe en el sistema.");			
		}else if(!enfermero.getIdCargo().getNombre().equals("enfermero")){
			throw new MyException("Solo se puede registrar por enfermero.");
		}
		
		if(!enfermero.getIdCargo().getNombre().equals("enfermero")){
			throw new MyException("Solo se le puede programar una cita a un enfermero");
		}
				
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
		String hoy = formatter.format(new Date());   
		Date fechaHoy;
		
        try {
			fechaHoy = formatter.parse(hoy);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new MyException("Error generando fecha.");			
		}
        
        DatosDonacionDTO datosDonacionDTO = new DatosDonacionDTO();
		
        datosDonacionDTO.setCantidad(cantidad);        
		//El estado de donación puede ser "realizada" o "en proceso"
        datosDonacionDTO.setEstadoDonacion("realizada");
        datosDonacionDTO.setFecha(fechaHoy);
        datosDonacionDTO.setIdRH(donanteDTO.getRh());
               
        DatosDonacionDTO resultado = datosDonacionDAO.guardar(datosDonacionDTO);
        
        System.out.println("____________Desde BL_____________________");
        System.out.println(resultado.getId());
        System.out.println("_________________________________");
        donanteDTO.setUltimaDonacion(fechaHoy);		
		donanteDTO.setApto("apto");
		
		DonacionExternaDTO donacionExternaDTO = new DonacionExternaDTO();
		
		donacionExternaDTO.setIdDatosDonacion(resultado);
		donacionExternaDTO.setIdDonante(donanteDTO);
		donacionExternaDTO.setIdUnidadMovil(enfermero.getIdUnidadMovil());
		
		
		
		return donacionExternaDAO.guardar(donacionExternaDTO);
	}
	
	/**
	 * Metodo para registrar una donacion de un usuario registrado
	 * @param usuarioRegistradoDTO usuario que donara
	 * @param datosDonacionDTO datos especificos de la donacion
	 * @param enfermero enfermero quien registra la donacion
	 * @throws MyException
	 */
	public boolean registrarDUR(
			String cedula,
			int cantidad,
			String usuarioEnfermero) throws MyException{
		
		if(cedula == null || cedula.equals("") ){
			throw new MyException("El donante no puede ser vacio");	
		}else if(usuarioEnfermero == null || usuarioEnfermero.equals("")){
			throw new MyException("El enfermero no puede ser vacio");	
		}else if(cantidad <= 0){
			throw new MyException("Cantidad a registrar debe ser mayor a 0");
		}
		
		UsuarioRegistradoDTO usuarioRegistradoDTO = 
				usuarioRegistradoDAO.obtener(donanteDAO.obtener(cedula));
		
		EmpleadoDTO enfermero = 
				empleadoDAO.obtener(usuarioEnfermero);
		
		
		if(usuarioRegistradoDTO == null){
			throw new MyException("El donante no puede ser vacio.");			
		}else if(enfermero == null){
			throw new MyException("El enfermero no existe en el sistema.");			
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
		}else if(cantidad < 0){
			throw new MyException("Cantidad a registrar debe ser mayor a 0");
		}
				
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
		String hoy = formatter.format(new Date());   
		Date fechaHoy;
		
        try {
			fechaHoy = formatter.parse(hoy);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new MyException("Error generando fecha.");			
		}

		
		DatosDonacionDTO datosDonacionDTO = new DatosDonacionDTO();
		
		datosDonacionDTO.setCantidad(cantidad);
		datosDonacionDTO.setEstadoDonacion("realizada");
		datosDonacionDTO.setFecha(fechaHoy);
		datosDonacionDTO.setIdRH(usuarioRegistradoDTO.getDocumentoUsuario().getRh());
		        
		DatosDonacionDTO resultado = datosDonacionDAO.guardar(datosDonacionDTO);
		
		//El atributo "apto" puede ser apto o noapto
		usuarioRegistradoDTO.getDocumentoUsuario().setApto("apto");		
        usuarioRegistradoDTO.getDocumentoUsuario().setUltimaDonacion(fechaHoy);
		
		DonacionUsuarioRegistradoDTO donacionUsuarioRegistradoDTO = new DonacionUsuarioRegistradoDTO();
		
		donacionUsuarioRegistradoDTO.setIdDatosDonacion(resultado);
		donacionUsuarioRegistradoDTO.setIdUsuarioRegistrado(usuarioRegistradoDTO);
		donacionUsuarioRegistradoDTO.setIdSede(enfermero.getIdSede());		
		
		return donacionUsuarioRegistradoDAO.guardar(donacionUsuarioRegistradoDTO);
	}	
	

	/**
	 * Este metodo sirve para registrar una donacion intersede
	 * @param sedeRecibo sede que recibe la donacion
	 * @param datosDonacionDTO datos especificos de la donacion
	 * @param administrador quien registra la donacion
	 * @throws MyException
	 */
	public boolean registrarDS(
			int idSedeRecibo, 
			int cantidad,
			String rh,
			String usuarioAdministrador) throws MyException{
		
		if(usuarioAdministrador == null || usuarioAdministrador.equals("") ){
			throw new MyException("El administrador no puede ser vacio.");		
		}
		
		SedeDTO sedeRecibo =
				sedeDAO.obtener(idSedeRecibo);
		EmpleadoDTO administrador =
				empleadoDAO.obtener(usuarioAdministrador);
		
		if(administrador == null){
			throw new MyException("El administrador no existe.");			
		}else if(!administrador.getIdCargo().getNombre().equals("administrador")){
			throw new MyException("Solo se puede registrar por administrador.");
		}else if(rh.equals("") || rh == null){
			throw new MyException("El rh no puede ser vacio.");		
		}else if(cantidad <= 0){
			throw new MyException("Cantidad a registrar debe ser mayor a 0");
		}else if(sedeRecibo == null){
			throw new MyException("La sede de envio no puede ser vacio.");			
		}
				
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
		String hoy = formatter.format(new Date());   
		Date fechaHoy;
		
        try {
			fechaHoy = formatter.parse(hoy);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new MyException("Error generando fecha.");			
		}        
        
		DatosDonacionDTO datosDonacionDTO = new DatosDonacionDTO();
		
		datosDonacionDTO.setCantidad(cantidad);
		datosDonacionDTO.setEstadoDonacion("realizada");
		datosDonacionDTO.setFecha(fechaHoy);
		datosDonacionDTO.setIdRH(rhDAO.obtener(rh));
		
		DatosDonacionDTO resultado = datosDonacionDAO.guardar(datosDonacionDTO);
		
		DonacionSedeDTO donacionSedeDTO = new DonacionSedeDTO();
		
		donacionSedeDTO.setIdDatosDonacion(resultado);
		donacionSedeDTO.setIdSedeEnvio(administrador.getIdSede());
		donacionSedeDTO.setIdSedeRecibo(sedeRecibo);
		
		return donacionSedeDAO.guardar(donacionSedeDTO);
	}

	/**
	 * Con este metodo se obtienen las preguntas de un examen de eps
	 * @param enfermero quien solicita las preguntas
	 * @return lista con las preguntas
	 * @throws MyException
	 */
	public List<PreguntaDTO> obtenerPreguntas(String usuario, String version) throws MyException{
		
		EmpleadoDTO enfermero = empleadoDAO.obtener(usuario);
		
		if(enfermero == null){
			throw new MyException("El empleado no existe.");
		}else if(!enfermero.getIdCargo().getNombre().equals("enfermero")){
			throw new MyException("Debe ser enfermero para realizar esta acción");
		}else if(version ==null || version.equals("")){
			throw new MyException("Debe ingresar una version valida para obtener el examen");
		}
		
		System.out.println(enfermero.getIdSede().getIdEPS().getNombre());
		EPSDTO eps = enfermero.getIdSede().getIdEPS();
			
		List<ExamenDTO> examenes = 
				examenDAO.obtener(eps);
		if(examenes.isEmpty()){
			throw new MyException("No hay preguntas registradas por la eps");
		}
		
		for(ExamenDTO examen : examenes){
			if(examen.getVersion().equals(version)){ 
				return preguntaDAO.obtener(examen);
			}
		}
		throw new MyException("No hay un examen con la version " + version);
	}
	
	/**
	 * Este metodo guarda las respuestas ingresadas al sistema
	 * @param respuestas lista con las respuestas
	 * @param enfermero quien registra las respuestas
	 * @return true si se guardan correctamente
	 * @throws MyException
	 */
	public boolean guardarRespuesta(int id,String documento, String descripcion, String usuario) throws MyException{
		
		EmpleadoDTO enfermero = empleadoDAO.obtener(usuario);
		DonanteDTO donante = donanteDAO.obtener(documento);
		PreguntaDTO preguntaDTO = preguntaDAO.obtener(id);
		
		if(documento == null || documento.equals("")){
			throw new MyException("Ingrese el documento del usuario que respondio la pregunta");
		}else if(descripcion == null || descripcion.equals("")){
			throw new MyException("Ingrese la respuesta");
		}else if(enfermero == null){
			throw new MyException("El empleado no puede estar vacio");
		}else if(!enfermero.getIdCargo().getNombre().equals("enfermero")){
			throw new MyException("Debe ser enfermero para realizar esta acción");
		}else if(donante == null){
			throw new MyException("El donante no existe en el sistema");
		}else if(preguntaDTO == null){
			throw new MyException("La pregunta no existe en el sistema");
		}
		
		RespuestaDTO respuesta = new RespuestaDTO();
		
		respuesta.setDescripcion(descripcion);
		respuesta.setDocumentoDonante(donante);
		respuesta.setIdPregunta(preguntaDTO);
		
		respuestaDAO.guardar(respuesta);
		
		
		return true;
	}
	
	
	/**
	 * Con este metodo se registra un donante en el sistema
	 * @param documento del donante
	 * @param direccion del donante
	 * @param edad del donante
	 * @param estadoCivil del donante
	 * @param estadoSalud del donante
	 * @param fechaNacimiento del donante
	 * @param nombres del donante
	 * @param apellidos del donante
	 * @param peso del donante
	 * @param rh del donante
	 * @return true si se registro correctamente el donante
	 * @throws MyException
	 */
	public boolean registrarDonante (
			String documento,
			String direccion,
			int edad,
			String estadoCivil,
			String estadoSalud,
			String fechaNacimiento,
			String nombres,
			String apellidos,
			int peso,
			String rh) throws MyException{
		
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
        
        return donanteDAO.guardar(donanteDTO);		
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
	public UnidadMovilDAOImp getUnidadMovilDAO() {
		return unidadMovilDAO;
	}

	public void setUnidadMovilDAO(UnidadMovilDAOImp unidadMovilDAO) {
		this.unidadMovilDAO = unidadMovilDAO;
	}

	public CitaDAOImp getCitaDAO() {
		return citaDAO;
	}

	public void setCitaDAO(CitaDAOImp citaDAO) {
		this.citaDAO = citaDAO;
	}

	public CargoDAOImp getCargoDAO() {
		return cargoDAO;
	}

	public void setCargoDAO(CargoDAOImp cargoDAO) {
		this.cargoDAO = cargoDAO;
	}
	
	
	public DonanteDAOImp getDonanteDAO() {
		return donanteDAO;
	}

	public void setDonanteDAO(DonanteDAOImp donanteDAO) {
		this.donanteDAO = donanteDAO;
	}	
	public SedeDAOImp getSedeDAO() {
		return sedeDAO;
	}

	public void setSedeDAO(SedeDAOImp sedeDAO) {
		this.sedeDAO = sedeDAO;
	}
	public DatosDonacionDAOImp getDatosDonacionDAO() {
		return datosDonacionDAO;
	}

	public void setDatosDonacionDAO(DatosDonacionDAOImp datosDonacionDAO) {
		this.datosDonacionDAO = datosDonacionDAO;
	}

}
