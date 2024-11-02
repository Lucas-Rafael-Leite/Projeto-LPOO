package cartas;

public class BolaDeFogo extends Feiticos{

    private int turnoJogada;

    public BolaDeFogo(){
        super();
        setNome("Bola de Fogo");
        setMana(2);
        danoEfeito(1);
    }
    
    public void jogarFeitico(Criatura destino, int trunoAtual){

        this.turnoJogada = trunoAtual;
        queimaduras(destino, trunoAtual);

    }
   
    public void queimaduras(Criatura destino, int turnoAtual){
        
        if(turnoAtual == turnoJogada + 1){

            destino.danoEfeito(1);
        
        }
        
        

    }

}

