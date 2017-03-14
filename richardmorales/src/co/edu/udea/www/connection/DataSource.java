package co.edu.udea.www.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.udea.www.exception.MyException;


public class DataSource {

	public static Connection getConnection() throws MyException{
		Connection con = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");		//Buscar el driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/davidace","root","root");
		
		} catch(ClassNotFoundException e){
			throw new MyException("Driver no encontrado.", e);
		} catch(SQLException e){
			throw new MyException("No puede establecer la conexión.", e);
		}		
		
		return con;		
	}
}
