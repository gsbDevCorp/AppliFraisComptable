package models;

import java.sql.*;
import java.util.ArrayList;

import controllers.FraisForfaitCtrl;
import controllers.VisiteurCtrl;

/**
 * ---------------------------------
 * Gestion des accès à la BDD pour
 * traitement des informations sur
 * les frais forfaits
 * ---------------------------------
 * 
 * @author Robin BILLY - SIO2
 * @author Chafik DAGGAG - SIO2
 * Package models
 * @version 1.0.0
 *
 */
public class FraisForfaitMdl {
	
	//-- Attributs
		private static Connector connexion = new Connector();
		private static String logTrace = "FraisForfaitMdl";
		
	//-- Méthodes
		
	/**
	 * Récupération de tous les frais forfaits d'un mois donné pour un visiteur donné
	 * 
	 * @param idVisiteur String
	 * @param mois String
	 * @return ArrayList<FraisForfaitCtrl>
	 */
	public static ArrayList<FraisForfaitCtrl> getFraisForfait(String idVisiteur, String mois) {
		System.out.println("["+logTrace+"] - INFO - getFraisForfait(String visiteur, String mois)");
		System.out.println("["+logTrace+"] - INFO - Récupération de tous les frais forfait");
		
		ArrayList<FraisForfaitCtrl> listeRetour = new ArrayList<FraisForfaitCtrl>();
		
		try {
			//-- Récupération de la connexion
			Connection connect = null;
			try {
				connect = connexion.getConnection();
			} catch(Exception e) {
				System.err.println("["+logTrace+"] - ERREUR - Erreur lors de la connexion à la BDD");
			}
			
			//-- Transactions

			PreparedStatement statement = connect.prepareStatement("SELECT * FROM LigneFraisForfait WHERE idVisiteur = ? AND mois = ?");
			statement.setString(1, idVisiteur);
			statement.setString(2, mois);
			ResultSet result = statement.executeQuery();
			
			System.out.println("["+logTrace+"] - INFO - Récupération de tous les frais forfait effectuée avec succès");
			System.out.println("["+logTrace+"] - INFO - Ajout des frais forfaits à la liste");
			
			while(result.next()) {
				FraisForfaitCtrl fraisForfait = new FraisForfaitCtrl(result.getString("idFraisForfait"), result.getInt("quantite"));
				listeRetour.add(fraisForfait);
			}
			
			System.out.println("["+logTrace+"] - INFO - Ajout des frais forfait à la liste effecuté avec succès");
			System.out.println("["+logTrace+"] - INFO - Retour de la liste de frais forfait");
			
		} catch(SQLException e) {
			System.err.println("["+logTrace+"] - ERREUR - Erreur SQL : " + e.getMessage());
		} catch(Exception e) {
			System.err.println("["+logTrace+"] - ERREUR - Erreur lors du traitement des données : " + e);
		} finally {
			connexion.closeConnection();
		}
		return listeRetour;
	}
}
