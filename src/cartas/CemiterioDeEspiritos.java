package cartas;

import arenas.CartasCampo;
import arenas.Cemiterio;

public class CemiterioDeEspiritos extends Encantamentos{

    public CemiterioDeEspiritos(){
        super();
        setNome(" Cemitério de Espiritos");
        setMana(5);

    }
    
    public void invocarEspirito(Criatura espirito, Cemiterio cemiterio, CartasCampo campo){
        for(int i = 0; i < cemiterio.getQuantidadeCartas(); i++ ){
            if(i%2 == 0) {
            	espirito = new EspiritoDeAgua(); 
            	campo.adicionarCriatura(espirito);
            }
            else{
            	espirito = new EspiritoDeFogo();
            	campo.adicionarCriatura(espirito);
            }
        }
    }
}
