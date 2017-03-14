 package co.edu.udea.www.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.udea.www.exception.MyException;

/**
 * Esta clase implementa el patrón de diseño singleton para el DataSource
 * @author Richard Morales
 *
 */
public class DataSourceSingleton {
    private static DataSourceSingleton instancia    = null;
    
    /**
     * Constructor privado para que no se pueda inicializar desde afuera
     */
    private DataSourceSingleton(){
    	
    }
    
    /**
     * Inicializa la instancia si no lo esta, de lo contrario (si está creada) solo la retorna
     * @return Retorna una instancia del datasource
     */
    public static DataSourceSingleton getInstance(){
        if(instancia==null){
            instancia = new DataSourceSingleton();
        }
        return instancia;
    }
    
    /**
     * Obtiene la conexión a la base de datos por medio del jdbc
     * @return Retorna una conexión a la base de datos
     * @throws MyException
     */
	public Connection getConnection() throws MyException{
		Connection con = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");		//Buscar el driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/richard","root","root");
		
		} catch(ClassNotFoundException e){
			throw new MyException("Driver no encontrado.", e);
		} catch(SQLException e){
			throw new MyException("No puede establecer la conexión.", e);
		}		
		
		return con;		
	}

}
