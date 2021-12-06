package InterfaceCampoMinado;

import javax.swing.JButton;

import CodigosFonteCampoMinado.Celula;
import CodigosFonteCampoMinado.Tabuleiro;

public class InterfaceCelula extends JButton {
	private static final long serialVersionUID = 1L;

	int linha;
	int coluna;
	Tabuleiro t;
	Celula e;
	String text;
		
	public InterfaceCelula(Tabuleiro t) {
		this.t = t;
		text = "";
		this.setText(text);
		this.addActionListener((java.awt.event.ActionEvent evento) -> { 
			buttonAction(evento);
		});
	}
	public void pressionar() {
		
		System.out.println("linha: " + linha + " coluna: " + coluna);
		if (e.isMinado()) {
			//fazer terminar o jogo
			this.setEnabled(false);
			return;
		}
		
		int retorno = t.clicarButton(linha, coluna);// retorno é o numero de vizinhos com minas
	
		if (retorno ==0) {
			for ( Celula vizinho : e.vizinhos) {
				
				if (!vizinho.clicado) {
					vizinho.button.pressionar();
					System.out.println(vizinho.button);
				}
			}
			//return;
		}
		
		this.text = Integer.toString(retorno);
		this.setText(text);
		this.setEnabled(false); // NÃO DEIXA CLICAR Denovo
		
		
		
	}
	public void buttonAction(java.awt.event.ActionEvent evento) { // Ação do Button (botão gráfico).
		
		
		//if (condition) {
			
			this.pressionar();
		//} else {
		//	minar
		//}
		
		
				
		
				
		
		
				
	}
	
	public void setPosition(int linha, int coluna) { // Informar linha e coluna do button.
		this.linha = linha;
		this.coluna = coluna;
		this.e  = t.getCelula(linha, coluna);        
			
	}
	
} 
