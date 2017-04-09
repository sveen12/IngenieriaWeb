package com.udea.www.dto;

public class DireccionesDTO {
	private DireccionIDDTO id;
	private String direccion;
	private String telefono;
	private Long ciudad;
	private Boolean preferido;
	
	public DireccionIDDTO getId() {
		return id;
	}
	public void setId(DireccionIDDTO id) {
		this.id = id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Long getCiudad() {
		return ciudad;
	}
	public void setCiudad(Long ciudad) {
		this.ciudad = ciudad;
	}
	public boolean getPreferido() {
		return preferido;
	}
	public void setPreferido(Boolean preferido) {
		this.preferido = preferido;
	}
	
	
	
	
}
