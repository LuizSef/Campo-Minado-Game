package CampoMinado;

public class Main {

	public static void main(String[] args) {
		
		
		Tabuleiro tabu = new Tabuleiro();
		tabu.IniciarTabuleiro();
		tabu.inserirMinas();
		System.out.println(tabu);
		

	}

}
