package controllers;

import sun.util.calendar.BaseCalendar.Date;

/**
 * ---------------------------------
 * Gestion des visiteurs médicaux
 * ---------------------------------
 * 
 * @author Robin BILLY - SIO2
 * @author Chafik DAGGAG - SIO2
 * @package controllers
 * @version 1.0.0
 *
 */
public class VisiteurCtrl {

	//-- Attributs
	
	private String id, nom, prenom, adresse, cp, ville;
	private Date dateEmbauche;
	
	//-- Constructeurs
	
	public VisiteurCtrl() {
		
	}
	
	public VisiteurCtrl(String id, String nom, String prenom, String adresse, String cp, String ville, Date dateEmbauche) {
		
	}

	//-- Accesseurs | Modificateurs
	
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCp() {
		return this.cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Date getDateEmbauche() {
		return this.dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	

}