package cartas;

import java.util.ArrayList;

public class AnulacaoDeBuff  extends Encantamentos{
    public AnulacaoDeBuff(){
        super();
        setNome("Anulação de Buff");
        setMana(3);
    }
    
    public void verificarCriatura(Criatura destino){
        
        ArrayList<Encantamentos> = destino.getArrayList();

        for (ArrayList<Encantamentos> : encantamento) {

            if(encantamento.getValidacao.equals("Buff")){
                destino.removerEncantamento(encantamento);
            }

        }
    }

    

}
