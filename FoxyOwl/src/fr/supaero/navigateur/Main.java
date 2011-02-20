package fr.supaero.navigateur;

import java.io.IOException;
import java.net.*;
import java.text.ParseException;

import fr.supaero.tags.ListeMarquePage;



public class Main {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws ParseException 
	 * @throws IOException 
	 */
    public static void main(String args[]) throws IOException, ParseException, ClassNotFoundException {
    	
    	Initialiser init = new Initialiser();
    	final Historique historique_ = init.getHistorique();
    	final ListeMarquePage lmp_ = init.getMarquepage();
    	
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceGraphique(historique_,lmp_).setVisible(true);
            }
        });
    }

}
