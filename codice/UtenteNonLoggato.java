public class UtenteNonLoggato implements Stato {
	
	public UtenteNonLoggato() {}
	
	public void visualizzaSchermata() {
            Simulatore.setJLabel1("Ciao visitatore");
            Simulatore.setJLabel2("Effettua il login per accedere ai nostri servizi!");
	}
	
}
