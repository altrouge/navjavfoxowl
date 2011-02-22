package fr.supaero.tags;

import java.io.Serializable;
import java.util.Date;

/**
 * <code>MarquePage</code> est une classe représentant des marque-pages.
 * Les marque-pages sont définis par un titre, une URL et une date.
 *
 * <p>Created: Mon Nov  8 22:27:52 2010</p>
 *
 * @author <a href="mailto:garion@supaero.fr">Christophe Garion</a>
 * @version 1.0
 */
public class MarquePage implements Serializable {

  /**
	 * 
	 */
	private static final long serialVersionUID = 7506836445733646236L;
private String titre;
  private String url;
  private Date date;
  
  
  
  /**
   * Créer une nouvelle instance de <code>MarquePage</code>.
   *
   * @param titre_ le titre du marque-page
   * @param url_ l'URL du marque-page qui est une instance de <code>String</code>
   * @param date_ la date de création du marque-page
   */
  public MarquePage(String titre_, String url_, Date date_) {
    this.titre = titre_;
    this.url = url_;
    this.date = date_;
    
    
  }

  /**
   * Le titre du marque-page
   *
   * @return le titre du marque-page qui est une instance de <code>String</code>
   */
  public String getTitre() {
    return this.titre;
  }

  /**
   * Changer le titre du marque-page
   *
   * @param titre_ le nouveau titre du marque-page
   */
  public void setTitre(String titre_) {
    this.titre = titre_;
  }

  /**
   * L'URL du marque-page
   *
   * @return l'URL du marque-page qui est une instance de <code>String</code>
   */
  public String getURL() {
    return this.url;
  }

  /**
   * La date de création du marque-page
   *
   * @return la date de création du marque-page qui est une
   *         instance de <code>Date</code>
   */
  public Date getDate() {
    return this.date;
  }

  public String toString() {
    String variableSeparator = "  ";
    StringBuilder sb = new StringBuilder();

    sb.append("titre=").append(titre);
    sb.append(variableSeparator);
    sb.append("url=").append(url);
    sb.append(variableSeparator);
    sb.append("date=").append(date);

    return sb.toString();
  }  
}
