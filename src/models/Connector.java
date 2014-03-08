package models;

import java.sql.*;

/**
 * ---------------------------------
 * Gestion de la connexion à la BDD
 * ---------------------------------
 * 
 * @author Robin BILLY - SIO2
 * @package models
 * @version 1.0.0
 *
 */
public class Connector {

	//-- Attributs
	private Connection connect;
	private String logTrace;
	
	//-- Constructeurs
	
	/**
	 * Constructeur Connector par défaut
	 * Gestion de la connexion à la BDD
	 */
	public Connector() {
		this.logTrace = "Connector";
		this.loadJDBCDriver();
		this.getConnection("gsb_frais", StaticDBConf.getUser(), StaticDBConf.getPasswd());
	}
	
	/**
	 * Constructeur Connector avec paramètres
	 * Gestion de la connexion à la BDD
	 * 
	 * @param String dbName
	 */
	public Connector(String dbName) {
		this.logTrace = "Connector";
		this.loadJDBCDriver();
		this.getConnection(dbName, StaticDBConf.getUser(), StaticDBConf.getPasswd());
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
	 * @param String dbName
	 * @param String user
	 * @param String passwd
	 */
	private void getConnection(String dbName, String user, String passwd) {
		
		try {
			if(this.connect == null || this.connect.isClosed()) {
				try {
					System.out.println("["+this.logTrace+"] - INFO - Tentative de connexion à : " + dbName);
					this.connect = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,user,passwd);
					System.out.println("["+this.logTrace+"] - INFO - Connexion à " + dbName + " passée avec succès");
				}
				catch(SQLException e) {
					if(e.getErrorCode() == 1044 || e.getErrorCode() == 1045)
						System.err.println("["+this.logTrace+"] - ERREUR - Erreur SQL lors de la connexion à " + dbName + " : Identifiants invalides");
					else if(e.getErrorCode() == 1049) {
						System.err.println("["+this.logTrace+"] - ERREUR - Erreur SQL lors de la connexion à " + dbName + " : Base de données inexistante");
					}
					else
						System.err.println("["+this.logTrace+"] - ERREUR - Erreur SQL lors de la connexion à " + dbName);
				}
			}
		}
		catch(SQLException e) {
			System.err.println("["+this.logTrace+"] - ERREUR - Erreur SQL : isClosed()");
		}
	}
	
	/**
	 * Fermeture de l'instance de connexion
	 */
	public void closeConnection() {
		if (this.connect != null) {
			try {
				this.connect.close();
				System.out.println("["+this.logTrace+"] - INFO - Fermeture des flux de connexion à la BDD effectuée");
			}
			catch (SQLException e) {
				System.err.println("["+this.logTrace+"] - ERREUR - Erreur lors de la fermeture des flux de connexion à la BDD");
			}
		}
	}
}