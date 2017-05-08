package co.edu.udea.donaciones.dto;

public class PreguntaDTO {
	private int id;
	private String descripcion;
	private ExamenDTO idExamen;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public ExamenDTO getIdExamen() {
		return idExamen;
	}
	public void setIdExamen(ExamenDTO idExamen) {
		this.idExamen = idExamen;
	}	
	
	
}
