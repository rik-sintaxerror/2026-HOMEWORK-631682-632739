import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestLabirinto {
	private Labirinto labirinto;
	@BeforeEach
	public void setUp() {
		 this.labirinto = new Labirinto();
	}
	@Test
	public void stanzaIniziale ()  {
		assertEquals("Atrio",labirinto.getStanzaIniziale().getNome());
	}
	@Test
	public void stanzaFinale () {
		assertEquals("Biblioteca",labirinto.getStanzaFinale().getNome());
	}
	@Test 
	public void addAttrezzo () {
		assertEquals("osso",labirinto.getStanzaIniziale().getAttrezzi()[0].getNome());
	}
}
