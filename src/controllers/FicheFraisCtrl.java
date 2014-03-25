package controllers;

import java.sql.*;
import java.util.ArrayList;

/**
 * ---------------------------------
 * Gestion des fiches de frais
 * ---------------------------------
 * 
 * @author Chafik DAGGAG - SIO2
 * @package controllers
 * @version 1.0.0
 *
 */
public class FicheFraisCtrl {

	//-- Attributs
	
		private String idEtat, mois;
		private Date dateModif;
		private int nbJustificatifs;
		private double montantValide;
		
		//-- Constructeurs
		
		/**
		 * Constructeur FicheFraisCtrl sans paramètres
		 */
		public FicheFraisCtrl() {
			
		}
		
		/**
		 * Constructeur FicheFraisCtrl avec paramètres 
		 * 
		 * @param String idEtat, mois
		 * @param Date dateModif
		 * @param int nbJustificatifs
		 * @param double montantValide
		 * @param 
		 */
		public FicheFraisCtrl(String idEtat, String mois, Date dateModif, int nbJustificatifs, double montantValide) {
			this.setIdEtat(idEtat);
			this.setDateModif(dateModif);
			this.setNbJustificatifs(nbJustificatifs);
			this.setMontantValide(montantValide);
		}

		//-- Accesseurs | Modificateurs
		
		/**
		 * Accesseur Mois
		 * 
		 * retourne le mois de la fiche de frais
		 * 
		 * @return String
		 * 
		 */
		public String getMois(){
			return this.mois;
		}
		
		/**
		 * Accesseur NbJustificatif
		 * 
		 * retourne le nombre de justificatif de la fiche de frais
		 * 
		 * @return int
		 * 
		 */
		public int getNbJustificatif() {
			return this.nbJustificatifs;
		}
		
		/**
		 * Accesseur MontantValide
		 * 
		 * retourne le montant final de la fiche de frais
		 * 
		 * @return double
		 * 
		 */
		public double getMontantValide() {
			return montantValide;
		}
		
		/**
		 * Modificateur NbJustificatifs avec paramètres
		 * 
		 * Modification du nombre de justificatifs d'une fiche de frais
		 * 
		 * @param int nbJustificatifs
		 * 
		 */
		public void setNbJustificatifs(int nbJustificatifs) {
			
		}
		
		/**
		 * Modificateur MontantValide avec paramètres
		 * 
		 * Modification du montant final d'une fiche de frais
		 * 
		 * @param double montantValide
		 * 
		 */
		public void setMontantValide(double montantValide) {
			
		}
		
		/**
		 * Accesseur DateModif
		 * 
		 * Retourne la date de modification d'une fiche de frais
		 * 
		 * @return Date
		 * 
		 */
		public Date getDateModif() {
			return dateModif;
		}
		
		/**
		 * Modificateur DateModif avec paramètres
		 * 
		 * Modification de la date de modification de la fiche de frais
		 * 
		 * @param Date dateModif
		 * 
		 */
		public void setDateModif(Date dateModif) {
			
		}
		
		/**
		 * Accesseur IdEtat
		 * 
		 * Retourne l'identifiant de l'état de la fiche de frais
		 * 
		 * @return String
		 * 
		 */
		public String getIdEtat() {
			return this.idEtat;
		}
		
		/**
		 * Modificateur IdEtat avec paramètres
		 * 
		 * Modification de l'identifiant de l'état de la fiche de frais
		 * 
		 * @param String idEtat
		 * 
		 */
		public void setIdEtat(String idEtat) {
			
		}
		
	}
