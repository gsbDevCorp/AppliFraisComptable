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
			this.setMontantValide(montantValide);
		}

		//-- Accesseurs | Modificateurs
		
		public String getMois(){
			return this.mois;
		}
		
		public int getNbJustificatif() {
			return this.nbJustificatifs;
		}
		
		public double getMontantValide() {
			return montantValide;
		}
		
		public void setMontantValide(double montantValide) {
			
		}
		
		public Date getDateModif() {
			return dateModif;
		}
		
		public void setDateModif(Date dateModif) {
			
		}
		
		public String getIdEtat() {
			return this.idEtat;
		}
		
		public void setIdEtat(String idEtat) {
			
		}
		
	}
