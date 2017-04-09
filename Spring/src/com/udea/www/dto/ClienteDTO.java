package com.udea.www.dto;

import java.util.Date;
import java.util.Set;

public class ClienteDTO {
	private String cedula;
	private String nombres;
	private String apellidos;
	private String email;
	private UsuarioDTO usuarioCrea;
	private Date fechaCreacion;
	private UsuarioDTO usuarioModifica;
	private Date fechaModificacion;
	private Boolean eliminado;
	private UsuarioDTO usuarioElimina;
	private Date fechaEliminacion;
	private Set<DireccionesDTO> direcciones;
	
	public Set<DireccionesDTO> getDirecciones() {
		return direcciones;
	}
	public void setDirecciones(Set<DireccionesDTO> direcciones) {
		this.direcciones = direcciones;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UsuarioDTO getUsuarioCrea() {
		return usuarioCrea;
	}
	public void setUsuarioCrea(UsuarioDTO usuarioCrea) {
		this.usuarioCrea = usuarioCrea;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public UsuarioDTO getUsuarioModifica() {
		return usuarioModifica;
	}
	public void setUsuarioModifica(UsuarioDTO usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public Boolean getEliminado() {
		return eliminado;
	}
	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}
	public UsuarioDTO getUsuarioElimina() {
		return usuarioElimina;
	}
	public void setUsuarioElimina(UsuarioDTO usuarioElimina) {
		this.usuarioElimina = usuarioElimina;
	}
	public Date getFechaEliminacion() {
		return fechaEliminacion;
	}
	public void setFechaEliminacion(Date fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}
	
	
	
}
