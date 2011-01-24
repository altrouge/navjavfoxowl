package fr.supaero.tags;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Date;

/**
 * Unit Test for class MarquePage
 *
 * <p>Created: Mon Nov  8 23:48:29 2010</p>
 *
 * @author <a href="mailto:garion@supaero.fr">Christophe Garion</a>
 * @version 1.0
 */
public class MarquePageTest {

  private Date d;
  private MarquePage mp;
  
  /** 
   * Setup for the tests
   */ 
  @Before public void setUp() {
    this.d = new Date();
    this.mp = new MarquePage("Java 6 API javadoc",
                             "http://download.oracle.com/javase/6/docs/api/",
                             d);
  }

  /**
   * Test method for getTitre
   */
  @Test public void testGetTitre() {
    assertEquals("Java 6 API javadoc", this.mp.getTitre());
  }

  /**
   * Test method for getURL
   */
  @Test public void testGetURL() {
    assertEquals("http://download.oracle.com/javase/6/docs/api/", this.mp.getURL());
  }

  /**
   * Test method for getDate
   */
  @Test public void testGetDate() {
    assertEquals(this.d, this.mp.getDate());
  }

  /**
   * Test method for setTitre
   */
  @Test public void testSetTitre() {
    this.mp.setTitre("coucou");
    assertEquals("coucou", this.mp.getTitre());    
  }
}// MarquePageTest
