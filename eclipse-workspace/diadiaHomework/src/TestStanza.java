

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestStanza {
	
	@Test
	
	public void testAddAttrezzo_StanzaVuota () {
		
		//1. Arrange : Creiamo lo stato iniziale più semplice possibile 
		Stanza stanza = new Stanza("Ingresso");
		Attrezzo spada = new Attrezzo("Spada",10);
		
		// 2. Act : Richiamiamo il metodo da testare
		boolean risultato = stanza.addAttrezzo(spada);
		
		// 3. Assert : Controlliamo che le aspettative siano rispettate
		assertTrue(risultato); // verifica inserimento ha rest true
		assertTrue(stanza.hasAttrezzo("Spada")); //verifica che stanza conosca l'attrezzo
	}
	
	@Test
	
	public void testAddAttrezzo_StanzaPiena () {
		
		// 1. Arrange : creiamo uno stato iniziale semplice
		Stanza stanza = new Stanza("Ingresso");
		for(int i = 0; i < 10; i++) {
			Attrezzo attrezzo = new Attrezzo("Oggetto"+i, 1);
			stanza.addAttrezzo(attrezzo);
		}
		
		// prepariamo l'11 attrezzo
		Attrezzo attrezzoInPiu = new Attrezzo("Palla", 60);
		
		// 2. Act : inseriamo l'11 attrezzo
		boolean risultato = stanza.addAttrezzo(attrezzoInPiu);
		
		// 3 Assert : verifichiamo
		assertFalse(risultato);
	}
	
	@Test
	
	public void testaddAttrezzo_Inserimenti() {
		
		// 1. Arrange : stato iniziale
		Stanza stanza = new Stanza("Ingresso");
		Attrezzo spada = new Attrezzo("Spada", 10);
		Attrezzo scudo = new Attrezzo("Scudo", 20);
		
		// 2. Act : inseriamo gli attrezzi 
		boolean risultato1 = stanza.addAttrezzo(spada);
		boolean risultato2 = stanza.addAttrezzo(scudo);
		
		// 3. Assert : verifichiamo
		assertTrue(risultato1);
		assertTrue(risultato2);
		assertTrue(stanza.hasAttrezzo("Spada"));
		assertTrue(stanza.hasAttrezzo("Scudo"));
	}
	
	@Test
	
	public void testimpostaStanzaAdiacente_NoDirezione() {
		
		// 1. Arrange : stato iniziale
		Stanza stanzaPartenza = new Stanza("Ingresso"); 
		Stanza stanzaAdiacente = new Stanza("n11"); 
		
		// 2. Act : inseriamo la stanza nella direzione
		stanzaPartenza.impostaStanzaAdiacente("Nord", stanzaAdiacente);
		
		// 3. Assert : verifichiamo
		assertEquals(stanzaAdiacente, stanzaPartenza.getStanzaAdiacente("Nord"));
	}
	
	@Test
	
	public void testimpostaStanzaAdiacente_DirezioneOccupata() {
		
		// 1. Arrange : stato iniziale
		Stanza stanzaPartenza = new Stanza("Ingresso"); 
		Stanza stanzaAdiacente = new Stanza("n11"); 
		Stanza nuovaStanza = new Stanza("n18");
		stanzaPartenza.impostaStanzaAdiacente("Nord", stanzaAdiacente);
		
		//2. Act : sovrasciviamo
		stanzaPartenza.impostaStanzaAdiacente("Nord", nuovaStanza);
		
		// 3. Assert : verifichiamo
		assertEquals(nuovaStanza, stanzaPartenza.getStanzaAdiacente("Nord"));	
	}
	
	@Test 
	
	public void testimpostaStanzaAdiacente_DirezioniEsaurite() {
		
		//1. Arrange : stato iniziale
		Stanza stanzaPartenza = new Stanza("Ingresso");
		Stanza stanza1 = new Stanza("n11");
		Stanza stanza2 = new Stanza("Aula Campus");
		Stanza stanza3 = new Stanza("Segreteria");
		Stanza stanza4 = new Stanza("n1");
		Stanza stanza5 = new Stanza("Bagno");
		
		// inserimento nelle direzioni delle stanze
		stanzaPartenza.impostaStanzaAdiacente("Nord", stanza1);
		stanzaPartenza.impostaStanzaAdiacente("Est", stanza2);
		stanzaPartenza.impostaStanzaAdiacente("Ovest", stanza3);
		stanzaPartenza.impostaStanzaAdiacente("Sud", stanza4);
		
		// 2. Act : inseriamo la 5 direzione
		stanzaPartenza.impostaStanzaAdiacente("Nord-Ovest", stanza5);
		
		// 3. Assert : verifichiamo
		assertNull(stanzaPartenza.getStanzaAdiacente("Nord-Ovest"));
	}
}	