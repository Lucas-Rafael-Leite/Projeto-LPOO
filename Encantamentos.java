import cartas.Criatura;

public class Encantamentos {
    private int custoMana;
    private String nome;
    private int efeitoContinuo;

    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setCustomana(int custoMana){
        this.custoMana = custoMana;
    }

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
    
    public void buffTodos(int efeito){
        this.poder += efeito;
    }
    
    public void buffUm(int dano){
        this.poder += dano;
    }
     public void receberBuff(Criatura destino){
        this.buffUm(this.efeitoContinuo);
     }
    
}
