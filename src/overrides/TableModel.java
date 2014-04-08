package overrides;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import controllers.FicheFraisCtrl;
import controllers.VisiteurCtrl;
import models.FraisForfaitMdl;

/**
 * Surcharge de la classe AbstractTableModel
 * Permet de générer le tableau d'ensemble des fiches de frais
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class TableModel extends AbstractTableModel {

	private String[] columnNames = {"Visiteur","Mois","Etat","Montant validé","Nombre de justificatifs","Gérer"};
	private ArrayList<FicheFraisCtrl> listeFicheFrais;
	private VisiteurCtrl visiteur;
	
	public TableModel() {
		this.listeFicheFrais = new ArrayList<FicheFraisCtrl>();
	}
	
	public TableModel(VisiteurCtrl visiteur, String etat) {
		this.visiteur = visiteur;
		this.listeFicheFrais = this.visiteur.getFichesFraisEtat(etat);
	}
	
	@Override
	public int getColumnCount() {
		return this.columnNames.length;
	}
	
	@Override
	public String getColumnName(int col) {
		return this.columnNames[col];
	}

	@Override
	public int getRowCount() {
		return this.listeFicheFrais.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Object result = this.listeFicheFrais.get(row);
		switch(col) {
			case 0 : 
				result = this.visiteur.getNom() + " " + this.visiteur.getPrenom();
				break;
			case 1 : 
				result = this.listeFicheFrais.get(row).getMoisFormate();
				break;
			case 2 : 
				result = FicheFraisCtrl.getLibelleIdEtat(this.listeFicheFrais.get(row).getIdEtat());
				break;
			case 3 : 
				result = this.listeFicheFrais.get(row).getMontantValide() + " €";
				break;
			case 4 :
				result = this.listeFicheFrais.get(row).getNbJustificatif();
				break;
			case 5 :
				result = " ";
				break;
		}
		return result;
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	
	public void setListeFicheFrais(VisiteurCtrl visiteur, String etat) {
		this.visiteur = visiteur;
		this.listeFicheFrais.clear();
		this.visiteur.setListeFicheFrais(this.visiteur.loadFichesFrais());
		this.listeFicheFrais = this.visiteur.getFichesFraisEtat(etat);
	}
}
