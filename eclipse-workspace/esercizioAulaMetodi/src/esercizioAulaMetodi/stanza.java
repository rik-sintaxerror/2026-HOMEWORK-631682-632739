package esercizioAulaMetodi;

public class stanza {
	 private String nome;
	 private stanza stanzaAdiacente;
	 private attrezzo attrezzoContenuto;
	 
	 public String getNome() {
		 return nome;
	 }
	 
	 public stanza getstanzaAdiacente() {
		 return stanzaAdiacente;
	 }
	 
	 public attrezzo getattrezzoContenuto() {
		 return attrezzoContenuto;
	 }
	 
	 public void setNome(String nuovo_nome) {
		 nome = nuovo_nome;
	 }
	 public void  setstanzaAdiacente(stanza nome_stanza) {
		 stanzaAdiacente = nome_stanza;
	 }
	 public void setattrezzoContenuto(attrezzo nome) {
		 attrezzoContenuto = nome;
	 }
	 
}
