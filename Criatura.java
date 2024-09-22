package cartas;

public class Criatura extends Carta{
	private int poder; 
	private int resistencia;

	public void ataque(int dano) {
		this.poder = dano;
	}
	
	public void defesa(int defesa) {
		this.resistencia = defesa;
	}
	
	public void receberDano(int dano) {
		this.resistencia = this.resistencia - dano;
	}
	
	public void atacarCriatura(Criatura destino) {
		this.ataque(this.poder);
		destino.receberDano(this.poder);
	}
	
	public int getPoder() {
		return this.poder;
	}
	
	public int getDefesa() {
		return this.resistencia;
	}
	
	public void atacarJogador(Jogador destino) {
		this.ataque(this.poder);
		destino.receberDano(this.poder);
	}


}


