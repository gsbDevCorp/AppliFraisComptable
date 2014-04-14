package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;

import controllers.FraisHorsForfaitCtrl;

/**
 * 
 * Gestion des accès à la BDD pour traitement des informations sur
 * les frais hors forfait
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
	 * Récupération de tous les frais hors forfaits pour un visiteur donné et un mois donné
	 * 
	 * @param idVisiteur String
	 * @param mois String
	 * 
	 * @return ArrayList<FraisHorsForfaitCtrl>
	 */
	public static ArrayList<FraisHorsForfaitCtrl> getFraisHorsForfait(String idVisiteur, String mois) {
		logTrace.setLevel(Level.WARNING);
		logTrace.info("getFraisHorsForfait("+idVisiteur+","+mois+")");
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

			PreparedStatement statement = connect.prepareStatement("SELECT * "
					+ "FROM LigneFraisHorsForfait "
					+ "WHERE idVisiteur = ? "
					+ "AND mois = ?");
			statement.setString(1, idVisiteur);
			statement.setString(2, mois);
			ResultSet result = statement.executeQuery();
			
			logTrace.info("Récupération de tous les frais hors forfait effectuée avec succès");
			logTrace.info("Ajout des frais hors forfaits à la liste");
			
			while(result.next()) {
				FraisHorsForfaitCtrl fraisForfait = new FraisHorsForfaitCtrl(result.getInt("id"), result.getString("libelle"), result.getDate("date"), result.getDouble("montant"), result.getInt("etat"));
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
	 * Modification de l'état du frais hors forfait<br>
	 * <ul>
	 * <li>NULL = non traité</li>
	 * <li>0 = refusée</li>
	 * <li>1 = validée</li>
	 * </ul>
	 * 
	 * @param id int
	 * @param etat int
	 */
	public static void modifierEtat(int id, int etat) {
		logTrace.setLevel(Level.WARNING);
		logTrace.info("modifierEtat("+id+","+etat+")");
		logTrace.info("Modification de l'état du frais hors forfait");
		
		try {
			//-- Récupération de la connexion
			Connection connect = null;
			try {
				connect = connexion.getConnection();
			} catch(Exception e) {
				logTrace.severe("Erreur lors de la connexion à la BDD");
			}
			
			//-- Transactions

			PreparedStatement statement = connect.prepareStatement("UPDATE LigneFraisHorsForfait "
					+ "SET etat = ? "
					+ "WHERE id = ?");
			statement.setInt(1, etat);
			statement.setInt(2, id);
			statement.executeUpdate();
			
			logTrace.info("Mise à jour de l'état du frais hors forfait effectuée avec succès");
			
		} catch(SQLException e) {
			logTrace.severe("Erreur SQL : " + e.getMessage());
		} catch(Exception e) {
			logTrace.severe("Erreur lors du traitement des données : ");
			e.printStackTrace();
		} finally {
			connexion.closeConnection();
		}
	}
}
