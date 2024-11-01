package cartas;

import arenas.CartasCampo;
import arenas.Cemiterio;


public class CemiterioDeEspiritos extends Encantamentos{

    public CemiterioDeEspiritos(){
        super();
        setNome("Cemitério de Espiritos");
        setMana(5);

    }
    
    public void invocarEspirito(Criatura espirito, Cemiterio cemiterio, CartasCampo campo){
        
        int quantidadeCartasCemiterio = cemiterio.getQuantidadeCartas();

        for(int i = 0; i < quantidadeCartasCemiterio; i++ ){
            
            Criatura criatura = new Criatura();
            criatura.setNome(" Espirito");
            criatura.defesa(1);
            criatura.ataque(0);
            campo.adicionarCriatura(criatura);
            System.out.println("Espirito invocado");
            
        }
    }
}