package fr.supaero.navigateur;

import java.util.Date;

import javax.swing.JEditorPane;

/**
 * 
 * Page internet au format wiki, peut etre affichee, et modifiee si elle est en
 * local
 * 
 * @author <a href="mailto@daniel.jartoux@isae.fr"> Daniel Jartoux </a>
 * @author <a href="mailto@o.ben-abbes@isae.fr"> Othman Ben Abbes </a>
 * @version 0.1
 */
public class Wiki extends Site {

	private static final long serialVersionUID = 125L;
	private String url;
	private Date date;
	private String titre;

	/**
	 * gere le "parser" du site et le rend lisible par un utilisateur non averti
	 */
	@Override
	public void afficher(JEditorPane jEditorPane1, String url) {
		// TODO Auto-generated method stub
		try {
			AfficherPageWiki wiki = new AfficherPageWiki(url, jEditorPane1);
			wiki.contenuhtml();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * boolean renvoyant true si le fichier wiki est local
	 */
	public boolean islocal() {
		if(this.getUrl().startsWith("file:/"))
			return true;
		else
			return false;
	}

	/**
	 * (ne) permet (pas) de modifier le contenu du fichier wiki si celui ci est en local
	 */
	public void editer() {

	}

	public Wiki(String url, Date date, String titre) {
		super(url, date, titre);
	}

}
