package fr.supaero.tags;

import java.util.Vector;

/**
 * <code>Etiquette</code> est une classe représentant une étiquette permettant
 * d'indexer des marque-pages. Les étiquettes sont organisées suivant une ontologie,
 * une étiquette peut donc avoir des étiquettes filles et une étiquette mère.
 * Une étiquette n'ayant pas d'étiquette mère est considérée comme étant la racine
 * de l'arbre d'ontologie.
 *
 * <p>Created: Tue Nov  9 00:01:34 2010</p>
 *
 * @author <a href="mailto:garion@supaero.fr">Christophe Garion</a>
 * @version 1.0
 */
public class Etiquette {

  private String nom;
  private Etiquette mere;
  private Vector<Etiquette> filles;
  private Vector<MarquePage> mp;
  
  /**
   * Créer une instance de <code>Etiquette</code>.
   * 
   * @param nom_ le nom de l'étiquette qui est une instance de <code>String</code>
   * @param mere_ l'étiquette mère de l'étiquette à construire dans l'ontologie. Si
   *              l'étiquette est la racine de l'ontologie, cette valeur devra être
   *              <code>null</code>.
   */
  public Etiquette(String nom_, Etiquette mere_) {
    this.nom = nom_;
    this.mere = mere_;
    this.filles = new Vector<Etiquette>();
    if (this.mere != null) {
      this.mere.filles.add(this);
    }
    this.mp = new Vector<MarquePage>();
  }
  
  /**
   * Le nom de l'étiquette
   *
   * @return le nom de l'étiquette qui est une instance de <code>String</code>
   */
  public String getNom() {
    return this.nom;
  }

  /**
   * L'étiquette mère de l'étiquette dans l'arbre d'ontologie
   *
   * @return l'étiquette mère qui est une instance de <code>Etiquette</code>.
   *         Cette valeur peut être <code>null</code> si l'étiquette est la racine
   *         de l'arbre d'ontologie
   */
  public Etiquette getMere() {
    return this.mere;
  }

  /**
   * L'ensemble des étiquettes filles de l'étiquette dans l'arbre d'ontologie
   *
   * @return l'ensemble des étiquettes filles sous forme d'une instance de
   *         <code>Vector&lt;Etiquette&gt;</code>
   */
  public Vector<Etiquette> getFilles() {
    return this.filles;
  }

  /**
   * L'ensemble des marque-pages associés à l'étiquette
   *
   * @return l'ensemble des marque-pages sous forme d'une instance de
   *         <code>Vector&lt;MarquePage&gt;</code>
   */  
  public Vector<MarquePage> getMarquePages() {
    return this.mp;
  }

  /**
   * Ajouter un marque-page à l'étiquette
   *
   * @param mp le marque-page à ajouter
   */
  public void ajouter(MarquePage mp) {
    this.mp.add(mp);
  }

  /**
   * Ajouter plusieurs marque-pages à l'étiquette
   *
   * @param mp les marque-pages à ajouter
   */  
  public void ajouter(MarquePage... mp) {
    for (MarquePage m : mp) {
      this.mp.add(m);
    }
  }

  /**
   * Retirer un marque-page à l'étiquette
   *
   * @param mp le marque-page à retirer
   */
  public void retirer(MarquePage mp) {
    this.mp.remove(mp);
  }

  public String toString() {
    return this.nom;
  }
}
