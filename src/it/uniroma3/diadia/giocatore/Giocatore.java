package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Giocatore {
	static final public int CFU_INIZIALI = 20;
	private int cfu;
	private Borsa borsa;
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		borsa = new Borsa();
	}
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}
	public void addOggettoBorsa(Attrezzo attrezzo) {
		this.borsa.addAttrezzo(attrezzo);
	}
	public void prendiOggettoDallaBorsa(Attrezzo attrezzo) {
		this.borsa.removeAttrezzo(attrezzo.getNome());
	}
	public Borsa getBorsa() {
		return this.borsa;
	}
	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
		
		
	}
}

