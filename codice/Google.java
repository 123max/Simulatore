import javax.swing.*;

public class Google extends MotoreDiRicerca {
	
	public Google(String nome, byte punti, MotoreDiRicerca successor) {
		super(nome, punti, successor);
	}
	
	public void visualizzaRisultato(String argomento) {
		JOptionPane.showMessageDialog(null, getNome()+"\nRicerca effettuata correttamente di: "+argomento, "Ricerca "+getNome(), 1);
	}
	
}
