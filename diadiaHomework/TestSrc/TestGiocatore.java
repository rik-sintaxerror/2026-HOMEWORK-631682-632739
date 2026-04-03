import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

class TestGiocatore {
	
	private Giocatore giocatore;
	
	@BeforeEach
	public void setUp() {
		this.giocatore = new Giocatore();
	}

	@Test
	/* controllo stato iniziale giocatore (costruttore) */
	public void CfuInizialiEsatti () {
		assertEquals(20,this.giocatore.getCfu());
	}
	
	@Test
	/* controllo instanziamento borsa interna */
	public void BorsaInstanziata () {
		assertNotNull(this.giocatore.getBorsa());
	}
	
	@Test
	/* controllo su set cfu */
	public void InserimentoCfu () {
		this.giocatore.setCfu(10);
		assertEquals(10, this.giocatore.getCfu());
	}
	
	@Test 
	/* controllo inserimento attrezzo */
	public void InserimentoAttrezzo () {
		Attrezzo spada = new Attrezzo("Spada",10);
		this.giocatore.addAttrezzo(spada);
		assertTrue(this.giocatore.hasAttrezzo("Spada"));
	}
	
	@Test 
	/* controllo rimozione */
	public void RimozioneAttrezzo () {
		Attrezzo spada = new Attrezzo("Spada",10);
		this.giocatore.addAttrezzo(spada);
		this.giocatore.removeAttrezzo("Spada");
		assertNull(this.giocatore.getAttrezzo("Spada"));
	}
}
