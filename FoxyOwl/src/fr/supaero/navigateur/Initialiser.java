package fr.supaero.navigateur;

import java.io.IOException;
import java.net.*;
import java.text.ParseException;

import fr.supaero.tags.*;

/**
 * 
 * Initialise les differentes donnees
 * 
 * @author <a href="mailto@daniel.jartoux@isae.fr"> Daniel Jartoux </a>
 * @author <a href="mailto@o.ben-abbes@isae.fr"> Othman Ben Abbes </a>
 * @version 0.8
 */
public class Initialiser {

	private Historique historique;
	private ListeMarquePage marquepage;

	public Historique getHistorique() {
		return historique;
	}

	public ListeMarquePage getMarquepage() {
		return marquepage;
	}

	public Initialiser() throws IOException, ParseException,
			ClassNotFoundException {

		System.setProperty("java.net.useSystemProxies", "true");
		System.setProperty("http.proxyHost", "proxy.isae.fr");
		System.setProperty("http.proxyPort", "3128");

		Historique h = new Historique("historique");
		h.charger();

		historique = h;

		ListeMarquePage lmp = new ListeMarquePage("marquepage");
		lmp.charger();
		
		marquepage = lmp;

	}
}
