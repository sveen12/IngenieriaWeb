package richardmorales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//Autor: David Acevedo
public class Ejemplo1 {
	public void CosultarCiudades(){
		Connection con = null; //Conexión con la BD
		PreparedStatement ps = null;	//Consulta a la BD
		ResultSet rs = null;	//Resultado
			
		try{	
			Class.forName("com.mysql.jdbc.Driver");		//Buscar el driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/davidace","root","root"); //Generar conexión con la BD
			ps = con.prepareStatement("Select * From ciudades");	//Consulta a la BD
			rs = ps.executeQuery();	//Resulatdo de la Consulta
			while(rs.next()){
				System.out.print(rs.getString("codigo") + " : " + rs.getString("Nombre")+" ");
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();	//En orden
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	
	}
	
	public static void main(String[] args) {
	}
}
