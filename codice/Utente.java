import java.util.*;

public class Utente implements Stato {
	private String nome;
	private String cognome;
	private String email;
	private String domicilio;
	private String username;
	private long password;
	private int punti;
	private List<String> paroleCercate;
	private Utente next;
	
	public Utente(String nome, String cognome, String email, String domicilio, String username, long password, int punti, List<String> paroleCercate) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.domicilio = domicilio;
		this.username = username;
		this.password = password;
		this.punti = punti;
		this.paroleCercate = paroleCercate;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getDomicilio() {
		return domicilio;
	}
	
	public String getUsername() {
		return username;
	}
	
	public long getPassword() {
		return password;
	}
	
	public List<String> getParoleCercate() {
		return paroleCercate;
	}
	
	public int getPunti() {
		return punti;
	}
	
	public Utente getNext() {
		return next;
	}
	
	public void setNext(Utente utente) {
		next = utente;
	}
	
	public void aggiungiParoleCercate(String argomento) {
		paroleCercate.add(argomento);
	}
	
	public int incrementaPunti(int punteggio) {
		punti += punteggio;
		return punti;
	}
	
	public int decrementaPunti(int punteggio) {
		punti -= punteggio;
		return punti;
	}
	
	public void visualizzaSchermata() {
            Simulatore.setJLabel1("Ciao "+username);
            Simulatore.setJLabel2("Saldo punti: "+punti);
	}
	
}
