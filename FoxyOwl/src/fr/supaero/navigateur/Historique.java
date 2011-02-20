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

	public Historique(String fichier) {
		super();
		this.fichier = fichier;
		this.historique = new Vector<Site>();
	}

	private String fichier;
	private Vector<Site> historique;
	
	public Vector<Site> getHistorique() {
		return historique;
	}
	
	/**
	 * Ajoute un site a l'historique
	 * 
	 * @param site <code> Site </code> a ajouter a l'historique
	 */
	public void ajouter(Site site) {
		historique.add(site);
	}
	/**
	 * genere une interface graphique permettant de gere l'historique
	 */
	public void gerer() {
		
	}
	
	/**
	 * Charge l'historique par un fichier
	 * @param Wiki 
	 * @throws IOException 
	 * @throws ParseException 
	 * @throws ClassNotFoundException 
	 */
	public void charger() throws IOException, ParseException, ClassNotFoundException {
	
		File f = new File(fichier);
		if (!f.exists())
			f.createNewFile();
		// si le fichier n'existe pas, on le cree.
		
		
		FileInputStream fis = new FileInputStream(fichier);
		ObjectInputStream ois = new ObjectInputStream(fis);

		historique = (Vector<Site>) ois.readObject();
		

		ois.close();

		/*
	
		f = new FileReader(fichier);
		BufferedReader in = new BufferedReader(f);
		String s = null;
		Site site = null;
		String[] substring = new String[3];
		SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy;HH:mm:ss"); 
		
		while ((s = in.readLine()) != null) {
			//TODO ajouter division des chaines et enregistrement sous le format site puis historique !
			
			substring = s.split(" ",3);
			
			if(substring[1].startsWith("http"))
				site = new Html();
			else if (substring[1].startsWith("wiki"))
				site = new Wiki();
			
			site.setDate(sdf.parse(substring[0]));
			site.setUrl(substring[1]);
			site.setTitre(substring[3]);
			
			
			historique.add(site);
			
			
		}
	*/
	}
	
	/**
	 * sauvegarde l'historique dans un fichier
	 * @throws IOException 

	 */
	public void sauvegarder() throws IOException {

		File f = new File(fichier);
		if (!f.exists())
			f.createNewFile();
		// si le fichier n'existe pas, on le cree.
		
		
		FileOutputStream fos = new FileOutputStream(fichier);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(historique);


		oos.close();
	 
	}
	
	/**
	 * recherche les sites contenant la chaine dans leur url/titre dans l'historique
	 * @return Vector<Site> Un vecteur contenant les sites lies a la chaine
	 */
	public Vector<Site> rechercher(String chaine) {
		Vector<Site> result = new Vector<Site>();
		for(Site s : historique) 
			if((s.getUrl().indexOf(chaine) != 0) || (s.getTitre().indexOf(chaine) != 0))
				result.add(s);
			
		return result;
	}

}
