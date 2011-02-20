package fr.supaero.navigateur;



import java.io.IOException;
import java.util.Vector;

import javax.swing.*;

import fr.supaero.tags.ListeMarquePage;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewApplication.java
 *
 * Created on 13 f�vr. 2011, 11:39:27
 */



/**
 *
 * @author marco
 */
/**
 * @author Othman
 *
 */
public class InterfaceGraphique extends javax.swing.JFrame {

    /** Creates new form NewApplication */
    public InterfaceGraphique(Historique h, ListeMarquePage lmp) {
        initComponents(h, lmp);
        
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    /**
     * 
     */
    private void initComponents(Historique h, ListeMarquePage lmp) {

        jInternalFrame1 = new javax.swing.JInternalFrame("FoxyOwl");
        jTabbedPane1 = new javax.swing.JTabbedPane();
        fermeronglet = new javax.swing.JButton();
        nouvelOngletBouton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        jMenuItemouvrir = new javax.swing.JMenuItem();
        jMenuItemfermer = new javax.swing.JMenuItem();
        
        historiqueMenu = new javax.swing.JMenu();
        consulterhistorique = new javax.swing.JMenuItem();
        sitesHistoriques = new Vector<javax.swing.JMenuItem>();
        
        marquepageMenu = new javax.swing.JMenu();
        sitesFavoris = new Vector<javax.swing.JMenuItem>();
        
        exitMenuItem = new javax.swing.JMenuItem();
        ongletactif = new OngletActif();
        
        premierOnglet= new NouvelOnglet("Onglet1",1,jTabbedPane1, ongletactif);
        
        jInternalFrame1.setVisible(true);
        
        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //on ajoute un onglet initial
        jTabbedPane1.addTab(premierOnglet.getOnglet().getSite().getTitre(), premierOnglet.jPanel1);

        nouvelOngletBouton.setText("+");
        fermeronglet.setText("Fermer l'onglet");
        fileMenu.setText("Fichier");

        jMenuItemouvrir.setText("Ouvrir");
        fileMenu.add(jMenuItemouvrir);

        jMenuItemfermer.setText("Fermer");
        fileMenu.add(jMenuItemfermer);

        exitMenuItem.setText("Quitter");

        fileMenu.add(exitMenuItem);
        
        menuBar.add(fileMenu);
        
        historiqueMenu.setText("Historique");
        
        System.out.println(h.getHistorique().firstElement().getTitre());
        for(int i = h.getHistorique().size()-1; (i >= 0) && (i>= h.getHistorique().size()-10) ; i--) {
        	sitesHistoriques.add(new JMenuItem(h.getHistorique().get(i).getTitre()));
        	historiqueMenu.add(sitesHistoriques.get(i));
        }
        
        
        menuBar.add(historiqueMenu);
        
        marquepageMenu.setText("Favoris");
        
        menuBar.add(marquepageMenu);

        setJMenuBar(menuBar);
        
        
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        
         
        nouvelOngletBouton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int num=jTabbedPane1.getTabCount()+1;
            	String tit= "Onglet"+ num ;
            	 NouvelOnglet nouvelonglet= new NouvelOnglet(tit,jTabbedPane1.getTabCount()+1,jTabbedPane1, ongletactif);
                 
				jTabbedPane1.addTab(nouvelonglet.getOnglet().getSite().getTitre(), nouvelonglet.jPanel1);
				jTabbedPane1.setSelectedIndex(nouvelonglet.getOnglet().getPosition()-1);
				
                 
            }
            
        });
        
        
        fermeronglet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               if(jTabbedPane1.getSelectedIndex() != -1) //si il y a au moins un onglet
            	 ongletactif.supprimer(jTabbedPane1.getSelectedIndex());
            	 jTabbedPane1.removeTabAt(jTabbedPane1.getSelectedIndex());
				//TODO on deplace les onglets suivants
               
                
            }
            
        });
        
        



        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()

            		
            		.addComponent(jTabbedPane1)
                    )
              .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                    .addComponent(nouvelOngletBouton)
                    .addComponent(fermeronglet)
                    )

        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()

              .addComponent(nouvelOngletBouton)
              .addComponent(jTabbedPane1))
                    
 
              .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()

              .addComponent(fermeronglet))
            
                
        );

        pack();
    }// </editor-fold>

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                             
        System.exit(0);
    }                                            


    /**
    * @param args the command line arguments
    */


    // Variables declaration - do not modify

 
    private javax.swing.JInternalFrame jInternalFrame1;
 
    
    private javax.swing.JMenuBar menuBar;
    
    private javax.swing.JMenu fileMenu;
    
    private javax.swing.JMenuItem jMenuItemouvrir;
    private javax.swing.JMenuItem jMenuItemfermer;
    private javax.swing.JMenuItem exitMenuItem;

    private javax.swing.JMenu historiqueMenu;
    
    private javax.swing.JMenuItem consulterhistorique;
    private Vector<javax.swing.JMenuItem> sitesHistoriques;
    
    private javax.swing.JMenu marquepageMenu;
    
    private Vector<javax.swing.JMenuItem> sitesFavoris;

    
   
    
    private javax.swing.JTabbedPane jTabbedPane1;
 
    private javax.swing.JButton nouvelOngletBouton;
    private javax.swing.JButton fermeronglet;
    private NouvelOnglet premierOnglet;
    private OngletActif ongletactif;
    // End of variables declaration

}
