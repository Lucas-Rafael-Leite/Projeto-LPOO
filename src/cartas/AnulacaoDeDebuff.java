package cartas;

import java.util.ArrayList;

public class AnulacaoDeDebuff extends Encantamentos{

    public AnulacaoDeDebuff(){

        super();
        setNome("Anulação de Debuff");
        setMana(3);
    }
    
    public void verificarCriatura(Criatura destino){
        
        ArrayList<Encantamentos> = destino.getArrayList();

        for (ArrayList<Encantamentos> : encantamento) {

            if(encantamento.getValidacao.equals("Debuff")){
                destino.removerEncantamento(encantamento);
            }

        }
    }

}
