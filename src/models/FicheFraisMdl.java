package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;

import controllers.FicheFraisCtrl;

/**
 * 
 * Gestion des accès à la BDD pour traitement des informations sur les fiches de frais
 * 
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class FicheFraisMdl {
	
	//-- Attributs
		private static Connector connexion = new Connector();
		private static Logger logTrace = Logger.getLogger(FicheFraisMdl.class.getName());
		
	//-- Méthodes
	
	/**
	 * Récupération de toutes les fiches frais d'un visiteur donné
	 * 
	 * @param idVisiteur String
	 * @return ArrayList<FicheFraisCtrl>
	 */
	public static ArrayList<FicheFraisCtrl> getFichesFrais(String idVisiteur) {
		logTrace.setLevel(Level.WARNING);
		logTrace.info("getFichesFrais("+idVisiteur+")");
		logTrace.info("Récupération de toutes les fiches de frais");
		
		ArrayList<FicheFraisCtrl> listeRetour = new ArrayList<FicheFraisCtrl>();
		
		try {
			//-- Récupération de la connexion
			Connection connect = null;
			try {
				connect = connexion.getConnection();
			} catch(Exception e) {
				logTrace.severe("Erreur lors de la connexion à la BDD");
			}
			
			//-- Transactions

			PreparedStatement statement = connect.prepareStatement("SELECT * FROM FicheFrais "
					+ "WHERE idVisiteur = ? ");
			statement.setString(1, idVisiteur);
			ResultSet result = statement.executeQuery();
			
			logTrace.info("Récupération de toutes les fiches de frais effectuée avec succès");
			logTrace.info("Ajout des fiches de frais à la liste");
			
			while(result.next()) {
				FicheFraisCtrl ficheFrais = new FicheFraisCtrl(idVisiteur, result.getString("idEtat"),result.getString("mois"),result.getDate("dateModif"),result.getInt("nbJustificatifs"),result.getDouble("montantValide"));
				listeRetour.add(ficheFrais);
			}
			
			logTrace.info("Ajout des fiches de frais à la liste effecuté avec succès");
			logTrace.info("Retour de la liste de fiches de frais");
			
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
