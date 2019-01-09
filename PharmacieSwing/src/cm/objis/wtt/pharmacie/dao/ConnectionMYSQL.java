package cm.objis.wtt.pharmacie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import cm.objis.wtt.pharmacie.util.DBParameter;

/**
 * Classe de création de la connexion à la Base de données MySQL
 * @author thierry WADJI
 *
 */
public class ConnectionMYSQL {
	
	
	/**
	 * URL(jdbc:mysql://dbhost/dbname) d'accès à la base de données
	 */
	public static String url;
	
	/**
	 * nom d'utilisateur de la base des données
	 */
	public static String login;
	
	/**
	 * Mot de passe 
	 */
	public static String passwd;
	
	/**
	 * Objet de connection à la BD 
	 */
	public static Connection connection;
	
	static {
		
		url = "jdbc:mysql://"+DBParameter.getDbhost()+"/"+DBParameter.getDbname();
		login = DBParameter.getUsername();
		passwd = DBParameter.getPassword();
		
	}
	
	/**
	 * Methode de création d'une connection
	 * Elle ne prend rien en parametre
	 * @return Connection
	 */
	public static Connection getInstance() {
		
		if (connection==null) {
			
			try {
				
				connection = DriverManager.getConnection(url,login,passwd);
				
			}catch (SQLException e) {
				
				System.out.println("Probleme de connection"); 
				
			}
			
		}
		
		return connection;
		
	}

}
