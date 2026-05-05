// File: Comando.java (Package: it.uniroma3.diadia.comandi)
package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;

public interface Comando {
    void esegui(Partita partita);
    void setParametro(String parametro);
    void setIo(IO io);
    String getNome();
    String getParametro();
}

