package fr.supaero.navigateur;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import javax.swing.JEditorPane;

/**
 * 
 * Page internet au format HTML, peut etre affichee (via swing et jeditorpane)
 * 
 * @author <a href="mailto@daniel.jartoux@isae.fr"> Daniel Jartoux </a>
 * @author <a href="mailto@o.ben-abbes@isae.fr"> Othman Ben Abbes </a>
 * @version 0.8
 */
public class Html extends Site {

	/**
	 * 
	 */
	private static final long serialVersionUID = -917271022995774304L;
	private String url;
	private Date date;
	private String titre;

	public Html(String url, Date date, String titre) {
		super(url, date, titre);
	}

	/**
	 * gere le "parser" du site et l'affiche sur un jeditorpane
	 */
	public void afficher(JEditorPane jEditorPane1, String url) {
		try {
			jEditorPane1.setPage(url);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("pas reussi a afficher");
			e.printStackTrace();
		}
	}
}
