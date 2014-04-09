package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;

import controllers.FraisForfaitCtrl;
import controllers.TypeFraisCtrl;

/**
 * ---------------------------------
 * Gestion des accès à la BDD pour
 * traitement des informations sur
 * les frais forfaits
 * ---------------------------------
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class FraisForfaitMdl {
	
	//-- Attributs
		private static Connector connexion = new Connector();
		private static Logger logTrace = Logger.getLogger(FraisForfaitMdl.class.getName());
		
	//-- Méthodes
	
	/**
	 * Récupération de tous les frais forfaits d'un visiteur donnée pour un mois donné
	 * 
	 * @param idVisiteur String
	 * @return ArrayList<FraisForfaitCtrl>
	 */
	public static ArrayList<FraisForfaitCtrl> getFraisForfait(String idVisiteur, String mois) {
		logTrace.setLevel(Level.WARNING);
		logTrace.info("getFraisForfait("+idVisiteur+")");
		logTrace.info("Récupération de tous les frais forfait");
		
		ArrayList<FraisForfaitCtrl> listeRetour = new ArrayList<FraisForfaitCtrl>();
		
		try {
			//-- Récupération de la connexion
			Connection connect = null;
			try {
				connect = connexion.getConnection();
			} catch(Exception e) {
				logTrace.severe("Erreur lors de la connexion à la BDD");
			}
			
			//-- Transactions

			PreparedStatement statement = connect.prepareStatement("SELECT l.quantite, f.id, f.libelle, f.montant "
					+ "FROM LigneFraisForfait l, FraisForfait f "
					+ "WHERE l.idFraisForfait = f.id "
					+ "AND idVisiteur = ? "
					+ "AND mois = ?");
			statement.setString(1, idVisiteur);
			statement.setString(2, mois);
			ResultSet result = statement.executeQuery();
			
			logTrace.info("Récupération de tous les frais forfait effectuée avec succès");
			logTrace.info("Ajout des frais forfaits à la liste");
			
			while(result.next()) {
				FraisForfaitCtrl fraisForfait = new FraisForfaitCtrl(new TypeFraisCtrl(result.getString(2), result.getString(3), result.getDouble(4)), result.getInt(1));
				listeRetour.add(fraisForfait);
			}
			
			logTrace.info("Ajout des frais forfait à la liste effecuté avec succès");
			logTrace.info("Retour de la liste de frais forfait");
			
		} catch(SQLException e) {
			logTrace.severe("Erreur SQL : " + e.getMessage());
		} catch(Exception e) {
			logTrace.severe("Erreur lors du traitement des données : ");
			e.printStackTrace();
		} finally {
			connexion.closeConnection();
		}
		return listeRetour;
	}
}
