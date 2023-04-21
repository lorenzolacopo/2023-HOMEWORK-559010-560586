package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
	private String attrezzoLuminoso;
	

	public StanzaBuia(String nome, String attrezzoLuminoso) {
		super(nome);
		this.attrezzoLuminoso = attrezzoLuminoso;
	}
	
	@Override
	public String getDescrizione() {
		String buio = new String();
		buio = "qui c'� un buio pesto";
		if(!this.hasAttrezzo(attrezzoLuminoso)) {
			return buio;
		}
			return super.getDescrizione();
		
	}

	
	

}
