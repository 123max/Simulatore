import java.util.*;
import javax.swing.*;

public class Catalogo implements Observer {
	private static Catalogo catalogo = new Catalogo();
	private Premio head;
	private Premio tail;
	private int size;
	
	private Catalogo() {
		head = tail = null;
		size = 0;
	}
	
	public static Catalogo getCatalogo() {
		return catalogo;
	}
	
	public Premio getHead() {
		return head;
	}
	
	public Premio getTail() {
		return tail;
	}
	
	public int getSize() {
		return size;
	}
	
	public void add(Premio premio) throws NullPointerException {
		if (premio == null) throw new NullPointerException();
		if (size == 0) head = tail = premio;
		else {
			tail.setNext(premio);
			tail = premio;
		}
		size++;
	}
	
	public Premio remove(String nome) throws NullPointerException {
		if (nome == null) throw new NullPointerException();
		if (size == 0) return null;
		else {
			Premio aux = head;
			Premio prev = null;
			for (; aux != null && !aux.getNome().equals(nome); prev = aux, aux = aux.getNext());
			if (aux != null) {
				if (prev == null) head = head.getNext();
				else prev.setNext(aux.getNext());
				aux.setNext(null);
				size--;
			}
			return aux;
		}
	}
	
	public Premio search(String nome) throws NullPointerException {
		if (nome == null) throw new NullPointerException();
		Premio aux = head;
		for (; aux != null && !aux.getNome().equals(nome); aux = aux.getNext());
		return aux;
	}
	
	public void update(Observable o, Object arg) {
		List<String> listaPremi = Configuratore.getConfiguratore().getDatiPremi();
		for (int i=0; i<listaPremi.size(); i++) {
			String info[] = listaPremi.get(i).split(";");
			add(new Premio(info[0], Integer.parseInt(info[1]), info[2]));
		}
	}
	
	public void visualizzaCatalogo() {
		StringBuilder sb = new StringBuilder();
		Premio aux = head;
		for (; aux != null; aux = aux.getNext()) {
			sb.append(aux.getNome()+" -> "+aux.getPunteggio()+" punti\n");
		}
                Simulatore.setJTextArea1(sb.toString());
	}
	
}
