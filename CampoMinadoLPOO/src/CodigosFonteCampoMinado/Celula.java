package CodigosFonteCampoMinado;

import java.util.ArrayList;

import InterfaceCampoMinado.InterfaceCelula;

public class Celula {
	public boolean minado; // Possui mina ou não.
	private boolean revelado; // Mina revelada ou não.
	private boolean marcado; // Marcado com bandeira ou não.
	public boolean clicado; // A célula está clicada ou não.
	
	public ArrayList<Celula> vizinhos; // Para que cada célula conte suas células vizinhas.
	public InterfaceCelula button; // ponte de comunicação do meio logico com o grafico
	
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

	
	public String toString() { // printar as minas.
		if (this.minado) {
			return "-1";
		}
		return " " + this.numMinasVizinhos();
	}
	
	public boolean finalizado() { // Condição das minas para finalizar o jogo.
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
