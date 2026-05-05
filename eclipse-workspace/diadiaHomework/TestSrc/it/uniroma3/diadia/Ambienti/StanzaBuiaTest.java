package it.uniroma3.diadia.Ambienti;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

    private StanzaBuia stanzaBuia;
    private Attrezzo lanterna;

    @BeforeEach
    public void setUp() {
        // Creiamo una stanza buia che richiede una "lanterna" per vedere
        this.stanzaBuia = new StanzaBuia("Cantina Oscura", "lanterna");
        this.lanterna = new Attrezzo("lanterna", 1);
    }

    @Test
    public void testGetDescrizioneSenzaAttrezzo() {
        assertEquals("qui c'è un buio pesto", this.stanzaBuia.getDescrizione(), 
            "Senza l'attrezzo richiesto la stanza deve restituire la stringa di buio pesto");
    }

    @Test
    public void testGetDescrizioneConAttrezzo() {
        this.stanzaBuia.addAttrezzo(this.lanterna);
        assertNotEquals("qui c'è un buio pesto", this.stanzaBuia.getDescrizione(), 
            "Con l'attrezzo presente la stanza non deve più essere buia");
    }
}