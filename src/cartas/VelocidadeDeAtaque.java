package cartas;

public class VelocidadeDeAtaque extends Encantamentos {
    public VelocidadeDeAtaque(){
        super();
        setNome("Velocidade de Ataque");
        setMana(3);

    }

    public void velocidadeAtaque(Criatura destino){
        destino.ataque(getPoder()*2); ;
    }
}
