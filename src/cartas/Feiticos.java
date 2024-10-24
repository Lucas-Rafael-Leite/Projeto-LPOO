package cartas;

import java.util.ArrayList;

public abstract class Feiticos extends Carta{
	    private int efeito;
	    
	    public void danoEfeito(int dano){
	        this.efeito = dano ;
	    }

	    
	    public void atacarTodasCriaturas(ArrayList<Criatura> criaturas){
	        for(Criatura criatura : criaturas){
	            this.danoEfeito(this.efeito);
	            criatura.receberDano(this.efeito);
	        }

	    }
	    
	    public int getEfeito(){
	        return this.efeito;

	    }

}
