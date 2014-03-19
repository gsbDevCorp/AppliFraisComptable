import java.util.ArrayList;

import models.*;
import controllers.*;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<VisiteurCtrl> liste =  VisiteurMdl.getAllVisitors();
/*		for(VisiteurCtrl visiteur : liste) {
			System.out.println(visiteur.getId() + " - " + visiteur.getNom() + " " + visiteur.getPrenom());
		}*/
		VisiteurMdl.getNbVisitors();
		ArrayList<FraisForfaitCtrl> listeFF = FraisForfaitMdl.getFraisForfait("a131", "201001");
/*		for(FraisForfaitCtrl frais : listeFF) {
			System.out.println(frais.getIdFraisForfait() + " - " + frais.getQuantite());
		}*/
		ArrayList<FraisHorsForfaitCtrl> listeFHF = FraisHorsForfaitMdl.getFraisHorsForfait("a131", "201001");
		/*for(FraisHorsForfaitCtrl fraisHF : listeFHF) {
		System.out.println(fraisHF.getId() + " - " + fraisHF.getLibelle() + " - " + fraisHF.getDate() + " - " + fraisHF.getMontant());
		}*/
		FraisHorsForfaitMdl.getNbFraisHorsForfait("a131", "201001");
	}
}