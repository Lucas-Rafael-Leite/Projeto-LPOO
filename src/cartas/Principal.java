package cartas;

import java.util.Scanner;

import menu.MontadorDeck;
import menu.NomearJogadores;
import arenas.ArenaCombate;

public class Principal {
	public static void main(String[] args) {
		NomearJogadores nomeio = new NomearJogadores();
		MontadorDeck deck = new MontadorDeck();
		ArenaCombate arena = new ArenaCombate();
		Scanner ler = new Scanner(System.in);
		nomeio.nomearJogadores(ler);
		nomeio.transferirJogadores(deck);
		deck.escolherCarta(ler);
		deck.transferirJogadores(arena);
		arena.vezJogador(ler);
		ler.close();
		
	}
}
		
		



