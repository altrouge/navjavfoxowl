package fr.supaero.navigateur;

import java.beans.*;
import java.util.Date;

import javax.swing.*;

public class ChangementPageListener implements PropertyChangeListener {
    	
    	JEditorPane jEditorPane;
    	NouvelOnglet nouvelonglet;
    	JTabbedPane jTabbedPane;
    	
    	
    	public ChangementPageListener(JEditorPane jEditorPane_,
				NouvelOnglet nouvelonglet_, JTabbedPane jTabbedPane_) {
			super();
			this.jEditorPane = jEditorPane_;
			this.nouvelonglet = nouvelonglet_;
			this.jTabbedPane = jTabbedPane_;
		}


		public void propertyChange(PropertyChangeEvent e) {
			Onglet o = nouvelonglet.getOnglet();
			o.setSite(new Html(jEditorPane.getPage().toString(), new Date(), (String)jEditorPane.getDocument().getProperty("title")));
			
			//o.getSite().setTitre((String)jEditorPane.getDocument().getProperty("title"));
			if(o.getSite().getTitre() == null) {
				o.getSite().setTitre(jEditorPane.getPage().toString());
			}
			
			System.out.println(o.getSite().getTitre() + " " + o.getPosition());
			
			jTabbedPane.setTitleAt(o.getPosition()-1,o.getSite().getTitre());
        }
 }
