package fr.supaero.tags;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Vector;
import java.lang.reflect.*;

/**
 *  Unit Test for class RechercheEtiquette to demonstrate test of
 *  private methods.
 *
 * <p>Created: Wed Nov 10 15:45:12 2010</p>
 *
 * @author <a href="mailto:garion@supaero.fr">Christophe Garion</a>
 * @version 1.0
 */
public class RechercheEtiquetteAdvancedTest {

  private RechercheEtiquette search;
  private Vector<Etiquette> tags = DataGenerator.generateEtiquettes();
  
  /** 
   * Setup for the tests
   */ 
  @Before public void setUp() {
    this.search = new RechercheEtiquette(tags.get(0));
  }

  /**
   * Test method for private method rechercher(String, etiquette)
   * of RechercheEtiquette
   */
  @Test public void testRechercheEtiquette() throws Exception {
    Class searchClass = this.search.getClass();
    
    Method methodRechercher = searchClass.getDeclaredMethod("rechercher",
                                                            java.lang.String.class,
                                                            fr.supaero.tags.Etiquette.class);
    methodRechercher.setAccessible(true);

    Etiquette e;

    e = (Etiquette) methodRechercher.invoke(this.search,
                                            "objet", this.tags.get(3));
    assertEquals(this.tags.get(3), e);

    e = (Etiquette) methodRechercher.invoke(this.search,
                                            "Java", this.tags.get(3));
    assertEquals(this.tags.get(5), e);

    assertNull(methodRechercher.invoke(this.search,
                                       "vacances", this.tags.get(3)));
  }

}// RechercheEtiquetteTestTest
