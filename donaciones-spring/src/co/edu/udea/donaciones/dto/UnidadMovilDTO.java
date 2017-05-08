package co.edu.udea.donaciones.dto;

public class UnidadMovilDTO {
	private int id;
	private String nombre;
	private String ubicacion;
	private SedeDTO idSede;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public SedeDTO getIdSede() {
		return idSede;
	}
	public void setIdSede(SedeDTO idSede) {
		this.idSede = idSede;
	}
	
	
	
}
