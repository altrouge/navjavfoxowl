package fr.supaero.tags;

/**
 * <code>RechercheEtiquette</code> est une classe permettant de rechercher
 * une étiquette particulière dans l'arbre représentant l'ontologie. La
 * recherche se fait par nom et s'effectue en profondeur d'abord.
 *
 * <p>Created: Tue Nov  9 00:18:48 2010</p>
 *
 * @author <a href="mailto:garion@supaero.fr">Christophe Garion</a>
 * @version 1.0
 */
public class RechercheEtiquette {

  private Etiquette racine;
  
  /**
   * Créer une nouvelle instance de <code>RechercheEtiquette</code>.
   * 
   * @param racine_ la racine de l'arbre sur lequel on veut travailler
   */
  public RechercheEtiquette(Etiquette racine_) {
    this.racine = racine_;
  }

  /**
   * Rechercher une étiquette dans l'arbre par son nom. La recherche
   * s'effectue en profondeur d'abord.
   *
   * @param nomEtiquette le nom de l'étiquette à rechercher
   * @return l'instance de <code>Etiquette</code> correspondant au nom
   *         demandé ou <code>null</code> si aucune étiquette de l'arbre
   *         ne porte ce nom
   */
  public Etiquette rechercher(String nomEtiquette) {
    return this.rechercher(nomEtiquette, this.racine);
  }

  private Etiquette rechercher(String nomEtiquette,
                               Etiquette start) {
    Etiquette res;
    
    if (nomEtiquette.equals(start.getNom())) {
      return start;
    }

    for (Etiquette e : start.getFilles()) {
      res = rechercher(nomEtiquette, e);
      if (res != null) {
        return res;
      }
    }

    return null;
  }

  public String toString() {
    return this.prettyPrint(this.racine, 0);
  }

  private String prettyPrint(Etiquette e, int space) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < space; i++) {
      sb.append(" ");
    }
    sb.append(e.getNom());
    sb.append("\n");
      
    for (Etiquette fille : e.getFilles()) {
      sb.append(this.prettyPrint(fille, space + 2));
    }
    
    return sb.toString();
  }
}
