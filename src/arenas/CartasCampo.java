package arenas;

import java.util.ArrayList;

import cartas.Carta;
import cartas.Criatura;
import cartas.Encantamentos;
import cartas.Feiticos;
import jogadores.Jogador;

public class CartasCampo {
	private ArrayList<Carta> cartas;
	public CartasCampo() {
		this.cartas = new ArrayList<>();
	}
	
	
	public void adicionarCriatura(Carta criatura) {
		this.cartas.add(criatura);
	}
	
	public boolean isEmpty() {
		if (cartas.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	public void verificarCartas(Jogador jogador) {
		for(int i = 0; i < cartas.size(); i++) {
			if(cartas.get(i) instanceof Criatura) {
				Criatura criatura = (Criatura) cartas.get(i);
				criatura.queimaduras();
				if(criatura.getDefesa() <= 0) {
					jogador.cemiterioReceberCartas(criatura);
					this.cartas.remove(i);
				}
			}
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
				System.out.print(" ");
				System.out.print(criatura);
				if(criatura.getQueimado() == true) {
					System.out.print(" (Queimado)");
				}
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
	

	public void remover(Carta escolherCarta) {
		this.cartas.remove(escolherCarta);
		
	}
	
	public void printQuantidadeDeCarta() {
		System.out.println(cartas.size());
	}
	public Carta getCarta(int i) {
		return cartas.get(i);
	}
	
	public void passarVezCriatura(int vez) {
		for(Carta carta : cartas) {
			if (carta instanceof Criatura) {
				((Criatura) carta).setVez(vez);
			}
		}
	}
	public void acordarCriaturas() {
		for(Carta carta : cartas) {
			if (carta instanceof Criatura) {
				((Criatura) carta).mudarEstado();
			}
		}
	}

	public boolean verificarFeiticos() {
		boolean verdade = false;
		for(int i = 0; i < cartas.size(); i++) {
			if(cartas.get(i) instanceof Feiticos) {
				verdade = true;
			}
			else {
				verdade = false;
			}
		}
		return verdade;
		
	}
	public Feiticos feitico() {
		Carta carta = null;
		for(Carta carta1 : cartas) {
			if(carta1 instanceof Feiticos) {
				carta1 = (Feiticos) carta1;
				carta = carta1;
			}
		}
		return (Feiticos) carta;
	}
	public boolean verificarEncantamentos() {
		boolean verdade = false;
		for(int i = 0; i < cartas.size(); i++) {
			if(cartas.get(i) instanceof Encantamentos) {
				verdade = true;
			}
			else {
				verdade = false;
			}
		}
		return verdade;
		
	}
	public void transferirCampoDeck(Jogador jogador) {
		for(int i = this.cartas.size() - 1; i >= 0; i--) {
			jogador.receberCarta(cartas.get(i));
			cartas.remove(i);
		}
	}
}