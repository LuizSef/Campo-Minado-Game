package CampoMinado;

import java.util.ArrayList;

public class Celula {
	private boolean minado; // Possui mina ou não.
	private boolean revelado; // Mina revelada ou não.
	private boolean marcado; // Marcado com bandeira ou não.
	private boolean clicado; // A célula está clicada ou não.
	
	ArrayList<Celula> vizinhos; // Para que cada célula conte suas células vizinhas.
	
	public Celula() {
		// Vai iniciar os atributos como false.
		this.minado = false;
		this.revelado = false;
		this.marcado = false;
		this.clicado = false;
		
		this.vizinhos = new ArrayList();
	}
	
	public void adicionarVizinhos(Celula e) {
		this.vizinhos.add(e);
	}
	
	/*
	 * Indica se a célula tem uma mina;
	 * Se a célula já tiver uma mina, ele retorna false;
	 * Se a célula não tiver uma mina antes, ele retorna true;
	 */
	public boolean colocarMina() { // Colocar a minas nas células.
		if (!this.minado) {
			this.minado = true;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean marcarBandeira() { // Marcar a célula com bandeira.
		this.marcado = !this.marcado;
		return this.marcado;
	}
	
	public int clicarCelula() { // Ações ao clicar em uma célula.
		this.clicado = true;
		if (this.minado) {
			return -1; // Clicou numa mina.
		}else {
			return numMinasVizinhos();
		}
	}
	
	public int numMinasVizinhos() { // Número de bombas nas células vizinhas.
		int n = 0;
		for (Celula e : this.vizinhos) {
			if (e.minado) {
				n++;
			}		
		}
		return n;
	}
	
	public void reset() { // Resetar o jogo.
		this.minado = false;
		this.revelado = false;
		this.marcado = false;
		this.clicado = false;
	}
}
