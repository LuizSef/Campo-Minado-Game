package InterfaceCampoMinado;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import CodigosFonteCampoMinado.Celula;
import CodigosFonteCampoMinado.ConstantesTabuleiro;
import CodigosFonteCampoMinado.Main;
import CodigosFonteCampoMinado.Tabuleiro;

public class InterfaceTabuleiro extends JFrame {
	private static final long serialVersionUID = 1L; // <-- O eclipse pediu para colocar, eu coloquei.
	JPanel panel; // painel gráfico.
	InterfaceCelula[][] matrizButton;
	InterfaceCelula ic;
	Tabuleiro t;
	Celula c;
	JButton buttonResetar;
	JButton facil;
	JButton medio;
	JButton dificil;
	JButton ranking;
	JRadioButton campoMinadoMaluco;

	public InterfaceTabuleiro() {		
		iniciarInterface();	
	}
	
	public void reconfigurar() { // Reconfigurar a interface para cada modo de jogo.
		Main.reconfigurar();
		this.dispose(); // Fecha a aba e abre uma nova com o novo modo de jogo.
				
	}
	
	private void iniciarInterface() {
		this.t = new Tabuleiro();
		t.iniciarTabuleiro();
		t.inserirMinas();
		this.panel = new JPanel();	
		panel.setLayout(null);
		this.add(panel);
		matrizButton = new InterfaceCelula[ConstantesTabuleiro.nLinhas][ConstantesTabuleiro.nColunas];
		
		for (int l = 0; l < ConstantesTabuleiro.nLinhas; l++) {
			for (int c = 0; c < ConstantesTabuleiro.nColunas; c++) {
				matrizButton[l][c] = new InterfaceCelula(this.t, this);
				t.getCelula(l, c).setInterfaceCelula(matrizButton[l][c]);
				matrizButton[l][c].setPosition(l, c);
				matrizButton[l][c].setSize(ConstantesTabuleiro.tamanhoCelula, ConstantesTabuleiro.tamanhoCelula); // Setar o tamanho do button.
				matrizButton[l][c].setLocation(ConstantesTabuleiro.tamanhoCelula*c, (ConstantesTabuleiro.tamanhoCelula*l)+ConstantesTabuleiro.deslocamento); // Setar a posição x e y dos buttons.
				panel.add(matrizButton[l][c]);
			}			
		}
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Não rodar em segundo plano quando fechar a janela.
		this.setSize((ConstantesTabuleiro.nColunas*ConstantesTabuleiro.tamanhoCelula)+ConstantesTabuleiro.diferencaLateral, (ConstantesTabuleiro.nLinhas*ConstantesTabuleiro.tamanhoCelula) + ConstantesTabuleiro.deslocamento + ConstantesTabuleiro.diferencaSuperior); // Setar o tamanho da janela.
		this.setResizable(false); // Não deixa redimensionar a janela. 
		this.setVisible(true); // Tornar visível.
		
		Icon icon = new ImageIcon("C:\\Users\\luiz_\\OneDrive\\Documents\\Programação em Java\\CampoMinadoLPOO\\src\\Images\\reset.png");
		this.buttonResetar = new JButton(icon); // Inicialização do button Reset.	
		this.panel.add(this.buttonResetar);
		this.buttonResetar.addActionListener((java.awt.event.ActionEvent evento) -> {
			this.resetar();
		});
		this.buttonResetar.setSize(ConstantesTabuleiro.tamanhoCelula, ConstantesTabuleiro.tamanhoCelula);
		this.buttonResetar.setLocation((ConstantesTabuleiro.tamanhoCelula*ConstantesTabuleiro.nColunas)/2 - (ConstantesTabuleiro.tamanhoCelula)/2, ConstantesTabuleiro.deslocamento - ConstantesTabuleiro.tamanhoCelula);
		
		this.facil = new JButton("Fácil"); // Inicialização do button modo fácil.
		this.panel.add(this.facil);
		this.facil.addActionListener((java.awt.event.ActionEvent evento) -> {
			ConstantesTabuleiro.nLinhas = 6;
			ConstantesTabuleiro.nColunas = 6;
			ConstantesTabuleiro.nMinas = 9;
			reconfigurar();
		});
		this.facil.setSize((ConstantesTabuleiro.tamanhoCelula * ConstantesTabuleiro.nColunas)/4, ConstantesTabuleiro.tamanhoCelula);
		this.facil.setLocation(0, 0);
		
		this.medio = new JButton("Médio"); // Inicialização do button modo médio.
		this.panel.add(this.medio);
		this.medio.addActionListener((java.awt.event.ActionEvent evento) -> {
			ConstantesTabuleiro.nLinhas = 8;
			ConstantesTabuleiro.nColunas = 8;
			ConstantesTabuleiro.nMinas = 16;
			reconfigurar();
		});
		this.medio.setSize((ConstantesTabuleiro.tamanhoCelula * ConstantesTabuleiro.nColunas)/4, ConstantesTabuleiro.tamanhoCelula);
		this.medio.setLocation((ConstantesTabuleiro.tamanhoCelula * ConstantesTabuleiro.nColunas)/4, 0);
		
		this.dificil = new JButton("Difícil"); // Inicialização do button modo difícil.
		this.panel.add(this.dificil);
		this.dificil.addActionListener((java.awt.event.ActionEvent evento) -> {
			ConstantesTabuleiro.nLinhas = 10;
			ConstantesTabuleiro.nColunas = 10;
			ConstantesTabuleiro.nMinas = 25;
			reconfigurar();
		});
		this.dificil.setSize((ConstantesTabuleiro.tamanhoCelula * ConstantesTabuleiro.nColunas)/4, ConstantesTabuleiro.tamanhoCelula);
		this.dificil.setLocation((ConstantesTabuleiro.tamanhoCelula * ConstantesTabuleiro.nColunas)/4*2, 0);
		
		this.ranking = new JButton("R"); // Inicialização do button Ranking.
		this.panel.add(this.ranking);
		this.ranking.addActionListener((java.awt.event.ActionEvent evento) -> {
			//
		});
		this.ranking.setSize((ConstantesTabuleiro.tamanhoCelula * ConstantesTabuleiro.nColunas)/4, ConstantesTabuleiro.tamanhoCelula);
		this.ranking.setLocation((ConstantesTabuleiro.tamanhoCelula * ConstantesTabuleiro.nColunas)/4*3, 0);
		
		this.campoMinadoMaluco = new JRadioButton("CMM", false); // Inicialização do radio button Campo Minado Maluco.
		this.panel.add(this.campoMinadoMaluco);
		this.campoMinadoMaluco.addActionListener((java.awt.event.ActionEvent evento) -> {
			//
		});
		this.campoMinadoMaluco.setSize(55, 50);
		this.campoMinadoMaluco.setLocation(0, 50);
	}
	
	public void revelarMinas() { // Revela todas as minas.
		for (int l = 0; l < ConstantesTabuleiro.nLinhas; l++) {
			for (int c = 0; c < ConstantesTabuleiro.nColunas; c++) {
				if (matrizButton[l][c].c.isMinado()) {
					matrizButton[l][c].revelaMinado("-1");
				}
			}
		}	
	}
	
	public void desativarButtons() { // Desativa todos os buttons.
		for (int l = 0; l < ConstantesTabuleiro.nLinhas; l++) {
			for (int c = 0; c < ConstantesTabuleiro.nColunas; c++) {
				matrizButton[l][c].setEnabled(false);
			}
		}
	}
	
	/*public void campoMinadoMaluco() { // O PROBLEMA TA AQUI
		if(this.c.marcarBandeira() && this.c.isMinado() && this.c.isMaluca()) {
			this.c.setMinado(false);
			this.t.iniciarTabuleiro();
		}else{
			this.t.iniciarTabuleiro();
		}
	}*/
	
	public void checarGanhouOuPerdeu() {
		if(this.t.ganhou()) {
			System.out.println("Venceu");
			this.desativarButtons();
		}
		
		if(this.t.perdeu()) {
			System.out.println("Perdeu");
			this.desativarButtons();
		}
	}
	
	public void resetar() { // Reseta o jogo.
		for (int l = 0; l < ConstantesTabuleiro.nLinhas; l++) {
			for (int c = 0; c < ConstantesTabuleiro.nColunas; c++) {
				matrizButton[l][c].resetar();
			}
		}
		this.t.inserirMinas();
	}
}
