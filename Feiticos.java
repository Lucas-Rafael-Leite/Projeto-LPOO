package cartas;

import java.util.List;

public class Feiticos {

    private int efeito;
    private int custoMana;
    private String nome;


    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setCustoMana(int custoMana){
        this.custoMana = custoMana;
    }

    public void danoEfeito(int dano){
        this.efeito = dano ;
    }

    public void atacarCriatura(Criatura destino) {
		this.danoEfeito(this.efeito);
		destino.receberDano(this.efeito);
    }
    
    public void atacarTodasCriaturas(List<Criatura> criaturas){
        for(Criatura criatura : criaturas){
            this.danoEfeito(this.efeito);
            criatura.receberDano(this.efeito);
        }

    }
    
    public int getEfeito(){
        return this.efeito;

    }

    public int getCustoMana(){
        return this.custoMana;
    }


}
