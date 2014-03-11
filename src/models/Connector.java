package models;

import java.sql.*;

/**
 * ---------------------------------
 * Gestion de la connexion � la BDD
 * ---------------------------------
 * 
 * @author Robin BILLY - SIO2
 * @author Chafik DAGGAG - SIO2
 * @package models
 * @version 1.0.1
 *
 */
public class Connector {

	//-- Attributs
	private Connection connect;
	private String dbName;
	private String logTrace = this.getClass().getSimpleName();
	
	//-- Constructeurs
	
	/**
	 * Constructeur Connector par d�faut
	 * Gestion de la connexion à la BDD
	 */
	public Connector() {
		this.setDbName("gsb_frais");
		this.loadJDBCDriver();
	}
	
	/**
	 * Constructeur Connector avec param�tres
	 * Gestion de la connexion � la BDD
	 * 
	 * @param String dbName
	 */
	public Connector(String dbName) {
		this.setDbName(dbName);
		this.loadJDBCDriver();
	}
	
	//-- Accesseurs | Modificateurs
	
	/**
	 * Accesseur dbName
	 * 
	 * @return String dbName
	 */
	public String getDbName() {
		return this.dbName;
	}
	/**
	 * Modificateur dbName
	 * 
	 * @param String dbName
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
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
	public void getConnection() {
		
		try {
			if(this.connect == null || this.connect.isClosed()) {
				try {
					System.out.println("["+this.logTrace+"] - INFO - Tentative de connexion � : " + this.getDbName());
					this.connect = DriverManager.getConnection("jdbc:mysql://localhost/"+this.getDbName(),StaticDBConf.getUser(),StaticDBConf.getPasswd());
					System.out.println("["+this.logTrace+"] - INFO - Connexion à " + this.getDbName() + " effectuée avec succès");
				}
				catch(SQLException e) {
					if(e.getErrorCode() == 1044 || e.getErrorCode() == 1045)
						System.err.println("["+this.logTrace+"] - ERREUR - Erreur SQL lors de la connexion � " + this.getDbName() + " : Identifiants invalides");
					else if(e.getErrorCode() == 1049) {
						System.err.println("["+this.logTrace+"] - ERREUR - Erreur SQL lors de la connexion � " + this.getDbName() + " : Base de donn�es inexistante");
					}
					else
						System.err.println("["+this.logTrace+"] - ERREUR - Erreur SQL lors de la connexion � " + this.getDbName());
				}
			}
			else {
				System.err.println("["+this.logTrace+"] - ERREUR - Connexion � " + this.getDbName() + " d�j� active");
				System.err.println("["+this.logTrace+"] - ERREUR - Tentative de connexion avort�e.");
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
				System.out.println("["+this.logTrace+"] - INFO - Fermeture des flux de connexion � " + this.getDbName() + " effectu�e");
			}
			catch (SQLException e) {
				System.err.println("["+this.logTrace+"] - ERREUR - Erreur lors de la fermeture des flux de connexion � " + this.getDbName());
			}
		}
	}
}