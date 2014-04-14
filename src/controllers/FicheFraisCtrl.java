package controllers;

import java.sql.Date;
import java.util.ArrayList;

import models.FicheFraisMdl;
import models.FraisForfaitMdl;
import models.FraisHorsForfaitMdl;

/**
 * 
 * Gestion des fiches de frais<br>
 * Les fiches de frais sont composées d'une liste de frais forfait
 * et d'une liste de frais hors forfait.
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
		 * 
		 * @param idVisiteur String
		 * @param idEtat String
		 * @param mois String
		 * @param dateModif Date
		 * @param nbJustificatifs int
		 * @param montantValide double
		 */
		public FicheFraisCtrl(String idVisiteur, String idEtat, String mois, Date dateModif, int nbJustificatifs, double montantValide) {
			this.idVisiteur = idVisiteur;
			this.idEtat = idEtat;
			this.mois = mois;
			this.dateModif = dateModif;
			this.nbJustificatifs = nbJustificatifs;
			this.montantValide = montantValide;
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
		 * Modification de l'id du visiteur
		 * 
		 * @param idVisiteur String
		 * 
		 */
		public void setIdVisiteur(String idVisiteur) {
			this.idVisiteur = idVisiteur;
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
		 * Modification du nombre de justificatifs
		 * 
		 * @param nbJustificatifs int
		 * 
		 */
		public void setNbJustificatifs(int nbJustificatifs) {
			this.nbJustificatifs = nbJustificatifs;
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
		 * Modification du MontantValide
		 * 
		 * @param montantValide double
		 */
		public void setMontantValide(double montantValide) {
			this.montantValide = montantValide;
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
		 * Modification de dateModif
		 * 
		 * @param dateModif Date
		 */
		public void setDateModif(Date dateModif) {
			this.dateModif = dateModif;
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
		 * Modification de idEtat
		 * 
		 * @param idEtat String
		 */
		public void setIdEtat(String idEtat) {
			this.idEtat = idEtat;
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
		 * Modification du mois
		 * 
		 * @param mois String
		 */
		public void setMois(String mois) {
			this.mois = mois;
		}
		
		/**
		 * Retourne la liste de frais forfait
		 * 
		 * @return ArrayList<FraisForfaitCtrl>
		 */
		public ArrayList<FraisForfaitCtrl> getListeFraisForfait() {
			return this.listeFraisForfait;
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
		 * Retourne la liste de frais hors forfait
		 * 
		 * @return ArrayList<FraisHorsForfaitCtrl>
		 */
		public ArrayList<FraisHorsForfaitCtrl> getListeFraisHorsForfait() {
			return this.listeFraisHorsForfait;
		}
		
		/**
		 * Modification de la liste de frais hors forfait
		 * 
		 * @param listeFraisHorsForfait ArrayList<FraisHorsForfaitCtrl>
		 */
		public void setListeFraisHorsForfait(ArrayList<FraisHorsForfaitCtrl> listeFraisHorsForfait) {
			this.listeFraisHorsForfait = listeFraisHorsForfait;
		}
		
		//-- Méthodes
		
		/**
		 * Chargement de la liste des frais forfait du mois
		 * 
		 */
		public void loadListeFraisForfait() {
			this.listeFraisForfait = FraisForfaitMdl.getFraisForfait(this.idVisiteur, this.getMois());
		}
		
		/**
		 * Chargement de la liste des frais hors forfait
		 * 
		 */
		public void loadListeFraisHorsForfait() {
			this.listeFraisHorsForfait = FraisHorsForfaitMdl.getFraisHorsForfait(this.idVisiteur, this.getMois());
		}
		
		/**
		 * Appel à la modification de la fiche de frais vers un nouvel etat<br>
		 * Les traitements sont effectués sur le modèle.<br>
		 * Pour éviter toute erreur entre la validation et le remboursement,
		 * la modification du montant est autorisée uniquement lors de la validation de la fiche.
		 * 
		 * @param nouvelEtat String
		 */
		public void modifierEtatFiche(String nouvelEtat) {
			if(nouvelEtat.equalsIgnoreCase("VA")) {
				double montant = 0;
				for(FraisForfaitCtrl fraisForfait : this.getListeFraisForfait()) {
					montant += fraisForfait.getQuantite()*fraisForfait.getTypeFrais().getMontant();
				}
				for(FraisHorsForfaitCtrl fraisHorsForfait : this.getListeFraisHorsForfait()) {
					if(fraisHorsForfait.getEtat() == 1)
						montant += fraisHorsForfait.getMontant();
				}
				this.setMontantValide(montant);
			}
			FicheFraisMdl.modifierEtatFiche(this.idVisiteur, this.mois, nouvelEtat, this.getMontantValide());
			this.setIdEtat(nouvelEtat);
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
			/*
			 * TODO Créer un objet Etat pour éviter le code en dur
			 */
			String libelleEtat;
			switch(idEtat) {
				case "CL" : libelleEtat = "Saisie clôturée"; break;
				case "CR" : libelleEtat = "Fiche créée, saisie en cours"; break;
				case "RB" : libelleEtat = "Remboursée"; break;
				case "VA" : libelleEtat = "Validée et mise en paiement"; break;
				default : libelleEtat = "Code d'état invalide"; break;
			}
			return libelleEtat;
		}
		
	}
