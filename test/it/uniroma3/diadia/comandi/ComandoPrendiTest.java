package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {
	private Partita p;
	private Attrezzo a;
	private Comando prendi;
	private IO io;

	@Before
	public void SetUp() throws Exception{
		p = new Partita();
		a = new Attrezzo("martello",2);
		prendi = new ComandoPosa();
		io = new IOConsole();
		prendi.setIo(io);
	}
	@After
	public void tearDown() throws Exception{
	}
	
	private boolean attrezzoPresente(String s) {
		Attrezzo[] array = p.getStanzaCorrente().getAttrezzi();
		for(Attrezzo a : array) {
			if(a!=null && s.equals(a.getNome()))
				return true;
		}
		return false;
	}

	@Test
	public void testAttrezzoPreso() {
		p.getStanzaCorrente().addAttrezzo(a);
		prendi.setParametro("martello");
		prendi.esegui(p);
		assertTrue(attrezzoPresente("martello"));
	}
	
	@Test
	public void testAttrezzoNonPresente() {
		prendi.setParametro("martello");
		prendi.esegui(p);
		assertFalse(attrezzoPresente("martello"));
		
	}

}
