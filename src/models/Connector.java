package models;

import java.sql.*;

/**
 * ---------------------------------
 * Gestion de la connexion à la BDD
 * ---------------------------------
 * 
 * @author Robin BILLY - SIO2
 * @package models
 * @version 1.0.2
 *
 */
public class Connector {

	//-- Attributs
	private static Connection connect;
	private static String dbName = "gsb_frais";
	private static String logTrace = "Connector";
	
	//-- Constructeurs
	
	/**
	 * Constructeur Connector par défaut
	 * Gestion de la connexion à la BDD
	 */
	public Connector() {
		this.loadJDBCDriver();
	}
	
	//-- Méthodes
	
	/**
	 * Chargement du driver JDBC
	 * 
	 */
	private void loadJDBCDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			System.err.println("["+this.logTrace+"] - ERREUR - Erreur au chargement du driver JDBC.");
		}
	}
	
	/**
	 * Instanciation de la connexion
	 * 
	 * @return Connection
	 */
	public static Connection getConnection() {
		
		try {
			if(connect == null || connect.isClosed()) {
				try {
					System.out.println("["+logTrace+"] - INFO - Tentative de connexion à : " + dbName);
					connect = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,StaticDBConf.getUser(),StaticDBConf.getPasswd());
					System.out.println("["+logTrace+"] - INFO - Connexion à " + dbName + " effectuée avec succès");
					return connect;
				}
				catch(SQLException e) {
					if(e.getErrorCode() == 1044 || e.getErrorCode() == 1045)
						System.err.println("["+logTrace+"] - ERREUR - Erreur SQL lors de la connexion à " + dbName + " : Identifiants invalides");
					else if(e.getErrorCode() == 1049) {
						System.err.println("["+logTrace+"] - ERREUR - Erreur SQL lors de la connexion à " + dbName + " : Base de données inexistante");
					}
					else
						System.err.println("["+logTrace+"] - ERREUR - Erreur SQL lors de la connexion à " + dbName);
				}
			}
			else {
				System.err.println("["+logTrace+"] - ERREUR - Connexion à " + dbName + " déjà active");
				System.err.println("["+logTrace+"] - ERREUR - Tentative de connexion avortée.");
			}
		}
		catch(SQLException e) {
			System.err.println("["+logTrace+"] - ERREUR - Erreur SQL : isClosed()");
		}
		return null;
	}
	
	/**
	 * Fermeture de l'instance de connexion
	 */
	public void closeConnection() {
		if (this.connect != null) {
			try {
				this.connect.close();
				System.out.println("["+this.logTrace+"] - INFO - Fermeture des flux de connexion à " + dbName + " effectuée");
			}
			catch (SQLException e) {
				System.err.println("["+this.logTrace+"] - ERREUR - Erreur lors de la fermeture des flux de connexion à " + dbName);
			}
		}
	}
}