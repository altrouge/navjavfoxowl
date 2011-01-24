package fr.supaero.tags;

/**
 * <code>Afficheur</code> est une classe permettant d'afficher sur la
 * console les marque-pages indexés par une étiquette et ses étiquettes
 * filles. L'affichage des marque-pages se fait en profondeur d'abord.
 *
 * <p>Created: Tue Nov  9 10:35:12 2010</p>
 *
 * @author <a href="mailto:garion@supaero.fr">Christophe Garion</a>
 * @version 1.0
 */
public class Afficheur {

  private RechercheEtiquette search;

  /**
   * Créer une instance de <code>Afficheur</code>
   *
   * @param search_ l'instance de <code>RechercheEtiquette</code> associé
   *                à l'afficheur
   */
  public Afficheur(RechercheEtiquette search_) {
    this.search = search_;
  }
  
  /**
   * Afficher tous les marque-pages indexés par l'étiquette dont le nom est passé en
   * paramètre et par ses étiquettes filles.
   *
   * @param nomEtiquette le nom de l'étiquette à partir de laquelle on veut afficher
   */
  public void afficher(String nomEtiquette) {
    prettyPrint(search.rechercher(nomEtiquette));
  }

  private void prettyPrint(Etiquette etiquette) {
    for (MarquePage mp : etiquette.getMarquePages()) {
      System.out.println(mp);
    }

    for (Etiquette e : etiquette.getFilles()) {
      prettyPrint(e);
    }
  }

  public String toString() {
    return "Arbre utilisé par l'afficheur:\n" + this.search;
  }
}
