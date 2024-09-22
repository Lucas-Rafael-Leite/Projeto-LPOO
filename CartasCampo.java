package cartas;

import java.util.ArrayList;

public class CartasCampo {
	private ArrayList<Carta> cartas;
	public CartasCampo() {
		this.cartas = new ArrayList<>();
	}
	
	public void receberCarta(Jogador jogador, int input) {
		int n = jogador.getMãoSize();
		for(int i = 0; i < n+1; i++) {
			if(input == i) {
				Carta carta = jogador.jogarCarta(i);
				if(carta == null) {
					System.out.println("Você não tem mana o suficiente!");
				}
				else {
					this.cartas.add(carta);
				}
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
	else {
		for(Carta carta : cartas) {
			if(carta instanceof Criatura) {
				Criatura criatura = (Criatura) carta;
				System.out.print(n);
				System.out.print(criatura);
				System.out.printf(" poder: " + criatura.getPoder());
				System.out.printf(" resitencia: " + criatura.getDefesa());
				System.out.println();
				n++;
				}
			}
		}
	}
	public Carta escolherCarta(int input) {
		Carta carta = null;
		for(int i = 0; i < cartas.size(); i++) {
			if(input == i+1) {
				carta = cartas.get(i);
			}
		}
		return carta;
	}
	public int getCartasCampoSize() {
		return cartas.size();
		
	
	}
	public ArrayList<Carta> getArray() {
		return cartas;
	}

	public void remove(Criatura escolherCarta) {
		cartas.remove(escolherCarta);
		
	}
	
	public void printQuantidadeDeCarta() {
		System.out.println(cartas.size());
	}
}