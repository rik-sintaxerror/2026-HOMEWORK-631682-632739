import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Ambienti.Labirinto;

class TestLabirinto {
	private Labirinto labirinto;
	@BeforeEach
	public void setUp() {
		 this.labirinto = new Labirinto();
	}
	@Test
	/* test su metodo setStanzaIniziale */
	public void stanzaIniziale ()  {
		assertEquals("Atrio",labirinto.getStanzaIniziale().getNome());
	}
	@Test
	/* Test su setStanzaFinale */
	public void stanzaFinale () {
		assertEquals("Biblioteca",labirinto.getStanzaFinale().getNome());
	}
	@Test 
	/* Test su addAttrezzo stanza esatta */
	public void addAttrezzo () {
		assertEquals("osso",labirinto.getStanzaIniziale().getAttrezzi()[0].getNome());
	}
}
