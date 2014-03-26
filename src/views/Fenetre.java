package views;

import java.awt.*;

import javax.swing.*;

/**
 * ---------------------------------
 * Gestion de la fenêtre
 * ---------------------------------
 * 
 * @author Robin BILLY - SIO2
 * Package views
 * @version 1.0.0
 *
 */
public class Fenetre extends JFrame {
	
	public Fenetre() {
		//-- Définition de la fenêtre de base
		this.setTitle("AppliFrais - Comptable");
		this.setIconImage(new ImageIcon("img/logo.png").getImage());
		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setMinimumSize(new Dimension(500, 250));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	public void setActivePanel(JPanel panel) {
		this.getContentPane().removeAll();
		this.getContentPane().add(panel);
		this.getContentPane().revalidate();
	}
}
