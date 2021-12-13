package InterfaceCampoMinado;

import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import CodigosFonteCampoMinado.Celula;
import CodigosFonteCampoMinado.ConstantesTabuleiro;
import CodigosFonteCampoMinado.Tabuleiro;

public class InterfaceCelula extends JButton {
	private static final long serialVersionUID = 1L;

	int linha;
	int coluna;
	Tabuleiro t;
	Celula c;
	InterfaceTabuleiro it;
	String text;

	public InterfaceCelula (Tabuleiro t, InterfaceTabuleiro it) {
		this.t = t;
		this.it = it;
		this.text = "";
		this.setText(text);
		this.addActionListener((java.awt.event.ActionEvent evento) -> { // Receitinha de bolo.
			buttonAction(false);
		});
		this.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mousePressed(java.awt.event.MouseEvent e) { // Usar botão direito do mouse (peguei no Stackoverflow).
				if(SwingUtilities.isRightMouseButton(e)) {
					buttonAction(true);
				}
			}
		});
	}

	public void buttonAction (boolean botaoDireito) { // Ação ao pressionar o button (botão gráfico).
		
		if(!botaoDireito) { // Botão esquerdo.
			if(!this.c.isMarcado()) { // Se não está marcado, pode clicar no button.
				this.clicarButton();
			}
		}else {
			this.marcarBandeira();
		}
		this.it.checarGanhouOuPerdeu();
	}

	public void clicarButton() {
		System.out.println("linha: " + linha + " | coluna: " + coluna);
		int retorno = c.clicarCelula(); // retorno = número de vizinhos minados se a célula não for minada.

		if (this.c.isMinado()) { // Se clicar na célula minada.
			this.it.revelarMinas(); // Revela todas as minas.
		}

		if (retorno == 0) { // Se não tiver minas nas células vizinhas (0);
			for (Celula vizinho : c.getVizinhos()) { 
				if (!vizinho.isClicado()) { 
					vizinho.button.clicarButton(); // Clicar/Abrir todos os vizinhos. 
				}				
			}
		}

		this.text = Integer.toString(retorno); // Se não tiver minado e nem (0) apenas retorna o número de minas nos vizinhos.
		this.revelaMinado(this.text);
		
	}

	public void setPosition(int linha, int coluna) { // Informar linha e coluna do button.
		this.linha = linha;
		this.coluna = coluna;
		this.c = t.getCelula(linha, coluna);
	}
	
	public void revelaMinado(String vizinhosMinados) { // setText "-1" em todas as minas reveladas.
		
		if (vizinhosMinados.equals("-1")) { // Exceção try/catch para colocar imagem no button (peguei no Stackoverflow).
            try {
                Image img = ImageIO.read(getClass().getResource("/Images/mina.png"));
                img = img.getScaledInstance(ConstantesTabuleiro.tamanhoCelula, ConstantesTabuleiro.tamanhoCelula, java.awt.Image.SCALE_SMOOTH);
                this.setIcon(new ImageIcon(img));
            } catch (Exception ex) {
                this.setText("-1");
            }
        } else {
            this.setText(vizinhosMinados);
        }

        this.setEnabled(false);
    }
	
	public void marcarBandeira() { // setText "B" nas bandeiras.
		if(this.c.isClicado()) {
			return;
		}
		
		boolean marcado = this.c.marcarBandeira();
		
		if(this.c.isMarcado()) { // Exceção try/catch para colocar imagem no button (peguei no Stackoverflow).
			try {
                Image imagem = ImageIO.read(getClass().getResource("/Images/bandeira .png"));
                imagem = imagem.getScaledInstance(ConstantesTabuleiro.tamanhoCelula, ConstantesTabuleiro.tamanhoCelula, java.awt.Image.SCALE_SMOOTH);
                this.setIcon(new ImageIcon(imagem));
            } catch (Exception ex) {
                this.setText("B");
            }
		}else {			this.setIcon(null);
			this.setText("");
		}
	}
	
	public void resetar() {
		this.c.reset();
		this.text = "";
		this.setText(text);
		this.setEnabled(true);
		this.setIcon(null);
	}

}
