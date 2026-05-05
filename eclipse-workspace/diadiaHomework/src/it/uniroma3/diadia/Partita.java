package it.uniroma3.diadia;
import it.uniroma3.diadia.Ambienti.Labirinto;
import it.uniroma3.diadia.Ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {
	
	/* variabili della classe */
	private Labirinto labirinto; 
	private Stanza stanzaCorrente;
	private boolean finita;
	private Giocatore giocatore;
	
	/* costruttore di partita ,imposta uno stato iniziale */
	public Partita(){
		this.labirinto = new Labirinto();
		this.stanzaCorrente = this.labirinto.getStanzaIniziale();
		this.finita = false;
		this.giocatore = new Giocatore();
	}

    /* metodo per restituzione della stanza vincente */
	public Stanza getStanzaVincente() {
		return this.labirinto.getStanzaFinale();
	}
	/* metodo di inserimento stanza corrente della partita */
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	/* metodo per restituzione stanza corrente */
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta, la partita risulta vinta nel caso
	 * la stanza corrente = stanza vincente.
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita, la partita termina in 3 casi : 
	 * se finite = true, se vinta = 1 o se i cfu=0
	 */
	public boolean isFinita() {
		return finita || vinta() || giocatore.getCfu()==0;
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	/* accessibilità del giocatore */
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
}
