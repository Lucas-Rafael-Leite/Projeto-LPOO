package cartas;

import java.util.ArrayList;

public class MontadorDeck {
	private ArrayList<Jogador> jogadores;
	
	public MontadorDeck() {
		this.jogadores = new ArrayList<>();
	}
	
	public void adicionar() {
		this.jogadores.add(null);
	}
	
}
