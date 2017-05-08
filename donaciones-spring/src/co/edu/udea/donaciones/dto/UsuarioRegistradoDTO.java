package co.edu.udea.donaciones.dto;

public class UsuarioRegistradoDTO {
	private String usuario;
	private DonanteDTO documentoUsuario;
	private String contrasena;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public DonanteDTO getDocumentoUsuario() {
		return documentoUsuario;
	}
	public void setDocumentoUsuario(DonanteDTO documentoUsuario) {
		this.documentoUsuario = documentoUsuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
}
