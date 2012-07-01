import java.util.*;
import javax.swing.*;

public abstract class MotoreDiRicerca implements Observer {
	private String nome;
	private byte punti;
	private List<String> blacklist;
	private MotoreDiRicerca successor;
	
	public MotoreDiRicerca(String nome, byte punti, MotoreDiRicerca successor) {
		this.nome = nome;
		this.punti = punti;
		this.successor = successor;
		blacklist = new ArrayList<String>();
	}
	
	public String getNome() {
		return nome;
	}
	
	public byte getPunti() {
		return punti;
	}
	
	public List<String> getBlacklist() {
		return blacklist;
	}
	
	public MotoreDiRicerca getSuccessor() {
		return successor;
	}
	
	public void update(Observable o, Object arg) {
		String str[] = Configuratore.getConfiguratore().getDatiBlacklist().split(";");
		for (int i=0; i<str.length; i++) {
			blacklist.add(str[i]);
		}
	}
	
	public void ricerca(String argomento, String nomeMotore, Utente utente) throws NullPointerException {
		if (argomento == null || nomeMotore == null || utente == null) throw new NullPointerException();
		if (!nomeMotore.equals(nome)) successor.ricerca(argomento, nomeMotore, utente);
		else {                    
			visualizzaRisultato(argomento);
                        for (int i=0; i<blacklist.size(); i++) {
				if (argomento.equals(blacklist.get(i))) {
					JOptionPane.showMessageDialog(null, "Per questa ricerca non ti sono stati accreditati punti perchè hai inserito termini non consentiti!", "Attenzione!", 2);
					return;
				}
			}
			List<String> str = utente.getParoleCercate();
			for (int i=0; i<str.size(); i++) {
				if (argomento.equals(str.get(i))) {
					JOptionPane.showMessageDialog(null, "Per questa ricerca non ti sono stati accreditati punti perchè da te effettuata in passato e quindi già presente nel tuo profilo!", "Attenzione!", 2);
					return;
				}
			}
                        JOptionPane.showMessageDialog(null, "Per questa ricerca ti "+(punti==1 ? "è stato attribuito " : "sono stati attribuiti ")+punti+(punti==1 ? " punto" : " punti")+".\nIl tuo nuovo punteggio è "+utente.incrementaPunti(punti)+" punti!", "Attenzione!", 1);
			utente.aggiungiParoleCercate(argomento);
                        Sistema.getSistema().visualizzaSchermata();
		}
	}
	
	public abstract void visualizzaRisultato(String argomento);
	
}
