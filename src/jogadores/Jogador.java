package jogadores;

import java.util.ArrayList;
import java.util.Random;

import arenas.CartasCampo;
import arenas.Cemiterio;
import cartas.AtributosGeraisCriaturas;
import cartas.Carta;

import cartas.Criatura;
import excecoes.ManaInsuficienteException;
import interfaces.Atacavel;

public class Jogador implements Atacavel {
	private String nome;
	private int vida;
	private int mana;
	private int vez;
	private int nivel;
	private int vitorias;
	private int derrotas;
	private ArrayList<Carta> mao;
	private ArrayList<Carta> deck;
	private Cemiterio cemiterio;
	private Random random;
	
	public Jogador() {
		this.mao = new ArrayList<>();
		this.deck = new ArrayList<>();
		 this.random = new Random();
		 this.cemiterio = new Cemiterio();
		 this.nivel = 1;
		 this.vitorias = 0;
		 this.derrotas = 0;
	}
	public void setVez(int vez) {
		this.vez = vez;
	}
	public int getVez() {
		return this.vez;
	}
	public void passarVez() {
		this.vez = this.vez + 1;
	}
	public int getNivel() {
		return this.nivel;
	}
	public void evoluirNivel() {
		this.nivel = this.nivel + 1;
	}
	public int getVitorias() {
		return this.vitorias;
	}
	public void venceu() {
		this.vitorias = this.vitorias + 1;
	}
	public int getDerrotas() {
		return this.derrotas;
	}
	public void perdeu() {
		this.derrotas = this.derrotas + 1;
	}
	public int getVida(){
		return this.vida;
	}
	public void setVida(){
		this.vida = 15;
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

	
	
	public void printMão() {
		int i = 1;
		for(Carta carta : this.mao) {
			System.out.print(i);
			System.out.print(" ");
			System.out.print(carta);
			System.out.printf(" custo de mana: " + carta.getMana());
			System.out.println();
			i++;
		}
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
			System.out.print(" ");
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

	public void jogarCarta(int input, int vez, Carta carta, CartasCampo campo) throws ManaInsuficienteException{
		try {
			if(input > this.mao.size()) {
			
			}
			else if(input == 0) {
				
			}
			else if (getCartaMão(input).getMana() > this.mana) {
				
				throw new ManaInsuficienteException("Mana insuficiente");
			
			}
			else{	
				
				this.mana = this.mana - getCartaMão(input).getMana();
				carta = getCartaMão(input);
				this.mao.remove(input-1);
				if(carta instanceof Criatura) {
					campo.adicionarCriatura((Criatura) carta);
					((Criatura) carta).setEstado();
					((Criatura) carta).setVez(vez);
					((Criatura) carta).setQueimado();
				}

				else{
					campo.adicionarCriatura(carta);
				}

			}

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void receberCarta(Carta carta){
		this.deck.add(carta);
	}

	public void cemiterioReceberCartas(Carta criatura) {
		this.cemiterio.receberCartas(criatura);
	}

	public Carta getCartaDeck(int input) {
		return this.deck.get(input);
	}

	public void transferirCemiterioDeck() {
		this.cemiterio.transferirCartasDeck(this);
	}
	public void resetAtributosCriaturas(AtributosGeraisCriaturas tabela) {
		for(Carta carta : this.deck) {
			if(carta instanceof Criatura) {
				tabela.tabelaDeAtributos((Criatura) carta);
			}
		}
	}
	public void transferirMaoDeck() {
	    for (int i = this.mao.size() - 1; i >= 0; i--) {
	        this.deck.add(this.mao.get(i));
	        this.mao.remove(i);
	    }
	}
	public int getCemiterioSize() {
		return this.cemiterio.getQuantidadeCartas();
	}
}


	
	
