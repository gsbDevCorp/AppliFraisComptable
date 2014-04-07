package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;

import controllers.FraisForfaitCtrl;

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
	 * Récupération de tous les frais forfaits d'un mois donné pour un visiteur donné
	 * 
	 * @param idVisiteur String
	 * @param mois String
	 * @return ArrayList<FraisForfaitCtrl>
	 */
	public static ArrayList<FraisForfaitCtrl> getFraisForfait(String idVisiteur, String mois) {
		logTrace.setLevel(Level.INFO);
		logTrace.info("["+logTrace+"] - INFO - getFraisForfait("+idVisiteur+", "+mois+")");
		logTrace.info("["+logTrace+"] - INFO - Récupération de tous les frais forfait");
		
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

			PreparedStatement statement = connect.prepareStatement("SELECT * FROM LigneFraisForfait "
					+ "WHERE idVisiteur = ? "
					+ "AND mois = ?");
			statement.setString(1, idVisiteur);
			statement.setString(2, mois);
			ResultSet result = statement.executeQuery();
			
			logTrace.info("["+logTrace+"] - INFO - Récupération de tous les frais forfait effectuée avec succès");
			logTrace.info("["+logTrace+"] - INFO - Ajout des frais forfaits à la liste");
			
			while(result.next()) {
				FraisForfaitCtrl fraisForfait = new FraisForfaitCtrl(result.getString("idFraisForfait"), result.getInt("quantite"));
				listeRetour.add(fraisForfait);
			}
			
			logTrace.info("["+logTrace+"] - INFO - Ajout des frais forfait à la liste effecuté avec succès");
			logTrace.info("["+logTrace+"] - INFO - Retour de la liste de frais forfait");
			
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
	 * Récupération du nombre total de frais forfaits
	 * 
	 * @return int
	 */
	public static int getTotalNbFraisForfait() {
		logTrace.setLevel(Level.INFO);
		logTrace.info("["+logTrace+"] - INFO - getNbFraisForfait()");
		logTrace.info("["+logTrace+"] - INFO - Récupération du nombre total de frais forfaits");
		
		int nbFraisForfaits = 0;
		
		try {
			//-- Récupération de la connexion
			Connection connect = null;
			try {
				connect = connexion.getConnection();
			} catch(Exception e) {
				logTrace.severe("Erreur lors de la connexion à la BDD");
			}
			
			//-- Transactions

			PreparedStatement statement = connect.prepareStatement("SELECT COUNT(*) AS nbFraisForfait "
					+ "FROM LigneFraisForfait");
			ResultSet result = statement.executeQuery();
			
			logTrace.info("Récupération du nombre de frais forfaits effectuée avec succès");
			logTrace.info("Incrémentation du compteur");
			
			while(result.next())
				nbFraisForfaits = result.getInt("nbFraisForfait");
			
			logTrace.info("Nombre de frais forfaits récupérés : " + nbFraisForfaits);
			logTrace.info("Retour de la liste de frais forfait");
			
		} catch(SQLException e) {
			logTrace.severe("Erreur SQL : " + e.getMessage());
		} catch(Exception e) {
			logTrace.severe("Erreur lors du traitement des données : " + e);
		} finally {
			connexion.closeConnection();
		}
		
		return nbFraisForfaits;
		
	}
	
	/**
	 * Récupération du nombre de frais forfaits en attente
	 * 
	 * @return int
	 */
	public static int getNbFraisForfaitAttente() {
		logTrace.setLevel(Level.INFO);
		logTrace.info("getNbFraisForfaitAttente()");
		logTrace.info("Récupération du nombre de frais forfaits en attente de validation");
		
		int nbFraisForfaitAttente = 0;
		
		try {
			//-- Récupération de la connexion
			Connection connect = null;
			try {
				connect = connexion.getConnection();
			} catch(Exception e) {
				logTrace.severe("Erreur lors de la connexion à la BDD");
			}
			
			//-- Transactions

			PreparedStatement statement = connect.prepareStatement("SELECT COUNT(*) AS nbFraisForfaitAttente "
					+ "FROM LigneFraisForfait l, FicheFrais f "
					+ "WHERE l.mois = f.mois "
					+ "AND f.idEtat = ?");
			statement.setString(1, "CL");
			ResultSet result = statement.executeQuery();
			
			logTrace.info("Récupération du nombre de frais forfaits effectuée avec succès");
			logTrace.info("Incrémentation du compteur");
			
			while(result.next())
				nbFraisForfaitAttente = result.getInt("nbFraisForfaitAttente");
			
			logTrace.info("Nombre de frais forfaits en attente récupérés : " + nbFraisForfaitAttente);
			logTrace.info("Retour du nombre de frais forfait en attente");
			
		} catch(SQLException e) {
			logTrace.severe("Erreur SQL : " + e.getMessage());
		} catch(Exception e) {
			logTrace.severe("Erreur lors du traitement des données : " + e);
		} finally {
			connexion.closeConnection();
		}
		return nbFraisForfaitAttente;
	}
	
	/**
	 * Récupération des frais forfait en attente
	 * Retourne une liste contenant l'ensemble des listes d'objets (lignes)
	 * 
	 * @return ArrayList<ArrayList<Object>>
	 */
	public static ArrayList<ArrayList<Object>> getFraisForfaitAttente() {
		logTrace.setLevel(Level.INFO);
		logTrace.info("getFraisForfaitAttente()");
		logTrace.info("Récupération des frais forfait en attente de validation");
		
		ArrayList<ArrayList<Object>> listeComplete = new ArrayList<ArrayList<Object>>();
		int compteurLignes = 0;
		
		try {
			//-- Récupération de la connexion
			Connection connect = null;
			try {
				connect = connexion.getConnection();
			} catch(Exception e) {
				logTrace.severe("Erreur lors de la connexion à la BDD");
			}
			
			//-- Transactions

			PreparedStatement statement = connect.prepareStatement("SELECT v.id, v.nom, v.prenom, e.libelle, frais.libelle, frais.montant, l.quantite "
					+ "FROM Visiteur v, Etat e, FraisForfait frais, LigneFraisForfait l, FicheFrais fiche "
					+ "WHERE v.id = l.idVisiteur "
					+ "AND frais.id = l.idFraisForfait "
					+ "AND l.mois = fiche.mois "
					+ "AND e.id = fiche.idEtat "
					+ "AND fiche.idEtat = ?");
			statement.setString(1, "CL");
			ResultSet result = statement.executeQuery();
			
			logTrace.info("Récupération des frais forfait en attente effectuée avec succès");
			logTrace.info("Création des listes");
			
			while(result.next()) {
				ArrayList<Object> ligne = new ArrayList<Object>();
				ligne.add(result.getString(1));
				ligne.add(result.getString(2));
				ligne.add(result.getString(3));
				ligne.add(result.getString(4));
				ligne.add(result.getString(5));
				ligne.add(result.getInt(6)*result.getInt(7));
				listeComplete.add(ligne);
				compteurLignes++;
			}
			
			logTrace.info("Liste de frais forfaits en attente crée");
			logTrace.info("Retour de la liste - ("+compteurLignes+" lignes)");
			
		} catch(SQLException e) {
			logTrace.severe("Erreur SQL : " + e.getMessage());
		} catch(Exception e) {
			logTrace.severe("Erreur lors du traitement des données : " + e);
		} finally {
			connexion.closeConnection();
		}
		return listeComplete;
	}
}
