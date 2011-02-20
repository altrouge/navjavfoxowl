package fr.supaero.navigateur;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HistoriqueTest {

	Historique h;
	String s;
	
	@Before public void setUp() {

		s = "historique";
		h = new Historique(s);
		
		
	}
	
	@Test public void testCharger() throws IOException, ParseException, ClassNotFoundException {
		
		h.charger();
			
	}
	
	@Test public void testSauvegarde() throws IOException {
		Site site = null;
		Date date = new Date();
		site = new Html("http://google.fr", date, "google");
		
		h.ajouter(site);
		h.sauvegarder();
	}
}
