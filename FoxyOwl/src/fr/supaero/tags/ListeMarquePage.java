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

	
	public ListeMarquePage(String fichier_mp) {
		super();
		this.fichier_mp = fichier_mp;
		this.listemp = new Vector<MarquePage>();
	}

	public void ajouter(MarquePage mp) {
		this.listemp.add(mp);
	}
	
	public void supprimer(MarquePage mp) {
		this.listemp.remove(mp);
	}
	
	public void sauvegarder() throws IOException {
		
		File f = new File(fichier_mp);
		if(!f.exists())
			f.createNewFile();
		
		FileOutputStream fos = new FileOutputStream(fichier_mp);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(listemp);


		oos.close();
	}

	@SuppressWarnings("unchecked")
	public void charger() throws IOException, ClassNotFoundException {
		
		File f = new File(fichier_mp);
		if(!f.exists())
			f.createNewFile();
		
			try {
			FileInputStream fis = new FileInputStream(fichier_mp);
			ObjectInputStream ois = new ObjectInputStream(fis);

			listemp = (Vector<MarquePage>) ois.readObject();

			ois.close();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	}
	
	
}
