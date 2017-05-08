package co.edu.udea.donaciones.dto;

public class DonacionExternaDTO {
	private int id;
	private UnidadMovilDTO idUnidadMovil;
	private DonanteDTO idDonante;
	private DatosDonacionDTO idDatosDonacion;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UnidadMovilDTO getIdUnidadMovil() {
		return idUnidadMovil;
	}
	public void setIdUnidadMovil(UnidadMovilDTO idUnidadMovil) {
		this.idUnidadMovil = idUnidadMovil;
	}
	public DonanteDTO getIdDonante() {
		return idDonante;
	}
	public void setIdDonante(DonanteDTO idDonante) {
		this.idDonante = idDonante;
	}
	public DatosDonacionDTO getIdDatosDonacion() {
		return idDatosDonacion;
	}
	public void setIdDatosDonacion(DatosDonacionDTO idDatosDonacion) {
		this.idDatosDonacion = idDatosDonacion;
	}
	
}
