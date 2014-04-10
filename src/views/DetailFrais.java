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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import models.VisiteurMdl;
import overrides.TableModel;
import controllers.ComptableCtrl;
import controllers.FicheFraisCtrl;
import controllers.FraisForfaitCtrl;
import controllers.FraisHorsForfaitCtrl;
import controllers.VisiteurCtrl;

public class DetailFrais extends JPanel implements ActionListener {

	//-- Attributs
	private JButton validBut, mepBut, retourBut, deconnexionBut;
	private JLabel comptableLabel, dateLabel, categorieLabel;
	private JLabel fichefraisLabel, fraisForfaitLabel, fraisHorsForfaitLabel, montantValideLabel;
	
	private ArrayList<JPanel> listeFraisForfaitJPanel;
	private ArrayList<JPanel> listeFraisHorsForfaitJPanel;
	
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
		
		this.listeFraisForfaitJPanel = new ArrayList<JPanel>();
		this.listeFraisHorsForfaitJPanel = new ArrayList<JPanel>();
	}
	public JPanel launchPanel() {
		
		//-- Définition du JPanel
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		mainPanel.setBackground(new Color(141,182,205));
		
		//-- Chargement des frais spécifiques à la fiche de frais
		this.ficheFrais.loadListeFraisForfaits();
		this.ficheFrais.loadListeFraisHorsForfaits();
		
		//-- Instanciation des attributs
		this.validBut = new JButton("Valider la fiche de frais");
		this.mepBut = new JButton("Mettre en paiement");
		
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
		
		this.fichefraisLabel = new JLabel("<html><u>Fiche de frais du " + this.ficheFrais.getMoisFormate() + " - " + this.visiteur.getNom() + " " + this.visiteur.getPrenom() + "</u></html>");
		
		this.montantValideLabel = new JLabel("Montant validé : " + this.ficheFrais.getMontantValide() + " €");
		
		this.fraisForfaitLabel = new JLabel("<html><u>Frais forfait :</u></html>");
		
		this.fraisHorsForfaitLabel = new JLabel("<html><u>Frais hors forfait :</ul></html>");
		
		this.listeFraisForfaitJPanel.add(this.generateFraisForfaitJPanel());
		this.listeFraisHorsForfaitJPanel.add(this.generateFraisHorsForfaitJPanel());
	
		//-- Ajout à l'ActionListener
		this.validBut.addActionListener(this);
		this.mepBut.addActionListener(this);
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
		
		// Fiche Frais (label)
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.CENTER;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(5, 10, 0, 10);
		mainPanel.add(this.fichefraisLabel, gbc);
		
		// Montant validé (label)
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.CENTER;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(5, 10, 0, 10);
		mainPanel.add(this.montantValideLabel, gbc);
		
		// Frais Forfait (label)
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.BASELINE_LEADING;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(15, 10, 0, 10);
		mainPanel.add(this.fraisForfaitLabel, gbc);
		
		// Frais Forfait (JPanel)
		for(JPanel panel : this.listeFraisForfaitJPanel) {
			gbc.gridx = 0;
			gbc.gridy = GridBagConstraints.RELATIVE;
			gbc.gridheight = 1;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.fill = GridBagConstraints.BASELINE_LEADING;
			gbc.anchor = GridBagConstraints.BASELINE_LEADING;
			gbc.insets = new Insets(5, 10, 0, 10);
			mainPanel.add(panel, gbc);
		}
		
		// Frais Hors Forfait (label)
		gbc.gridx = 0;
		gbc.gridy = GridBagConstraints.RELATIVE;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.BASELINE_LEADING;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(5, 10, 0, 10);
		mainPanel.add(this.fraisHorsForfaitLabel, gbc);
		
		// Frais Hors Forfait (JPanel)
		for(JPanel panel : this.listeFraisHorsForfaitJPanel) {
			gbc.gridx = 0;
			gbc.gridy = GridBagConstraints.RELATIVE;
			gbc.gridheight = 1;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.fill = GridBagConstraints.BASELINE_LEADING;
			gbc.anchor = GridBagConstraints.BASELINE_LEADING;
			gbc.insets = new Insets(5, 10, 0, 10);
			mainPanel.add(panel, gbc);
		}
		
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        //Validation de la fiche (Button)
        if(this.ficheFrais.getIdEtat().equalsIgnoreCase("VA")) {
	        gbc.gridx = 0;
			gbc.gridy = GridBagConstraints.RELATIVE;
			gbc.gridheight = 1;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.anchor = GridBagConstraints.BASELINE;
			gbc.fill = GridBagConstraints.NONE;
			gbc.insets = new Insets(15, 10, 0, 0);
			mainPanel.add(this.validBut, gbc);
        }
        
        // Mise en paiement (Button)
        if(this.ficheFrais.getIdEtat().equalsIgnoreCase("CL")) {
	        gbc.gridx = 0;
			gbc.gridy = GridBagConstraints.RELATIVE;
			gbc.gridheight = 1;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.anchor = GridBagConstraints.BASELINE;
			gbc.fill = GridBagConstraints.NONE;
			gbc.insets = new Insets(15, 10, 0, 0);
			mainPanel.add(this.mepBut, gbc);
        }
        
        // Retour (Button)
		gbc.gridx = 0;
		gbc.gridy = GridBagConstraints.RELATIVE;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(0, 10, 0, 10);
		mainPanel.add(this.retourBut, gbc);
		
        return mainPanel;
	}
	
	/**
	 * Génération d'un JPanel contenant l'ensemble des frais forfait de la fiche de frais.
	 * 
	 * @return JPanel
	 */
	private JPanel generateFraisForfaitJPanel() {
		
		JPanel fraisForfaitPanel = new JPanel();
		fraisForfaitPanel.setLayout(new GridBagLayout());
		fraisForfaitPanel.setBackground(new Color(141,182,205));
		int i = 0;
		
		for(FraisForfaitCtrl fraisForfait : this.ficheFrais.getListeFraisForfait()) {		
			
			JLabel libelleLabel = new JLabel(fraisForfait.getTypeFrais().getLibelle() + " :");
			JLabel montantLabel = new JLabel(fraisForfait.getQuantite()*fraisForfait.getTypeFrais().getMontant() + " €");
			
			GridBagConstraints gbc = new GridBagConstraints();
			
			gbc.gridx = 0;
			gbc.gridy = i;
			gbc.gridheight = gbc.gridwidth = 1;
			gbc.anchor = GridBagConstraints.BASELINE_LEADING;
			gbc.insets = new Insets(0,10,0,10);
			fraisForfaitPanel.add(libelleLabel, gbc);
			
			gbc.gridx = 1;
			gbc.gridy = i;
			gbc.gridheight = 1;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.anchor = GridBagConstraints.BASELINE_LEADING;
			gbc.insets = new Insets(0,10,0,10);
			fraisForfaitPanel.add(montantLabel, gbc);
			
			i++;
		}
		return fraisForfaitPanel;
	}
	
	/**
	 * Génération d'un JPanel contenant l'ensemble des frais hors forfait de la fiche de frais.
	 * 
	 * @return JPanel
	 */
	private JPanel generateFraisHorsForfaitJPanel() {
		
		JPanel fraisForfaitPanel = new JPanel();
		fraisForfaitPanel.setLayout(new GridBagLayout());
		fraisForfaitPanel.setBackground(new Color(141,182,205));
		int i = 0;
		
		for(final FraisHorsForfaitCtrl fraisHorsForfait : this.ficheFrais.getListeFraisHorsForfait()) {		
			
			JLabel libelleLabel = new JLabel(fraisHorsForfait.getLibelle());
			JLabel dateLabel = new JLabel("le : " + fraisHorsForfait.getDate());
			JLabel montantLabel = new JLabel(fraisHorsForfait.getMontant() + " €");
			
			if(fraisHorsForfait.getEtat() == 0) {
				libelleLabel.setForeground(Color.red);
				dateLabel.setForeground(Color.red);
				montantLabel.setForeground(Color.red);
			}
			else if(fraisHorsForfait.getEtat() == 1) {
				libelleLabel.setForeground(new Color(0,100,0));
				dateLabel.setForeground(new Color(0,100,0));
				montantLabel.setForeground(new Color(0,100,0));
			}
			
			JButton valFraisBut = new JButton("Valider");
			JButton refFraisBut = new JButton("Refuser");
			
			valFraisBut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					fraisHorsForfait.setEtat(1);
					final ImageIcon icon = new ImageIcon("img/gsb.png");
					JOptionPane.showMessageDialog(null,"Le frais a bien été validé.","AppliFrais - Comptable",JOptionPane.INFORMATION_MESSAGE, icon);
					DetailFrais.this.fenetre.setActivePanel(new DetailFrais(DetailFrais.this.fenetre, DetailFrais.this.comptable, DetailFrais.this.ficheFrais, DetailFrais.this.visiteur).launchPanel());
				}
			});
			
			refFraisBut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					fraisHorsForfait.setEtat(0);
					final ImageIcon icon = new ImageIcon("img/gsb.png");
					JOptionPane.showMessageDialog(null,"Le frais a bien été réfusé.","AppliFrais - Comptable",JOptionPane.INFORMATION_MESSAGE, icon);
					DetailFrais.this.fenetre.setActivePanel(new DetailFrais(DetailFrais.this.fenetre, DetailFrais.this.comptable, DetailFrais.this.ficheFrais, DetailFrais.this.visiteur).launchPanel());
				}
			});
			
			GridBagConstraints gbc = new GridBagConstraints();
			
			gbc.gridx = 0;
			gbc.gridy = i;
			gbc.gridheight = gbc.gridwidth = 1;
			gbc.anchor = GridBagConstraints.BASELINE_LEADING;
			gbc.insets = new Insets(0,10,0,10);
			fraisForfaitPanel.add(libelleLabel, gbc);
			
			gbc.gridx = 1;
			gbc.gridy = i;
			gbc.gridheight = gbc.gridwidth = 1;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.anchor = GridBagConstraints.BASELINE_LEADING;
			gbc.insets = new Insets(0,10,0,10);
			fraisForfaitPanel.add(dateLabel, gbc);
			
			gbc.gridx = 2;
			gbc.gridy = i;
			gbc.gridheight = 1;
			gbc.gridwidth = 1;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.anchor = GridBagConstraints.BASELINE_LEADING;
			gbc.insets = new Insets(0,10,0,10);
			fraisForfaitPanel.add(montantLabel, gbc);
			
			if(this.ficheFrais.getIdEtat().equalsIgnoreCase("CL")) {
				gbc.gridx = 3;
				gbc.gridy = i;
				gbc.gridheight = 1;
				gbc.gridwidth = 1;
				gbc.fill = GridBagConstraints.HORIZONTAL;
				gbc.anchor = GridBagConstraints.BASELINE_LEADING;
				gbc.insets = new Insets(0,10,0,10);
				fraisForfaitPanel.add(valFraisBut, gbc);
				
				gbc.gridx = 4;
				gbc.gridy = i;
				gbc.gridheight = 1;
				gbc.gridwidth = GridBagConstraints.REMAINDER;
				gbc.fill = GridBagConstraints.HORIZONTAL;
				gbc.anchor = GridBagConstraints.BASELINE_LEADING;
				gbc.insets = new Insets(0,10,0,10);
				fraisForfaitPanel.add(refFraisBut, gbc);
			}
			
			i++;
		}
		return fraisForfaitPanel;
	}
	
	/**
	 * Gestion des évènements sur les éléments de la page
	 * 
	 * @param event ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		Object evt = event.getSource();
		if(evt.equals(this.validBut)) {
			final ImageIcon icon = new ImageIcon("img/gsb.png");
			int reply = JOptionPane.showConfirmDialog(null, "Etes vous sûr de vouloir mettre cette fiche de frais en remboursement ?", "AppliFrais - Comptable",  JOptionPane.YES_NO_OPTION);
			if(reply == JOptionPane.YES_OPTION) {
				this.ficheFrais.modifierEtatFiche("RB");
				JOptionPane.showMessageDialog(null,"La fiche de frais a bien été mise en remboursement.\nVous allez être redirigé vers l'écran précédent dans quelques instants.","AppliFrais - Comptable",JOptionPane.INFORMATION_MESSAGE, icon);
				try{
					Thread.sleep(500);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				this.fenetre.setActivePanel(new OverviewFrais(this.fenetre, this.comptable).launchPanel());
			}
		}
		else if(evt.equals(this.mepBut)) {
			final ImageIcon icon = new ImageIcon("img/gsb.png");
			int reply = JOptionPane.showConfirmDialog(null, "Etes vous sûr de vouloir mettre cette fiche de frais en paiement ?", "AppliFrais - Comptable",  JOptionPane.YES_NO_OPTION);
			if(reply == JOptionPane.YES_OPTION) {
				this.ficheFrais.modifierEtatFiche("VA");
				JOptionPane.showMessageDialog(null,"La fiche de frais a bien été mise en paiement.\nVous allez être redirigé vers l'écran précédent dans quelques instants.","AppliFrais - Comptable",JOptionPane.INFORMATION_MESSAGE, icon);
				try{
					Thread.sleep(500);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				this.fenetre.setActivePanel(new OverviewFrais(this.fenetre, this.comptable).launchPanel());
			}
		}
		else if(evt.equals(this.retourBut))
			this.fenetre.setActivePanel(new OverviewFrais(this.fenetre, this.comptable).launchPanel());
		else if(evt.equals(this.deconnexionBut))
			this.fenetre.setActivePanel(new Connexion(this.fenetre).launchPanel());
	}
}