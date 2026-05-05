package it.uniroma3.diadia;

/**
 * Classe che simula l'I/O per facilitare i test automatizzati.
 * Implementa l'interfaccia IO memorizzando gli output in un array
 * e restituendo input predefiniti da un altro array.
 */
public class IOSimulator implements IO {

    private String[] righeDaLeggere;
    private int indiceRigheLette;
    
    private String[] messaggiProdotti;
    private int indiceMessaggiProdotti;

    /**
     * Costruttore che accetta le righe che verranno simulate come input dell'utente.
     * @param righeDaLeggere array di stringhe che simula le letture da tastiera
     */
    public IOSimulator(String[] righeDaLeggere) {
        this.righeDaLeggere = righeDaLeggere;
        this.indiceRigheLette = 0;
        
        // Inizializza un array capiente per conservare i messaggi stampati durante il test
        this.messaggiProdotti = new String[100]; 
        this.indiceMessaggiProdotti = 0;
    }

    @Override
    public String leggiRiga() {
        if (this.righeDaLeggere != null && this.indiceRigheLette < this.righeDaLeggere.length) {
            String rigaLetta = this.righeDaLeggere[this.indiceRigheLette];
            this.indiceRigheLette++;
            return rigaLetta;
        }
        return null;
    }

    @Override
    public void mostraMessaggio(String messaggio) {
        if (this.indiceMessaggiProdotti < this.messaggiProdotti.length) {
            this.messaggiProdotti[this.indiceMessaggiProdotti] = messaggio;
            this.indiceMessaggiProdotti++;
        }
    }

    // --- Metodi extra utili per effettuare le asserzioni (assert) nei Test ---
    
    public String[] getMessaggiProdotti() {
        return this.messaggiProdotti;
    }
    
    public int getIndiceMessaggiProdotti() {
        return this.indiceMessaggiProdotti;
    }

    public boolean hasNextMessaggio() {
        return this.indiceMessaggiProdotti > 0;
    }
}