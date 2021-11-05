package CampoMinado;

public class Tabuleiro {
	 private int nLinhas = 9;
	 private int nColunas = 9 ;
	 
	Celula[][] campo = new Celula[nLinhas][nColunas];
	

	
	
	public Tabuleiro( ) {
		
		
		
		
	}
	
	
	
	public void IniciarTabuleiro() {
		for (int l = 0; l < nLinhas; l++) {
			for (int c = 0; c < nColunas; c++) {
				campo[l][c] = new Celula();
			}
		}
		
		
	}
	
	
	
	
	
	
	
	
}


