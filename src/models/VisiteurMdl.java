package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;

import controllers.VisiteurCtrl;

/**
 * ---------------------------------
 * Gestion des accès à la BDD pour
 * traitement des informations sur
 * les visiteurs médicaux
 * ---------------------------------
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class VisiteurMdl {

	//-- Attributs
	private static Connector connexion = new Connector();
	private static Logger logTrace = Logger.getLogger(VisiteurMdl.class.getName());
	
	//-- Méthodes
	
	/**
	 * Récupération de tous les visiteurs
	 * 
	 * @return ArrayList<VisiteurCtrl>
	 */
	public static ArrayList<VisiteurCtrl> getAllVisitors() {
		logTrace.setLevel(Level.INFO);
		logTrace.info("getAllVisitors()");
		logTrace.info("Récupération de tous les visiteurs médicaux");
		
		ArrayList<VisiteurCtrl> listeRetour = new ArrayList<VisiteurCtrl>();
		
		try {
			//-- Récupération de la connexion
			Connection connect = null;
			try {
				connect = connexion.getConnection();
			} catch(Exception e) {
				logTrace.severe("Erreur lors de la connexion à la BDD");
			}
			
			//-- Transactions

			PreparedStatement statement = connect.prepareStatement("SELECT * FROM Visiteur");
			ResultSet result = statement.executeQuery();
			
			logTrace.info("Récupération de tous les visiteurs médicaux effectuée avec succès");
			logTrace.info("Ajout des visiteurs médicaux à la liste");
			
			while(result.next()) {
				VisiteurCtrl visiteur = new VisiteurCtrl(result.getString("id"),result.getString("nom"),result.getString("prenom"),result.getString("adresse"),result.getString("cp"),result.getString("ville"),result.getDate("dateEmbauche"));
				listeRetour.add(visiteur);
			}
			logTrace.info("Ajout des visiteurs médicaux à la liste effecuté avec succès");
			logTrace.info("Retour de la liste de visiteurs médicaux");
			
		} catch(SQLException e) {
			logTrace.severe("Erreur SQL : " + e.getMessage());
		} catch(Exception e) {
			logTrace.severe("Erreur lors du traitement des données : " + e);
		} finally {
			connexion.closeConnection();
		}
		return listeRetour;
	}
	
	/**
	 * Récupération du nombre total de visiteurs
	 * 
	 * @return int
	 */
	public static int getNbVisitors() {
		logTrace.setLevel(Level.INFO);
		logTrace.info("getNbVisitors()");
		logTrace.info("Récupération du nombre de visiteurs médicaux");
		
		int nbVisiteurs = 0;

		try {
			//-- Récupération de la connexion
			Connection connect = null;
			try {
				connect = connexion.getConnection();
			} catch(Exception e) {
				logTrace.severe("Erreur lors de la connexion à la BDD");
			}
			
			//-- Transactions

			PreparedStatement statement = connect.prepareStatement("SELECT COUNT(*) AS nbVisiteur FROM Visiteur");
			ResultSet result = statement.executeQuery();
			
			while(result.next())
				nbVisiteurs = result.getInt("nbVisiteur");
			
			logTrace.info("Nombre de visiteurs récupérés : " + nbVisiteurs);
			logTrace.info("Retour du nombre de visiteurs médicaux");
		}
		catch(SQLException e) {
			logTrace.severe("Erreur SQL : " + e.getMessage());
		} catch(Exception e) {
			logTrace.severe("Erreur lors du traitement des données : " + e);
		} finally {
			connexion.closeConnection();
		}
		return nbVisiteurs;
	}
}
