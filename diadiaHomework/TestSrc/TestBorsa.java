import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class TestBorsa {

		@Test
		public void InserimentoAttrezzo () {
			Borsa borsa = new Borsa();
			Attrezzo spada = new Attrezzo("Spada", 10);
			assertTrue(borsa.addAttrezzo(spada));
		}
		
		@Test 
		public void InserimentoBorsaPiena () {
			Borsa borsaPiena = new Borsa ();
			for(int i = 0; i < 10; i++) {
				borsaPiena.addAttrezzo(new Attrezzo("Riempimento",0));
			}
			assertFalse(borsaPiena.addAttrezzo(new Attrezzo("undicesimo",11)));
		}
		
		@Test 
		public void InserimentoPesoSforato () {
			Borsa borsaPesante = new Borsa (10);
			assertFalse(borsaPesante.addAttrezzo(new Attrezzo("pesante",15)));
		}
		
		@Test
		public void restituzioneAttrezzo() {
			Borsa borsaUnAttrezzo = new Borsa();
			borsaUnAttrezzo.addAttrezzo(new Attrezzo ("Spada",10));
			assertEquals("Spada", borsaUnAttrezzo.getAttrezzo("Spada").getNome());
		}
		
		@Test 
		public void getAttrezzoNonEsistente() {
			Borsa borsa = new Borsa();
			assertNull(borsa.getAttrezzo("Inesistente"));
		}
		
		@Test 
		public void rimozioneAttrezzoBorsaUnOggetto () {
			Borsa borsaUnAttrezzo = new Borsa();
			Attrezzo spada = new Attrezzo("Spada",10);
			borsaUnAttrezzo.addAttrezzo(spada);
			assertEquals(spada,borsaUnAttrezzo.removeAttrezzo("Spada"));
		}
		
		@Test 
		public void rimozioneBorsaVuota () {
			Borsa borsaVuota = new Borsa();
			assertNull(borsaVuota.removeAttrezzo("Spada"));
		}
	
		@Test 
		public void rimozioneAttrezzoInesistente () {
			Borsa borsaDueAttrezzi = new Borsa();
			Attrezzo spada = new Attrezzo("Spada",10);
			Attrezzo scudo = new Attrezzo("Scudo",15);
			borsaDueAttrezzi.addAttrezzo(spada);
			borsaDueAttrezzi.addAttrezzo(scudo);
			assertNull(borsaDueAttrezzi.removeAttrezzo("Lampada"));
		}
}
