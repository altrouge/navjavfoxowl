package fr.supaero.navigateur;

import java.io.Serializable;
import javax.swing.*;
import java.util.Date;

/**
 * 
 * classe abstraite designant l'ensemble des "sites" web
 * 
 * @author <a href="mailto@daniel.jartoux@isae.fr"> Daniel Jartoux </a>
 * @author <a href="mailto@o.ben-abbes@isae.fr"> Othman Ben Abbes </a>
 * @version 0.1
 */
public abstract class Site implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 123L;
	/**
	 * 
	 */

	private String url;
	private Date date;
	private String titre;

	/**
	 * gere le "parser" du site et le rend lisible
	 */
	public abstract void afficher(JEditorPane JEditorPane1, String url);

	public Site(String url, Date date, String titre) {
		this.url = url;
		this.date = date;
		this.titre = titre;
	}

	public Site() {
		date = new Date();
		this.url = new String();
		this.titre = new String();
	}

	public String getUrl() {
		return url;
	}

	public Date getDate() {
		return date;
	}

	public String getTitre() {
		return titre;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

}
