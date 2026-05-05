package it.uniroma3.diadia.Ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {

    private StanzaMagica stanzaSogliaBassa;
    private Attrezzo attrezzoNormale;
    private Attrezzo attrezzoDaModificare;

    @BeforeEach
    public void setUp() {
        // Creiamo una stanza con soglia 1 per testare subito l'effetto magico
        this.stanzaSogliaBassa = new StanzaMagica("Stanza Incantata", 1);
        
        this.attrezzoNormale = new Attrezzo("spada", 2);
        this.attrezzoDaModificare = new Attrezzo("scudo", 3);
    }

    @Test
    public void testAddAttrezzoSottoSogliaMagica() {
        // Aggiungiamo il primo attrezzo: non deve subire modifiche perché la soglia è 1
        this.stanzaSogliaBassa.addAttrezzo(this.attrezzoNormale);
        
        assertTrue(this.stanzaSogliaBassa.hasAttrezzo("spada"), 
            "L'attrezzo posato prima della soglia deve mantenere il nome originale");
        assertFalse(this.stanzaSogliaBassa.hasAttrezzo("adaps"));
    }

    @Test
    public void testAddAttrezzoSopraSogliaMagica() {
        // Primo attrezzo (raggiunge la soglia di 1)
        this.stanzaSogliaBassa.addAttrezzo(this.attrezzoNormale);
        
        // Secondo attrezzo (supera la soglia, attiva la magia)
        this.stanzaSogliaBassa.addAttrezzo(this.attrezzoDaModificare);
        
        // Verifichiamo che "scudo" non esista più e sia diventato "oducs"
        assertFalse(this.stanzaSogliaBassa.hasAttrezzo("scudo"), 
            "L'attrezzo originale non deve più esistere nella stanza");
        assertTrue(this.stanzaSogliaBassa.hasAttrezzo("oducs"), 
            "Il nome dell'attrezzo aggiunto oltre la soglia deve essere invertito");
        
        // Verifichiamo che il peso sia stato raddoppiato (3 * 2 = 6)
        Attrezzo attrezzoMagico = this.stanzaSogliaBassa.getAttrezzo("oducs");
        assertNotNull(attrezzoMagico);
        assertEquals(6, attrezzoMagico.getPeso(), 
            "Il peso dell'attrezzo aggiunto oltre la soglia deve essere raddoppiato");
    }
}