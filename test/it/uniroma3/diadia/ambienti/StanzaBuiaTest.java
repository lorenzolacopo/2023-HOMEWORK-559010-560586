package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	private StanzaBuia stanza;
	private Attrezzo torcia;
	
	@Before
	public void SetUp() throws Exception {
		stanza = new StanzaBuia("StanzaBuia", "torcia");
		torcia = new Attrezzo("torcia",1);
	}
	
	@After
	public void tearDown() throws Exception{
	}
	
	@Test
	public void testGetDescrizioneConAttrezzo() {
		stanza.addAttrezzo(torcia);
		assertEquals(stanza.toString(),stanza.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneSenzaAttrezzo() {
		String x = "qui c'è un buio pesto";
		assertEquals(x,stanza.getDescrizione());
	}

}
