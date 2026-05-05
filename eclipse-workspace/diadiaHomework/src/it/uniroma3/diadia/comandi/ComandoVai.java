// File: ComandoVai.java (Package: it.uniroma3.diadia.comandi)
package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.Ambienti.Stanza;
import it.uniroma3.diadia.IO;

public class ComandoVai implements Comando {
    private String direzione;
    private IO io;

    @Override
    public void esegui(Partita partita) {
        if (this.direzione == null) {
            this.io.mostraMessaggio("Dove vuoi andare ?");
            return;
        }
        Stanza prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(this.direzione);
        if (prossimaStanza == null) {
            this.io.mostraMessaggio("Direzione inesistente");
            return;
        } else {
            partita.setStanzaCorrente(prossimaStanza);
            partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
            this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
        }
    }
    @Override
    public void setParametro(String parametro) { this.direzione = parametro; }
    @Override
    public void setIo(IO io) { this.io = io; }
    @Override
    public String getNome() { return "vai"; }
    @Override
    public String getParametro() { return this.direzione; }
}
