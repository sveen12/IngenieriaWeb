package com.udea.www.dto;

public class CiudadDTO {
	/**/
		//Se hacen privados para manipularlos por getters y setters
		private long codigo;
		private String nombre;
		//La ciudad tiene un codigo de Area
		private String codigoArea; 
		
		/*Getters y setters*/
		public long getCodigo(){
			return this.codigo;
		}
		public void setCodigo(Long cod){
			this.codigo = cod;
		}
		
		public String getNombre(){
			return this.nombre;
		}
		public void setNombre(String nom){
			this.nombre=nom;
		}
		
		public String getCodigoArea(){
			return this.codigoArea;
		}
		public void setCodigoArea(String codA){
			this.codigoArea = codA;
		}
}
