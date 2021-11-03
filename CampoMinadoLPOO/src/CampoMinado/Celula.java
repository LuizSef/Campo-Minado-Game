package CampoMinado;

import java.util.ArrayList;

public class Celula {
	private boolean minado; // Possui mina ou n�o.
	private boolean revelado; // Mina revelada ou n�o.
	private boolean marcado; // Marcado com bandeira ou n�o.
	private boolean clicado; // A c�lula est� clicada ou n�o.
	
	ArrayList<Celula> vizinhos; // Para que cada c�lula conte suas c�lulas vizinhas.
	
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
	 * Indica se a c�lula tem uma mina;
	 * Se a c�lula j� tiver uma mina, ele retorna false;
	 * Se a c�lula n�o tiver uma mina antes, ele retorna true;
	 */
	public boolean colocarMina() { // Colocar a minas nas c�lulas.
		if (!this.minado) {
			this.minado = true;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean marcarBandeira() { // Marcar a c�lula com bandeira.
		this.marcado = !this.marcado;
		return this.marcado;
	}
	
	public int clicarCelula() { // A��es ao clicar em uma c�lula.
		this.clicado = true;
		if (this.minado) {
			return -1; // Clicou numa mina.
		}else {
			return numMinasVizinhos();
		}
	}
	
	public int numMinasVizinhos() { // N�mero de bombas nas c�lulas vizinhas.
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
