package cartas;

import java.util.ArrayList;

public class Jogador {
	private int vida;
	private int mana;
	private ArrayList<Criatura> mao;
	private ArrayList<Criatura> deck;
	private ArrayList<Criatura> cemiterio;
	
	public Jogador() {
		this.mao = new ArrayList<>();
		this.deck = new ArrayList<>();
		this.cemiterio = new ArrayList<>();
	}

	public int setVida(){
		return this.vida = 30;
	}
	public int setMana() {
		return this.mana = 1;
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

	public Criatura jogarCarta(int numeroInput) {
		Criatura criatura = null;
		for(int i = 0; i < this.mao.size(); i++) {
			if(numeroInput == i+1) {
				criatura = mao.get(i);
				this.mao.remove(i);
			}
		}
		return criatura;
	}
	public void printMão() {
		int i = 1;
		for(Criatura carta : mao) {
			System.out.print(i);
			System.out.println(carta);
			i++;
		}
	}
	public void setDeck(){
		this.deck.add(null);
	}
	public void setCemiterio() {
		this.cemiterio.add(null);
	}
}
	

