package fr.supaero.navigateur;

import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;


/**
 * 
 * Ecoute de clic sur un lien html
 * 
 * @author <a href="mailto@daniel.jartoux@isae.fr"> Daniel Jartoux </a>
 * @author <a href="mailto@o.ben-abbes@isae.fr"> Othman Ben Abbes </a>
 * @version 0.8
 */
class MyHyperlinkListener implements HyperlinkListener {
	/*
	 * public void hyperlinkUpdate(HyperlinkEvent evt) { if (evt.getEventType()
	 * == HyperlinkEvent.EventType.ACTIVATED) { JEditorPane pane =
	 * (JEditorPane)evt.getSource(); try { // Show the new page in the editor
	 * pane. pane.setPage(evt.getURL()); } catch (IOException e) { } } }
	 */
	public void hyperlinkUpdate(HyperlinkEvent e) {
		if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
			JEditorPane pane = (JEditorPane) e.getSource();
			if (e instanceof HTMLFrameHyperlinkEvent) {
				HTMLFrameHyperlinkEvent evt = (HTMLFrameHyperlinkEvent) e;
				HTMLDocument doc = (HTMLDocument) pane.getDocument();
				doc.processHTMLFrameHyperlinkEvent(evt);
			} else {
				try {
					pane.setPage(e.getURL());
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
		}
	}
}
