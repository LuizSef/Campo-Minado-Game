package CampoMinado;


import java.util.Random;

public class Tabuleiro {
	private static int nLinhas = 6; // tamanho do tabuleiro
	private static int nColunas = 6;
	private static int nMinas = 5;

	Celula[][] campo = new Celula[nLinhas][nColunas];

	public Tabuleiro() {

	}

	public Celula[][] getCampo() {
		return campo;
	}

	public void IniciarTabuleiro() { // Cria o tabuleiro , inserindo as celulas
		for (int l = 0; l < nLinhas; l++) {
			for (int c = 0; c < nColunas; c++) {
				campo[l][c] = new Celula();
			}
		}

		for (int l = 0; l < nLinhas; l++) { // adiciona os vizinhos + condições dos vizinhos
			for (int c = 0; c < nColunas; c++) {
				if (l > 0) {
					if (c > 0) {
						campo[l][c].adicionarVizinhos(campo[l - 1][c - 1]);
						campo[l][c].adicionarVizinhos(campo[l - 1][c]);
					}
					if (c < nColunas - 1) {
						campo[l][c].adicionarVizinhos(campo[l - 1][c + 1]);
					}
				}

				if (c > 0) {
					campo[l][c].adicionarVizinhos(campo[l][c - 1]);
				}
				if (c < nColunas - 1) {
					campo[l][c].adicionarVizinhos(campo[l][c + 1]);
				}

				if (l < nLinhas - 1) {
					if (c > 0) {
						campo[l][c].adicionarVizinhos(campo[l + 1][c - 1]);
						campo[l][c].adicionarVizinhos(campo[l + 1][c]);
					}
					if (c < nColunas - 1) {
						campo[l][c].adicionarVizinhos(campo[l + 1][c + 1]);
					}
				}
			}
		}

	}

	public void inserirMinas() {
		int x = nMinas;
		Random rand = new Random();
		while (x > 0) {
			int l = rand.nextInt(nLinhas);
			int c = rand.nextInt(nColunas);
			if (campo[l][c].colocarMina()) {
				x--;
			}

		}

	}

	
	public String toString() {
		String string = "";

		for (int l = 0; l < nLinhas; l++) {
			for (int c = 0; c < nColunas; c++) {
				string = string + campo[l][c] + " ";
			}
			string = string + "\n";
		}
		return string;

	}

}
