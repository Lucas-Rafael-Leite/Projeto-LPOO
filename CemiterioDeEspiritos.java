package cartas;

import arenas.Cemiterio;
import cartas.Criatura;

public class CemiterioDeEspiritos extends Encantamentos{

    public CemiterioDeEspiritos(){
        super();
        setNome("Cemitério de Espiritos");
        setMana(5);

    }
    
    public void invocarEspirito(Criatura espirito){
        
        int quantidadeCartasCemiterio = getQuantidadeCartas();

        for(int i = 0; i < quantidadeCartasCemiterio; i++ ){
            
            Criatura criatura = new Criatura();

            System.out.println("Espirito invocado");
            
        }
    }
}
