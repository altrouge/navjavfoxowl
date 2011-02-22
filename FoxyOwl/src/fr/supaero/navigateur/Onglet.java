package fr.supaero.navigateur;

import fr.supaero.tags.MarquePage;

/**
 * 
 * Onglet contenant un site et une position, l'onglet peut etre marque, epingle,
 * deplace, ou encore duplique
 * 
 * @author <a href="mailto@daniel.jartoux@isae.fr"> Daniel Jartoux </a>
 * @author <a href="mailto@o.ben-abbes@isae.fr"> Othman Ben Abbes </a>
 * @version 0.1
 */
public class Onglet {
	private Site site;
	private int position;

	public Onglet() {
		super();
		this.site = new SiteDefault();
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	/**
	 * duplique l'onglet (a implementer)
	 */
	public void dupliquer() {

	}

	/**
	 * epingle l'onglet (cf google chrome) (a implementer)
	 */
	public void epingler() {

	}

	/**
	 * marquer l'onglet (l'ajouter au marque pages) (voir si c'est vraiment utile et le plus efficace, dans ce cas, a implementer)
	 */
	public void marquer() {

	}
}
