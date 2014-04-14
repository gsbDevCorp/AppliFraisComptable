package controllers;

import java.util.ArrayList;

import models.FicheFraisMdl;

/**
 * 
 * Gestion des visiteurs médicaux<br>
 * Les informations sur le visiteur restent minimales :
 * les comptables ne doivent pas avoir accès à l'ensemble des données concernant les visiteurs médicaux.
 * 
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class VisiteurCtrl {

	//-- Attributs
	
	private String id, nom, prenom;
	private ArrayList<FicheFraisCtrl> listeFicheFrais;
	
	//-- Constructeurs
	
	/**
	 * Constructeur VisiteurCtrl sans paramètres
	 */
	public VisiteurCtrl() {	
	}
	
	/**
	 * Constructeur VisiteurCtrl<br>
	 * 
	 * @param id String
	 * @param nom String
	 * @param prenom String
	 */
	public VisiteurCtrl(String id, String nom, String prenom) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
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
	 * Chargement de l'ensemble des fiches de frais du visiteur depuis la base de données
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
	 * Retourne un visiteur
	 * 
	 * @return String
	 */
	public String toString() {
		return this.getNom() + " " + this.getPrenom();
	}

}
