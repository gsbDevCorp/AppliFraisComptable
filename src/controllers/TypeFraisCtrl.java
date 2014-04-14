package controllers;

/**
 * Définition des types de frais pouvant exister<br>
 * Les types de frais sont appliqués aux frais forfait
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class TypeFraisCtrl {
	
	//-- Attributs
	private String id, libelle;
	private double montant;
	
	//-- Constructeurs
	
	/**
	 * Constructeur par défaut
	 */
	public TypeFraisCtrl() {	
	}
	
	/**
	 * Constructeur avec paramètres
	 * 
	 * @param id String
	 * @param libelle String
	 * @param montant double
	 */
	public TypeFraisCtrl(String id, String libelle, double montant) {
		this.id = id;
		this.libelle = libelle;
		this.montant = montant;
	}
	
	//-- Accesseurs | Modificateurs
	
	/**
	 * Renvoie l'identifiant du type de frais
	 * 
	 * @return String
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * Modifie l'identifiant du type de frais
	 * 
	 * @param id String
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Renvoie le libellé du type de frais
	 * 
	 * @return String
	 */
	public String getLibelle() {
		return this.libelle;
	}
	
	/**
	 * Modifie le libelle du type de frais
	 * 
	 * @param libelle String
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	/**
	 * Retourne le montant du type de frais
	 * 
	 * @return double
	 */
	public double getMontant() {
		return this.montant;
	}
	
	/**
	 * Modifie le montant du type de frais
	 * 
	 * @param montant double
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}
}
