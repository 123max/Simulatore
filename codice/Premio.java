import javax.swing.*;

public class Premio {
	private String nome;
	private int punteggio;
	private String descrizione;
	private Premio next;
	
	public Premio(String nome, int punteggio, String descrizione) {
		this.nome = nome;
		this.punteggio = punteggio;
		this.descrizione = descrizione;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getPunteggio() {
		return punteggio;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public Premio getNext() {
		return next;
	}
	
	public void setNext(Premio premio) {
		next = premio;
	}
	
	public boolean richiediPremio(Utente utente) throws NullPointerException {
		if (utente == null) throw new NullPointerException();
		if (verificaPunti(utente.getPunti())) {
			JOptionPane.showMessageDialog(null, "Hai richiesto "+nome+"\nTi sono rimasti "+utente.decrementaPunti(punteggio)+" punti!", "Attenzione!", 1);
			Sistema.getSistema().visualizzaSchermata();
                        return true;
		}
		JOptionPane.showMessageDialog(null, "Il numero dei tuoi punti non è sufficiente alla richiesta di "+nome, "Attenzione!", 2);
		return false;
	}
	
	public boolean verificaPunti(int punti) {
		if (punti >= punteggio) return  true;
		return false;
	}
	
	public void visualizzaPremio() {
            Simulatore.setJLabel7("Nome: "+nome);
            Simulatore.setJLabel8("Punteggio: "+punteggio);
            Simulatore.setJLabel9("Descrizione: "+descrizione);
	}
	
}
