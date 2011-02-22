package fr.supaero.navigateur;

import java.util.Date;

import javax.swing.JEditorPane;


/**
 * 
 * Site par defaut, sa fonction affiche regarde sur quel style de site on travaille et affiche en consequence
 * 
 * @author <a href="mailto@daniel.jartoux@isae.fr"> Daniel Jartoux </a>
 * @author <a href="mailto@o.ben-abbes@isae.fr"> Othman Ben Abbes </a>
 * @version 0.8
 */
public class SiteDefault extends Site {

	/**
	 * regarde sur quel type de site on travaille et affiche en consequence
	 */
	@Override
	public void afficher(JEditorPane jEditorPane1, String url) {

		Site site;
		// on part du principe qu'une page non wiki est pas une page html
		if (url.endsWith("wiki")) {
			site = new Wiki(url, new Date(), null);
		} else {
			site = new Html(url, new Date(), null);
		}

		site.afficher(jEditorPane1, url);

	}

	
}
