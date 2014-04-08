package controllers;

import java.sql.*;
import java.util.ArrayList;

import models.FicheFraisMdl;
import models.FraisForfaitMdl;

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
	private Date dateEmbauche;
	private ArrayList<FicheFraisCtrl> listeFicheFrais;
	
	//-- Constructeurs
	
	/**
	 * Constructeur VisiteurCtrl sans paramètres
	 */
	public VisiteurCtrl() {
		
	}
	
	/**
	 * Constructeur VisiteurCtrl simplifié <br>
	 * 
	 * @param id String
	 * @param nom String
	 * @param prenom String
	 */
	public VisiteurCtrl(String id, String nom, String prenom) {
		this.setId(id);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.listeFicheFrais = new ArrayList<FicheFraisCtrl>();
	}
	
	/**
	 * Constructeur VisiteurCtrl complet <br>
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
		this.listeFicheFrais = new ArrayList<FicheFraisCtrl>();
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
	
	/**
	 * Accesseur listeFicheFrais
	 * 
	 * @return ArrayList<FicheFraisCtrl>
	 */
	public ArrayList<FicheFraisCtrl> getListeFicheFrais() {
		return this.listeFicheFrais;
	}
	
	/**
	 * Modificateur listeFicheFrais
	 * 
	 * @param listeFicheFrais ArrayList<FicheFraisCtrl>
	 */
	public void setListeFicheFrais(ArrayList<FicheFraisCtrl> listeFicheFrais) {
		this.listeFicheFrais = listeFicheFrais;
	}
	
	//-- Méthodes
	
	/**
	 * Chargement de l'ensemble des fiches de frais du visiteur
	 * 
	 * @return ArrayList<FicheFraisCtrl>
	 */
	public ArrayList<FicheFraisCtrl> loadFichesFrais() {
		return FicheFraisMdl.getFichesFrais(this.id);
	}
	
	/**
	 * Récupération de toutes les fiches de frais dont l'état est celui spécifié en paramètre
	 * <p>
	 * Rappel :
	 * <ul>
	 * <li>CL = Saisie clôturée</li>
	 * <li>CR = Fiche créee, saisie en cours</li>
	 * <li>RB = Remboursée</li>
	 * <li>VA = Validée et mise en paiement</li>
	 * </ul>
	 * </p>
	 * 
	 * @param etat String
	 * @return ArrayList<FicheFraisCtrl>
	 */
	public ArrayList<FicheFraisCtrl> getFichesFraisEtat(String etat) {
		
		ArrayList<FicheFraisCtrl> listeRetour = new ArrayList<FicheFraisCtrl>();
		
		for(FicheFraisCtrl ficheFrais : this.getListeFicheFrais())
			if(ficheFrais.getIdEtat().equalsIgnoreCase(etat))
				listeRetour.add(ficheFrais);
		
		return listeRetour;
	}
	
	/**
	 * Méthode d'affichage toString <br>
	 * Retourne un visiteur simplifié
	 * 
	 * @return String
	 */
	public String toString() {
		return this.getNom() + " " + this.getPrenom();
	}

}
