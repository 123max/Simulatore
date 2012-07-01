import javax.swing.*;

public class Volunia extends MotoreDiRicerca {
	
	public Volunia(String nome, byte punti, MotoreDiRicerca successor) {
		super(nome, punti, successor);
	}
	
	public void visualizzaRisultato(String argomento) {
		JOptionPane.showMessageDialog(null, getNome()+"\nEcco il risultati inerenti a: "+argomento, "Ricerca "+getNome(), 1);
	}
	
}
