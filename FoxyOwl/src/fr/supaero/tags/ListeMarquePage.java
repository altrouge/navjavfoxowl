package fr.supaero.tags;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import fr.supaero.navigateur.Site;

public class ListeMarquePage {
	
	private String fichier_mp;
	private Vector<MarquePage> listemp;

	
	public Vector<MarquePage> getListemp() {
		return listemp;
	}

	public ListeMarquePage(String fichier_mp_) {
		super();
		this.fichier_mp = fichier_mp_;
		this.listemp = new Vector<MarquePage>();
	}
	
	/*
	 * Regarde si le site contenu dans le marquepage est deja marque
	 */
	public boolean existeDeja(MarquePage mp) {
		for(MarquePage mp_ :this.listemp)
			if(mp_.getURL().compareTo(mp.getURL()) == 0)
				return true;
		return false;
	}

	
	/*
	 * Ajoute un marque page
	 */
	public void ajouter(MarquePage mp) {
		if(!existeDeja(mp))
			this.listemp.add(mp);
	}
	
	public void supprimer(MarquePage mp) {
		this.listemp.remove(mp);
	}
	
	/*
	 * sauvegarde le marque page dans le fichier specifie pour construire le marque page
	 */
	public void sauvegarder() throws IOException {
		
		File f = new File(fichier_mp);
		if(!f.exists())
			f.createNewFile();
		
		FileOutputStream fos = new FileOutputStream(fichier_mp);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(listemp);


		oos.close();
	}

	
	/*
	 * Charge le marque page depuis le fichier specifie pour construire le marque page
	 */
	public void charger() throws IOException, ClassNotFoundException {
		
		File f = new File(fichier_mp);
		if(!f.exists())
			f.createNewFile();
		
			try {
			FileInputStream fis = new FileInputStream(fichier_mp);
			ObjectInputStream ois_ = new ObjectInputStream(fis);

			listemp = (Vector<MarquePage>) ois_.readObject();

			ois_.close();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	}
	
	
}
