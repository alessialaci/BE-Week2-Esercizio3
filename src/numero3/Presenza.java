package numero3;

public class Presenza {

	String nome;
	int numPresenze;
	
	public Presenza(String nome, int numPresenze) {
		this.nome = nome;
		this.numPresenze = numPresenze;
	}
	
	@Override
	public String toString() {
		String s = String.format(this.nome + "@" + this.numPresenze + "#");		
		return s;
	}
	
}
