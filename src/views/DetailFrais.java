package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import models.VisiteurMdl;
import overrides.TableModel;
import controllers.ComptableCtrl;
import controllers.FicheFraisCtrl;
import controllers.VisiteurCtrl;

public class DetailFrais extends JPanel implements ActionListener, MouseListener {

	//-- Attributs
	private JButton retourBut, deconnexionBut;
	private JLabel comptableLabel, dateLabel, categorieLabel;
	private JLabel fichefraisLabel, fraisForfaitLabel;
	
	private Fenetre fenetre;
	private ComptableCtrl comptable;
	private FicheFraisCtrl ficheFrais;
	private VisiteurCtrl visiteur;
	
	//-- Constructeurs
	public DetailFrais(Fenetre fenetre, ComptableCtrl comptable, FicheFraisCtrl ficheFrais, VisiteurCtrl visiteur) {
		this.fenetre = fenetre;
		this.comptable = comptable;
		this.ficheFrais = ficheFrais;
		this.visiteur = visiteur;
	}
	public JPanel launchPanel() {
		
		//-- Définition du JPanel
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		mainPanel.setBackground(new Color(141,182,205));
		
		//-- Instanciation des attributs
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
		
		this.fichefraisLabel = new JLabel("Fiche de frais du " + this.ficheFrais.getMoisFormate() + " - " + this.visiteur.getNom() + " " + this.visiteur.getPrenom());
		
		this.fraisForfaitLabel = new JLabel("Frais forfaits :");
		
		//-- Ajout à l'ActionListener
		this.retourBut.addActionListener(this);
		this.deconnexionBut.addActionListener(this);
		
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
		gbc.insets = new Insets(0, 10, 0, 10);
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
		
		// Fiche Frais (label)
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.CENTER;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(5, 10, 0, 10);
		mainPanel.add(this.fichefraisLabel, gbc);
		
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
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
	
	public void actionPerformed(ActionEvent event) {
		Object evt = event.getSource();
		if(evt.equals(this.retourBut))
			this.fenetre.setActivePanel(new OverviewFrais(this.fenetre, this.comptable).launchPanel());
		if(evt.equals(this.deconnexionBut))
			this.fenetre.setActivePanel(new Connexion(this.fenetre).launchPanel());
	}
	
	@Override
	public void mouseClicked(MouseEvent evt) {

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