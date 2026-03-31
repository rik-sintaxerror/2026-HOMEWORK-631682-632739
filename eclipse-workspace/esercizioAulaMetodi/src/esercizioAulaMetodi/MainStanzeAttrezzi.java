package esercizioAulaMetodi;

public class MainStanzeAttrezzi {
	public static void main(String[] args) {
		attrezzo spada = new attrezzo(); // qui sto creando un nuovo oggetto di tipo attrezzo
		spada.setNome("spada");				// in cui inserisco il nome spada con l'oopportuno metodo
		spada.setPeso(7);					// in cui inserisco un peso con l'ooportuno metodo 
		
		attrezzo osso = new attrezzo(); // stessa cosa qui un nuovo oggetto di tipo attrezzo 
		osso.setNome("osso");			//	inserisco il nome
		osso.setPeso(1);				//	inserisco il peso */
		
		stanza n11 = new stanza();     // creazione oggetto di tipo stanza 
		n11.setNome("N11");				// inserimento del nome 
	
		n11.setattrezzoContenuto(spada); // inserimento dell'attrezzo contenuto
		
		n11.setattrezzoContenuto(osso); // inserimento di un 2 attrezzo contenuto */
	}
}
