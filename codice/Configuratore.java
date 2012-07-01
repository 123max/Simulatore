import java.util.*;
import java.io.*;

public class Configuratore extends Observable {
	private static Configuratore configuratore = new Configuratore();
	private List<String> datiUtenti;
	private List<String> datiPremi;
	private String datiBlacklist;
	
	private Configuratore() {
		datiUtenti = new ArrayList<String>();
		datiPremi = new ArrayList<String>();
		datiBlacklist = "";
	}
	
	public static Configuratore getConfiguratore() {
		return configuratore;
	}
	
	public List<String> getDatiUtenti() {
		return datiUtenti;
	}
	
	public List<String> getDatiPremi() {
		return datiPremi;
	}
	
	public String getDatiBlacklist() {
		return datiBlacklist;
	}
	
	public void setConfig(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String str;
		while (!(str = reader.readLine()).equals("")) {
			datiUtenti.add(str);
		}
		while (!(str = reader.readLine()).equals("")) {
			datiPremi.add(str);
		}
		datiBlacklist = reader.readLine();
		setChanged();
		notifyObservers();
	}
	
}
