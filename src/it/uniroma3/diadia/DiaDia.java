package it.uniroma3.diadia;
import it.uniroma3.diadia.IOConsole.IOConsole;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

//import java.util.Scanner;



/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */


public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private Giocatore giocatore;
	private IOConsole io;

	public DiaDia(IOConsole io) {
		this.giocatore = new Giocatore();
		this.partita = new Partita();
		this.io = io;
	}

	public void gioca() {
		String istruzione; 

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		do		
			istruzione = this.io.leggiRiga();
		while (!processa(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processa(String istruzione) {
		Comando comando = new Comando(istruzione);
		
		String nome = comando.getNome();
		if(nome == null) {
			io.mostraMessaggio("Devi digitare un comando!");
			return false;	
		}
		
		if (nome.equals("fine")) {
			this.fine(); 
			return true;
		} else if (nome.equals("vai"))
			this.vai(comando.getParametro());
		else if (nome.equals("aiuto"))
			this.aiuto();
		else if(nome.equals("prendi"))
			this.prendi(comando.getParametro());
		else if(nome.equals("posa")) 
			this.posa(comando.getParametro());
		else
			io.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	private void posa(String nomeAttrezzo) {
		if(nomeAttrezzo == null)
			io.mostraMessaggio("Che attrezzo vuoi possare?");
		Attrezzo attrezzoDaPosare = this.giocatore.getBorsa().getAttrezzo(nomeAttrezzo);
		if(attrezzoDaPosare != null) {
			this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzoDaPosare);
			this.giocatore.prendiOggettoDallaBorsa(attrezzoDaPosare);
			io.mostraMessaggio("Ho posato l'attrezzo " + attrezzoDaPosare.getNome());
		}
		else
			io.mostraMessaggio("Attrezzo non presente");
		
	}

	private void prendi(String nomeAttrezzo) {
		if(nomeAttrezzo == null)
			io.mostraMessaggio("Che attrezzo vuoi prendere?");
		Attrezzo attrezzoDaPrendere = this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(attrezzoDaPrendere != null) {
			this.giocatore.addOggettoBorsa(attrezzoDaPrendere);
			this.partita.getLabirinto().getStanzaCorrente().removeAttrezzo(nomeAttrezzo);
			io.mostraMessaggio("Ho preso l'attrezzo " + attrezzoDaPrendere.getNome());
		}
		else
			io.mostraMessaggio("Attrezzo non presente");
		
	}

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		Stanza stanzaCorrente = this.partita.getLabirinto().getStanzaCorrente();
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente\n");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.giocatore.setCfu(cfu--);
		}
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole ioConsole = new IOConsole();
		DiaDia gioco = new DiaDia(ioConsole);
		gioco.gioca();
	}
}