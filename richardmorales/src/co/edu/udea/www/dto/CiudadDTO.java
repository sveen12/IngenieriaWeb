package co.edu.udea.www.dto;

/**
 * 
 * @author Richard
 *
 */
public class CiudadDTO {
	private long codigo;
	private String nombre;
	private String codigoArea;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoArea() {
		return codigoArea;
	}

	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}

}
