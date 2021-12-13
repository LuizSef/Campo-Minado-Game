package CodigosFonteCampoMinado;

import java.util.Random;

public class Tabuleiro {
	Celula[][] campo;

	public Tabuleiro() {
		campo = new Celula[ConstantesTabuleiro.nLinhas][ConstantesTabuleiro.nColunas];

		for (int l = 0; l < ConstantesTabuleiro.nLinhas; l++) { // l = linhas
			for (int c = 0; c < ConstantesTabuleiro.nColunas; c++) { // c = colunas
				campo[l][c] = new Celula();
			}
		}
	}

	public Celula[][] getCampo() {
		return campo;
	}

	public void setCampo(Celula[][] campo) {
		this.campo = campo;
	}

	public Celula getCelula(int linha, int coluna) {
		return campo[linha][coluna];
	}

	/*
	 * Adicionar os vizinhos: Série de if's para as condições de linhas e colunas
	 * para assim adicionar cada célula.
	 */

	public void iniciarTabuleiro() {
		for (int l = 0; l < ConstantesTabuleiro.nLinhas; l++) {
			for (int c = 0; c < ConstantesTabuleiro.nColunas; c++) {
				if (l > 0) {
					if (c > 0) {
						campo[l][c].adicionarVizinhos(campo[l - 1][c - 1]);
					}
					campo[l][c].adicionarVizinhos(campo[l - 1][c]);
					if (c < ConstantesTabuleiro.nColunas - 1) {
						campo[l][c].adicionarVizinhos(campo[l - 1][c + 1]);
					}
				}

				if (c > 0) {
					campo[l][c].adicionarVizinhos(campo[l][c - 1]);
				}
				if (c < ConstantesTabuleiro.nColunas - 1) {
					campo[l][c].adicionarVizinhos(campo[l][c + 1]);
				}

				if (l < ConstantesTabuleiro.nLinhas - 1) {
					if (c > 0) {
						campo[l][c].adicionarVizinhos(campo[l + 1][c - 1]);
					}
					campo[l][c].adicionarVizinhos(campo[l + 1][c]);
					if (c < ConstantesTabuleiro.nColunas - 1) {
						campo[l][c].adicionarVizinhos(campo[l + 1][c + 1]);
					}
				}
			}
		}
	}

	public void inserirMinas() { // Inserção randômica das minas nas células.
		int x = ConstantesTabuleiro.nMinas;
		Random rand = new Random();
		while (x > 0) {
			int l = rand.nextInt(ConstantesTabuleiro.nLinhas);
			int c = rand.nextInt(ConstantesTabuleiro.nColunas);
			if (campo[l][c].colocarMina()) {
				x--;
			}
		}
	}

	/*public void colocarCelulaMaluca() {
		Random rand = new Random();
		int y = rand.nextInt(ConstantesTabuleiro.nLinhas*ConstantesTabuleiro.nColunas);
		while (y > 0) {
			int l = rand.nextInt(ConstantesTabuleiro.nLinhas);
			int c = rand.nextInt(ConstantesTabuleiro.nColunas);
			if (campo[l][c].celulaMaluca()) {
				y--;
			}
		}
	}*/

	public int clicarButton(int linha, int coluna) { // Ação de clicar no button.
		return campo[linha][coluna].clicarCelula();
	}

	@Override
	public String toString() { // printar o tabuleiro.
		String string = "";

		for (int l = 0; l < ConstantesTabuleiro.nLinhas; l++) {
			for (int c = 0; c < ConstantesTabuleiro.nColunas; c++) {
				string += campo[l][c] + "";
			}
			string += "\n";
		}
		return string;
	}

	public boolean ganhou() { // utilizando as condições das minas para finalizar.
		for (int l = 0; l < ConstantesTabuleiro.nLinhas; l++) {
			for (int c = 0; c < ConstantesTabuleiro.nColunas; c++) {
				if (!campo[l][c].finalizado()) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean perdeu() {
		for (int l = 0; l < ConstantesTabuleiro.nLinhas; l++) {
			for (int c = 0; c < ConstantesTabuleiro.nColunas; c++) {
				if (campo[l][c].isClicado() && campo[l][c].isMinado()) {
					return true;
				}
			}
		}
		return false;
	}
}
