package overrides;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import models.FraisForfaitMdl;

/**
 * Surcharge de la classe AbstractTableModel
 * Permet de générer le tableau d'ensemble des frais
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class Table extends AbstractTableModel{

	private final String[] entetes = {"Visiteur","Libellé","État","Montant","Gérer"};
	private ArrayList<ArrayList<Object>> listeLignes;
	
	public Table() {
		this.listeLignes = FraisForfaitMdl.getFraisForfaitAttente();
	}
	
	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public int getRowCount() {
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
		case 0:
			return listeLignes.get(rowIndex);
		case 1:
			return listeLignes.get(rowIndex);
		case 2:
			return listeLignes.get(rowIndex);
		default:
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

}
