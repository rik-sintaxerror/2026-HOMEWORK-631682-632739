// File: ComandoPrendi.java (Package: it.uniroma3.diadia.comandi)
package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.Ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IO;

public class ComandoPrendi implements Comando {
    private String nomeAttrezzo;
    private IO io;

    @Override
    public void esegui(Partita partita) {
        Stanza stanzaCorrente = partita.getStanzaCorrente();
        Attrezzo attrezzo = stanzaCorrente.getAttrezzo(this.nomeAttrezzo);
        if (attrezzo != null) {
            if (partita.getGiocatore().addAttrezzo(attrezzo)) {
                stanzaCorrente.removeAttrezzo(attrezzo);
                this.io.mostraMessaggio("Hai raccolto: " + attrezzo.toString());
            } else {
                this.io.mostraMessaggio("Non puoi prendere l'attrezzo: borsa piena o troppo pesante!");
            }
        } else {
            this.io.mostraMessaggio("L'attrezzo '" + this.nomeAttrezzo + "' non è qui.");
        }
    }
    @Override
    public void setParametro(String parametro) { this.nomeAttrezzo = parametro; }
    @Override
    public void setIo(IO io) { this.io = io; }
    @Override
    public String getNome() { return "prendi"; }
    @Override
    public String getParametro() { return this.nomeAttrezzo; }
}