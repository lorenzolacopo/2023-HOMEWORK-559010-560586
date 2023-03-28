package it.uniroma3.diadia;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	private static final String ATTREZZO = "AttrezzoDiTest";
	private static final String STANZA = "StanzaTest";
	private static final String STANZA_ADIACENTE = "StanzaAdiacente";
	private static final String SUD = "sud";
	
	private Stanza stanza;

	@Before
	public void creaUnaStanzaPerIseguentiTest() {
		this.stanza = new Stanza(STANZA);
	}
	
	@Test
	public void testImpostaStanzaAdiacente() {
		Stanza adiacente = creaStanzaEImpostaAdiacente(this.stanza, STANZA_ADIACENTE, SUD);
		assertEquals(adiacente, this.stanza.getStanzaAdiacente(SUD));
	}
	
	@Test
	public void testCambiaStanzaAdiacente() {
		creaStanzaEImpostaAdiacente(this.stanza, STANZA_ADIACENTE, SUD);
		Stanza nuova = creaStanzaEImpostaAdiacente(this.stanza, "Nuova adiacente", SUD);
		assertEquals(nuova, this.stanza.getStanzaAdiacente(SUD));
	}
	@Test
	public void testAddAttrezzo() {
		Attrezzo attrezzo = new Attrezzo(ATTREZZO, 1);
		this.stanza.addAttrezzo(attrezzo);
		assertEquals(attrezzo,this.stanza.getAttrezzo(ATTREZZO));	
	}
	@Test
	public void testRemoveAttrezzo() {
		new Attrezzo(ATTREZZO, 1);
		this.stanza.removeAttrezzo(ATTREZZO);	
		assertFalse(this.stanza.hasAttrezzo(ATTREZZO));
	}
	
	private Stanza creaStanzaEImpostaAdiacente(Stanza stanzaDiPartenza, String nomeStanzaAdiacente, String direzione) {
		Stanza stanzaAdiacente = new Stanza(nomeStanzaAdiacente);
		stanzaDiPartenza.impostaStanzaAdiacente(direzione, stanzaAdiacente);
		return stanzaAdiacente;
	}

}
