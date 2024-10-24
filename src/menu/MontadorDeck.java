package menu;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import arenas.ArenaCombate;
import cartas.AlmaDeMana;
import cartas.AranhaGigante;
import cartas.AtiradorNoturno;
import cartas.BolaDeFogo;
import cartas.BolaDeNeve;
import cartas.CampoDeFogo;
import cartas.Carta;
import cartas.Cavaleiro;
import cartas.CavaleiroLuz;
import cartas.CavaleiroTrevas;
import cartas.CemiterioDeEspiritos;
import cartas.ChuvaDeFlechas;
import cartas.Cura;
import cartas.DragaoFogo;
import cartas.DragãoDaMontanha;
import cartas.DragãoDaTempestade;
import cartas.DragãoDasSombras;
import cartas.DragãoDeGelo;
import cartas.DragãoDoAbismo;
import cartas.DragãoSelva;
import cartas.Enfraquecimento;
import cartas.Envenenamento;
import cartas.Escudo;
import cartas.EspelhoMagico;
import cartas.EspiritoDeAgua;
import cartas.EspiritoDeFogo;
import cartas.Fortalecimento;
import cartas.FrancoAtirador;
import cartas.Furia;
import cartas.GambáGigante;
import cartas.GiganteFerro;
import cartas.GiganteOuro;
import cartas.GigantePlatina;
import cartas.GolemDePedra;
import cartas.GolemDiamante;
import cartas.GolemLava;
import cartas.Grifo;
import cartas.Javali;
import cartas.Leviatã;
import cartas.LeãoAreia;
import cartas.LeãoDaIlha;
import cartas.LeãoFogo;
import cartas.LeãoTrevas;
import cartas.LoboElétrico;
import cartas.LoboNeve;
import cartas.Quimera;
import cartas.SerpenteGigante;
import cartas.Trovao;
import cartas.VelocidadeDeAtaque;
import cartas.VentosRevigorantes;
import cartas.ZebraMistica;
import cartas.ZebraTroia;
import jogadores.Jogador;

public class MontadorDeck {
	private ArrayList<Jogador> jogadores;
	private ArrayList<Carta> cartas;
	private Random random;
	public MontadorDeck() {
		this.jogadores = new ArrayList<>();
		this.cartas = new ArrayList<>();
		this.random = new Random();
	}
	public void receberJogadores(Jogador jogador) {
		this.jogadores.add(jogador);
	}
	public void resetCartas() {
		this.cartas.removeAll(cartas);
	}
	public void setCartas() {
		this.cartas.add(new Javali());
		this.cartas.add(new AlmaDeMana());
		this.cartas.add(new AranhaGigante());
		this.cartas.add(new AtiradorNoturno());
		this.cartas.add(new BolaDeFogo());
		this.cartas.add(new BolaDeNeve());
		this.cartas.add(new CampoDeFogo());
		this.cartas.add(new Cavaleiro());
		this.cartas.add(new CavaleiroLuz());
		this.cartas.add(new CavaleiroTrevas());
		this.cartas.add(new CemiterioDeEspiritos());
		this.cartas.add(new ChuvaDeFlechas());
		this.cartas.add(new Cura());
		this.cartas.add(new DragãoDaMontanha());
		this.cartas.add(new DragãoDasSombras());
		this.cartas.add(new DragãoDaTempestade());
		this.cartas.add(new DragãoDeGelo());
		this.cartas.add(new DragãoDoAbismo());
		this.cartas.add(new DragaoFogo());
		this.cartas.add(new DragãoSelva());
		this.cartas.add(new Enfraquecimento());
		this.cartas.add(new Envenenamento());
		this.cartas.add(new Escudo());
		this.cartas.add(new EspelhoMagico());
		this.cartas.add(new EspiritoDeAgua());
		this.cartas.add(new EspiritoDeFogo());
		this.cartas.add(new Fortalecimento());
		this.cartas.add(new FrancoAtirador());
		this.cartas.add(new Furia());
		this.cartas.add(new GambáGigante());
		this.cartas.add(new GiganteFerro());
		this.cartas.add(new GiganteOuro());
		this.cartas.add(new GigantePlatina());
		this.cartas.add(new GolemDePedra());
		this.cartas.add(new GolemDiamante());
		this.cartas.add(new GolemLava());
		this.cartas.add(new Grifo());
		this.cartas.add(new LeãoAreia());
		this.cartas.add(new LeãoDaIlha());
		this.cartas.add(new LeãoFogo());
		this.cartas.add(new LeãoTrevas());
		this.cartas.add(new Leviatã());
		this.cartas.add(new LoboElétrico());
		this.cartas.add(new LoboNeve());
		this.cartas.add(new Quimera());
		this.cartas.add(new SerpenteGigante());
		this.cartas.add(new Trovao());
		this.cartas.add(new VelocidadeDeAtaque());
		this.cartas.add(new VentosRevigorantes());
		this.cartas.add(new ZebraMistica());
		this.cartas.add(new ZebraTroia());
	}
	
	public void printCarta() {
		int n = 1;
		for(Carta carta : this.cartas) {
			System.out.print(n);
			System.out.print(carta);
			System.out.print("  ");
			if(n % 5 == 0) {
				System.out.println();
			}
			n++;
		}
	}
	public static boolean isNumeric(String str) {
	    if (str == null) {
	        return false;
	    }
	    try {
	    	Integer.parseInt(str);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	public void escolherCarta(Scanner ler) {
		
		for(int i = 0; i < this.jogadores.size(); i++) {
			boolean escolha = true;
			while(escolha == true) {
				if(jogadores.get(i).getDeckSize() < 30) {
					resetCartas();
					setCartas();
					System.out.println(jogadores.get(i).getNome());
					System.out.println("Escolha 30 cartas das opções abaixo, no máximo você pode escolher duas cartas iguais");
					printCarta();
					System.out.println("Deseja ver o seu deck (d)");
					String input = ler.nextLine();
					if(isNumeric(input) == true) {
						int num = Integer.parseInt(input);
						jogadores.get(i).receberCarta(this.cartas.get(num-1));
					}
					else if(input.equals("d")) {
						if(jogadores.get(i).getDeckSize() == 0) {
							System.out.println("seu deck está vazio!");
						}
						else {
							jogadores.get(i).printDeck();
							System.out.println("Deseja remover alguma carta (r)");
							String input2 = ler.nextLine();
							if(input2.equals("r")){
								jogadores.get(i).printDeck();
								System.out.println("digite o número da carta que você dejesa remover");
								int num2 = Integer.parseInt(ler.nextLine());
								jogadores.get(i).removerCartaDeck(num2-1);
							}
						}
					}
				}
				else {
					System.out.println("Seu deck está cheio, deseja olhar seu deck (d) ou terminar a montagem do deck (t)");
					String input = ler.nextLine();
					if(input.equals("d")) {
						jogadores.get(i).printDeck();
						System.out.println("Deseja remover alguma carta (r)");
						String input2 = ler.nextLine();
						if(input2.equals("r")){
							jogadores.get(i).printDeck();
							System.out.println("digite o número da carta que você dejesa remover");
							int num2 = Integer.parseInt(ler.nextLine());
							jogadores.get(i).removerCartaDeck(num2-1);
						}
					}
					else if(input.equals("t")) {
						escolha = false;
					}
				}
			}
		}
	}

	public void transferirJogadores(ArenaCombate arena) {
		int indice = this.random.nextInt(this.cartas.size());
		if(indice % 2 == 0) {
			System.out.println(jogadores.get(0).getNome() + " vai começar jogando");
			arena.receberJogadores(this.jogadores.get(0));
			arena.receberJogadores(this.jogadores.get(1));
		}
		else {
			System.out.println(jogadores.get(1).getNome() + " vai começar jogando");
			arena.receberJogadores(this.jogadores.get(1));
			arena.receberJogadores(this.jogadores.get(0));
		}
	}

}

