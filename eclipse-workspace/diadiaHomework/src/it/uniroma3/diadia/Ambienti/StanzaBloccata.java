package it.uniroma3.diadia.Ambienti;

public class StanzaBloccata extends Stanza {
    
    private String direzioneBloccata;
    private String attrezzoSbloccante;

    public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoSbloccante) {
        super(nome);
        this.direzioneBloccata = direzioneBloccata;
        this.attrezzoSbloccante = attrezzoSbloccante;
    }

    @Override
    public Stanza getStanzaAdiacente(String dir) {
        if (dir.equals(this.direzioneBloccata) && !this.hasAttrezzo(this.attrezzoSbloccante)) {
            return this;
        }
        return super.getStanzaAdiacente(dir);
    }

    @Override
    public String getDescrizione() {
        String descrizionePiena = super.getDescrizione();
        if (!this.hasAttrezzo(this.attrezzoSbloccante)) {
            descrizionePiena += "\nAttenzione: la direzione " + this.direzioneBloccata + 
                                " è bloccata. Ti serve l'oggetto: " + this.attrezzoSbloccante;
        }
        return descrizionePiena;
    }
}