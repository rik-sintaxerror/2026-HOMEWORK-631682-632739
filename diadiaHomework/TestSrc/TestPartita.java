import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class TestPartita {
	@Test
	
	/* test su funzione setstanzaCorrente */
	public void ImpostaStanze() {
		
		// 1. Arrange : imposto stato iniziale
		Partita partita = new Partita();
		Stanza atrio = new Stanza("Atrio");
		partita.setStanzaCorrente(atrio);
		
		
		
		// 3. Assert : controlliamo
		assertEquals(atrio, partita.getStanzaCorrente());
	}
	
	@Test 
	/* coontrollo funzione vinta () */
	public void StanzeUguali() {
		
		// 1. Arrange: set stato iniziale
		Partita partita = new Partita();
		partita.setStanzaCorrente(partita.getStanzaVincente());
		
		assertTrue(partita.vinta());
	}
	
	@Test 
	/* test su vinta() = false */
	public void StanzeDiverse() {
		
		// 1. Arrange : stato inziale
		Partita partita = new Partita();
		Stanza atrio = new Stanza("Atrio");
		partita.setStanzaCorrente(atrio);
		
		assertFalse(partita.vinta());
	}
	
	/* test metodo isFinita su cfu = 0 */
	@Test
	public void checkCfu() {
		
		//stato iniziale
		Partita partita = new Partita();
		partita.setCfu(0);
		
		//controllo
		assertTrue(partita.isFinita());
	}
	
	@Test
	/* Test su partita non finita */
	public void finitaFalse() {
		
		//stato iniziale
		Partita partita = new Partita();
		partita.setFinita();
		
		//controllo
		assertTrue(partita.isFinita());
	}
	
	@Test
	/* Test su partita vinta */
	public void partitaVinta() {
		
		// 1. Arrange: set stato iniziale
		Partita partita = new Partita();
		partita.setStanzaCorrente(partita.getStanzaVincente());
		
		//controllo
		assertTrue(partita.isFinita());
				
	}
}