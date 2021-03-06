package cm.objis.wtt.pharmacie.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Classe qui contient les param�tres de connexion � la Base de donn�es.
 * Les param�tres sont lus dans un fichier de configration
 * 
 * @author thierry WADJI
 *
 */
public class DBParameter {
	
	/**
	 * Le nom du fichier de configuration (config.txt). Il doit etre renseign� comme suit:
	 * dbhost=adresse IP ou nom du serveur de base de donn�e
	 * dbname=nom de la base de donn�e (BD)
	 * username=nom d'utilisateur de la BD
	 * password=mot de passe   
	 */
	public static final String FILENAME = "config.txt";
	
	private static String dbhost;
	private static String dbname;
	private static String username;
	private static String password;
	
	static { // initialisation static
		
		try {
			Scanner sc = new Scanner (new FileReader(FILENAME));
			while(sc.hasNext()) {
				String[] line = sc.next().split("=");
				String val = (line.length < 2) ? "" : line[1];
				switch(line[0]) {
				case "dbhost":
					dbhost = val;
					break;
				case "dbname":
					dbname =  val;
					break;
				case "username":
					username = val;
					break;
				case "password":
					password = val;
					break;
				}
					
				
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	/**
	 * @return l'adresse IP ou nom du serveur de bases de donn�es
	 */
	public static String getDbhost() {
		return dbhost;
	}

	/**
	 * @return le nom de la base de donn�es
	 */
	public static String getDbname() {
		return dbname;
	}

	/**
	 * @return le nom d'utilisateur de la base de donn�es
	 */
	public static String getUsername() {
		return username;
	}

	/**
	 * @return le mot de passe de la base de donn�es
	 */
	public static String getPassword() {
		return password;
	}
	
	
	
	

}
