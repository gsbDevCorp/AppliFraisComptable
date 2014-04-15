package controllers;

/**
 * 
 * Gestion des etats attribués aux fiches de frais
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class EtatCtrl {
	
	//-- Attributs
	private String id, libelle;
	
	//-- Constructeurs
	
	/**
	 * Constructeur par défaut
	 */
	public EtatCtrl() {
	}
	
	/**
	 * Constructeur avec paramètres
	 * 
	 * @param id String
	 * @param libelle String
	 */
	public EtatCtrl(String id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}
	
	//-- Accesseurs | Modificateurs
	
	/**
	 * Retourne l'identifiant
	 * 
	 * @return String
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Modifie l'identifiant
	 * 
	 * @param id String
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Retourne le libelle
	 * 
	 * @return String
	 */
	public String getLibelle() {
		return this.libelle;
	}

	/**
	 * Modifie le libelle
	 * 
	 * @param libelle String
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
