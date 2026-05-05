package it.uniroma3.diadia.comandi;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.Ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IOConsole;

public class ComandoPosaTest {
    private Partita partita;
    private ComandoPosa comando;
    private Stanza stanza;
    private Attrezzo attrezzo;

    @Before
    public void setUp() {
        partita = new Partita();
        comando = new ComandoPosa();
        comando.setIo(new IOConsole());
        stanza = new Stanza("StanzaTest");
        attrezzo = new Attrezzo("martello", 2);
        partita.getGiocatore().addAttrezzo(attrezzo); // Metto l'oggetto in borsa prima del test
        partita.setStanzaCorrente(stanza);
    }

    @Test
    public void testEseguiPosaAttrezzoPresenteInBorsa() {
        comando.setParametro("martello");
        comando.esegui(partita);
        assertTrue(stanza.hasAttrezzo("martello"));
        assertFalse(partita.getGiocatore().hasAttrezzo("martello"));
    }

    @Test
    public void testEseguiPosaAttrezzoAssenteInBorsa() {
        comando.setParametro("chiave");
        comando.esegui(partita);
        assertFalse(stanza.hasAttrezzo("chiave"));
    }
}