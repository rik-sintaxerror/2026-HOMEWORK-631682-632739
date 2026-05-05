// File: DiaDia.java (Package: it.uniroma3.diadia)
package it.uniroma3.diadia;

import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadia.comandi.Comando;

public class DiaDia {

    static final private String MESSAGGIO_BENVENUTO = ""+
            "Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
            "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
            "I locali sono popolati da strani personaggi, " +
            "alcuni amici, altri... chissa!\n"+
            "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
            "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
            "o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
            "Per conoscere le istruzioni usa il comando 'aiuto'.";

    private Partita partita;
    private IO io;
    
    public DiaDia(IO io) {
        this.partita = new Partita();
        this.io = io;
    }

    public void gioca() {
        String istruzione; 
        this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
        do {		
            istruzione = this.io.leggiRiga();
        } while (!processaIstruzione(istruzione));
    }   

    private boolean processaIstruzione(String istruzione) {
        Comando comandoDaEseguire;
        FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica(this.io);
        comandoDaEseguire = factory.costruisciComando(istruzione);
        
        comandoDaEseguire.esegui(this.partita);
        
        if (this.partita.vinta()) {
            this.io.mostraMessaggio("Hai vinto!");
            return true;
        } else {
            return this.partita.isFinita();
        }
    }   

    public static void main(String[] argc) {
        IO io = new IOConsole(); // Assicurati di avere la classe IOConsole
        DiaDia gioco = new DiaDia(io);
        gioco.gioca();
    }
}