package cartas;

import java.util.ArrayList;

public class CartasCampo {
	private ArrayList<Criatura> cartas;
	public CartasCampo() {
		this.cartas = new ArrayList<>();
	}
	
	public void receberCarta(Jogador jogador, int input) {
		int n = jogador.getMãoSize();
		for(int i = 0; i < n+1; i++) {
			if(input == i) {
				this.cartas.add(jogador.jogarCarta(i));
			}

		}
	}
	public boolean isEmpty() {
		if (cartas.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	public void printCartasCampo() {	
	int n = 1;	
	if(isEmpty() == true) {
		System.out.println("Campo Vazio");
	}
	for(Criatura carta : cartas) {
		System.out.print(n);
		System.out.print(carta);
		System.out.printf(" poder: " + carta.getPoder());
		System.out.printf(" resistência: " + carta.getDefesa());
		System.out.println();
		n++;
	}
}
	public Criatura escolherCarta(int input) {
		Criatura criatura = null;
		for(int i = 0; i < cartas.size(); i++) {
			if(input == i+1) {
				criatura = cartas.get(i);
			}
		}
		return criatura;
	}
	public int getCartasCampoSize() {
		return cartas.size();
	}
}