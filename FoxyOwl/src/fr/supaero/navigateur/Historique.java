package fr.supaero.navigateur;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.io.*;

/**
 * 
 * Historique des connexions avec le logiciel FoxyOwl
 * 
 * @author <a href="mailto@daniel.jartoux@isae.fr"> Daniel Jartoux </a>
 * @author <a href="mailto@o.ben-abbes@isae.fr"> Othman Ben Abbes </a>
 * @version 0.1
 */
public class Historique {



	private String fichier;
	private Vector<Site> historique;
	private boolean recherche_privee;
	
	public boolean isRecherche_privee() {
		return recherche_privee;
	}


	public void setRecherche_privee(boolean recherche_privee) {
		this.recherche_privee = recherche_privee;
	}


	public Vector<Site> getHistorique() {
		return historique;
	}

	
	public Historique(String fichier) {
		super();
		this.fichier = fichier;
		this.historique = new Vector<Site>();
		this.recherche_privee = false;
	}
	
	/**
	 * Ajoute un site a l'historique si l'on n'est pas en navigation privee
	 * 
	 * @param site
	 *            <code> Site </code> a ajouter a l'historique
	 */
	public void ajouter(Site site) {
		if(!recherche_privee)
			historique.add(site);
	}

	/**
	 * genere une interface graphique permettant de gere l'historique
	 */
	public void gerer() {

	}

	/**
	 * Charge l'historique par un fichier
	 * 
	 * @param Wiki
	 * @throws IOException
	 * @throws ParseException
	 * @throws ClassNotFoundException
	 */
	public void charger() throws ParseException,
			ClassNotFoundException, IOException {

		File f = new File(fichier);
		if (!f.exists())
			f.createNewFile();
		// si le fichier n'existe pas, on le cree.

		try {
		FileInputStream fis = new FileInputStream(fichier);
		ObjectInputStream ois = new ObjectInputStream(fis);

		historique = (Vector<Site>) ois.readObject();
		ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/* Autre implementation basee sur les expressions regulieres, il faudrait voir efficacite
		 * 
		 * f = new FileReader(fichier); BufferedReader in = new
		 * BufferedReader(f); String s = null; Site site = null; String[]
		 * substring = new String[3]; SimpleDateFormat sdf = new
		 * SimpleDateFormat("dd:MM:yyyy;HH:mm:ss");
		 * 
		 * while ((s = in.readLine()) != null) { //TODO ajouter division des
		 * chaines et enregistrement sous le format site puis historique !
		 * 
		 * substring = s.split(" ",3);
		 * 
		 * if(substring[1].startsWith("http")) site = new Html(); else if
		 * (substring[1].startsWith("wiki")) site = new Wiki();
		 * 
		 * site.setDate(sdf.parse(substring[0])); site.setUrl(substring[1]);
		 * site.setTitre(substring[3]);
		 * 
		 * 
		 * historique.add(site);
		 * 
		 * 
		 * }
		 */
	}

	/**
	 * sauvegarde l'historique dans un fichier
	 * 
	 * @throws IOException
	 */
	public void sauvegarder() throws IOException {

		File f = new File(fichier);
		if (!f.exists())
			f.createNewFile();
		// si le fichier n'existe pas, on le cree.

		try {
		FileOutputStream fos = new FileOutputStream(fichier);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(historique);

		oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * recherche les sites contenant la chaine dans leur url/titre dans
	 * l'historique
	 * 
	 * @return Vector<Site> Un vecteur contenant les sites lies a la chaine
	 */
	public Vector<Site> rechercher(String chaine) {
		Vector<Site> result = new Vector<Site>();
		for (Site s : historique)
			if ((s.getUrl().indexOf(chaine) != -1)
					|| (s.getTitre().indexOf(chaine) != -1))
				result.add(s);

		return result;
	}

}
