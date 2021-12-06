  package InterfaceCampoMinado;

import javax.swing.JFrame;
import javax.swing.JPanel;

import CodigosFonteCampoMinado.ConstantesTabuleiro;
import CodigosFonteCampoMinado.Tabuleiro;

public class InterfaceTabuleiro extends JFrame {
	private static final long serialVersionUID = 1L; // <-- O eclipse pediu para colocar, eu coloquei.
	JPanel panel; // painel gráfico.
	InterfaceCelula[][] matrizButton;
	Tabuleiro t;

	public InterfaceTabuleiro(Tabuleiro t) {	
		this.t = t;
		this.panel = new JPanel();	
		panel.setLayout(null);
		this.add(panel);
		matrizButton = new InterfaceCelula[ConstantesTabuleiro.nLinhas][ConstantesTabuleiro.nColunas];
		for (int l = 0; l < ConstantesTabuleiro.nLinhas; l++) {
			for (int c = 0; c < ConstantesTabuleiro.nColunas; c++) {
				t.getCelula(l, c).setButton(matrizButton[l][c]);
				matrizButton[l][c] = new InterfaceCelula(this.t);
				matrizButton[l][c].setPosition(l, c); 
				matrizButton[l][c].setSize(ConstantesTabuleiro.tamanhoCelula, ConstantesTabuleiro.tamanhoCelula); // Setar o tamanho do button.
				matrizButton[l][c].setLocation(ConstantesTabuleiro.tamanhoCelula*c, ConstantesTabuleiro.tamanhoCelula*l); // Setar a posição x e y dos buttons.
				panel.add(matrizButton[l][c]);
			}			
		}
		//iniciarTabuNaInterface();
		iniciarInterface();
	}
	public void iniciarTabuNaInterface() {
		
		
		
	}
	
	private void iniciarInterface() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Não rodar em segundo plano quando fechar a janela.
		this.setSize(ConstantesTabuleiro.nColunas*ConstantesTabuleiro.tamanhoCelula + 16, ConstantesTabuleiro.nLinhas*ConstantesTabuleiro.tamanhoCelula + 40); // Setar o tamanho da janela.
		this.setResizable(false); // Não deixa redimensionar a janela.
		this.setVisible(true); // Tornar visível.
	}

}
