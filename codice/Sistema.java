import javax.swing.*;

public class Sistema {
	private static Sistema sistema = new Sistema();
	private Stato statoCorrente;
	
	private Sistema() {
		statoCorrente = new UtenteNonLoggato();
	}
	
	public static Sistema getSistema() {
		return sistema;
	}
	
	public Stato getStatoCorrente() {
		return statoCorrente;
	}
	
	public boolean login(String username, long password) throws NullPointerException {
		if (username == null) throw new NullPointerException();
		Utente tmp = ListaUtenti.getListaUtenti().search(username, password);
		if (tmp == null) {
			JOptionPane.showMessageDialog(null, "Username e/o password errati!", "Errore credenziali", 0);
                        return false;
		}
		statoCorrente = tmp;
		visualizzaSchermata();
		return true;
	}
	
	public void logout() {
		statoCorrente = new UtenteNonLoggato();
		visualizzaSchermata();
	}
	
	public void visualizzaSchermata() {
		statoCorrente.visualizzaSchermata();
	}
	
}
