package co.edu.udea.donaciones.dto;

public class DonacionUsuarioRegistradoDTO {
	private int id;
	private UsuarioRegistradoDTO idUsuarioRegistrado;
	private DatosDonacionDTO idDatosDonacion;
	private SedeDTO idSede;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UsuarioRegistradoDTO getIdUsuarioRegistrado() {
		return idUsuarioRegistrado;
	}
	public void setIdUsuarioRegistrado(UsuarioRegistradoDTO idUsuarioRegistrado) {
		this.idUsuarioRegistrado = idUsuarioRegistrado;
	}
	public DatosDonacionDTO getIdDatosDonacion() {
		return idDatosDonacion;
	}
	public void setIdDatosDonacion(DatosDonacionDTO idDatosDonacion) {
		this.idDatosDonacion = idDatosDonacion;
	}
	public SedeDTO getIdSede() {
		return idSede;
	}
	public void setIdSede(SedeDTO idSede) {
		this.idSede = idSede;
	}
	
}
