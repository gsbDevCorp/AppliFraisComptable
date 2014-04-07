package views;

import javax.swing.*;
import javax.swing.border.Border;

import overrides.Table;
import controllers.ComptableCtrl;
import models.ComptableMdl;
import models.FraisForfaitMdl;
import models.FraisHorsForfaitMdl;
import models.VisiteurMdl;

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
public class OverviewFrais extends JPanel implements ActionListener {
	
	//-- Attributs
	private JButton retourBut, deconnexionBut;
	private JLabel comptableLabel, dateLabel, categorieLabel;
	private JLabel nbVisiteursLabel, fraisForfaitLabel, fraisHForfaitLabel;
	private JLabel nbVisiteursValue, fraisForfaitValue, fraisHForfaitValue;
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
		
		//-- Instanciation des attributs
		this.retourBut = new JButton("Retour");
		this.retourBut.setBackground(new Color(221,72,20));
		this.retourBut.setFont(new Font("Arial", Font.BOLD, 15));
		this.retourBut.setForeground(new Color(255,255,255));
		
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
		
		this.nbVisiteursLabel = new JLabel("Nombre de visiteurs :");
		this.nbVisiteursLabel.setFont(new Font("Arial", Font.BOLD, 15));
		this.nbVisiteursLabel.setForeground(new Color(255,255,255));
		
		this.nbVisiteursValue = new JLabel(VisiteurMdl.getNbVisitors()+"");
		this.nbVisiteursValue.setFont(new Font("Arial", Font.BOLD, 15));
		this.nbVisiteursValue.setForeground(new Color(255,255,255));
		
		this.fraisForfaitLabel = new JLabel("Fiches de frais forfait en attente :");
		this.fraisForfaitLabel.setFont(new Font("Arial", Font.BOLD, 15));
		this.fraisForfaitLabel.setForeground(new Color(255,255,255));
		
		this.fraisForfaitValue = new JLabel(FraisForfaitMdl.getNbFraisForfaitAttente() +"/"+ FraisForfaitMdl.getTotalNbFraisForfait());
		this.fraisForfaitValue.setFont(new Font("Arial", Font.BOLD, 15));
		this.fraisForfaitValue.setForeground(new Color(255,255,255));

		this.fraisHForfaitLabel = new JLabel("Fiches de frais hors forfait en attente :");
		this.fraisHForfaitLabel.setFont(new Font("Arial", Font.BOLD, 15));
		this.fraisHForfaitLabel.setForeground(new Color(255,255,255));
		
		this.fraisHForfaitValue = new JLabel(FraisHorsForfaitMdl.getNbFraisHorsForfaitAttente() +"/"+ FraisHorsForfaitMdl.getTotalNbFraisHorsForfait());
		this.fraisHForfaitValue.setFont(new Font("Arial", Font.BOLD, 15));
		this.fraisHForfaitValue.setForeground(new Color(255,255,255));

		//-- Ajout à l'ActionListener
		this.retourBut.addActionListener(this);
		this.deconnexionBut.addActionListener(this);
		
		JTable tableau = new JTable(new Table());
		//-- Création du tableau
		/*String  title[] = {"Visiteur","Libellé","État","Montant","Détails"};
		
		Object[][] data;
		data.
		
		String[] comboData = {"Très bien", "Bien", "Mal"};
		JTable tableau;
	    //Données de notre tableau
	    Object[][] data = {   
	      {"Cysboy", "6boy", comboData[0], new Boolean(true)},
	      {"BZHHydde", "BZH", comboData[0], new Boolean(false)},
	      {"IamBow", "BoW", comboData[0], new Boolean(false)},
	      {"FunMan", "Year", comboData[0], new Boolean(true)}
	    };
	   
	    //Combo à utiliser
	    JComboBox combo = new JComboBox(comboData);
	    new JT
	    tableau = new JTable(data, title);      
	    tableau.setRowHeight(30);
	    //On définit l'éditeur par défaut pour la cellule en lui spécifiant quel type d'affichage prendre en compte
	    tableau.getColumn("Taille").setCellEditor(new DefaultCellEditor(combo));*/
		
		ArrayList<ArrayList<Object>> liste = FraisForfaitMdl.getFraisForfaitAttente();
		for(ArrayList<Object> ligne : liste) {
			/*listeItem = 
			for(Object item : ligne) {
				
			}*/
			System.out.println(ligne);
		}

	    //-- Mise en forme
	    GridBagConstraints gbc = new GridBagConstraints();
	    
		// Comptable (label)
		gbc.gridx = gbc.gridy = 0;
		gbc.gridheight = gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 10, 0, 0);
		mainPanel.add(this.comptableLabel, gbc);
		
		// Date (label)
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 10, 0, 0);
		mainPanel.add(this.dateLabel, gbc);
		
		// Déconnexion (Button)
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 10, 0, 0);
		mainPanel.add(this.deconnexionBut, gbc);
		
		// Categorie (label)
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(5, 10, 0, 0);
		mainPanel.add(this.categorieLabel, gbc);
		
		// Nombre de visiteurs (label)
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(10, 10, 0, 0);
		mainPanel.add(this.nbVisiteursLabel, gbc);
		
		// Nombre de visiteurs (Label|Value)
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(5, 10, 0, 0);
		mainPanel.add(this.nbVisiteursValue, gbc);
		
		// Nombre de frais forfait (label)
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(5, 10, 0, 0);
		mainPanel.add(this.fraisForfaitLabel, gbc);
		
		// Nombre de frais forfait (Label|Value)
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(5, 10, 0, 0);
		mainPanel.add(this.fraisForfaitValue, gbc);
		
		// Nombre de frais hors forfait (label)
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(5, 10, 0, 0);
		mainPanel.add(this.fraisHForfaitLabel, gbc);
		
		// Nombre de frais hors forfait (Label|Value)
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(5, 10, 0, 0);
		mainPanel.add(this.fraisHForfaitValue, gbc);
        
        // Tableau
		gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 10, 0, 0);
        mainPanel.add(new JScrollPane(tableau), gbc);
        
        // Retour (Button)
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 10, 0, 0);
		mainPanel.add(this.retourBut, gbc);
		
        return mainPanel;
	}
	
	public void actionPerformed(ActionEvent event) {
		Object evt = event.getSource();
		if(evt.equals(this.retourBut))
			this.fenetre.setActivePanel(new Accueil(this.fenetre, this.comptable).launchPanel());
		if(evt.equals(this.deconnexionBut))
			this.fenetre.setActivePanel(new Connexion(this.fenetre).launchPanel());
	}
}
