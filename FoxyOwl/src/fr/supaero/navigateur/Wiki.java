package fr.supaero.navigateur;

import java.util.Date;

/**
 * 
 * Page internet au format wiki, peut etre affichee, et modifiee si elle est en local
 * 
 * @author <a href="mailto@daniel.jartoux@isae.fr"> Daniel Jartoux </a>
 * @author <a href="mailto@o.ben-abbes@isae.fr"> Othman Ben Abbes </a>
 * @version 0.1
 */
public class Wiki extends Site {
	private String url;
	private Date date;
	private String titre;
	
	/**
	 * gere le "parser" du site et le rend lisible par un utilisateur non averti
	 */
	public void afficher(){	
	
	}
	
	/**
	 * boolean renvoyant true si le fichier wiki est local
	 */
	public boolean islocal(){
		return false;
	}
	
	/**
	 * permet de modifier le contenu du fichier wiki si celui ci est en local
	 */
	public void editer(){
		
	}
}
