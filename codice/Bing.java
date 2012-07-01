import javax.swing.*;

public class Bing extends MotoreDiRicerca {
	
	public Bing(String nome, byte punti, MotoreDiRicerca successor) {
		super(nome, punti, successor);
	}
	
	public void visualizzaRisultato(String argomento) {
		JOptionPane.showMessageDialog(null, getNome()+"\nQuesto è il risultato della ricerca: "+argomento, "Ricerca "+getNome(), 1);
	}
	
}
