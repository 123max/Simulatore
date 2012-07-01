import java.util.*;

public class ListaUtenti implements Observer {
	private static ListaUtenti listaUtenti = new ListaUtenti();
	private Utente head;
	private Utente tail;
	private int size;
	
	private ListaUtenti() {
		head = tail = null;
		size = 0;
	}
	
	public static ListaUtenti getListaUtenti() {
		return listaUtenti;
	}
	
	public Utente getHead() {
		return head;
	}
	
	public Utente getTail() {
		return tail;
	}
	
	public int getSize() {
		return size;
	}
	
	public void add(Utente utente) throws NullPointerException {
		if (utente == null) throw new NullPointerException();
		if (size == 0) head = tail = utente;
		else {
			tail.setNext(utente);
			tail = utente;
		}
		size++;
	
	}
	
	public Utente remove(String username) throws NullPointerException {
		if (username == null) throw new NullPointerException();
		if (size == 0) return null;
		else {
			Utente aux = head;
			Utente prev = null;
			for (; aux != null && !aux.getUsername().equals(username); prev = aux, aux = aux.getNext());
			if (aux != null) {
				if (prev == null) head = head.getNext();
				else prev.setNext(aux.getNext());
				aux.setNext(null);
				size--;
			}
			return aux;
		}
	
	}
	
	public Utente search(String username, long password) throws NullPointerException {
		if (username == null) throw new NullPointerException();
		Utente aux = head;
		for (; aux != null && (!aux.getUsername().equals(username) || aux.getPassword() != password); aux = aux.getNext());
		return aux;
	}
	
	public void update(Observable o, Object arg) {
		List<String> listaUtenti = Configuratore.getConfiguratore().getDatiUtenti();
		for (int i=0; i<listaUtenti.size(); i++) {
			String info[] = listaUtenti.get(i).split(";");
			List<String> listaParole = new ArrayList<String>();
			for (int j=8; j<info.length; j++) {
				listaParole.add(info[j]);
			}
                        add(new Utente(info[0], info[1], info[2], info[3], info[4], Long.parseLong(info[5]), Integer.parseInt(info[6]), listaParole));
		}
	}
	
}
