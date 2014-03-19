package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controllers.FraisHorsForfaitCtrl;

/**
 * ---------------------------------
 * Gestion des accès à la BDD pour
 * traitement des informations sur
 * les frais hors forfait
 * ---------------------------------
 * 
 * @author Robin BILLY - SIO2
 * @author Chafik DAGGAG - SIO2
 * @package models
 * @version 1.0.0
 *
 */
public class FraisHorsForfaitMdl {

	//-- Attributs
	private static Connector connexion = new Connector();
	private static String logTrace = "FraisHorsForfaitMdl";
	
	//-- Méthodes
	
	/**
	 * Récupération de tous les frais hors forfaits d'un mois donné pour un visiteur donné
	 * 
	 * @param String idVisiteur
	 * @param String mois
	 * @return ArrayList<FraisHorsForfaitCtrl>
	 */
	public static ArrayList<FraisHorsForfaitCtrl> getFraisHorsForfait(String idVisiteur, String mois) {
		System.out.println("["+logTrace+"] - INFO - getFraisHorsForfait(String visiteur, String mois)");
		System.out.println("["+logTrace+"] - INFO - Récupération de tous les frais hors forfait");
		
		ArrayList<FraisHorsForfaitCtrl> listeRetour = new ArrayList<FraisHorsForfaitCtrl>();
		
		try {
			//-- Récupération de la connexion
			Connection connect = null;
			try {
				connect = connexion.getConnection();
			} catch(Exception e) {
				System.err.println("["+logTrace+"] - ERREUR - Erreur lors de la connexion à la BDD");
			}
			
			//-- Transactions

			PreparedStatement statement = connect.prepareStatement("SELECT * FROM LigneFraisHorsForfait WHERE idVisiteur = ? AND mois = ?");
			statement.setString(1, idVisiteur);
			statement.setString(2, mois);
			ResultSet result = statement.executeQuery();
			
			System.out.println("["+logTrace+"] - INFO - Récupération de tous les frais hors forfait effectuée avec succès");
			System.out.println("["+logTrace+"] - INFO - Ajout des frais hors forfaits à la liste");
			
			while(result.next()) {
				FraisHorsForfaitCtrl fraisForfait = new FraisHorsForfaitCtrl(result.getInt("id"), result.getString("libelle"), result.getDate("date"), result.getDouble("montant"));
				listeRetour.add(fraisForfait);
			}
			
			System.out.println("["+logTrace+"] - INFO - Ajout des frais hors forfait à la liste effecuté avec succès");
			System.out.println("["+logTrace+"] - INFO - Retour de la liste de frais hors forfait");
			
		} catch(SQLException e) {
			System.err.println("["+logTrace+"] - ERREUR - Erreur SQL : " + e.getMessage());
		} catch(Exception e) {
			System.err.println("["+logTrace+"] - ERREUR - Erreur lors du traitement des données : " + e);
		} finally {
			connexion.closeConnection();
		}
		return listeRetour;
	}
	
	/**
	 * Récupération du nombre de frais hors forfait enregistrés pour un visiteur donné et un mois donné
	 * 
	 * @param String idVisiteur
	 * @param String mois
	 * @return int
	 */
	public static int getNbFraisHorsForfait(String idVisiteur, String mois) {
		System.out.println("["+logTrace+"] - INFO - getNbFraisHorsForfait(String visiteur, String mois)");
		System.out.println("["+logTrace+"] - INFO - Récupération du nombre de frais hors forfait pour " + idVisiteur + " - " + mois);
		
		int compteurRetour = 0;
		

		try {
			//-- Récupération de la connexion
			Connection connect = null;
			try {
				connect = connexion.getConnection();
			} catch(Exception e) {
				System.err.println("["+logTrace+"] - ERREUR - Erreur lors de la connexion à la BDD");
			}
			
			//-- Transactions

			PreparedStatement statement = connect.prepareStatement("SELECT COUNT(*) AS nbFiches FROM LigneFraisHorsForfait WHERE idVisiteur = ? AND mois = ?");
			statement.setString(1, idVisiteur);
			statement.setString(2, mois);
			ResultSet result = statement.executeQuery();
			
			System.out.println("["+logTrace+"] - INFO - Récupération de tous les frais hors forfait du mois effectuée avec succès");
			System.out.println("["+logTrace+"] - INFO - Calcul du nombre de fiches hors forfait");
			
			while(result.next()) {
				compteurRetour = result.getInt("nbFiches");
			}
			
			System.out.println("["+logTrace+"] - INFO - Calcul du nombre de frais hors forfait effecuté avec succès");
			System.out.println("["+logTrace+"] - INFO - Retour du compteur de frais hors forfait ("+compteurRetour+")");
			
		} catch(SQLException e) {
			System.err.println("["+logTrace+"] - ERREUR - Erreur SQL : " + e.getMessage());
		} catch(Exception e) {
			System.err.println("["+logTrace+"] - ERREUR - Erreur lors du traitement des données : " + e);
		} finally {
			connexion.closeConnection();
		}
		
		return compteurRetour;
	}
}
