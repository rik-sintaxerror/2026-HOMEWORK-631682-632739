
public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	
	/* costruttore borsa imposta il peso a 10 */
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	/* costruttore per impostazione delle borsa 
	 * @param pesoMax quantita max contenibile ? 
	 */
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}
	/* metodo aggiunta attrezzo alla borsa */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
				return false;
		if (this.numeroAttrezzi==10)
				return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
	/* restituisce il pesoMax impostato */
	public int getPesoMax() {
		return pesoMax;
	}
	/* metodo di restituzione attrezzi nella borsa */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];
		return a;
	}
	/* metodo restituzione peso della borsa 
	 * si incrementa con l'aggiunta di attrezzi
	*/
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();
		return peso;
	}
	/* metodo di controllo se borsa è vuota */
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	/* controllo se ha un attrezzo */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	/* rimozione attrezzo da stanza */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		// ---> TODO (implementare questo metodo) <---
		return a;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
				s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
				for (int i= 0; i<this.numeroAttrezzi; i++)
					s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}
