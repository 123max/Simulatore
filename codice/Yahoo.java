import javax.swing.*;

public class Yahoo extends MotoreDiRicerca {
	
	public Yahoo(String nome, byte punti, MotoreDiRicerca successor) {
		super(nome, punti, successor);
	}
	
	public void visualizzaRisultato(String argomento) {
		JOptionPane.showMessageDialog(null, getNome()+"\nVisualizzati i risultati di: "+argomento, "Ricerca "+getNome(), 1);
	}
	
}
