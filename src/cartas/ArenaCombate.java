package cartas;

import java.util.ArrayList;
import java.util.Scanner;


public class ArenaCombate {
	private ArrayList<Jogador> jogadores;
	private ArrayList<CartasCampo> secção;

	
	public ArenaCombate() {
		this.jogadores = new ArrayList<>();
		this.secção = new ArrayList<>();
		
		

	}
	public void setJogadores() {
		this.jogadores.add(new Jogador());
		this.jogadores.add(new Jogador());
		this.secção.add(new CartasCampo());
		this.secção.add(new CartasCampo());
	}
	

	public void vezJogador(Scanner ler) {
		primeiroTurno(ler);
		int numeroTurno = 1;
		while(jogadores.get(0).getVida() > 0 && jogadores.get(1).getVida() > 0) {
				for(int i = 0; i < this.jogadores.size(); i++) {
					System.out.printf("Vez do Jogador " + (i+1));
					System.out.println();
					System.out.printf("Quantidade de mana: " + jogadores.get(i).getMana());
					System.out.println();
					System.out.println("Escolha uma carta para jogar no campo");
					this.jogadores.get(i).printMão();
					int input = Integer.parseInt(ler.nextLine());	
					receberCarta(this.jogadores.get(i), input);
					boolean verdade = false;
					secção.get(i).verificarCartas(jogadores.get(i).getCemiterio());
					while(verdade == false) {
					System.out.println("Jogar outra carta(c), Deseja ver o campo de batalha(b) ou terminar o turno(t)");
					String confirma = ler.nextLine();
					verdade = confirma.equals("t") == true;
					if(confirma.equals("c")) {
						System.out.printf("Quantidade de mana: " + jogadores.get(i).getMana());
						System.out.println();
						System.out.println("Escolha uma carta para jogar no campo");
						this.jogadores.get(i).printMão();
						int input2 = Integer.parseInt(ler.nextLine());	
						receberCarta(this.jogadores.get(i), input2);
					}
					if(confirma.equals("b")) {
						if(compararJogadores(jogadores.get(i)) == false) {
							System.out.println("Campo do Jogador " + (i+1));
							secção.get(i).printCartasCampo();
							System.out.println("ver o Campo do seu oponente (o) ou escolher uma carta para atacar (a)");
							String confirma2 = ler.nextLine();
							if(confirma2.equals("o")){
								printJogadores(i+1);
								secção.get(i+1).printCartasCampo();
							}
							if(confirma2.equals("a")) {
								System.out.println("Escolha uma criatura do seu campo para atacar ");
								secção.get(i).printCartasCampo();
								int input3 = Integer.parseInt(ler.nextLine());
								if (secção.get(i).escolherCarta(input3) instanceof Criatura) {
									Criatura criatura = (Criatura) secção.get(i).escolherCarta(input3);
									System.out.println("Agora escolha um alvo para ser atacado");
									printJogadores(i+1);
									secção.get(i+1).printCartasCampo();
									int input4 = Integer.parseInt(ler.nextLine());
									if(input4 == 0) {
										criatura.atacarJogador(jogadores.get(i+1));
									}
									else {
										Criatura criatura2 = (Criatura) secção.get(i+1).escolherCarta(input4);
										criatura.atacarCriatura(criatura2);
									}
								}
							}
						}
						else {
							System.out.println("Campo do Jogador " + (i+1));
							secção.get(i).printCartasCampo();
							System.out.println("ver o Campo do seu oponente (o) ou escolher uma carta para atacar (a)");
							String confirma2 = ler.nextLine();
							if(confirma2.equals("o")){
								printJogadores(i-1);
								secção.get(i-1).printCartasCampo();
							}
							if(confirma2.equals("a")) {
								System.out.println("Escolha uma criatura do seu campo para atacar ");
								secção.get(i).printCartasCampo();
								int input3 = Integer.parseInt(ler.nextLine());
								if (secção.get(i).escolherCarta(input3) instanceof Criatura) {
									Criatura criatura = (Criatura) secção.get(i).escolherCarta(input3);
									System.out.println("Agora escolha um alvo para ser atacado");
									printJogadores(i-1);
									secção.get(i-1).printCartasCampo();
									int input4 = Integer.parseInt(ler.nextLine());
									if(input4 == 0) {
										criatura.atacarJogador(jogadores.get(i-1));
									}
									else {
										Criatura criatura2 = (Criatura) secção.get(i-1).escolherCarta(input4);
										criatura.atacarCriatura(criatura2);
									}	
								}
							}
						}
					}
				}
			}
			numeroTurno++;
			for(int i = 0; i < jogadores.size(); i++) {
				jogadores.get(i).adicionarMana(numeroTurno);
				jogadores.get(i).adicionarMão();
				
			}		
		}
	}

	public void primeiroTurno(Scanner ler) {
		setJogadores();
		this.jogadores.get(0).setVida();
		this.jogadores.get(1).setVida();
		this.jogadores.get(0).setMana();
		this.jogadores.get(1).setMana();
		for(int i = 0; i < this.jogadores.size(); i++) {
			this.jogadores.get(i).setDeck();
			this.jogadores.get(i).embaralharDeck();
			this.jogadores.get(i).setMão();
			System.out.printf("Vez do Jogador " + (i+1));
			System.out.println();
			System.out.printf("Quantidade de mana: " + jogadores.get(i).getMana());
			System.out.println();
			System.out.println("Escolha uma carta para jogar no campo");
			this.jogadores.get(i).printMão();
			int input = Integer.parseInt(ler.nextLine());	
			receberCarta(this.jogadores.get(i), input);
			boolean verdade = false;
			int numeroTurno = 0;
			while(verdade == false) {
			System.out.println("Jogar outra carta(c), Deseja ver o campo de batalha(b) ou terminar o turno(t)");
			String confirma = ler.nextLine();
				verdade = confirma.equals("t") == true;
					if(confirma.equals("c")) {
						System.out.printf("Quantidade de mana: " + jogadores.get(i).getMana());
						System.out.println();
						System.out.println("Escolha uma carta para jogar no campo");
						this.jogadores.get(i).printMão();
						int input2 = Integer.parseInt(ler.nextLine());	
						receberCarta(this.jogadores.get(i), input2);
					}
					if(confirma.equals("b")) {
						if(compararJogadores(jogadores.get(i)) == false) {
							System.out.println("Campo do Jogador " + (i+1));
							secção.get(i).printCartasCampo();
							System.out.println("deseja ver o Campo do seu oponente? (o)");
							String confirma2 = ler.nextLine();
								if (confirma2.equals("o")){
									printJogadores(i+1);
									secção.get(i+1).printCartasCampo();
								}	
						}
						else {
							System.out.println("Campo do Jogador " + (i+1));
							secção.get(i).printCartasCampo();
							System.out.println("deseja ver o Campo do seu oponente? (o)");
							String confirma2 = ler.nextLine();
								if (confirma2.equals("o")){
									printJogadores(i-1);
									secção.get(i-1).printCartasCampo();
								}
						}
					}
			}
			numeroTurno++;
			jogadores.get(i).adicionarMana(numeroTurno);
			jogadores.get(i).adicionarMão();
		}
	}


	public void receberCarta(Jogador jogador, int input) {
		int n = jogador.getMãoSize();
		int o = secção.size();
		if(compararJogadores(jogador) == true) {
			for(int i = 0; i < n+1; i++) {
				if(input == i) {
				secção.get(o-1).receberCarta(jogador, input);
				}
			}
		}
		else {
			for(int i = 0; i < n+1; i++) {
				if(input == i) {
				secção.get(o-2).receberCarta(jogador, input);
				}
			}
		}
	}
	

	public void verificarCriatura(int index, int input) {
		if (secção.get(index).escolherCarta(input) instanceof Criatura) {
			Criatura criatura = (Criatura) secção.get(index).escolherCarta(input);
			criatura.atacarJogador(jogadores.get(index+1));
		}
	}
   
        
    
    
    public boolean compararJogadores(Jogador jogador) {
    	int n = jogadores.size();
    	boolean verdade = false;
    		for(int i = 0; i < n; i++) {	
    			if(jogadores.get(i) == jogador) {
    		verdade = true;
    	}
    	else {
    		verdade = false;
    	}
    }
    return verdade;
    }
    public void printJogadores(int i) {
    	int n = 0;
    	System.out.print(n);
    	System.out.printf(" Jogador " + (i+1));
    	System.out.printf(" Vida: " + jogadores.get(i).getVida());
    	System.out.println();
    }


}



		
	


