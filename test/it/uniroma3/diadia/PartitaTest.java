package it.uniroma3.diadia;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PartitaTest {
	private Partita partita;

	@Before
	public void setUp() {
		this.partita = new Partita();
	}

	@Test
	public void testVintaSeStanzaCorrenteEVincente() {
		this.partita.getLabirinto().setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.vinta());
	}
	@Test
	public void testPartitaFinitaSeRisultaFinita() {
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}
	@Test
	public void testPartitaFinitaSeCfuGiocatoreFiniti() {
		this.partita.getGiocatore().getCfu();
		assertTrue(this.partita.isFinita());
	}
}
