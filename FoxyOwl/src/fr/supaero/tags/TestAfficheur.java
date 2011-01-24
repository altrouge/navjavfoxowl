package fr.supaero.tags;

/**
 * <code>TestAfficheur</code> permet d'afficher les marque-pages associés à diverses
 * étiquettes de l'exemple donné en cours. On utilise la classe <code>DataGenerator</code>
 * pour construire l'arbre d'étiquettes.
 *
 * <p>Created: Tue Nov  9 10:40:11 2010</p>
 *
 * @author <a href="mailto:garion@supaero.fr">Christophe Garion</a>
 * @version 1.0
 */
public class TestAfficheur {

  /**
   * Quelques exemples d'utilisation de l'afficheur sur l'arbre présenté dans le sujet.
   */
  public static void main(String[] args) {
    Etiquette racine = DataGenerator.generateEtiquettes().get(0);
    RechercheEtiquette search = new RechercheEtiquette(racine);
    Afficheur afficheur = new Afficheur(search);
    
    System.out.println("---------------");
    System.out.println("Arbre utilisé :\n");
    System.out.println(search);
    System.out.println(afficheur);
    System.out.println("---------------\n\n");

    System.out.println("----------------------------------------------");
    System.out.println("On affiche les marque-pages depuis la racine :\n");
    afficheur.afficher("racine");
    System.out.println("----------------------------------------------\n\n");

    System.out.println("----------------------------------------------------------");
    System.out.println("On affiche les marque-pages depuis l'étiquette \"objet\" :\n");
    afficheur.afficher("objet");
    System.out.println("----------------------------------------------------------\n\n");

    System.out.println("-------------------------------------------------------------------------------");
    System.out.println("On affiche les marque-pages depuis l'étiquette \"vacances\" (il n'y en a pas) :\n");
    afficheur.afficher("vacances");
    System.out.println("-------------------------------------------------------------------------------\n\n");

  }
}
