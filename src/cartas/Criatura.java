package cartas;

import interfaces.Atacavel;



public class Criatura extends Carta implements Atacavel{
	private int poder; 
	private int resistencia;
	private int maxResistencia;
	private boolean estado;
	
	public void ataque(int dano) {
		this.poder = dano;
	}
	public void defesa(int defesa) {
		this.resistencia = defesa;
	}
	public int getDefesaMax() {
		return this.maxResistencia;
	}
	public void defesaMax(int defesa) {
		this.maxResistencia = defesa;
	}
	
	public void receberDano(int dano) {
		this.resistencia = this.resistencia - dano;
		if(this.resistencia > this.maxResistencia) {
			this.resistencia = this.maxResistencia;
		}
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

	public void queimaduras() {
		this.resistencia = this.resistencia - 1;
	}

	public void congelar() {
		setEstado();
	}

	public void anular() {
		receberDano(0);
	}
	
	public void provocar() {
		
	}

}


