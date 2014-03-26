package models;

import java.sql.*;
import java.util.ArrayList;

import controllers.VisiteurCtrl;

/**
 * ---------------------------------
 * Gestion des accès à la BDD pour
 * traitement des informations sur
 * les visiteurs médicaux
 * ---------------------------------
 * 
 * @author Robin BILLY - SIO2
 * @author Chafik DAGGAG - SIO2
 * Package controllers
 * @version 1.0.0
 *
 */
public class VisiteurMdl {

	//-- Attributs
	private static Connector connexion = new Connector();
	private static String logTrace = "VisiteurMdl";
	
	//-- Méthodes
	
	/**
	 * Récupération de tous les visiteurs
	 * 
	 * @return ArrayList<VisiteurCtrl>
	 */
	public static ArrayList<VisiteurCtrl> getAllVisitors() {
		System.out.println("["+logTrace+"] - INFO - getAllVisitors()");
		System.out.println("["+logTrace+"] - INFO - Récupération de tous les visiteurs médicaux");
		
		ArrayList<VisiteurCtrl> listeRetour = new ArrayList<VisiteurCtrl>();
		
		try {
			//-- Récupération de la connexion
			Connection connect = null;
			try {
				connect = connexion.getConnection();
			} catch(Exception e) {
				System.err.println("["+logTrace+"] - ERREUR - Erreur lors de la connexion à la BDD");
			}
			
			//-- Transactions

			PreparedStatement statement = connect.prepareStatement("SELECT * FROM Visiteur");
			ResultSet result = statement.executeQuery();
			
			System.out.println("["+logTrace+"] - INFO - Récupération de tous les visiteurs médicaux effectuée avec succès");
			System.out.println("["+logTrace+"] - INFO - Ajout des visiteurs médicaux à la liste");
			
			while(result.next()) {
				VisiteurCtrl visiteur = new VisiteurCtrl(result.getString("id"),result.getString("nom"),result.getString("prenom"),result.getString("adresse"),result.getString("cp"),result.getString("ville"),result.getDate("dateEmbauche"));
				listeRetour.add(visiteur);
			}
			System.out.println("["+logTrace+"] - INFO - Ajout des visiteurs médicaux à la liste effecuté avec succès");
			System.out.println("["+logTrace+"] - INFO - Retour de la liste de visiteurs médicaux");
			
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
	 * Récupération du nombre total de visiteurs
	 * 
	 * @return int
	 */
	public static int getNbVisitors() {
		System.out.println("["+logTrace+"] - INFO - getNbVisitors()");
		System.out.println("["+logTrace+"] - INFO - Récupération du nombre de visiteurs médicaux");
		
		int nbVisiteurs = 0;

		try {
			//-- Récupération de la connexion
			Connection connect = null;
			try {
				connect = connexion.getConnection();
			} catch(Exception e) {
				System.err.println("["+logTrace+"] - ERREUR - Erreur lors de la connexion à la BDD");
			}
			
			//-- Transactions

			PreparedStatement statement = connect.prepareStatement("SELECT COUNT(*) AS nbVisiteur FROM Visiteur");
			ResultSet result = statement.executeQuery();
			
			while(result.next())
				nbVisiteurs = result.getInt("nbVisiteur");
			
			System.out.println("["+logTrace+"] - INFO - Nombre de visiteurs récupérés : " + nbVisiteurs);
			System.out.println("["+logTrace+"] - INFO - Retour du nombre de visiteurs médicaux");
		}
		catch(SQLException e) {
			System.err.println("["+logTrace+"] - ERREUR - Erreur SQL : " + e.getMessage());
		} catch(Exception e) {
			System.err.println("["+logTrace+"] - ERREUR - Erreur lors du traitement des données : " + e);
		} finally {
			connexion.closeConnection();
		}
		return nbVisiteurs;
	}
}
