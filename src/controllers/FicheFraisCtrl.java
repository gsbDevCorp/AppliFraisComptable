package controllers;

import java.sql.*;
import java.util.ArrayList;

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
	
		private String idEtat, mois;
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
		 * @param idEtat String
		 * @param mois String
		 * @param dateModif Date
		 * @param nbJustificatifs int
		 * @param montantValide double
		 */
		public FicheFraisCtrl(String idEtat, String mois, Date dateModif, int nbJustificatifs, double montantValide) {
			this.setIdEtat(idEtat);
			this.setDateModif(dateModif);
			this.setNbJustificatifs(nbJustificatifs);
			this.setMontantValide(montantValide);
		}

		//-- Accesseurs | Modificateurs
		
		/**
		 * Retourne le mois
		 * 
		 * @return String
		 */
		public String getMois(){
			return this.mois;
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
		 * Modification de la liste de frais forfait
		 * 
		 * @param listeFraisForfait ArrayList<FraisForfaitCtrl>
		 */
		public void setListeFraisForfait(ArrayList<FraisForfaitCtrl> listeFraisForfait) {
			this.listeFraisForfait = listeFraisForfait;
		}
		//-- Méthodes
		
	}
