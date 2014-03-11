package models;

/**
 * ---------------------------------
 * Gestion des logs d'accès aux BDD
 * ---------------------------------
 * 
 * @author Robin BILLY - SIO2
 * @author Chafik DAGGAG - SIO2
 * @package models
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
