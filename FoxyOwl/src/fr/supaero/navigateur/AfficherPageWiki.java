package fr.supaero.navigateur;



import info.bliki.wiki.model.WikiModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 * 
 * Parse les pages wiki et les affiche sur un JeditorPane
 * 
 * @author <a href="mailto@daniel.jartoux@isae.fr"> Daniel Jartoux </a>
 * @author <a href="mailto@o.ben-abbes@isae.fr"> Othman Ben Abbes </a>
 * @version 0.8
 */
public class AfficherPageWiki {
	
	private String adresse;
	private JEditorPane contenu;
	
	public AfficherPageWiki(String adresse_, JEditorPane contenu_){
		this.adresse = adresse_;
		this.contenu = contenu_;
	}
	
	public void contenuhtml() throws Exception{
		if(true){

			URL url = new URL(this.adresse);
	        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.isae.fr", 3128));
	        
	        URLConnection connection = url.openConnection(proxy);

	    
	       StringBuffer page = new StringBuffer();
	       String line;
	       BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	       while ((line = in.readLine()) != null){
	            page.append(line + "\n");
	        }
	              
	        WikiModel wikiModel = new WikiModel("http://www.mywiki.com/wiki/${image}","http://www.mywiki.com/wiki/${title}"); 
	        
			  String htmlStr = wikiModel.render(page.toString()); 
			  contenu.setText(htmlStr);
			}
		
		
        
	}
	
	public String getAdresse(){
		return this.adresse;
	}
	
	public JEditorPane getContenu(){
		return this.contenu;
	}

}
