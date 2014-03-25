package models;

import java.sql.*;
import java.util.ArrayList;

/**
 * ---------------------------------
 * Gestion des accès à la BDD pour
 * traitement des informations sur
 * les comptables
 * ---------------------------------
 * 
 * @author Robin BILLY - SIO2
 * @package controllers
 * @version 1.0.0
 *
 */
public class ComptableMdl {

	//-- Attributs
	private static Connector connexion = new Connector();
	private static String logTrace = "ComptableMdl";

	//-- Méthodes
	
	/**
	 * Vérification de la connexion des comptables
	 * Retours :
	 * 1 = OK
	 * <> 1 = ERREUR
	 * 
	 * @param String identifiant
	 * @param String mdp
	 * @return int
	 */
	public static int connexionComptable(String identifiant, String mdp) {
		System.out.println("["+logTrace+"] - INFO - connexionComptable()");
		System.out.println("["+logTrace+"] - INFO - Vérification des identifiants de connexion du comptable " + identifiant);
		
		int retourComptable = 0;

		try {
			//-- Récupération de la connexion
			Connection connect = null;
			try {
				connect = connexion.getConnection();
			} catch(Exception e) {
				System.err.println("["+logTrace+"] - ERREUR - Erreur lors de la connexion à la BDD");
			}
			
			//-- Transactions

			PreparedStatement statement = connect.prepareStatement("SELECT COUNT(*) AS nbComptables FROM Comptable WHERE login = ? AND mdp = ?");
			statement.setString(1, identifiant);
			statement.setString(2, mdp);
			ResultSet result = statement.executeQuery();
			
			while(result.next())
				retourComptable = result.getInt("nbComptables");
			
			System.out.println("["+logTrace+"] - INFO - Nombre de comptables récupérés : " + retourComptable);
			System.out.println("["+logTrace+"] - INFO - Retour du nombre de visiteurs médicaux");
		}
		catch(SQLException e) {
			System.err.println("["+logTrace+"] - ERREUR - Erreur SQL : " + e.getMessage());
		} catch(Exception e) {
			System.err.println("["+logTrace+"] - ERREUR - Erreur lors du traitement des données : " + e);
		} finally {
			connexion.closeConnection();
		}
		return retourComptable;
	}
}
