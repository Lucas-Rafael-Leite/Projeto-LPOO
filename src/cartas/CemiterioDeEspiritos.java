package cartas;

import arenas.CartasCampo;
import arenas.Cemiterio;
import cartas.Criatura;

public class CemiterioDeEspiritos extends Encantamentos{

    public CemiterioDeEspiritos(){
        super();
        setNome("Cemitério de Espíritos");
        setMana(5);
        setValidacao("Buff");
    }

    
    public void invocarEspirito(Criatura criatura, Cemiterio cemiterio, CartasCampo campo) {
        
        int quantidadeCartasCemiterio = cemiterio.getQuantidadeCartas();

        for (int i = 0; i < quantidadeCartasCemiterio; i++) {
            Criatura criatura = new Criatura();
            criatura.setNome("Espírito");
            criatura.defesa(1); 
            criatura.ataque(0);
            campo.acordarCriaturas();
            System.out.println("Espirito invocado!");
        }

        return criaturasInvocadas;
    }
}
