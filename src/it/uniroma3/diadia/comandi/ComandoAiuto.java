package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	private static final String NOME = "aiuto";
	private static final String[] ELENCO_COMANDI = {"vai","aiuto","fine","prendi","posa","guarda"};
	private IO io;
	

	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< ELENCO_COMANDI.length; i++) 
			io.mostraMessaggio(ELENCO_COMANDI[i]+" ");
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
