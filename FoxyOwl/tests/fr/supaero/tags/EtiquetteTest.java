package fr.supaero.tags;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Vector;
import java.util.Date;

/**
 * Unit Test for class Etiquette. It uses the data provided by
 * <code>DataGenerator</code> class.
 *
 * <p>Created: Tue Nov  9 08:40:37 2010</p>
 *
 * @author <a href="mailto:garion@supaero.fr">Christophe Garion</a>
 * @version 1.0
 */
public class EtiquetteTest {

  private Vector<MarquePage> mps;  
  private Vector<Etiquette> tags;  
  
  /** 
   * Setup for the tests
   */ 
  @Before public void setUp() {
    this.mps = DataGenerator.generateMarquePages();
    this.tags = DataGenerator.generateEtiquettes();
  }

  /**
   * Test method for constructor if tag is root
   */
  @Test public void testConstructeurRacine() {
    assertNull(this.tags.get(0).getMere());
  }

  /**
   * Test method for constructor if tag is not root. The tag must be
   * added to the root's children list.
   */
  @Test public void testConstructeurNonRacine() {
    assertSame(this.tags.get(0), this.tags.get(1).getMere());
    assertSame(this.tags.get(0), this.tags.get(2).getMere());
    assertSame(this.tags.get(2), this.tags.get(3).getMere());
    assertSame(this.tags.get(2), this.tags.get(4).getMere());
    assertSame(this.tags.get(3), this.tags.get(5).getMere());
    assertSame(this.tags.get(3), this.tags.get(5).getMere());
  }

  /**
   * Test method for getFilles when tag has children
   */
  @Test public void testGetFillesWithChildren() {
    Vector<Etiquette> filles = this.tags.get(3).getFilles();
    assertEquals(2, filles.size());
    assertSame(this.tags.get(5), filles.get(0));
    assertSame(this.tags.get(6), filles.get(1));
  }

  /**
   * Test method for getFilles when tag does not have children
   */
  @Test public void testGetFillesWithoutChildren() {
    Vector<Etiquette> filles = this.tags.get(5).getFilles();
    assertEquals(0, filles.size());
  }

  /**
   * Test method for getMarquePages when tag has bookmarks
   */
  @Test public void testGetMarquePagesWithMP() {
    Vector<MarquePage> mp = this.tags.get(5).getMarquePages();
    assertEquals(3, mp.size());
    assertSame(this.mps.get(3), mp.get(0));
    assertSame(this.mps.get(4), mp.get(1));
    assertSame(this.mps.get(5), mp.get(2));
  }

  /**
   * Test method for getMarquePages when tag has no bookmark
   */
  @Test public void testGetMarquePagesWithoutMP() {
    Vector<MarquePage> mp = this.tags.get(1).getMarquePages();
    assertEquals(0, mp.size());
  }
  
  /**
   * Test method for ajouter
   */
  @Test public void testAjouter() {
    Vector<MarquePage> mps = this.tags.get(0).getMarquePages();
    int oldSize = mps.size();
    MarquePage mp = new MarquePage("SUPAERO", "http://www.supaero.fr", new Date());

    this.tags.get(0).ajouter(mp);

    assertEquals(oldSize + 1, mps.size());
    assertTrue(mps.contains(mp));
    assertSame(mp, mps.get(0));
  }

  /**
   * Test method for retirer when tags has bookmarks
   */
  @Test public void testAjouterWithMP() {
    Vector<MarquePage> mps = this.tags.get(5).getMarquePages();
    int oldSize = mps.size();
    MarquePage mpToRemove = this.mps.get(5);
    Vector<MarquePage> oldMps = new Vector<MarquePage>();
    for (MarquePage mp : mps) {
      if (mp != mpToRemove) {
        oldMps.add(mp);
      }
    }
    
    this.tags.get(5).retirer(mpToRemove);
    
    assertEquals(oldSize - 1, mps.size());
    assertFalse(mps.contains(mpToRemove));
    
    for (MarquePage mp : oldMps) {
      assertTrue(mps.contains(mp));
    }
  }

  /**
   * Test method for retirer when tags has no bookmark
   */
  @Test public void testAjouterWithoutMP() {
    Vector<MarquePage> mps = this.tags.get(0).getMarquePages();
    MarquePage mpToRemove = this.mps.get(5);

    this.tags.get(0).retirer(mpToRemove);
    
    assertEquals(0, mps.size());
    assertFalse(mps.contains(mpToRemove));
  }
}// EtiquetteTest
