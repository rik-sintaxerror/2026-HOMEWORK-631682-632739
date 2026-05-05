// File: ComandoAiuto.java (Package: it.uniroma3.diadia.comandi)
package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;

public class ComandoAiuto implements Comando {
    static final private String[] elencoComandi = {"vai", "aiuto", "prendi", "posa", "fine"};
    private IO io;

    @Override
    public void esegui(Partita partita) {
        String tuttiIComandi = "";
        for(int i=0; i< elencoComandi.length; i++) 
            tuttiIComandi += elencoComandi[i] + " ";
        this.io.mostraMessaggio(tuttiIComandi);
    }
    @Override
    public void setParametro(String parametro) {}
    @Override
    public void setIo(IO io) { this.io = io; }
    @Override
    public String getNome() { return "aiuto"; }
    @Override
    public String getParametro() { return null; }
}