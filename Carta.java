package cartas;

public class Carta {
	private String nome;
	private int custoMana;
	
	
	public String toString() {
		return nome;
    }
	
	public int getMana() {
		return this.custoMana;
	}
	public void setMana(int mana) {
		this.custoMana = mana;
	}
	


	public void setNome(String criaturaNome) {
		this.nome = criaturaNome;	
	}
}
