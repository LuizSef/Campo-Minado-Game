package CodigosFonteCampoMinado;

import java.util.Random;

public class Tabuleiro {
   Celula[][] campo;
   
   public Tabuleiro() {
	   campo = new Celula[ConstantesTabuleiro.nLinhas][ConstantesTabuleiro.nColunas];
	   
	   for (int l = 0; l < ConstantesTabuleiro.nLinhas; l++) { // l = linhas
           for (int c = 0; c < ConstantesTabuleiro.nColunas; c++) { // c = colunas
        	   campo[l][c] = new Celula();
           }               
       }
   }
     
   public Celula[][] getCampo() {
	return campo;
   }

   public void setCampo(Celula[][] campo) {
	this.campo = campo;
   }
   
   /*
	* Adicionar os vizinhos:
	* S�rie de if's para as condi��es de linhas e colunas para assim adicionar cada c�lula.
	*/
   
   public void iniciarTabuleiro() {
	   for (int l = 0; l < ConstantesTabuleiro.nLinhas; l++) {
		   for (int c = 0; c < ConstantesTabuleiro.nColunas; c++) {
			   if (l > 0) {
        		   if (c > 0) {
        			   campo[l][c].adicionarVizinhos(campo[l-1][c-1]);
        		   }
        		   campo[l][c].adicionarVizinhos(campo[l-1][c]);
        		   if (c < ConstantesTabuleiro.nColunas-1) {
        			   campo[l][c].adicionarVizinhos(campo[l-1][c+1]);
        		   }
        	   }
        	   
        	   if (c > 0) {
        		   campo[l][c].adicionarVizinhos(campo[l][c-1]);
        	   }
        	   if (c < ConstantesTabuleiro.nColunas-1) {
        		   campo[l][c].adicionarVizinhos(campo[l][c+1]);
        	   }
        	   
        	   if (l < ConstantesTabuleiro.nLinhas-1) {
        		   if (c > 0) {
        			   campo[l][c].adicionarVizinhos(campo[l+1][c-1]);
        		   }
        		   campo[l][c].adicionarVizinhos(campo[l+1][c]);
        		   if (c < ConstantesTabuleiro.nColunas-1) {
        			   campo[l][c].adicionarVizinhos(campo[l+1][c+1]);
        		   }
        	   }
		   }
	   }
   }
   
   
    // Inser��o rand�mica das minas nas c�lulas 
    
   public void inserirMinas() {
	   int x = ConstantesTabuleiro.nMinas;
	   Random rand = new Random();
	   while (x > 0) {
		   int l = rand.nextInt(ConstantesTabuleiro.nLinhas);
           int c = rand.nextInt(ConstantesTabuleiro.nColunas);
           if (campo[l][c].colocarMina()) {
               x--;
           }
	   }
   }

	@Override
	public String toString() {
		String string = "";
		
		for (int l = 0; l < ConstantesTabuleiro.nLinhas; l++) {
			for (int c = 0; c < ConstantesTabuleiro.nColunas; c++) {
				string += campo[l][c] + "";
			}
			string += "\n";
		}
		return string;
	}      
}
