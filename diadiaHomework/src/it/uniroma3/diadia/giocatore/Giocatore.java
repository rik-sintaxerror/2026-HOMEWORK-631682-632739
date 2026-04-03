package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Giocatore {
	static final private int CFU_INIZIALI = 20; //cfu di partenza della partita
	
	private int cfu;
	private Borsa borsa;
	
	/* Costruttore stato iniziale */
	public Giocatore () {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}
	
	/* ritorna il numero dei cfu correnti */
	public int getCfu() {
		return this.cfu;
	}
	
	/* metodo di setting dei cfu */
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}
	
	/* metodo di aggiunta attrezzo */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		return this.borsa.addAttrezzo(attrezzo);
	}
	
	/* metodo di estrazione/ispezione oggetti */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.borsa.getAttrezzo(nomeAttrezzo);
	}
	
	/* metodo giocatore su hasAttrezzo */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.borsa.hasAttrezzo(nomeAttrezzo);
	}
	
	/* metodo removeAttrezzo */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		return this.borsa.removeAttrezzo(nomeAttrezzo);
	}
	
	/* metodo per ricevere la borsa */
	public Borsa getBorsa() {
		return this.borsa;
	}
}
