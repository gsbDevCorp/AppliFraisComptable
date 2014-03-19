package controllers;

import java.sql.Date;

/**
 * ---------------------------------
 * Gestion des frais hors forfait
 * ---------------------------------
 * 
 * @author Robin BILLY - SIO2
 * @author Chafik DAGGAG - SIO2
 * @package controllers
 * @version 1.0.0
 *
 */
public class FraisHorsForfaitCtrl {

	//-- Attributs
	
	private int id;
	private String libelle;
	private Date date;
	private double montant;
	
	//-- Constructeurs
	
	/**
	 * Constructeur de la classe FicheHorsForfait sans paramètres
	 */
	public FraisHorsForfaitCtrl() {
		
	}
	
	/**
	 * Constructeur de la classe FicheHorsForfait avec paramètres
	 */
	public FraisHorsForfaitCtrl(int id, String libelle, Date date, double montant) {
		this.setId(id);
		this.setLibelle(libelle);
		this.setDate(date);
		this.setMontant(montant);
	}
	
	//-- Accesseurs | Modificateurs
	
	/**
	 * Retourne l'id de la fiche hors forfait
	 * 
	 * @return int
	 */
	public int getId() {
		return this.id;
	}
	/**
	 * Retourne le libelle de la fiche hors forfait
	 * 
	 * @return String
	 */
	public String getLibelle() {
		return this.libelle;
	}
	/**
	 * Retourne la date de la fiche hors forfait
	 * 
	 * @return Date
	 */
	public Date getDate() {
		return this.date;
	}
	/**
	 * Retourne le montant de la fiche hors forfait
	 * 
	 * @return double
	 */
	public double getMontant() {
		return this.montant;
	}
	/**
	 * Modification de l'id de la fiche hors forfait
	 * 
	 * @param int
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Modification du libelle de la fiche hors forfait
	 * 
	 * @param String
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	/**
	 * Modification de la date de la fiche hors forfait
	 * 
	 * @param Date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * Modification du montant de la fiche hors forfait
	 * 
	 * @param double
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}
}
