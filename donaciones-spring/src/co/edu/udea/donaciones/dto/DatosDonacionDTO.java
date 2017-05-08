package co.edu.udea.donaciones.dto;

import java.util.Date;

public class DatosDonacionDTO {
	private int id;
	private RHDTO idRH;
	private String estadoDonacion;
	private int cantidad;
	private Date fecha;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public RHDTO getIdRH() {
		return idRH;
	}
	public void setIdRH(RHDTO idRH) {
		this.idRH = idRH;
	}
	public String getEstadoDonacion() {
		return estadoDonacion;
	}
	public void setEstadoDonacion(String estadoDonacion) {
		this.estadoDonacion = estadoDonacion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
