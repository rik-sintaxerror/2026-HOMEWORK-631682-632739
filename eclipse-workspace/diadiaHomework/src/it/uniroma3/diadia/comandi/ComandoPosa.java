// File: ComandoPosa.java (Package: it.uniroma3.diadia.comandi)
package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.Ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IO;

public class ComandoPosa implements Comando {
    private String nomeAttrezzo;
    private IO io;

    @Override
    public void esegui(Partita partita) {
        Attrezzo attrezzoDaPosare = partita.getGiocatore().removeAttrezzo(this.nomeAttrezzo);
        if (attrezzoDaPosare != null) {
            Stanza stanzaCorrente = partita.getStanzaCorrente();
            if (stanzaCorrente.addAttrezzo(attrezzoDaPosare)) {
                this.io.mostraMessaggio("Hai posato: " + attrezzoDaPosare.getNome());
            } else {
                this.io.mostraMessaggio("Non c'è spazio in questa stanza per posare l'oggetto!");
                partita.getGiocatore().addAttrezzo(attrezzoDaPosare);
            }
        } else {
            this.io.mostraMessaggio("Non hai l'attrezzo '" + this.nomeAttrezzo + "' nella borsa.");
        }
    }
    @Override
    public void setParametro(String parametro) { this.nomeAttrezzo = parametro; }
    @Override
    public void setIo(IO io) { this.io = io; }
    @Override
    public String getNome() { return "posa"; }
    @Override
    public String getParametro() { return this.nomeAttrezzo; }
}
