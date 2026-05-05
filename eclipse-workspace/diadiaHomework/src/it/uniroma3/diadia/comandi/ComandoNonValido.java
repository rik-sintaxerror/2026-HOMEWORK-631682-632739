// File: ComandoNonValido.java (Package: it.uniroma3.diadia.comandi)
package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;

public class ComandoNonValido implements Comando {
    private IO io;

    @Override
    public void esegui(Partita partita) {
        this.io.mostraMessaggio("Comando sconosciuto");
    }
    @Override
    public void setParametro(String parametro) {}
    @Override
    public void setIo(IO io) { this.io = io; }
    @Override
    public String getNome() { return "sconosciuto"; }
    @Override
    public String getParametro() { return null; }
}
