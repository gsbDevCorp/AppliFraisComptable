package models;

/**
 * 
 * Gestion des logs d'accès à la base de données
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class StaticDBConf {

	//-- Attributs
	private static String user = "root", passwd = "root";
	
	public static String getUser() {
		return user;
	}
	
	public static String getPasswd() {
		return passwd;
	}
}
