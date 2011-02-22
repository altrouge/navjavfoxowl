package fr.supaero.testsnavigateur;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.*;

import fr.supaero.navigateur.*;

public class SiteTest {
	
	private Wiki wiki1;
	private Html html;
	private Wiki wiki2;
	
	@Before public void setUp() {
		String url1 = "file:/c:/users/daniel/example.wiki";
		String url2 = "http://google.fr";
		wiki1 = new Wiki(url1, new Date(), null);
		wiki2 = new Wiki(url2, new Date(), null);
		html = new Html(url2, new Date(), null);
	}
	
	@Test public void testIsLocal() {
		assertTrue(wiki1.islocal());
		assertFalse(wiki2.islocal());
	}
	
	
}
