package cartas;

import java.util.ArrayList;

public class Encantamentos extends Carta {
	 private int efeitoContinuo;

	    public void setEfeitoContinuo(int efeitoContinuo){
	        this.efeitoContinuo = efeitoContinuo;
	    }

	    public void danoEfeitoContinuo(int dano){
	        this.efeitoContinuo = dano ;
	    }
	    
	    public void atacarCriatura(Criatura destino) {
			this.danoEfeitoContinuo(this.efeitoContinuo);
			destino.receberDano(this.efeitoContinuo);
	    }
	    
	    public void buffTodos(int efeito, ArrayList<Criatura> criaturas){
	        for(int i = 0; i < criaturas.size(); i++) {
	        	int ataque = criaturas.get(i).getPoder();
	        	ataque += efeito;
	        	criaturas.get(i).ataque(ataque);
	        }
	    }
	    
	    public void buffUm(int dano, Criatura destino){
	        int ataque = destino.getPoder();
	        ataque += dano;
	        destino.ataque(ataque);
	    }
		public void debuffUm(int dano, Criatura destino, int efeitoContinuo){
	        int ataque = destino.getPoder();
	        ataque += (dano - efeitoContinuo);
	        destino.ataque(ataque);
	    }

		

}
	    
	

