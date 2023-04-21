package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	private String direzioneBloccante;
	private String attrezzoSbloccante;
	
	public StanzaBloccata(String nome, String direzioneBloccante, String attrezzoSbloccante) {
		super(nome);
		this.direzioneBloccante = direzioneBloccante;
		this.attrezzoSbloccante = attrezzoSbloccante;

}
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzioneBloccante.equals(direzione)
		&& !this.hasAttrezzo(attrezzoSbloccante)) {
			return this;
		}
			return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		String descrizione = new String();
		descrizione = "Stanza bloccata nella direzione: "+ direzioneBloccante +"\nPrendi il "
				+ attrezzoSbloccante + "e posalo nella stanza";
		if(!this.hasAttrezzo(attrezzoSbloccante)) {
			return descrizione;
		}
		    return super.getDescrizione();
		}
		
	}
	

