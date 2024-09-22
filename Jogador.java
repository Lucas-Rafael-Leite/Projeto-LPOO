package cartas;

import java.util.ArrayList;

public class Jogador {
	private int vida;
	private int mana;
	private ArrayList<Carta> mao;
	private ArrayList<Carta> deck;
	private ArrayList<Carta> cemiterio;
	
	public Jogador() {
		this.mao = new ArrayList<>();
		this.deck = new ArrayList<>();
		this.cemiterio = new ArrayList<>();
	}

	public int getVida(){
		return this.vida;
	}
	public void setVida(){
		this.vida = 30;
	}
	public int getMana() {
		return this.mana;
	}
	public void setMana() {
		this.mana = 1;
	}
	public void adicionarMana(int input) {
		setMana();
		for(int i = 0; i < input; i++) {
			this.mana = this.mana + 1;
			if(this.mana == 10) {
				break;
			}
		}
	}
	public void receberDano(int poder) {
		this.vida = this.vida - poder;
		
	}
	public void setMão() {
		this.mao.add(new Javali());
		this.mao.add(new Javali());
		this.mao.add(new GigantePlatina());
		this.mao.add(new GigantePlatina());
		this.mao.add(new DragaoFogo());
		
	}
	

	
	public int getMãoSize() {
		return this.mao.size();
	}

	
	public Carta jogarCarta(int numeroInput) {
		Carta carta = null;
		for(int i = 0; i < this.mao.size(); i++) {
			if(numeroInput == i+1) {
				if(mao.get(i).getMana() <= this.mana) {
					this.mana = this.mana - mao.get(i).getMana();
					carta = mao.get(i);
					this.mao.remove(i);
				}
				else {
					carta = null;
				}
			}
		}
		return carta;
	}
	public void printMão() {
		int i = 1;
		for(Carta carta : this.mao) {
			System.out.print(i);
			System.out.print(carta);
			System.out.printf(" custo de mana: " + carta.getMana());
			System.out.println();
			i++;
		}
	}
	public void setDeck(){
		this.deck.add(null);
	}
	public void setCemiterio() {
		this.cemiterio.add(null);
	}
	
	public void adicionarCemiterio(Carta carta) {
		this.cemiterio.add(carta);
	}
}
	

