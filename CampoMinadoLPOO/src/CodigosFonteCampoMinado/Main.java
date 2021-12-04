package CodigosFonteCampoMinado;

import InterfaceCampoMinado.InterfaceTabuleiro;

public class Main {

	public static void main(String[] args) {
		Tabuleiro t = new Tabuleiro();
		t.iniciarTabuleiro();
		t.inserirMinas();
		InterfaceTabuleiro i = new InterfaceTabuleiro(t);

	}
	
}
