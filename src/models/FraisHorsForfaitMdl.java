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
	 * Récupération de tous les frais hors forfaits pour un visiteur donné
	 * 
	 * @param idVisiteur String
	 * 
	 * @return ArrayList<FraisHorsForfaitCtrl>
	 */
	public static ArrayList<FraisHorsForfaitCtrl> getFraisHorsForfait(String idVisiteur) {
		logTrace.setLevel(Level.WARNING);
		logTrace.info("getFraisHorsForfait("+idVisiteur+")");
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
					+ "WHERE idVisiteur = ?");
			statement.setString(1, idVisiteur);
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
}
