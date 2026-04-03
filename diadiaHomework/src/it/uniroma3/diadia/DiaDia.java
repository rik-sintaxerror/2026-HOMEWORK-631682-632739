package it.uniroma3.diadia;

import java.util.Scanner;


import it.uniroma3.diadia.Ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "prendi", "posa", "fine"};

	private Partita partita;
	private IO io; //nuovo attribbuto
	
	public DiaDia(IO io) {
		this.partita = new Partita();
		this.io = io;
	}

	public void gioca() {
		String istruzione; 

		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
				
		do {		
			istruzione = this.io.leggiRiga();
		} while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("prendi"))
				this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("posa"))
				this.posa(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
				this.aiuto();
		else
			this.io.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			this.io.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		String tuttiIComandi = "";
		for(int i=0; i< elencoComandi.length; i++) 
			tuttiIComandi += elencoComandi[i] + " ";
		this.io.mostraMessaggio(tuttiIComandi);
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null) {
			this.io.mostraMessaggio("Dove vuoi andare ?");
			return; 
		}
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null) {
			this.io.mostraMessaggio("Direzione inesistente");
			return;	
		} else {
			this.partita.setStanzaCorrente(prossimaStanza);
			this.partita.getGiocatore().setCfu(this.partita.getGiocatore().getCfu() - 1);
			this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		}
		
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		this.io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}
	/* metodo prendi attrezzo */
	private void prendi(String nomeAttrezzo) {
        // Recuperiamo la stanza corrente dalla partita
        Stanza stanzaCorrente = this.partita.getStanzaCorrente();

        /* verifichiamo se l'attrezzo esiste nella stanza*/
        Attrezzo attrezzo = stanzaCorrente.getAttrezzo(nomeAttrezzo);

        if (attrezzo != null) {
            //  aggiungiamo l'attrezzo al giocatore  e quindi alla borsa se è possbile
            if (this.partita.getGiocatore().addAttrezzo(attrezzo)) {

                // Se aggiunto con successo, lo rimuoviamo dalla stanza
                stanzaCorrente.removeAttrezzo(attrezzo);
                this.io.mostraMessaggio("Hai raccolto: " + attrezzo.toString());
            } else {
                // Caso in cui la borsa è piena o l'oggetto è troppo pesante
            	this.io.mostraMessaggio("Non puoi prendere l'attrezzo: borsa piena o troppo pesante!");
            }
        } else {
            // Caso in cui l'attrezzo non è nella stanza
        	this.io.mostraMessaggio("L'attrezzo '" + nomeAttrezzo + "' non è qui.");
        }
    }
	
	/* metodo per lasciare un attrezzo */
	private void posa(String nomeAttrezzo) {

        // Proviamo a rimuovere l'attrezzo dal giocatore e quindi dalla borsa
        Attrezzo attrezzoDaPosare = this.partita.getGiocatore().removeAttrezzo(nomeAttrezzo);

        if (attrezzoDaPosare != null) {
            // Se il giocatore aveva l'attrezzo, viene aggiunto alla stanza
            Stanza stanzaCorrente = this.partita.getStanzaCorrente();

            if (stanzaCorrente.addAttrezzo(attrezzoDaPosare)) {
            	this.io.mostraMessaggio("Hai posato: " + attrezzoDaPosare.getNome());
            } else {
                // Se la stanza è piena rimetto lattrezzo nella borsa
            	this.io.mostraMessaggio("Non c'è spazio in questa stanza per posare l'oggetto!");
                this.partita.getGiocatore().addAttrezzo(attrezzoDaPosare);
            }
        } else {
            // Caso in cui l'attrezzo non è nella borsa
        	this.io.mostraMessaggio("Non hai l'attrezzo '" + nomeAttrezzo + "' nella borsa.");
        }
    }
	
	public static void main(String[] argc) {
		IO io = new IOConsole(); //creazione interfaccia concreta
		DiaDia gioco = new DiaDia(io); //La passiamo al gioco
		gioco.gioca();
	}
}