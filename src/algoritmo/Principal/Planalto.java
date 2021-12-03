package algoritmo.Principal;

import java.util.Arrays;

public class Planalto {
	//private int maxX, maxY;
	private Posicao posPlanalto;
	private int[][] campo;
	//private Posicao posicao;
	/*
	 * Devido ao plano cartesiano ser de 0 a x e 0 a y
	 * e a matriz instanciada ser de 0 a x-1 e 0 a y-1
	 * precisamos corrigir o índice.
	 */
	public Planalto(int x, int y) {
		this.posPlanalto = new Posicao(x+1,y+1);
		this.inicializaCampo();
	}
	
	public void inicializaCampo(){
		int xAux = this.posPlanalto.getX();
		int yAux = this.posPlanalto.getY();
		
		this.campo = new int[xAux][yAux];
		
		for(int i = 0; i< xAux; i++) {
			for(int j = 0; j< yAux; j++) {
				this.campo[i][j] = 0;
			}
		}
		//System.out.printf(Arrays.deepToString(this.campo));
	}
	
	public int getLimiteX() {
		return this.posPlanalto.getX()-1;
	}
	
	public int getLimiteY() {
		return this.posPlanalto.getY()-1;
	}
	
	public int atualiza(int x, int y){
		
		this.campo[x][y]++;
		return this.campo[x][y];
	}
	public boolean posicaoLivre(int x, int y) {
		return this.campo[x][y] == 0;
	}
}
