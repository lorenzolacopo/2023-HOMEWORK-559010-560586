package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {
	private static final String NOME = "fine";
	private IO io;

	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	@Override
	public String getNome() {
		return NOME;
	}

	@Override
	public String getParametro() {
		return null;
	}

	@Override
	public void setParametro(String parametro) {
	}
     
	@Override
	public void setIo(IO io) {
		this.io = io;
	}
}
