package cartas;

public class Enfraquecimento extends Encantamentos{
    
    public Enfraquecimento(){
        super();
        setNome("Enfraquecimento");
        setMana(3);
        danoEfeitoContinuo(1);
        setValidacao("Debuff");
    }
}
