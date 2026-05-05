package it.uniroma3.diadia.Ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

    private StanzaBloccata stanzaBloccata;
    private Stanza stanzaOltreIlBlocco;
    private Stanza stanzaLibera;
    private Attrezzo grimaldello;

    @BeforeEach
    public void setUp() {
        // Creiamo la stanza bloccata verso "nord", serve un "grimaldello" per passare
        this.stanzaBloccata = new StanzaBloccata("Cella", "nord", "grimaldello");
        this.stanzaOltreIlBlocco = new Stanza("Corridoio Nord");
        this.stanzaLibera = new Stanza("Corridoio Sud");
        
        this.stanzaBloccata.impostaStanzaAdiacente("nord", this.stanzaOltreIlBlocco);
        this.stanzaBloccata.impostaStanzaAdiacente("sud", this.stanzaLibera);
        
        this.grimaldello = new Attrezzo("grimaldello", 1);
    }

    @Test
    public void testGetStanzaAdiacenteDirezioneBloccataSenzaAttrezzo() {
        assertEquals(this.stanzaBloccata, this.stanzaBloccata.getStanzaAdiacente("nord"), 
            "Andando a nord senza grimaldello, devo rimanere nella stanza bloccata");
    }

    @Test
    public void testGetStanzaAdiacenteDirezioneBloccataConAttrezzo() {
        this.stanzaBloccata.addAttrezzo(this.grimaldello);
        assertEquals(this.stanzaOltreIlBlocco, this.stanzaBloccata.getStanzaAdiacente("nord"), 
            "Avendo il grimaldello nella stanza, devo poter passare a nord");
    }

    @Test
    public void testGetStanzaAdiacenteDirezioneLiberaSenzaAttrezzo() {
        assertEquals(this.stanzaLibera, this.stanzaBloccata.getStanzaAdiacente("sud"), 
            "Andando verso una direzione non bloccata, devo passare anche senza grimaldello");
    }
}
