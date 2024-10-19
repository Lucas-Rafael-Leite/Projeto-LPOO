package cartas;

import java.util.Scanner;

import arenas.ArenaCombate;

public class Principal {
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		ArenaCombate arena = new ArenaCombate();
		arena.vezJogador(ler);
		ler.close();
		
	}
}
		
		



