package fr.supaero.navigateur;

import java.beans.*;
import java.util.Date;

import javax.swing.*;

/**
 * 
 * Listener applique lorsque FoxyOwl charge une nouvelle page
 * 
 * @author <a href="mailto@daniel.jartoux@isae.fr"> Daniel Jartoux </a>
 * @author <a href="mailto@o.ben-abbes@isae.fr"> Othman Ben Abbes </a>
 * @version 0.8
 */
public class ChangementPageListener implements PropertyChangeListener {

	JEditorPane jEditorPane;
	NouvelOnglet nouvelonglet;
	JTabbedPane jTabbedPane;
	Historique historique;

	public ChangementPageListener(JEditorPane jEditorPane_,
			NouvelOnglet nouvelonglet_, JTabbedPane jTabbedPane_, Historique h) {
		super();
		this.historique = h;
		this.jEditorPane = jEditorPane_;
		this.nouvelonglet = nouvelonglet_;
		this.jTabbedPane = jTabbedPane_;
	}

	public void propertyChange(PropertyChangeEvent e) {
		Onglet o = nouvelonglet.getOnglet();
		
		if(jEditorPane.getPage().toString().endsWith(".wiki")) {
			o.setSite(new Wiki(jEditorPane.getPage().toString(), new Date(),
					(String) jEditorPane.getDocument().getProperty("title")));
		}
		else {
		o.setSite(new Html(jEditorPane.getPage().toString(), new Date(),
				(String) jEditorPane.getDocument().getProperty("title")));
		}
		
		// o.getSite().setTitre((String)jEditorPane.getDocument().getProperty("title"));
		if (o.getSite().getTitre() == null) {
			o.getSite().setTitre(jEditorPane.getPage().toString());
		}

		historique.ajouter(o.getSite());
		jTabbedPane.setTitleAt(o.getPosition() - 1, o.getSite().getTitre());
	}
}
