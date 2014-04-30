package views;

import javax.swing.*;

import overrides.*;
import controllers.*;
import models.*;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Vue de Connexion
 * Gestion de la connexion
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class OverviewFrais extends JPanel implements ActionListener, MouseListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4276243847095381073L;
	//-- Attributs
	private JButton validerChoixBut, retourBut, deconnexionBut;
	private JLabel comptableLabel, dateLabel, categorieLabel;
	
	private JComboBox<String> choixEtatCombo;
	private JComboBox<VisiteurCtrl> choixVisiteurCombo;
	
	private TableModel tableTableModel;
	private JTable tableau;
	
	private ArrayList<VisiteurCtrl> listeVisiteurs;
	
	private Fenetre fenetre;
	private ComptableCtrl comptable;
	
	//-- Constructeurs
	public OverviewFrais(Fenetre fenetre, ComptableCtrl comptable) {
		this.fenetre = fenetre;
		this.comptable = comptable;
	}
	public JPanel launchPanel() {
		
		//-- Définition du JPanel
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		mainPanel.setBackground(new Color(141,182,205));
		
		//-- Instanciation de la liste de visiteurs et des listes de fiches de frais
		this.listeVisiteurs = VisiteurMdl.getAllVisitors();
		for(VisiteurCtrl visiteur : this.listeVisiteurs)
			visiteur.loadFichesFrais();
		
		//-- Instanciation des attributs
		this.validerChoixBut = new JButton("Valider");
		
		this.retourBut = new JButton("Retour");
		
		this.deconnexionBut = new JButton("Déconnexion");
		this.deconnexionBut.setBackground(new Color(255,0,0));
		this.deconnexionBut.setFont(new Font("Arial", Font.BOLD, 15));
		this.deconnexionBut.setForeground(new Color(255,255,255));
		
		this.comptableLabel = new JLabel(this.comptable.getPrenom()+" "+this.comptable.getNom());
		this.comptableLabel.setFont(new Font("Arial", Font.BOLD, 15));
		this.comptableLabel.setForeground(new Color(255,255,255));
		
		this.dateLabel = new JLabel(new SimpleDateFormat("dd MMMM yyyy", Locale.FRANCE).format(new Date()));
		this.dateLabel.setFont(new Font("Arial", Font.BOLD, 15));
		this.dateLabel.setForeground(new Color(255,255,255));
		
		this.categorieLabel = new JLabel("Gestion des frais pour les visiteurs médicaux");
		this.categorieLabel.setFont(new Font("Arial", Font.BOLD, 15));
		this.categorieLabel.setForeground(new Color(255,255,255));
		
		this.choixEtatCombo = new JComboBox<String>();
		this.choixEtatCombo.addItem("Tous les états");
		this.choixEtatCombo.addItem("Saisie clôturée");
		this.choixEtatCombo.addItem("Fiche créée, saisie en cours");
		this.choixEtatCombo.addItem("Remboursée");
		this.choixEtatCombo.addItem("Validée et mise en paiement");
		
		this.choixVisiteurCombo = new JComboBox<VisiteurCtrl>();
		for(VisiteurCtrl visiteur : this.listeVisiteurs)
			this.choixVisiteurCombo.addItem(visiteur);
		
		//-- Ajout à l'ActionListener
		this.choixEtatCombo.addActionListener(this);
		this.choixVisiteurCombo.addActionListener(this);
		this.validerChoixBut.addActionListener(this);
		this.retourBut.addActionListener(this);
		this.deconnexionBut.addActionListener(this);
		
		//-- Création du tableau
		this.tableTableModel = new TableModel(this.listeVisiteurs.get(0), "CL");
		
		this.tableau = new JTable(tableTableModel);
		this.tableau.setPreferredScrollableViewportSize(new Dimension(700, 300));
		this.tableau.setFillsViewportHeight(true);
		this.tableau.setRowSelectionAllowed(true);
		this.tableau.setColumnSelectionAllowed(false);
		this.tableau.setAutoCreateRowSorter(true);
		this.tableau.addMouseListener(this);
		
	    //-- Mise en forme
	    GridBagConstraints gbc = new GridBagConstraints();
	    
        gbc.weightx = 1;
        gbc.weighty = 1;
        
		// Comptable (label)
		gbc.gridx = gbc.gridy = 0;
		gbc.gridheight = gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 10, 0, 10);
		mainPanel.add(this.comptableLabel, gbc);
		
		// Date (label)
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 10, 0, 10);
		mainPanel.add(this.dateLabel, gbc);
		
		// Déconnexion (Button)
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 10, 0, 0);
		mainPanel.add(this.deconnexionBut, gbc);
		
        gbc.weightx = 0;
        gbc.weighty = 0;
	
		// Categorie (label)
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.CENTER;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(5, 10, 0, 10);
		mainPanel.add(this.categorieLabel, gbc);
		
        gbc.weightx = 1;
        gbc.weighty = 1;
        
		// Choix Visiteur (Combo)
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 0, 10);
		mainPanel.add(this.choixVisiteurCombo, gbc);
		
		// Choix Etat (Combo)
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 0, 10);
		mainPanel.add(this.choixEtatCombo, gbc);
		
		// Valider choix (Button)
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 0, 10);
		mainPanel.add(this.validerChoixBut, gbc);
        
        // Tableau
		gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 10, 0, 10);
        mainPanel.add(new JScrollPane(this.tableau), gbc);
        
        // Retour (Button)
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(0, 10, 0, 10);
		mainPanel.add(this.retourBut, gbc);
		
        return mainPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		Object evt = event.getSource();
		if(evt.equals(this.validerChoixBut)) {
			String etat;
			switch(this.choixEtatCombo.getSelectedItem().toString()) {
				case "Tous les états" : etat = "TS"; break;
				case "Saisie clôturée" : etat = "CL"; break;
				case "Fiche créée, saisie en cours" : etat = "CR"; break;
				case "Remboursée" : etat = "RB"; break;
				case "Validée et mise en paiement" : etat = "VA"; break;
				default : etat = "CL"; break;
			}
			this.tableTableModel.setListeFicheFrais((VisiteurCtrl)this.choixVisiteurCombo.getSelectedItem(),etat);
			this.tableau.setAutoCreateRowSorter(false);
			this.tableau.invalidate();
			this.tableau.revalidate();
			this.tableau.clearSelection();
			this.tableau.setAutoCreateRowSorter(true);
			this.tableau.repaint();
		}
		if(evt.equals(this.retourBut))
			this.fenetre.setActivePanel(new Accueil(this.fenetre, this.comptable).launchPanel());
		if(evt.equals(this.deconnexionBut))
			this.fenetre.setActivePanel(new Connexion(this.fenetre).launchPanel());
	}
	
	@Override
	public void mouseClicked(MouseEvent evt) {

		if (evt.getClickCount() == 2) {			
			Point p = evt.getPoint();
			
			int row = this.tableau.rowAtPoint(p);
			int column = this.tableau.convertColumnIndexToModel(this.tableau.columnAtPoint(p));
			if (row >= 0 && column >= 0)
				this.fenetre.setActivePanel(new DetailFrais(this.fenetre, this.comptable,this.tableTableModel.getFicheFrais((String)this.tableau.getValueAt(row, 1)),this.tableTableModel.getVisiteurActif()).launchPanel());
		}
	}
		
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
}
