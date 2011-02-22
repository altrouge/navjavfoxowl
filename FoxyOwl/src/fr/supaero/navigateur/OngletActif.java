package fr.supaero.navigateur;

import java.util.Vector;

/**
 * 
 * Onglets actifs du programme, peuvent etre ajoutes, supprimes, ou encore
 * deplaces dans ce milieu
 * 
 * @author <a href="mailto@daniel.jartoux@isae.fr"> Daniel Jartoux </a>
 * @author <a href="mailto@o.ben-abbes@isae.fr"> Othman Ben Abbes </a>
 * @version 0.1
 */
public class OngletActif {

	private Vector<Onglet> ongletactif;

	public OngletActif() {
		ongletactif = new Vector<Onglet>();
	}
	
	

	public Vector<Onglet> getOngletactif() {
		return ongletactif;
	}



	/**
	 * ajoute un onglet au vecteur en derniere position
	 * 
	 * @param Onglet
	 *            o <code> onglet </code> a ajouter au vecteur
	 */
	public void ajouter(Onglet o) {
		ongletactif.add(o);
		ongletactif.lastElement().setPosition(ongletactif.size());
	}

	/**
	 * insere l'onglet a une certaine position et decale les onglets suivants, a implementer dans l'interface graphique
	 * 
	 * @param position_ini
	 *            <code> ancienne position </code> de l'onglet a deplacer
	 * @param position_fin
	 *            <code> nouvelle position </code> de l'onglet a deplacer
	 */
	public void deplacer(int position_ini, int position_fin) {
		if ((position_ini < ongletactif.size())
				&& (position_fin < ongletactif.size())) {
			Onglet o = ongletactif.get(position_ini);
			ongletactif.remove(position_ini);
			ongletactif.insertElementAt(o, position_fin);
		}
	}

	/**
	 * Supprime l'onglet a la position selectionnee
	 * @param position <code> position </code> de l'onglet a supprimer
	 */
	public void supprimer(int position) {
		ongletactif.remove(position);

		for (int i = position; i <= ongletactif.size() - 1; i++)
			ongletactif.get(i).setPosition(i + 1);
	}
}
