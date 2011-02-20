package fr.supaero.navigateur;

import java.util.Date;

import javax.swing.JEditorPane;

public class SiteDefault extends Site {

	@Override
	public void afficher(JEditorPane jEditorPane1, String url) {
		
		Site site;
		//on part du principe qu'une page non wiki est pas une page html 
		if(url.endsWith("wiki")) {
			site = new Wiki(url, new Date(), null);
			site.afficher(jEditorPane1, url);
		}
		else {
			site = new Html(url, new Date(), null);		
		}
		
		site.afficher(jEditorPane1, url);
		
	}

}
