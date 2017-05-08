package co.edu.udea.donaciones.dto;

public class ExamenDTO {
	private int id;
	private String version;
	private String nombre;
	private EPSDTO idEPS;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public EPSDTO getIdEPS() {
		return idEPS;
	}
	public void setIdEPS(EPSDTO idEPS) {
		this.idEPS = idEPS;
	}
	
}
