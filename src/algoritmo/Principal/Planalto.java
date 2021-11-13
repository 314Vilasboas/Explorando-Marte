package algoritmo.Principal;

public class Planalto {
	private int maxX, maxY;
	private int[][] campo;
	
	/*
	 * Devido ao plano cartesiano ser de 0 a x e 0 a y
	 * e a matriz instanciada ser de 0 a x-1 e 0 a y-1
	 * precisamos corrigir o índice.
	 */
	public Planalto(int x, int y) {
		this.maxX = x+1;
		this.maxY = y+1;
		this.inicializaCampo();
	}
	
	public void inicializaCampo(){
		this.campo = new int[this.maxX][this.maxY];
		
		for(int i = 0; i< this.maxX; i++) {
			for(int j = 0; j< this.maxY; j++) {
				this.campo[i][j] = 0;
			}
		}
	}
	
	public int getLimiteX() {
		return this.maxX-1;
	}
	
	public int getLimiteY() {
		return this.maxY-1;
	}
	
	public int atualiza(int x, int y){
		
		this.campo[x][y]++;
		return this.campo[x][y];
	}
}
