package it.uniroma3.diadia.comandi;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.Ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IOConsole;

public class ComandoPrendiTest {
    private Partita partita;
    private ComandoPrendi comando;
    private Stanza stanza;
    private Attrezzo attrezzo;

    @Before
    public void setUp() {
        partita = new Partita();
        comando = new ComandoPrendi();
        comando.setIo(new IOConsole());
        stanza = new Stanza("StanzaTest");
        attrezzo = new Attrezzo("martello", 2);
        stanza.addAttrezzo(attrezzo);
        partita.setStanzaCorrente(stanza);
    }

    @Test
    public void testEseguiPrendiAttrezzoPresente() {
        comando.setParametro("martello");
        comando.esegui(partita);
        assertFalse(stanza.hasAttrezzo("martello"));
        assertTrue(partita.getGiocatore().hasAttrezzo("martello"));
    }

    @Test
    public void testEseguiPrendiAttrezzoAssente() {
        comando.setParametro("chiave");
        comando.esegui(partita);
        assertFalse(partita.getGiocatore().hasAttrezzo("chiave"));
    }
}
