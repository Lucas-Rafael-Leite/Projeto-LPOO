package cartas;

import java.util.ArrayList;

import interfaces.Atacavel;



public class Criatura extends Carta implements Atacavel{
	private int poder; 
	private int resistencia;
	private boolean estado;
	private ArrayList<Encantamentos> encantamento;
	
	public void adicionarEncantamento(Encantamentos encantamento){
		encantamento.add(encantamento);
	}
	
	public void removerEncantamento(Encantamentos encantamento){
		encantamento.remove(encantamento);
	}

	public ArrayList<Encantamentos> getArrayList(){
		return encantamento;
	}

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




