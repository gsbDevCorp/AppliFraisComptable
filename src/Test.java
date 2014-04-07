import java.util.ArrayList;

import models.*;
import controllers.*;
import views.*;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Fenetre fenetre = new Fenetre();
		fenetre.setActivePanel(new Connexion(fenetre).launchPanel());
		
		/*try{
			Thread.sleep(3000);
		}catch(InterruptedException e){
			System.out.println(e.getMessage());
		}*/
	}
}