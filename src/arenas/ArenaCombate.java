package arenas;

import java.util.ArrayList;
import java.util.Scanner;

import cartas.Criatura;
import jogadores.Jogador;


public class ArenaCombate {
	private ArrayList<Jogador> jogadores;
	private ArrayList<CartasCampo> secção;

	
	public ArenaCombate() {
		this.jogadores = new ArrayList<>();
		this.secção = new ArrayList<>();
	}
	public void setJogadores() {
		this.secção.add(new CartasCampo());
		this.secção.add(new CartasCampo());
	}
	public void receberJogadores(Jogador jogador) {
		this.jogadores.add(jogador);
	}
	public void printJogadores(int i) {
	    System.out.printf(jogadores.get(i).getNome());
	    System.out.printf(" Vida: " + jogadores.get(i).getVida());
	    System.out.println();
	}
	public void verificarCriatura(int index, int input) {
		if (secção.get(index).escolherCarta(input) instanceof Criatura) {
			Criatura criatura = (Criatura) secção.get(index).escolherCarta(input);
			criatura.atacar(jogadores.get(index+1));
		}
	}
	public void escolherOutraCarta(int i, Scanner ler) {
	    System.out.printf("Quantidade de mana: " + jogadores.get(i).getMana());
		System.out.println();
		System.out.println("Escolha uma carta para jogar no campo");
		this.jogadores.get(i).printMão();
		int input2 = Integer.parseInt(ler.nextLine());	
		jogadores.get(i).jogarCarta(input2, jogadores.get(i).getCartaMão(input2), secção.get(i));
	}

	public void faseCombate(int i, Scanner ler) {
	    int o = 1 - i;
	    System.out.println("Campo de " + jogadores.get(i).getNome());
		secção.get(i).verificarCartas(jogadores.get(i));
		secção.get(o).verificarCartas(jogadores.get(o));
		secção.get(i).printCartasCampo();
		System.out.println("ver o Campo do seu oponente (o) ou escolher uma carta para atacar (a)");
		String confirma2 = ler.nextLine();
		if(confirma2.equals("o")){
			printJogadores(o);
			secção.get(o).printCartasCampo();
		}
		if(confirma2.equals("a")) {
			combate(i, o, ler);
		}
	}
	public void combate(int i, int o, Scanner ler) {
	    System.out.println("Escolha uma criatura do seu campo para atacar ");
		secção.get(i).printCartasCampo();
		int input3 = Integer.parseInt(ler.nextLine());
		if (secção.get(i).escolherCarta(input3) instanceof Criatura) {
			Criatura criatura = (Criatura) secção.get(i).escolherCarta(input3);
			if(criatura.getEstado() == true) {
				System.out.println("A criatura não pode atacar!");
			}
			else {
				System.out.println("Agora escolha um alvo para ser atacado");
				System.out.print(0);
				System.out.print(" ");
				printJogadores(o);
				secção.get(o).printCartasCampo();
				int input4 = Integer.parseInt(ler.nextLine());
				if(input4 == 0) {
					criatura.atacar(jogadores.get(o));
					criatura.setEstado();
				}
				else {
					Criatura criatura2 = (Criatura) secção.get(o).escolherCarta(input4);
					criatura.atacar(criatura2);
					criatura2.atacar(criatura);
					criatura.setEstado();
				}	
			}
		}
	}
	public void turno(int i, Scanner ler) {
		System.out.printf("Vez de " + jogadores.get(i).getNome());
		System.out.println();
		System.out.printf("Quantidade de mana: " + jogadores.get(i).getMana());
		System.out.println();
		System.out.println("Escolha uma carta para jogar no campo");
		this.jogadores.get(i).printMão();
		int input = Integer.parseInt(ler.nextLine());	
		jogadores.get(i).jogarCarta(input, jogadores.get(i).getCartaMão(input), secção.get(i));
		boolean verdade = false;
		secção.get(i).verificarCartas(jogadores.get(i));
		while(verdade == false) {
			System.out.println("Jogar outra carta(c), Deseja ver o campo de batalha(b) ou terminar o turno(t)");
			String confirma = ler.nextLine();
			verdade = confirma.equals("t") == true;
			if(confirma.equals("c")) {
				escolherOutraCarta(i, ler);
			}
			if(confirma.equals("b")) {
				faseCombate(i, ler);
			}
		}	
    }
	public void primeiroTurno(Scanner ler) {
		setJogadores();
		this.jogadores.get(0).setVida();
		this.jogadores.get(1).setVida();
		this.jogadores.get(0).setMana();
		this.jogadores.get(1).setMana();
		int numeroTurno = 0;
		for(int i = 0; i < this.jogadores.size(); i++) {
			this.jogadores.get(i).embaralharDeck();
			this.jogadores.get(i).setMão();
			turno(i, ler);
			numeroTurno++;
			jogadores.get(i).adicionarMana(numeroTurno);
			jogadores.get(i).adicionarMão();
			secção.get(i).acordarCriaturas();
		}
	}
	public void vezJogador(Scanner ler) {
		primeiroTurno(ler);
		int numeroTurno = 1;
		while(jogadores.get(0).getVida() > 0 && jogadores.get(1).getVida() > 0) {
			for(int i = 0; i < this.jogadores.size(); i++) {
				turno(i, ler);
			}
			numeroTurno++;
			for(int i = 0; i < jogadores.size(); i++) {
				jogadores.get(i).adicionarMana(numeroTurno);
				jogadores.get(i).adicionarMão();
				secção.get(i).acordarCriaturas();
				
			}		
		}
	}

}



		
	


