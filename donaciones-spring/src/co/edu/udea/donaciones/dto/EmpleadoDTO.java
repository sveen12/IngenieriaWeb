package co.edu.udea.donaciones.dto;

public class EmpleadoDTO {
	private String documento;
	private String direccion;
	private String nombres;
	private String apellidos;
	private String telefono;
	private String usuario;
	private String contrasena;
	private CargoDTO idCargo;
	private SedeDTO idSede;
	private UnidadMovilDTO idUnidadMovil;
	
	
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public CargoDTO getIdCargo() {
		return idCargo;
	}
	public void setIdCargo(CargoDTO idCargo) {
		this.idCargo = idCargo;
	}
	public SedeDTO getIdSede() {
		return idSede;
	}
	public void setIdSede(SedeDTO idSede) {
		this.idSede = idSede;
	}
	public UnidadMovilDTO getIdUnidadMovil() {
		return idUnidadMovil;
	}
	public void setIdUnidadMovil(UnidadMovilDTO idUnidadMovil) {
		this.idUnidadMovil = idUnidadMovil;
	}
	
	
}
