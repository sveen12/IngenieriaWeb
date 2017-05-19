package co.edu.udea.donaciones.dto;

public class RespuestaDTO {

	private int id;
	private PreguntaDTO idPregunta;
	private DonanteDTO documentoDonante;
	private String descripcion;
	
	
	
	public RespuestaDTO() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PreguntaDTO getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(PreguntaDTO idPregunta) {
		this.idPregunta = idPregunta;
	}
	public DonanteDTO getDocumentoDonante() {
		return documentoDonante;
	}
	public void setDocumentoDonante(DonanteDTO documentoDonante) {
		this.documentoDonante = documentoDonante;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
