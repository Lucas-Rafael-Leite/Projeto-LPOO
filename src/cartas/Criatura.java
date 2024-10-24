package cartas;

import interfaces.Atacavel;


public abstract class Criatura extends Carta implements Atacavel{
	private int poder; 
	private int resistencia;
	private boolean estado;

	public void ataque(int dano) {
		this.poder = dano;
	}
	
	public void defesa(int defesa) {
		this.resistencia = defesa;
	}
	
	public void receberDano(int dano) {
		this.resistencia = this.resistencia - dano;
	}
	
	
	public int getPoder() {
		return this.poder;
	}
	
	public int getDefesa() {
		return this.resistencia;
	}
	
	

	public void setEstado() {
		this.estado = true;
	}
	
	public boolean getEstado() {
		return this.estado;
	}
	
	public void mudarEstado() {
		this.estado = false;
	}

	public void atacar(Atacavel destino) {
		this.ataque(poder);
		destino.receberDano(poder);
	}

}


