package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoPosaTest {
	private Partita p;
	private Comando posa;
	private IO io;

	@Before
	public void SetUp() throws Exception{
		p = new Partita();
		posa = new ComandoPosa();
		io = new IOConsole();
		posa.setIo(io);
	}
	@After
	public void tearDown() throws Exception{
	}
	
	@Test
	public void testAttrezzoPosato() {
		posa.setParametro("martello");
		posa.esegui(p);
		assertTrue(p.getStanzaCorrente().hasAttrezzo("martello"));
	}
	
	@Test
	public void testAttrezzoPosatoNull() {
		posa.setParametro("martello");
		posa.esegui(p);
		assertFalse(p.getStanzaCorrente().hasAttrezzo("martello"));
	}

}
