package fr.supaero.navigateur;

import java.util.Vector;
import java.lang.*;
import java.io.*;

/**
 * 
 * Historique des connexions avec le logiciel FoxyOwl
 * 
 * @author <a href="mailto@daniel.jartoux@isae.fr"> Daniel Jartoux </a>
 * @author <a href="mailto@o.ben-abbes@isae.fr"> Othman Ben Abbes </a>
 * @version 0.1
 */
public class Historique {
	
	private String fichier;
	private Vector<Site> historique;
	
	/**
	 * Ajoute un site a l'historique
	 * 
	 * @param site <code> Site </code> a ajouter a l'historique
	 */
	public void ajouter(Site site) {
		historique.add(site);
	}
	/**
	 * genere une interface graphique permettant de gere l'historique
	 */
	public void gerer() {
		
	}
	
	/**
	 * Charge l'historique par un fichier
	 * @throws IOException 
	 */
	public void charge(String file) throws IOException {
	
		FileReader f = null;
	
		f = new FileReader(file);
		BufferedReader in = new BufferedReader(f);
		String s = null;
		Site site;
		
		while ((s = in.readLine()) != null) {
			//TODO ajouter division des chaines et enregistrement sous le format site puis historique !
		}
	}
	
	/**
	 * sauvegarde l'historique dans un fichier
	 */
	public void sauvegarder(String fichier) {
		
	}
	
	/**
	 * recherche les sites contenant la chaine dans leur url/titre dans l'historique
	 * @return Vector<Site> Un vecteur contenant les sites lies a la chaine
	 */
	public Vector<Site> rechercher(String chaine) {
		Vector<Site> result = new Vector<Site>();
		for(Site s : historique) 
			if((s.getUrl().indexOf(chaine) != 0) || (s.getTitre().indexOf(chaine) != 0))
				result.add(s);
			
		return result;
	}

}
