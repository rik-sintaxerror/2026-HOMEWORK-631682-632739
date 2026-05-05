package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PartitaTest {

    /**
     * Test di accettazione che verifica il comando "fine" immediato.
     */
    @Test
    public void testPartitaTerminataConFine() {
        // Prepariamo i comandi da "digitare" in sequenza
        String[] comandiDaEseguire = {"fine"};
        IOSimulator io = new IOSimulator(comandiDaEseguire);
        
        // Avviamo il gioco passandogli la nostra finta tastiera/schermo
        DiaDia gioco = new DiaDia(io);
        gioco.gioca();
        
        // Verifichiamo che tra i messaggi stampati ci sia quello di chiusura
        assertTrue(this.contieneMessaggio("Grazie di aver giocato", io.getMessaggiProdotti(), io.getIndiceMessaggiProdotti()), 
            "Il messaggio di fine gioco deve essere stampato se l'utente inserisce 'fine'");
    }

    /**
     * Test di accettazione per una sequenza di movimenti.
     * N.B. Modifica "vai nord" con una direzione valida per il tuo labirinto iniziale
     * e cambia la stringa attesa con il nome della stanza in cui dovresti finire.
     */
    @Test
    public void testEsplorazioneStanza() {
        String[] comandiDaEseguire = {"vai nord", "fine"};
        IOSimulator io = new IOSimulator(comandiDaEseguire);
        
        DiaDia gioco = new DiaDia(io);
        gioco.gioca();
        
        // Esempio: controlliamo se il gioco ha stampato la descrizione di una nuova stanza
        // Adatta "Aula N11" al nome effettivo della stanza a nord del tuo ambiente iniziale
        assertTrue(this.contieneMessaggio("Biblioteca", io.getMessaggiProdotti(), io.getIndiceMessaggiProdotti()), 
            "La console dovrebbe stampare il nome della stanza di destinazione dopo un movimento");
    }

    /**
     * Metodo privato di supporto per cercare una sottostringa nell'array dei messaggi.
     * Rende le asserzioni molto più semplici e robuste.
     */
    private boolean contieneMessaggio(String messaggioAtteso, String[] messaggiProdotti, int indiceMax) {
        for (int i = 0; i < indiceMax; i++) {
            if (messaggiProdotti[i] != null && messaggiProdotti[i].contains(messaggioAtteso)) {
                return true;
            }
        }
        return false;
    }
}