package fr.supaero.navigateur;

import java.io.IOException;
import java.net.*;
import java.text.ParseException;

import fr.supaero.tags.ListeMarquePage;

/**
 * 
 * Main, initialise puis lance le programme
 * 
 * @author <a href="mailto@daniel.jartoux@isae.fr"> Daniel Jartoux </a>
 * @author <a href="mailto@o.ben-abbes@isae.fr"> Othman Ben Abbes </a>
 * @version 0.8
 */
public class Main {

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws ParseException
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException, ParseException,
			ClassNotFoundException {

		Initialiser init = new Initialiser();
		final Historique historique_ = init.getHistorique();
		final ListeMarquePage lmp_ = init.getMarquepage();

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new InterfaceGraphique(historique_, lmp_).setVisible(true);
			}
		});
	}

}
