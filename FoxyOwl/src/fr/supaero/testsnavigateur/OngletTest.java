package fr.supaero.testsnavigateur;

import static org.junit.Assert.*;
import fr.supaero.navigateur.*;

import org.junit.*;

public class OngletTest {

	private Onglet onglet1;
	private Onglet onglet2;
	private OngletActif ongletactif;
	
	
	@Before
	public void setUp() {
		onglet1 = new Onglet();
		onglet2 = new Onglet();
		ongletactif = new OngletActif();
	}
	
	
	//la seule fonction utilisee de ongletactif pour l'instant est supprimer()
	// on verifie que l'onglet a bien ete deplace.
	@Test
	public void testSupprimer() {
		ongletactif.ajouter(onglet1);
		ongletactif.ajouter(onglet2);
		ongletactif.supprimer(0);
		assertTrue(ongletactif.getOngletactif().get(0).getPosition() == 1);		
	}
	
	

}
