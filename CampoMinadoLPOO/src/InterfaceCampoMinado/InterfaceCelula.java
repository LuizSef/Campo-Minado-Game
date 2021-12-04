package InterfaceCampoMinado;

import javax.swing.JButton;

import CodigosFonteCampoMinado.Tabuleiro;

public class InterfaceCelula extends JButton {
	private static final long serialVersionUID = 1L;

	int linha;
	int coluna;
	Tabuleiro t;
	String text;
		
	public InterfaceCelula(Tabuleiro t) {
		this.t = t;
		text = "";
		this.setText(text);
		this.addActionListener((java.awt.event.ActionEvent evento) -> { 
			buttonAction(evento);
		});
	}
	
	public void buttonAction(java.awt.event.ActionEvent evento) { // Ação do Button (botão gráfico).
		System.out.println("linha: " + linha + "coluna: " + coluna);
		int retorno = t.clicarButton(linha, coluna);
		this.text = Integer.toString(retorno);
		this.setText(text);
	}

	public void setPosition(int linha, int coluna) { // Informar linha e coluna do button.
		this.linha = linha;
		this.coluna = coluna;
			
	}
	
}
