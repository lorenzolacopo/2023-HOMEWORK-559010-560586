package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {

	private static final String NOME = "non valido";
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
	     io.mostraMessaggio("Comando non valido");

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
		// TODO Auto-generated method stub

	}
	
	@Override
	public void setIo(IO io) {
		this.io = io;
	}

}
