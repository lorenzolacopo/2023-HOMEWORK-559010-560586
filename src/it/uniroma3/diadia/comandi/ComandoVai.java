package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando{
	private String direzione;
	private IO io;
	private static final String NOME = "vai";
	@Override
	public void esegui(Partita partita) {
	Stanza stanzaCorrente = partita.getStanzaCorrente();
	Stanza prossimaStanza = null;
	if (this.direzione==null) {
		io.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
		return;
	}
	
	prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
	 if (prossimaStanza==null) {
		 io.mostraMessaggio("Direzione inesistente");
		 return;
	 }
	 partita.setStanzaCorrente(prossimaStanza);
	 io.mostraMessaggio(partita.getStanzaCorrente().getNome());
	 partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
}
@Override
public void setParametro(String parametro) {
	this.direzione = parametro;
}
@Override
public String getNome() {
	return NOME;
}
@Override
public String getParametro() {
	return this.direzione;
}

@Override
public void setIo(IO io) {
	this.io = io;
}
}


