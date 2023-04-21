package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	private StanzaBloccata sb;
	private Attrezzo a;

	@Before
	public void SetUp() throws Exception {
		sb = new StanzaBloccata("StanzaBloccata", "ovest", "grimaldello");
		a = new Attrezzo("grimaldello",1);
	}
	
	@After
	public void tearDown() throws Exception{
	}
	
	@Test
	public void getStanzaAdiacenteDirezioneSbloccata() {
		sb.addAttrezzo(a);
		assertEquals(sb.toString(),sb.getStanzaAdiacente("ovest"));
	}
	@Test
	public void getStanzaAdiacenteDirezioneBloccata() {
		assertEquals(sb.toString(),sb.getStanzaAdiacente("ovest"));
	}
	@Test
	public void getDescrizioneDirezioneSbloccata() {
		sb.addAttrezzo(a);
		assertEquals(sb.toString(),sb.getStanzaAdiacente("ovest"));
	}
	@Test
	public void getDescrezioneDirezioneBloccata() {
		String x = "Stanza bloccata nella direzione: ovest"+"\nPrendi il grimaldello e posalo nella stanza"; 
		assertEquals(x,sb.getStanzaAdiacente("ovest"));
	}
		
}

