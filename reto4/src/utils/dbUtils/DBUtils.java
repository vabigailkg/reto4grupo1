package utils.dbUtils;

//Configuraciones necesarias para la Base de Datos de MySql
/**
 * Gestiona las conexiones con MySQL.
 */
public class DBUtils {
	
		// La URL donde esta la Base de Datos. Se descompone en:
		// driver : bbd : // IP : Puerto / Schema
		public static final String URL = "jdbc:mysql://localhost:3306/musicfy";

		// El Driver que vamos a usar
		public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
		
		// Nombre y Pass de acceso a la Base de Datos
		public static final String USER = "root";
		public static final String PASS = "elorrieta";
}
