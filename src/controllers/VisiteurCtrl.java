package controllers;

import java.sql.*;

/**
 * ---------------------------------
 * Gestion des visiteurs médicaux
 * ---------------------------------
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class VisiteurCtrl {

	//-- Attributs
	
	private String id, nom, prenom, adresse, cp, ville;
	private String logTrace = this.getClass().getSimpleName();
	private Date dateEmbauche;
	
	//-- Constructeurs
	
	/**
	 * Constructeur VisiteurCtrl sans paramètres
	 */
	public VisiteurCtrl() {
		
	}
	
	/**
	 * Constructeur VisiteurCtrl avec paramètres 
	 * 
	 * @param id String
	 * @param nom String
	 * @param prenom String
	 * @param adresse String
	 * @param cp String
	 * @param ville String
	 * @param dateEmbauche Date
	 */
	public VisiteurCtrl(String id, String nom, String prenom, String adresse, String cp, String ville, Date dateEmbauche) {
		this.setId(id);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setAdresse(adresse);
		this.setCp(cp);
		this.setVille(ville);
		this.setDateEmbauche(dateEmbauche);
	}

	//-- Accesseurs | Modificateurs
	
	/**
	 * Accesseur id
	 * 
	 * @return String
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Modificateur id
	 * 
	 * @param id String
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Accesseur nom
	 * 
	 * @return String
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Modificateur nom
	 * 
	 * @param nom String
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Accesseur prenom
	 * 
	 * @return String
	 */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * Modificateur prenom
	 * 
	 * @param prenom String
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Accesseur adresse
	 * 
	 * @return String
	 */
	public String getAdresse() {
		return this.adresse;
	}

	/**
	 * Modificateur adresse
	 * 
	 * @param adresse String
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * Accesseur cp
	 * 
	 * @return String
	 */
	public String getCp() {
		return this.cp;
	}

	/**
	 * Modificateur cp
	 * 
	 * @param cp String
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}

	/**
	 * Accesseur ville
	 * 
	 * @return String
	 */
	public String getVille() {
		return this.ville;
	}

	/**
	 * Modificateur ville
	 * 
	 * @param ville String
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Accesseur dateEmbauche
	 * 
	 * @return Date
	 */
	public Date getDateEmbauche() {
		return this.dateEmbauche;
	}

	/**
	 * Modificateur dateEmbauche
	 * 
	 * @param dateEmbauche Date
	 */
	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	

}
