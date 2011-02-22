package fr.supaero.navigateur;

import java.beans.PropertyChangeListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.html.*;

/**
 * 
 * interface graphique de l'interieur d'un onglet (contenant donc un site)
 * 
 * @author <a href="mailto@daniel.jartoux@isae.fr"> Daniel Jartoux </a>
 * @author <a href="mailto@o.ben-abbes@isae.fr"> Othman Ben Abbes </a>
 * @version 0.8
 */
public class NouvelOnglet {

	public Onglet onglet;

	public JTabbedPane jTabbedPanew;
	public javax.swing.JTextField adresseOnglet;
	public javax.swing.JButton go;
	public javax.swing.JPanel jPanel1;
	public javax.swing.JScrollPane jScrollPane1;
	public javax.swing.JEditorPane jEditorPane1;
	public ChangementPageListener changementPage;

	public Onglet getOnglet() {
		return onglet;
	}

	public javax.swing.JEditorPane getjEditorPane1() {
		return jEditorPane1;
	}

	public NouvelOnglet(String titre_, int numero_, JTabbedPane jTabbedPane1,
			OngletActif ongletactif, String url, Historique h) {
		super();
		this.onglet = new Onglet();
		this.onglet.setPosition(numero_);
		this.onglet.getSite().setTitre(titre_);
		jTabbedPanew = jTabbedPane1;
		jPanel1 = new javax.swing.JPanel();
		adresseOnglet = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		jEditorPane1 = new javax.swing.JEditorPane();
		go = new javax.swing.JButton();

		ongletactif.ajouter(this.onglet);

		jEditorPane1.setEditorKit(jEditorPane1
				.getEditorKitForContentType("text/html"));

		changementPage = new ChangementPageListener(jEditorPane1, this,
				jTabbedPanew, h);

		jEditorPane1.setEditable(false);
		jEditorPane1.addPropertyChangeListener("page", changementPage);

		if (url == null)
			adresseOnglet.setText("http://");
		else {
			adresseOnglet.setText(url);
			SiteDefault s = new SiteDefault();
			onglet.getSite().setUrl(url);
			s.afficher(jEditorPane1, adresseOnglet.getText());
		}

		jScrollPane1.setViewportView(jEditorPane1);
		jScrollPane1.createHorizontalScrollBar();
		jScrollPane1.createVerticalScrollBar();
		go.setText("GO");
		go.setActionCommand("jButton2");
		go.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				SiteDefault s = new SiteDefault();
				onglet.getSite().setUrl(adresseOnglet.getText());
				s.afficher(jEditorPane1, adresseOnglet.getText());
			}

		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
				// .addGap(18, 18, 18)
						.addComponent(adresseOnglet).addComponent(go))
				.addGroup(
						jPanel1Layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(
										jPanel1Layout.createSequentialGroup()
												.addContainerGap()
												.addComponent(jScrollPane1)
												.addContainerGap())));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																adresseOnglet)
														.addComponent(go))
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jScrollPane1)
																		.addContainerGap()))));

		// Try to display the page

		this.jEditorPane1.addHyperlinkListener(new MyHyperlinkListener());

	}

}
