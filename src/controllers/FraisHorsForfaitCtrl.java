package controllers;

import java.sql.Date;

import models.FraisHorsForfaitMdl;

/**
 * 
 * Gestion des frais hors forfait<br>
 * Les frais hors forfait sont soumis à la validation des comptables<br>
 * Leur état doit donc pouvoir changer afin de savoir si celui-ci a été validé ou invalidé
 * 
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class FraisHorsForfaitCtrl {

	//-- Attributs
	
	private int id, etat;
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
	 * 
	 * @param id int
	 * @param libelle String
	 * @param date Date
	 * @param montant double
	 * @param etat int
	 */
	public FraisHorsForfaitCtrl(int id, String libelle, Date date, double montant, int etat) {
		this.id = id;
		this.libelle = libelle;
		this.date = date;
		this.montant = montant;
		this.etat = etat;
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
	 * Modification de l'id de la fiche hors forfait
	 * 
	 * @param id int
	 */
	public void setId(int id) {
		this.id = id;
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
	 * Modification du libelle de la fiche hors forfait
	 * 
	 * @param libelle String
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
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
	 * Modification de la date de la fiche hors forfait
	 * 
	 * @param date Date
	 */
	public void setDate(Date date) {
		this.date = date;
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
	 * Modification du montant de la fiche hors forfait
	 * 
	 * @param montant double
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	/**
	 * Retourne l'état de la fiche hors forfait
	 * <ul>
	 * <li>NULL | 0 = refusée</li>
	 * <li>1 = validée</li>
	 * </ul>
	 * 
	 * @return int
	 */
	public int getEtat() {
		return this.etat;
	}
	
	/**
	 * Modification de l'état de la fiche hors forfait<br>
	 * Par souci d'intégrité, la modification est également effectuée en base de données<br>
	 * <ul>
	 * <li>NULL | 0 = refusée</li>
	 * <li>1 = validée</li>
	 * </ul>
	 * 
	 * @param etat int
	 */
	public void setEtat(int etat) {
		FraisHorsForfaitMdl.modifierEtat(this.id, etat);
		this.etat = etat;
	}
}
