package co.edu.udea.donaciones.dto;

import java.util.Date;

public class DonanteDTO {
	private String documento;
	private String direccion;
	private String edad;
	private String estadoCivil;
	private String estadoSalud;
	private Date fechaNacimiento;	
	private Date ultimaDonacion;
	private String nombres;
	private String apellidos;
	private int peso;
	private String apto;
	private RHDTO rh;
	
	
	
	public RHDTO getRh() {
		return rh;
	}

	public void setRh(RHDTO rh) {
		this.rh = rh;
	}

	public String getApto() {
		return apto;
	}

	public void setApto(String apto) {
		this.apto = apto;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getEstadoSalud() {
		return estadoSalud;
	}
	public void setEstadoSalud(String estadoSalud) {
		this.estadoSalud = estadoSalud;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Date getUltimaDonacion() {
		return ultimaDonacion;
	}
	public void setUltimaDonacion(Date ultimaDonacion) {
		this.ultimaDonacion = ultimaDonacion;
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
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
}
