package fr.supaero.tags;

import java.util.Vector;
import java.util.Date;

/**
 * <code>GenerateData</code> is a class generating atree of tags for
 * unit tests. The tags tree is the one presented in the exercise.
 *
 * <p>Created: Tue Nov  9 08:54:22 2010</p>
 *
 * @author <a href="mailto:garion@supaero.fr">Christophe Garion</a>
 * @version 1.0
 */
public class DataGenerator {

  private static Vector<MarquePage> mp;
  
  /**
   * <code>generateTags</code> generates a vector of bookmarks in the
   * following order:
   * 
   * <ul>
   * <li>Haskell</li>
   * <li>Eiffel</li>
   * <li>Simula</li>
   * <li>Java @ Oracle</li>
   * <li>JUnit</li>
   * <li>Java API javadoc</li>
   * <li>C++ FAQ Lite</li>
   * <li>Thinking in C++</li>
   * </ul>
   *
   * The vector is cached into a private attribute in order to be able
   * to call this method several times for test comparisons.
   *
   * @return a <code>Vector&lt;MarquePage&gt;</code> instance
   */
  public static Vector<MarquePage> generateMarquePages() {
    if (mp != null) {
      return mp;
    }

    mp = new Vector<MarquePage>();

    mp.add(new MarquePage("Haskell",
                          "http://www.haskell.org/",
                          new Date()));
    mp.add(new MarquePage("Eiffel",
                          "http://www.eiffel.com/",
                          new Date()));
    mp.add(new MarquePage("Simula",
                          "http://en.wikipedia.org/wiki/Simula",
                          new Date()));
    mp.add(new MarquePage("Java @ Oracle",
                          "http://www.oracle.com/us/technologies/java/index.html",
                          new Date()));
    mp.add(new MarquePage("Junit",
                          "http://www.junit.org",
                          new Date()));
    mp.add(new MarquePage("Java API javadoc",
                          "http://java.sun.com/reference/api/",
                          new Date()));
    mp.add(new MarquePage("C++ FAQ Lite",
                          "http://www.parashift.com/c++-faq-lite/",
                          new Date()));
    mp.add(new MarquePage("Thinking in C++",
                          "http://www.mindview.net/Books/TICPP/ThinkingInCPP2e.html",
                          new Date()));

    return mp;
  }
  
  /**
   * <code>generateEtiquettes</code> generates a vector of tags corresponding
   * to the exercise example. The order of tags in the vector is obtained
   * from the example by using breadth-first method.<br/>
   *
   * The bookmarks associated to tags are the following:
   * <ul>
   * <li>"langages" tag -> Haskell</li>
   * <li>"objet" tag -> Eiffel, Simula</li>
   * <li>"Java" tag -> Java @ Oracle, JUnit, Java API javadoc</li>
   * <li>"C++" tag -> C++ FAQ Lite, Thinking in C++</li>
   * </ul>
   * 
   * @return a <code>Vector&lt;Etiquette&gt;</code> instance with the tags
   *         corresponding to the example
   */
  public static Vector<Etiquette> generateEtiquettes() {
    Vector<Etiquette> result = new Vector<Etiquette>();

    result.add(new Etiquette("racine", null));
    result.add(new Etiquette("vacances", result.get(0)));
    result.add(new Etiquette("langages", result.get(0)));
    result.add(new Etiquette("objet", result.get(2)));
    result.add(new Etiquette("procedural", result.get(2)));
    result.add(new Etiquette("Java", result.get(3)));
    result.add(new Etiquette("C++", result.get(3)));

    Vector<MarquePage> mp = generateMarquePages();
    
    result.get(2).ajouter(mp.get(0));
    result.get(3).ajouter(mp.get(1));
    result.get(3).ajouter(mp.get(2));
    result.get(5).ajouter(mp.get(3));
    result.get(5).ajouter(mp.get(4));
    result.get(5).ajouter(mp.get(5));
    result.get(6).ajouter(mp.get(6));
    result.get(6).ajouter(mp.get(7));
    
    return result;
  }
}
