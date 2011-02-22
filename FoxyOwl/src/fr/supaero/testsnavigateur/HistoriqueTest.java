package fr.supaero.testsnavigateur;

import fr.supaero.navigateur.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HistoriqueTest {

	private Historique h;
	private String s;
	private Site s1;
	private Site s2;
	
	@Before
	public void setUp() {

		s = "testhistorique";
		h = new Historique(s);
		s1 = new Html("http://www.google.fr", new Date(), "google");
		s2 = new Html("http://www.jeuxvideos.com", new Date(), "jv.com");

	}

	//on cree un objet, qu'on sauvegarde, et on verifie que l'objet nouvellement charge contient bien quelque chose
	@Test
	public void testChargerSauvegarder() throws IOException, ParseException, ClassNotFoundException {
		h.ajouter(s1);
		h.sauvegarder();
		
		Historique h2 = new Historique(s);
		h2.charger();
		assertTrue(h2.getHistorique().size() != 0);
	}
	
	@Test
	public void testRechercher() {
		h.ajouter(s1);
		h.ajouter(s2);
		
		Vector<Site> recherche = h.rechercher("google");
		assertTrue(recherche.size() == 1);
		assertEquals(recherche.firstElement().getTitre(), "google");

	}

}
