package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;

import controllers.FraisHorsForfaitCtrl;

/**
 * ---------------------------------
 * Gestion des accès à la BDD pour
 * traitement des informations sur
 * les frais hors forfait
 * ---------------------------------
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class FraisHorsForfaitMdl {

	//-- Attributs
	private static Connector connexion = new Connector();
	private static Logger logTrace = Logger.getLogger(FraisHorsForfaitMdl.class.getName());
	
	//-- Méthodes
	
	/**
	 * Récupération de tous les frais hors forfaits d'un mois donné pour un visiteur donné
	 * 
	 * @param idVisiteur String
	 * @param mois String
	 * @return ArrayList<FraisHorsForfaitCtrl>
	 */
	public static ArrayList<FraisHorsForfaitCtrl> getFraisHorsForfait(String idVisiteur, String mois) {
		logTrace.setLevel(Level.INFO);
		logTrace.info("getFraisHorsForfait(String visiteur, String mois)");
		logTrace.info("Récupération de tous les frais hors forfait");
		
		ArrayList<FraisHorsForfaitCtrl> listeRetour = new ArrayList<FraisHorsForfaitCtrl>();
		
		try {
			//-- Récupération de la connexion
			Connection connect = null;
			try {
				connect = connexion.getConnection();
			} catch(Exception e) {
				logTrace.severe("Erreur lors de la connexion à la BDD");
			}
			
			//-- Transactions

			PreparedStatement statement = connect.prepareStatement("SELECT * FROM LigneFraisHorsForfait WHERE idVisiteur = ? AND mois = ?");
			statement.setString(1, idVisiteur);
			statement.setString(2, mois);
			ResultSet result = statement.executeQuery();
			
			logTrace.info("Récupération de tous les frais hors forfait effectuée avec succès");
			logTrace.info("Ajout des frais hors forfaits à la liste");
			
			while(result.next()) {
				FraisHorsForfaitCtrl fraisForfait = new FraisHorsForfaitCtrl(result.getInt("id"), result.getString("libelle"), result.getDate("date"), result.getDouble("montant"));
				listeRetour.add(fraisForfait);
			}
			
			logTrace.info("Ajout des frais hors forfait à la liste effecuté avec succès");
			logTrace.info("Retour de la liste de frais hors forfait");
			
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
	 * Récupération du nombre de frais hors forfait enregistrés pour un visiteur donné et un mois donné
	 * 
	 * @param idVisiteur String
	 * @param mois String
	 * @return int
	 */
	public static int getNbFraisHorsForfait(String idVisiteur, String mois) {
		logTrace.setLevel(Level.INFO);
		logTrace.info("getNbFraisHorsForfait(String visiteur, String mois)");
		logTrace.info("Récupération du nombre de frais hors forfait pour " + idVisiteur + " - " + mois);
		
		int compteurRetour = 0;
		

		try {
			//-- Récupération de la connexion
			Connection connect = null;
			try {
				connect = connexion.getConnection();
			} catch(Exception e) {
				logTrace.severe("Erreur lors de la connexion à la BDD");
			}
			
			//-- Transactions

			PreparedStatement statement = connect.prepareStatement("SELECT COUNT(*) AS nbFiches FROM LigneFraisHorsForfait WHERE idVisiteur = ? AND mois = ?");
			statement.setString(1, idVisiteur);
			statement.setString(2, mois);
			ResultSet result = statement.executeQuery();
			
			logTrace.info("Récupération de tous les frais hors forfait du mois effectuée avec succès");
			logTrace.info("Calcul du nombre de fiches hors forfait");
			
			while(result.next()) {
				compteurRetour = result.getInt("nbFiches");
			}
			
			logTrace.info("Calcul du nombre de frais hors forfait effecuté avec succès");
			logTrace.info("Retour du compteur de frais hors forfait ("+compteurRetour+")");
			
		} catch(SQLException e) {
			logTrace.severe("Erreur SQL : " + e.getMessage());
		} catch(Exception e) {
			logTrace.severe("Erreur lors du traitement des données : " + e);
		} finally {
			connexion.closeConnection();
		}
		
		return compteurRetour;
	}
	
	/**
	 * Récupération du nombre total de frais hors forfait
	 * 
	 * @return int
	 */
	public static int getTotalNbFraisHorsForfait() {
		logTrace.setLevel(Level.INFO);
		logTrace.info("["+logTrace+"] - INFO - getTotalNbFraisHorsForfait()");
		logTrace.info("["+logTrace+"] - INFO - Récupération du nombre total de frais hors forfait");
		
		int nbFraisHorsForfait = 0;
		
		try {
			//-- Récupération de la connexion
			Connection connect = null;
			try {
				connect = connexion.getConnection();
			} catch(Exception e) {
				logTrace.severe("Erreur lors de la connexion à la BDD");
			}
			
			//-- Transactions

			PreparedStatement statement = connect.prepareStatement("SELECT COUNT(*) AS nbFraisHorsForfait FROM LigneFraisHorsForfait");
			ResultSet result = statement.executeQuery();
			
			logTrace.info("Récupération du nombre de frais hors forfait effectuée avec succès");
			logTrace.info("Incrémentation du compteur");
			
			while(result.next())
				nbFraisHorsForfait = result.getInt("nbFraisHorsForfait");
			
			logTrace.info("Nombre de frais hors forfait récupérés : " + nbFraisHorsForfait);
			logTrace.info("Retour de la liste de frais hors forfait");
			
		} catch(SQLException e) {
			logTrace.severe("Erreur SQL : " + e.getMessage());
		} catch(Exception e) {
			logTrace.severe("Erreur lors du traitement des données : " + e);
		} finally {
			connexion.closeConnection();
		}
		
		return nbFraisHorsForfait;
		
	}
	
	/**
	 * Récupération du nombre de frais hors forfait en attente
	 * 
	 * @return int
	 */
	public static int getNbFraisHorsForfaitAttente() {
		logTrace.setLevel(Level.INFO);
		logTrace.info("getNbFraisHorsForfaitAttente()");
		logTrace.info("Récupération du nombre de frais hors forfait en attente de validation");
		
		int nbFraisHorsForfaitAttente = 0;
		
		try {
			//-- Récupération de la connexion
			Connection connect = null;
			try {
				connect = connexion.getConnection();
			} catch(Exception e) {
				logTrace.severe("Erreur lors de la connexion à la BDD");
			}
			
			//-- Transactions

			PreparedStatement statement = connect.prepareStatement("SELECT COUNT(*) AS nbFraisHorsForfaitAttente FROM LigneFraisHorsForfait l, FicheFrais f WHERE l.mois = f.mois AND f.idEtat = ?");
			statement.setString(1, "CL");
			ResultSet result = statement.executeQuery();
			
			logTrace.info("Récupération du nombre de frais hors forfait effectuée avec succès");
			logTrace.info("Incrémentation du compteur");
			
			while(result.next())
				nbFraisHorsForfaitAttente = result.getInt("nbFraisHorsForfaitAttente");
			
			logTrace.info("Nombre de frais hors forfait en attente récupérés : " + nbFraisHorsForfaitAttente);
			logTrace.info("Retour du nombre de frais hors forfait en attente");
			
		} catch(SQLException e) {
			logTrace.severe("Erreur SQL : " + e.getMessage());
		} catch(Exception e) {
			logTrace.severe("Erreur lors du traitement des données : " + e);
		} finally {
			connexion.closeConnection();
		}
		
		return nbFraisHorsForfaitAttente;
		
	}
}
