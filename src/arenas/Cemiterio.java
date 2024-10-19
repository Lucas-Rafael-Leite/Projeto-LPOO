package arenas;

import java.util.ArrayList;

import cartas.Carta;
import cartas.Criatura;




public class Cemiterio {
	private ArrayList<Carta> cartas;
	public Cemiterio() {
		this.cartas = new ArrayList<>();
	}
	public void receberCartas(Criatura criatura) {
		this.cartas.add(criatura);
	}
	public int getQuantidadeCartas() {
		return this.cartas.size();
	}
}



