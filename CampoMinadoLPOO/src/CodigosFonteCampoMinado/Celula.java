package CodigosFonteCampoMinado;

import java.util.ArrayList;

import InterfaceCampoMinado.InterfaceCelula;

public class Celula {
	public boolean minado; // Possui mina ou n�o.
	private boolean revelado; // Mina revelada ou n�o.
	private boolean marcado; // Marcado com bandeira ou n�o.
	public boolean clicado; // A c�lula est� clicada ou n�o.
	
	public ArrayList<Celula> vizinhos; // Para que cada c�lula conte suas c�lulas vizinhas.
	public InterfaceCelula button; // ponte de comunica��o do meio logico com o grafico
	
	public Celula() {
		// Vai iniciar os atributos como false.
		this.minado = false;
		this.revelado = false;
		this.marcado = false;
		this.clicado = false;
		
		this.vizinhos = new ArrayList<Celula>();
		
	}
	
	public boolean isMinado() {
		return minado;
	}

	public void setMinado(boolean minado) {
		this.minado = minado;
	}

	public boolean isRevelado() {
		return revelado;
	}

	public void setRevelado(boolean revelado) {
		this.revelado = revelado;
	}

	public boolean isMarcado() {
		return marcado;
	}

	public void setMarcado(boolean marcado) {
		this.marcado = marcado;
	}

	public boolean isClicado() {
		return clicado;
	}

	public void setClicado(boolean clicado) {
		this.clicado = clicado;
	}

	public ArrayList<Celula> getVizinhos() {
		return vizinhos;
	}

	public void setVizinhos(ArrayList<Celula> vizinhos) {
		this.vizinhos = vizinhos;
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

	
	public String toString() { // printar as minas.
		if (this.minado) {
			return "-1";
		}
		return " " + this.numMinasVizinhos();
	}
	
	public boolean finalizado() { // Condi��o das minas para finalizar o jogo.
		if(this.minado && this.marcado) {
			return true;
		}
		if(!this.minado && !this.marcado) {
			return true;
		}
		return false;
	}
		public void setButton(InterfaceCelula button) {
			this.button = button;
		}

		
}
