package controllers;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * ----------------------------------------------------
 * Gestion du Répertoire
 * Contient toutes les fiches de frais d'un visiteur
 * ----------------------------------------------------
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class RepertoireCtrl {
	
	//-- Attributs
	private VisiteurCtrl visiteur;
	private ArrayList<FicheFraisCtrl> listeFichesFrais;
	
	//-- Constructeurs
	
	/**
	 * Constructeur RepertoireCtrl 
	 * Instanciation et completion automatique de l'ArrayList
	 * 
	 * @param visiteur VisiteurCtrl
	 */
	public RepertoireCtrl(VisiteurCtrl visiteur) {
		this.visiteur = visiteur;
		
	}
	
	//-- Accesseurs | Modificateurs
	
	/**
	 * Accesseur Visiteur
	 * 
	 * @return VisiteurCtrl
	 */
	public VisiteurCtrl getVisiteur() {
		return this.visiteur;
	}
	
	/**
	 * Modificateur Visiteur
	 * 
	 * @param visiteur VisiteurCtrl
	 */
	public void setVisiteur(VisiteurCtrl visiteur) {
		this.visiteur = visiteur;
	}
	
	/**
	 * Accesseur listeFichesFrais
	 * 
	 * @return ArrayList<FicheFraisCtrl>
	 */
	public ArrayList<FicheFraisCtrl> getListeFichesFrais() {
		return this.listeFichesFrais;
	}
	
	/**
	 * Modificateur listeFichesFrais
	 * 
	 * @param ArrayList<FicheFraisCtrl>
	 */
	public void setListeFichesFrais(ArrayList<FicheFraisCtrl> listeFichesFrais) {
		this.listeFichesFrais = listeFichesFrais;
	}
	
	//-- Méthodes
	/**
	 * Récupération de l'ensemble des fiches de frais en attente du visiteur
	 * 
	 * @return ArrayList<FicheFraisCtrl>
	 */
	private ArrayList<FicheFraisCtrl> getFraisAttente() {
		ArrayList<FicheFraisCtrl> listeRetour = new ArrayList<FicheFraisCtrl>();
		
		for(FicheFraisCtrl ficheFrais : this.listeFichesFrais) {
			if(ficheFrais.getIdEtat().equalsIgnoreCase("CL"))
				listeRetour.add(ficheFrais);
		}
		
		return listeRetour;
	}
}
