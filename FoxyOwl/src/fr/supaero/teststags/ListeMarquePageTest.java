package fr.supaero.teststags;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import fr.supaero.navigateur.Historique;
import fr.supaero.tags.*;
import org.junit.*;

public class ListeMarquePageTest {

	private ListeMarquePage lmp;
	private MarquePage mp1;
	private MarquePage mp2;
	private MarquePage mp3;
	
	@Before
	public void setUp() throws Exception {
		lmp = new ListeMarquePage("testlmp");
		mp1 = new MarquePage("google", "http://google.fr", new Date());
		mp2 = new MarquePage("youtube", "http://youtube.com", new Date());
		mp3 = new MarquePage("google2", "http://google.fr", new Date());
	}
	
	//on cree un objet, qu'on sauvegarde, et on verifie que l'objet nouvellement charge contient bien quelque chose
	@Test
	public void testChargerSauvegarder() throws IOException, ParseException, ClassNotFoundException {
		lmp.ajouter(mp1);
		lmp.ajouter(mp2);
		
		lmp.sauvegarder();
		
		ListeMarquePage lmp2 = new ListeMarquePage("testlmp");
		lmp2.charger();
		assertTrue(lmp2.getListemp().size() != 0);
	}
	
	
	//on verifie que si on charge google 1 fois, on va pas le remettre en marque page sous un autre nom
	@Test
	public void testexistedeja() {
		lmp.ajouter(mp1);
		assertTrue(lmp.existeDeja(mp3));
	}

}
