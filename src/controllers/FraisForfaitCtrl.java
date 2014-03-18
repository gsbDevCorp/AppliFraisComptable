package controllers;

import java.sql.*;

/**
 * ---------------------------------
 * Gestion des frais forfait
 * ---------------------------------
 * 
 * @author Robin BILLY - SIO2
 * @author Chafik DAGGAG - SIO2
 * @package controllers
 * @version 1.0.0
 *
 */
public class FraisForfaitCtrl {

	//-- Attributs
	private String idFraisForfait;
	private int quantite;
	
	//-- Constructeurs
	
	/**
	 * Constructeur FraisForfaitCtrl sans paramètres
	 */
	public FraisForfaitCtrl() {
		
	}
	
	/**
	 * Constructeur FraisForfaitCtrl avec paramètres
	 * 
	 * @param String idFraisForfait
	 * @param int quantite
	 */
	public FraisForfaitCtrl(String idFraisForfait, int quantite) {
		this.setIdFraisForfait(idFraisForfait);
		this.setQuantite(quantite);
	}
	
	//-- Accesseurs | Modificateurs
	
	/**
	 * Retourne l'identifiant du frais forfait
	 * 
	 * @return String
	 */
	public String getIdFraisForfait() {
		return idFraisForfait;
	}
	/**
	 * Retourne la quantité du frais forfait
	 * 
	 * @return int
	 */
	public int getQuantite() {
		return quantite;
	}
	/**
	 * Modifie l'identifiant du frais forfait
	 * 
	 * @param String idFraisForfait
	 */
	public void setIdFraisForfait(String idFraisForfait) {
		this.idFraisForfait = idFraisForfait;
	}
	/**
	 * Modifie la quantité du frais forfait
	 * 
	 * @param int quantite
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	//-- Méthodes
	
	
}
