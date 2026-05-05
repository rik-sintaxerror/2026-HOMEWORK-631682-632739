package it.uniroma3.diadia.comandi;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.Ambienti.Stanza;
import it.uniroma3.diadia.IOConsole; 

public class ComandoVaiTest {
    private Partita partita;
    private ComandoVai comando;
    private Stanza stanzaPartenza;
    private Stanza stanzaDestinazione;

    @Before
    public void setUp() {
        partita = new Partita();
        comando = new ComandoVai();
        comando.setIo(new IOConsole()); 
        stanzaPartenza = new Stanza("Partenza");
        stanzaDestinazione = new Stanza("Destinazione");
        stanzaPartenza.impostaStanzaAdiacente("nord", stanzaDestinazione);
        partita.setStanzaCorrente(stanzaPartenza);
    }

    @Test
    public void testEseguiDirezioneEsistente() {
        comando.setParametro("nord");
        comando.esegui(partita);
        assertEquals(stanzaDestinazione, partita.getStanzaCorrente());
    }

    @Test
    public void testEseguiDirezioneInesistente() {
        comando.setParametro("sud");
        comando.esegui(partita);
        assertEquals(stanzaPartenza, partita.getStanzaCorrente());
    }
}