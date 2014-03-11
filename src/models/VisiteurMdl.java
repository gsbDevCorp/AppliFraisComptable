package models;

import java.sql.Statement;
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
 * @package controllers
 * @version 1.0.0
 *
 */
public class VisiteurMdl {

	//-- Attributs
	private static Connector connexion = new Connector();
	
	//-- Méthodes
	
	/**
	 * Récupération de tous les visiteurs
	 * 
	 * @return ArrayList<VisiteurCtrl>
	 */
	public static ArrayList<VisiteurCtrl> getAllVisitors() {
		System.out.println("[VisiteurMdl] - INFO - Récupération de tous les visiteurs médicaux");
		
		try {
			//-- Récupération de la connexion
			try {
				connexion.getConnection();
			} catch(Exception e) {
				System.err.println("[VisiteurMdl] - ERREUR - Erreur lors de la connexion à la BDD");
			}
			
			//-- Transactions
			/*Statement statement = connexion.createStatement();*/
			
		} catch(Exception e) {
			System.err.println("[VisiteurMdl] - ERREUR - Erreur lors du traitement des données");
		} finally {
			connexion.closeConnection();
		}
		return null;
	}
}
