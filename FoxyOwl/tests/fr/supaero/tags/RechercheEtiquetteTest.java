package fr.supaero.tags;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Vector;

/**
 * Unit Test for class RechercheEtiquette
 *
 * <p>Created: Tue Nov  9 10:13:38 2010</p>
 *
 * @author <a href="mailto:garion@supaero.fr">Christophe Garion</a>
 * @version 1.0
 */
public class RechercheEtiquetteTest {

  private RechercheEtiquette search;
  private Vector<Etiquette> tags = DataGenerator.generateEtiquettes();
  
  /** 
   * Setup for the tests
   */ 
  @Before public void setUp() {
    this.search = new RechercheEtiquette(tags.get(0));
  }

  /**
   * Test method for searching the tree root
   */
  @Test public void testRechercheRacine() {
    Etiquette e = this.search.rechercher("racine");

    assertSame(this.tags.get(0), e);
  }

  /**
   * Test method for searching a tag "in the middle of the tree"
   */
  @Test public void testRechercheAutreEtiquette() {
    Etiquette e = this.search.rechercher("objet");

    assertSame(this.tags.get(3), e);    
  }

  /**
   * Test method for searching a tag which is a leaf of the tree
   */
  @Test public void testRechercheFeuille() {
    Etiquette e = this.search.rechercher("Java");

    assertSame(this.tags.get(5), e);    
  }

  /**
   * Test method for searching a tag which is not present
   */
  @Test public void testRechercheEtiquetteNonPresente() {
    Etiquette e = this.search.rechercher("SUPAERO");

    assertNull(e);
  }
}// RechercheEtiquetteTest
