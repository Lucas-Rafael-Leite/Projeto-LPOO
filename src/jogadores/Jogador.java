package jogadores;

import java.util.ArrayList;
import java.util.Random;

import arenas.CartasCampo;
import arenas.Cemiterio;
import cartas.AlmaDeMana;
import cartas.AranhaGigante;
import cartas.AtiradorNoturno;
import cartas.Carta;
import cartas.Cavaleiro;
import cartas.ChuvaDeFlechas;
import cartas.Criatura;
import cartas.DragaoFogo;
import cartas.DragãoDaMontanha;
import cartas.EspiritoDeAgua;
import cartas.Feiticos;
import cartas.GiganteOuro;
import cartas.GigantePlatina;
import cartas.GolemDePedra;
import cartas.Javali;
import cartas.LeãoDaIlha;
import cartas.LoboNeve;
import cartas.Quimera;
import interfaces.Atacavel;

public class Jogador implements Atacavel {
	private String nome;
	private int vida;
	private int mana;
	private ArrayList<Carta> mao;
	private ArrayList<Carta> deck;
	private Cemiterio cemiterio;
	private Random random;
	
	public Jogador() {
		this.mao = new ArrayList<>();
		this.deck = new ArrayList<>();
		 this.random = new Random();
		 this.cemiterio = new Cemiterio();
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
		for(int i = 0; i < 5; i++) {
			adicionarMão();
		}
		
	}
	
	public Carta getCartaMão(int input){
		if(input > this.mao.size()) {
			return null;
		}
		if(input <= 0 ) {
			return null;
		}
		else {
			return mao.get(input-1);
		}
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
		this.deck.add(new Javali());
		this.deck.add(new Javali());
		this.deck.add(new GigantePlatina());
		this.deck.add(new GigantePlatina());
		this.deck.add(new DragaoFogo());
		this.deck.add(new DragaoFogo());
		this.deck.add(new LoboNeve());
		this.deck.add(new LoboNeve());
		this.deck.add(new ChuvaDeFlechas());
		this.deck.add(new ChuvaDeFlechas());
		this.deck.add(new AlmaDeMana());
		this.deck.add(new AlmaDeMana());
		this.deck.add(new EspiritoDeAgua());
		this.deck.add(new EspiritoDeAgua());
		this.deck.add(new Quimera());
		this.deck.add(new Quimera());
		this.deck.add(new Cavaleiro());
		this.deck.add(new Cavaleiro());
		this.deck.add(new LeãoDaIlha());
		this.deck.add(new LeãoDaIlha());
		this.deck.add(new GolemDePedra());
		this.deck.add(new GolemDePedra());
		this.deck.add(new AtiradorNoturno());
		this.deck.add(new AtiradorNoturno());
		this.deck.add(new AranhaGigante());
		this.deck.add(new AranhaGigante());
		this.deck.add(new DragãoDaMontanha());
		this.deck.add(new DragãoDaMontanha());
		this.deck.add(new GiganteOuro());
		this.deck.add(new GiganteOuro());
	
	}
	
	public int getDeckSize() {
		return this.deck.size();
	}
	
	
	public void adicionarMão() {
		if(this.deck.size() > 0) {
			Carta carta = this.deck.get(0);
			this.mao.add(carta);
			this.deck.remove(0);
		}
	}
	
	public void embaralharDeck() {
		for(int i = 0; i < this.deck.size(); i++) {
			int indice = random.nextInt(this.deck.size());
			Carta carta = this.deck.get(i);
			carta = this.deck.set(indice, carta);
			carta = this.deck.set(i, carta);
			
		}
	}

	
	public void printDeck() {
		int i = 1;
		for(Carta carta: this.deck) {
			System.out.print(i);
			System.out.print(carta);
			System.out.println();
			i++;
		}
	}
		
	public void removerCartaDeck(int input) {
		this.deck.remove(input);
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public void jogarCarta(int input, Carta carta, CartasCampo campo) {
		if(input > this.mao.size()) {
			
		}
		else if(input == 0) {
			
		}
		else if(getCartaMão(input).getMana() <= this.mana) {
					this.mana = this.mana - getCartaMão(input).getMana();
					carta = getCartaMão(input);
					this.mao.remove(input-1);
					if(carta instanceof Criatura) {
						campo.adicionarCriatura((Criatura) carta);
						((Criatura) carta).setEstado();
					}
					else if(carta instanceof Feiticos) {
						
					}
			
				}
				else {
					System.out.println("Você não tem mana o suficiente!");
				}
	}

	public void receberCarta(Carta carta){
		this.deck.add(carta);
	}

	public void cemiterioReceberCartas(Criatura criatura) {
		this.cemiterio.receberCartas(criatura);
	}


}


	
	
