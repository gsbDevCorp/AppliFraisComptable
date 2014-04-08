package models;

import java.sql.*;
import java.util.logging.*;

/**
 * ---------------------------------
 * Gestion de la connexion à la BDD
 * ---------------------------------
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.2
 *
 */
public class Connector {

	//-- Attributs
	private static Connection connect;
	private static String dbName = "gsb_frais";
	private static Logger logTrace = Logger.getLogger(Connector.class.getName());
	
	//-- Constructeurs
	
	/**
	 * Constructeur Connector par défaut
	 * Appel au chargement du driver JDBC
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
		logTrace.setLevel(Level.WARNING);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			logTrace.severe("Erreur au chargement du driver JDBC.");
		}
	}
	
	/**
	 * Instanciation de la connexion
	 * 
	 * @return Connection
	 */
	public static Connection getConnection() {
		logTrace.setLevel(Level.WARNING);
		try {
			if(connect == null || connect.isClosed()) {
				try {
					logTrace.info("Tentative de connexion à : " + dbName);
					connect = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,StaticDBConf.getUser(),StaticDBConf.getPasswd());
					logTrace.info("Connexion à " + dbName + " effectuée avec succès");
					return connect;
				}
				catch(SQLException e) {
					//-- Gestion des erreurs d'identifiants
					if(e.getErrorCode() == 1044 || e.getErrorCode() == 1045)
						logTrace.severe("Erreur SQL lors de la connexion à " + dbName + " : Identifiants invalides");
					//-- Gestion d'erreur base de données inexistante
					else if(e.getErrorCode() == 1049) {
						logTrace.severe("Erreur SQL lors de la connexion à " + dbName + " : Base de données inexistante");
					}
					else
						logTrace.severe("Erreur SQL lors de la connexion à " + dbName);
				}
			}
			else {
				logTrace.warning("Connexion à " + dbName + " déjà active");
				logTrace.warning("Tentative de connexion avortée.");
			}
		}
		catch(SQLException e) {
			logTrace.severe("Erreur SQL : isClosed()");
		}
		return null;
	}
	
	/**
	 * Fermeture de l'instance de connexion
	 */
	public void closeConnection() {
		logTrace.setLevel(Level.WARNING);
		if (this.connect != null) {
			try {
				this.connect.close();
				logTrace.info("Fermeture des flux de connexion à " + dbName + " effectuée");
			}
			catch (SQLException e) {
				logTrace.severe("Erreur lors de la fermeture des flux de connexion à " + dbName);
			}
		}
	}
}