package fr.supaero.navigateur;

import java.util.Date;
/**
 * 
 * classe abstraite designant l'ensemble des "sites" web
 * 
 * @author <a href="mailto@daniel.jartoux@isae.fr"> Daniel Jartoux </a>
 * @author <a href="mailto@o.ben-abbes@isae.fr"> Othman Ben Abbes </a>
 * @version 0.1
 */
public abstract class Site {
	private String url;
	private Date date;
	private String titre;
	
	/**
	 * gere le "parser" du site et le rend lisible
	 */
	public abstract void afficher() ;

	public String getUrl() {
		return url;
	}

	public Date getDate() {
		return date;
	}

	public String getTitre() {
		return titre;
	}

}
