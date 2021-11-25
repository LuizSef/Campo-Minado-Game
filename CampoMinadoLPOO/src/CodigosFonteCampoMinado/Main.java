package CodigosFonteCampoMinado;

public class Main {

	public static void main(String[] args) {
		Tabuleiro c = new Tabuleiro();
		c.iniciarTabuleiro();
		c.inserirMinas();
		System.out.println(c);

	}
	
}
