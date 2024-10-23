package cartas;

public class EspelhoMagico extends Feiticos{
    public EspelhoMagico(){
        super();
        setNome(" EspelhoMagico");
        setMana(6);
        danoEfeito(0);

    }
    public void refletirDano(Criatura destino, int danoRecebido){
    	destino.atacarCriatura(destino);
    }
    
}
