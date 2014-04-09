package controllers;

import java.sql.*;
import java.util.ArrayList;

import models.FraisForfaitMdl;

/**
 * ---------------------------------
 * Gestion des frais forfait
 * ---------------------------------
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class FraisForfaitCtrl {

	//-- Attributs
	private TypeFraisCtrl typeFrais;
	private int quantite;
	
	//-- Constructeurs
	
	/**
	 * Constructeur FraisForfaitCtrl par défaut
	 */
	public FraisForfaitCtrl() {

	}
	
	/**
	 * Constructeur FraisForfaitCtrl avec paramètres
	 * 
	 * @param typeFrais TypeFraisCtrl
	 * @param quantite int
	 */
	public FraisForfaitCtrl(TypeFraisCtrl typeFrais, int quantite) {
		this.setQuantite(quantite);
		this.setTypeFrais(typeFrais);
	}
	
	//-- Accesseurs | Modificateurs
	
	/**
	 * Retourne la quantité du frais forfait
	 * 
	 * @return int
	 */
	public int getQuantite() {
		return quantite;
	}
	
	/**
	 * Modifie la quantité du frais forfait
	 * 
	 * @param quantite int
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	/**
	 * Retourne le type de frais
	 * 
	 * @return TypeFraisCtrl
	 */
	
	public TypeFraisCtrl getTypeFrais() {
		return this.typeFrais;
	}
	
	/**
	 * Modifie le type de frais
	 * 
	 * @param typeFrais TypeFraisCtrl
	 */
	public void setTypeFrais(TypeFraisCtrl typeFrais) {
		this.typeFrais = typeFrais;
	}
}
