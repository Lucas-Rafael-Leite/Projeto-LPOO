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
	
	public void receberCarta(Jogador jogador, int input) {
		int n = jogador.getMãoSize();
		for(int i = 0; i < n+1; i++) {
			if(input == i) {
				Carta carta = jogador.jogarCarta(i);
				if(carta == null) {
					System.out.println("Você não tem mana o suficiente!");
				}
				else if(carta instanceof Feiticos){
					
				}
				else {
					this.cartas.add(carta);
				}
			}

		}
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
	

	public void remover(Carta escolherCarta) {
		this.cartas.remove(escolherCarta);
		
	}
	
	public void printQuantidadeDeCarta() {
		System.out.println(cartas.size());
	}
	public Carta getCarta(int i) {
		return cartas.get(i);
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
	
}