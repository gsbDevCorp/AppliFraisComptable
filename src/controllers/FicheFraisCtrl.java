package controllers;

import java.sql.*;
import java.util.ArrayList;

import models.FraisForfaitMdl;
import models.FraisHorsForfaitMdl;

/**
 * ---------------------------------
 * Gestion des fiches de frais
 * ---------------------------------
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class FicheFraisCtrl {

	//-- Attributs
	
		private String idVisiteur, idEtat, mois;
		private Date dateModif;
		private int nbJustificatifs;
		private double montantValide;
		private ArrayList<FraisForfaitCtrl> listeFraisForfait;
		private ArrayList<FraisHorsForfaitCtrl> listeFraisHorsForfait;
		
		//-- Constructeurs
		
		/**
		 * Constructeur FicheFraisCtrl sans paramètres
		 */
		public FicheFraisCtrl() {
			
		}
		
		/**
		 * Constructeur FicheFraisCtrl avec paramètres 
		 * Charge automatiquement les lignes de frais forfait
		 * Charge automatiquement les lignes de frais hors forfait
		 * 
		 * @param idVisiteur String
		 * @param idEtat String
		 * @param mois String
		 * @param dateModif Date
		 * @param nbJustificatifs int
		 * @param montantValide double
		 */
		public FicheFraisCtrl(String idVisiteur, String idEtat, String mois, Date dateModif, int nbJustificatifs, double montantValide) {
			this.setIdVisiteur(idVisiteur);
			this.setIdEtat(idEtat);
			this.setMois(mois);
			this.setDateModif(dateModif);
			this.setNbJustificatifs(nbJustificatifs);
			this.setMontantValide(montantValide);
			this.listeFraisForfait = new ArrayList<FraisForfaitCtrl>();
			this.listeFraisHorsForfait = new ArrayList<FraisHorsForfaitCtrl>();
		}

		//-- Accesseurs | Modificateurs
		
		/**
		 * Retourne l'identifiant du visiteur
		 * 
		 * @return String
		 */
		public String getIdVisiteur(){
			return this.idVisiteur;
		}
		
		/**
		 * Retourne le nbJustificatif
		 * 
		 * @return int
		 */
		public int getNbJustificatif() {
			return this.nbJustificatifs;
		}
		
		/**
		 * Retourne le montantValide
		 * 
		 * @return double
		 */
		public double getMontantValide() {
			return montantValide;
		}
		
		/**
		 * Retourne la dateModif
		 * 
		 * @return Date
		 */
		public Date getDateModif() {
			return dateModif;
		}
		
		/**
		 * Retourne idEtat
		 * 
		 * @return String
		 */
		public String getIdEtat() {
			return this.idEtat;
		}
		
		/**
		 * Retourne le mois
		 * 
		 * @return String
		 */
		public String getMois() {
			return this.mois;
		}
		
		/**
		 * Retourne la liste de frais forfaits
		 * 
		 * @return ArrayList<FraisForfaitCtrl>
		 */
		public ArrayList<FraisForfaitCtrl> getListeFraisForfait() {
			return this.listeFraisForfait;
		}
		
		/**
		 * Retourne la liste de frais hors forfaits
		 * 
		 * @return ArrayList<FraisHorsForfaitCtrl>
		 */
		public ArrayList<FraisHorsForfaitCtrl> getListeFraisHorsForfait() {
			return this.listeFraisHorsForfait;
		}
		
		/**
		 * Modification de l'id du visiteur
		 * 
		 * @param idVisiteur String
		 * 
		 */
		public void setIdVisiteur(String idVisiteur) {
			this.idVisiteur = idVisiteur;
		}
		
		/**
		 * Modification du nombre de justificatifs
		 * 
		 * @param nbJustificatifs int
		 * 
		 */
		public void setNbJustificatifs(int nbJustificatifs) {
			this.nbJustificatifs = nbJustificatifs;
		}
		
		/**
		 * Modification du MontantValide
		 * 
		 * @param montantValide double
		 */
		public void setMontantValide(double montantValide) {
			this.montantValide = montantValide;
		}
		
		/**
		 * Modification de dateModif
		 * 
		 * @param dateModif Date
		 */
		public void setDateModif(Date dateModif) {
			this.dateModif = dateModif;
		}
		
		/**
		 * Modification de idEtat
		 * 
		 * @param idEtat String
		 */
		public void setIdEtat(String idEtat) {
			this.idEtat = idEtat;
		}
		
		/**
		 * Modification du mois
		 * 
		 * @param mois String
		 */
		public void setMois(String mois) {
			this.mois = mois;
		}
		
		/**
		 * Modification de la liste de frais forfait
		 * 
		 * @param listeFraisForfait ArrayList<FraisForfaitCtrl>
		 */
		public void setListeFraisForfait(ArrayList<FraisForfaitCtrl> listeFraisForfait) {
			this.listeFraisForfait = listeFraisForfait;
		}
		
		/**
		 * Modification de la liste de frais hors forfait
		 * 
		 * @param listeFraisForfait ArrayList<FraisHorsForfaitCtrl>
		 */
		public void setListeFraisHorsForfait(ArrayList<FraisHorsForfaitCtrl> listeFraisHorsForfait) {
			this.listeFraisHorsForfait = listeFraisHorsForfait;
		}
		
		//-- Méthodes
		
		/**
		 * Chargement de la liste des frais forfaits
		 * 
		 * @return ArrayList<FraisForfaitCtrl>
		 */
		public ArrayList<FraisForfaitCtrl> loadListeFraisForfaits() {
			return FraisForfaitMdl.getFraisForfait(this.idVisiteur);
		}
		
		/**
		 * Chargement de la liste des frais hors forfaits
		 * 
		 * @return ArrayList<FraisHorsForfaitCtrl>
		 */
		public ArrayList<FraisHorsForfaitCtrl> loadListeFraisHorsForfaits() {
			
			ArrayList<FraisHorsForfaitCtrl> listeRetour = new ArrayList<FraisHorsForfaitCtrl>();
			listeRetour = FraisHorsForfaitMdl.getFraisHorsForfait(this.idVisiteur);
			
			return listeRetour;
		}
		
		/**
		 * Retourne le mois formaté du format<br>
		 * <code>aaaamm</code> au format </code>aaaa - mm</code>
		 * 
		 * @return String
		 */
		public String getMoisFormate() {
			return this.mois.substring(0, 4) + " - " + this.mois.substring(4,6);
		}
		
		/**
		 * Méthode permettant de récupérer le libellé associé à l'identifiant d'etat (idEtat).
		 * Méthode statique
		 * 
		 * @param idEtat String
		 * @return String
		 */
		public static String getLibelleIdEtat(String idEtat) {
			String libelleEtat;
			switch(idEtat) {
				case "CL" : libelleEtat = "Saisie clôturée"; break;
				case "CR" : libelleEtat = "Fiche créée, saisie en cours"; break;
				case "RB" : libelleEtat = "Remboursée"; break;
				case "VA" : libelleEtat = "Validée et mise en paiement"; break;
				default : libelleEtat = "CL"; break;
			}
			return libelleEtat;
		}
		
	}
