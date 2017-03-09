package richardmorales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Autor: David Acevedo
public class Ejemplo2 {
	public void ConsultarCiudades(){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver"); //Cargar la clase entre parentesis
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/davidace","root","root");
			ps = con.prepareStatement("Select * From ciudades");	//Consulta a la BD
			
		}catch(Exception e){
			System.out.print(e.getMessage());
		}
	}
}
