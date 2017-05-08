package co.edu.udea.donaciones.dto;

public class DonacionSedeDTO {
	private int id;
	private SedeDTO idSedeEnvio;
	private SedeDTO idSedeRecibo;
	private DatosDonacionDTO idDatosDonacion;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public SedeDTO getIdSedeEnvio() {
		return idSedeEnvio;
	}
	public void setIdSedeEnvio(SedeDTO idSedeEnvio) {
		this.idSedeEnvio = idSedeEnvio;
	}
	public SedeDTO getIdSedeRecibo() {
		return idSedeRecibo;
	}
	public void setIdSedeRecibo(SedeDTO idSedeRecibo) {
		this.idSedeRecibo = idSedeRecibo;
	}
	public DatosDonacionDTO getIdDatosDonacion() {
		return idDatosDonacion;
	}
	public void setIdDatosDonacion(DatosDonacionDTO idDatosDonacion) {
		this.idDatosDonacion = idDatosDonacion;
	}
	
}
