package cartas;

public class Jogador {
	private int vida;
	private int mana;
	private int mão;
	public int setVida(){
		return this.vida = 30;
	}
	public int setMana() {
		return this.mana = 1;
	}
	public void receberDano(int poder) {
		this.vida = this.vida - poder;
		
	}
	public int setMão() {
		return this.mão = 5;
	}
	public void jogarCarta() {
		this.mão = this.mão - 1;
	}
	
}
