package models;

import java.sql.*;
import java.util.logging.*;

import controllers.ComptableCtrl;

/**
 * 
 * Gestion des accès à la BDD pour traitement des informations sur
 * les comptables
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class ComptableMdl {

	//-- Attributs
	private static Connector connexion = new Connector();
	private static Logger logTrace = Logger.getLogger(ComptableMdl.class.getName());

	//-- Méthodes
	
	/**
	 * Vérification de la connexion des comptables
	 * Retours :
	 * ComptableCtrl = OK
	 * null = ERREUR
	 * 
	 * @param identifiant String
	 * @param mdp String
	 * @return ComptableCtrl
	 */
	public static ComptableCtrl connexionComptable(String identifiant, String mdp) {
		logTrace.setLevel(Level.WARNING);
		logTrace.info("connexionComptable()");
		logTrace.info("Vérification des identifiants de connexion du comptable : " + identifiant);
		
		ComptableCtrl retourComptable = null;

		try {
			//-- Récupération de la connexion
			Connection connect = null;
			try {
				connect = connexion.getConnection();
			} catch(Exception e) {
				logTrace.severe("Erreur lors de la connexion à la BDD");
			}
			
			//-- Transactions

			PreparedStatement statement = connect.prepareStatement("SELECT * FROM Comptable WHERE login = ? AND mdp = ?");
			statement.setString(1, identifiant);
			statement.setString(2, mdp);
			ResultSet result = statement.executeQuery();
			
			while(result.next())
				retourComptable = new ComptableCtrl(result.getInt("id"),result.getString("nom"),result.getString("prenom"));
			
			logTrace.info("Identifiant de comptable récupéré : " + retourComptable.getId());
			logTrace.info("Retour du comptable");
		}
		catch(SQLException e) {
			logTrace.severe("Erreur lors de la connexion à la BDD");
		} catch(Exception e) {
			logTrace.severe("Erreur lors du traitement des données : " + e);
		} finally {
			connexion.closeConnection();
		}
		return retourComptable;
	}
	
	/**
	 * Comparaison du mot de passe utilisateur passé en paramètre à celui présent
	 * en base de données.
	 * Utile pour la modification du mot de passe.
	 * 
	 * @param id int
	 * @param password String
	 * @return boolean
	 */
	public static boolean checkPassword(int id, String password) {
		logTrace.setLevel(Level.WARNING);
		logTrace.info("checkPassword()");
		logTrace.info("Vérification du mot de passe comptable : " + id);
		
		boolean check = false;
		
		try {
			//-- Récupération de la connexion
			Connection connect = null;
			try {
				connect = connexion.getConnection();
			} catch(Exception e) {
				logTrace.severe("Erreur lors de la connexion à la BDD");
			}
			
			//-- Transactions

			PreparedStatement statement = connect.prepareStatement("SELECT COUNT(*) AS nbOccurences FROM Comptable WHERE id = ? AND mdp = ?");
			statement.setInt(1, id);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();

			while(result.next()) {
				if(result.getInt("nbOccurences") == 1)
					check = true;
			}
			
			logTrace.info("Validité du mot de passe : " + check);
			logTrace.info("Retour du résultat");
		}
		catch(SQLException e) {
			logTrace.severe("Erreur SQL : " + e.getMessage());
		} catch(Exception e) {
			logTrace.severe("Erreur lors du traitement des données : " + e);
		} finally {
			connexion.closeConnection();
		}
		return check;
	}
	
	/**
	 * Modification du mot de passe en base de données
	 * 
	 * @param id int
	 * @param password String
	 */
	public static void setPassword(int id, String password) {
		logTrace.setLevel(Level.WARNING);
		logTrace.info("setPassword()");
		logTrace.info("Modification du mot de passe comptable : " + id);
		
		try {
			//-- Récupération de la connexion
			Connection connect = null;
			try {
				connect = connexion.getConnection();
			} catch(Exception e) {
				logTrace.severe("Erreur lors de la connexion à la BDD");
			}
			
			//-- Transactions

			PreparedStatement statement = connect.prepareStatement("UPDATE Comptable SET mdp = ? WHERE id = ?");
			statement.setString(1, password);
			statement.setInt(2, id);
			statement.executeUpdate();
			
			logTrace.info("Mot de passe modifié pour comptable : " + id);
		}
		catch(SQLException e) {
			logTrace.severe("Erreur SQL : " + e.getMessage());
		} catch(Exception e) {
			logTrace.severe("Erreur lors du traitement des données : " + e);
		} finally {
			connexion.closeConnection();
		}
	}
}
