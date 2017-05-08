package co.edu.udea.donaciones.dto;

import java.util.Date;

public class CitaDTO {
	private int id;
	private String estadoCita;
	private Date fecha;
	private String hora;
	private EmpleadoDTO idEnfermero;
	private UsuarioRegistradoDTO idUsuarioRegistrado;
	private SedeDTO idSede;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEstadoCita() {
		return estadoCita;
	}
	public void setEstadoCita(String estadoCita) {
		this.estadoCita = estadoCita;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public EmpleadoDTO getIdEnfermero() {
		return idEnfermero;
	}
	public void setIdEnfermero(EmpleadoDTO idEnfermero) {
		this.idEnfermero = idEnfermero;
	}
	public UsuarioRegistradoDTO getIdUsuarioRegistrado() {
		return idUsuarioRegistrado;
	}
	public void setIdUsuarioRegistrado(UsuarioRegistradoDTO idUsuarioRegistrado) {
		this.idUsuarioRegistrado = idUsuarioRegistrado;
	}
	public SedeDTO getIdSede() {
		return idSede;
	}
	public void setIdSede(SedeDTO idSede) {
		this.idSede = idSede;
	}
	
	
}
