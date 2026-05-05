package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.IOConsole;

public class FabbricaDiComandiFisarmonicaTest {

    private FabbricaDiComandi factory;

    @Before
    public void setUp() {
        // Inizializziamo la fabbrica prima di ogni test
        factory = new FabbricaDiComandiFisarmonica(new IOConsole());
    }

    @Test
    public void testCostruisciComandoConParametro() {
        Comando comando = factory.costruisciComando("vai est");
        
        // Verifichiamo che riconosca il nome e separi correttamente il parametro
        assertEquals("vai", comando.getNome());
        assertEquals("est", comando.getParametro());
    }

    @Test
    public void testCostruisciComandoSenzaParametro() {
        Comando comando = factory.costruisciComando("aiuto");
        
        // Verifichiamo che riconosca il nome e che il parametro sia nullo
        assertEquals("aiuto", comando.getNome());
        assertNull(comando.getParametro());
    }

    @Test
    public void testCostruisciComandoSconosciuto() {
        Comando comando = factory.costruisciComando("salta");
        
        // Verifichiamo che un comando non previsto venga etichettato come sconosciuto
        assertEquals("sconosciuto", comando.getNome());
        assertNull(comando.getParametro());
    }
    
    @Test
    public void testCostruisciComandoVuoto() {
        Comando comando = factory.costruisciComando("");
        
        // Verifichiamo il comportamento con una stringa vuota
        assertEquals("sconosciuto", comando.getNome());
        assertNull(comando.getParametro());
    }
}