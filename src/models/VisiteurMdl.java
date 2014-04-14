package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;

import controllers.VisiteurCtrl;

/**
 * 
 * Gestion des accès à la BDD pour traitement des informations sur
 * les visiteurs médicaux
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
		logTrace.setLevel(Level.WARNING);
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

			PreparedStatement statement = connect.prepareStatement("SELECT id, nom, prenom "
					+ "FROM Visiteur "
					+ "ORDER BY nom ASC");
			ResultSet result = statement.executeQuery();
			
			logTrace.info("Récupération de tous les visiteurs médicaux effectuée avec succès");
			logTrace.info("Ajout des visiteurs médicaux à la liste");
			
			while(result.next()) {
				VisiteurCtrl visiteur = new VisiteurCtrl(result.getString("id"),result.getString("nom"),result.getString("prenom"));
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
}
