package algoritmo.Principal;

public class Sonda {
	//private int inicialX, inicialY;
	private String direcaoInicial;
	
	//private int atualX, atualY;
	private String direcaoAtual;
	
	private Posicao posSonda;
	
	private String comando;
	
	
	public Sonda(int x, int y, String direcao) {
		
		this.posSonda = new Posicao(x, y);
		this.direcaoInicial = direcao;
	}
	
	public void setComando(String comando) {
		this.comando = comando;
	}
	public String getComando() {
		return this.comando;
	}
	
	public int getPosX() {
		return this.posSonda.getX();
	}
	
	public int getPosY() {
		return this.posSonda.getY();
	}
	
	public String getDirecaoAtual() {
		return this.direcaoAtual;
	}


	public boolean executaComando (Planalto planalto) {
		int contadorX = this.posSonda.getX();
    	int contadorY = this.posSonda.getY();
    	
    	String direcao = this.direcaoInicial;
    	
    	
    	boolean caminhoBloqueado = false;
    	int indiceComandoAtual = 0;
    	
    	while(!caminhoBloqueado && indiceComandoAtual < this.getComando().length()) {
    		//System.out.printf("%s/%s\n",indiceComandoAtual,this.comando.length());
    		char comandoAtual = this.getComando().charAt(indiceComandoAtual);
    		
    		switch(comandoAtual) {
    			case 'M': 
    				switch(direcao) {
    					case "N":
    						if(contadorY < planalto.getLimiteY()) {
    							if(planalto.posicaoLivre(contadorX, contadorY + 1)) {
    								contadorY++;   								
    							}
    							else {
    								caminhoBloqueado = true;
    							}
    						}
    						break;
    					case "E":
    						if(contadorX < planalto.getLimiteX()) {
    							if(planalto.posicaoLivre(contadorX + 1, contadorY)) {
    								contadorX++;				
    							}else {
    								caminhoBloqueado = true;
    							}
    						}
    						break;
    					case "W":
    						if(contadorX > 0) {
    							if(planalto.posicaoLivre(contadorX - 1, contadorY)) {
    								contadorX--;
    							}else {
    								caminhoBloqueado = true;
    							}
    						}
    						break;
    					case "S":
    						if(contadorY > 0) {
    							if(planalto.posicaoLivre(contadorX, contadorY - 1)) {
    								contadorY--;
    							}else {
    								caminhoBloqueado = true;
    							}
    						}
    						break;
    				}
    				break;
    			case 'L': 
    				switch(direcao) {
    					case "N":
    						direcao = "W";
    						break;
    					case "W":
    						direcao = "S";
    						break;
    					case "S":
    						direcao = "E";
    						break;
    					case "E":
    						direcao = "N";
    						break;
    				}
    				break;
    			case 'R': 
	    				switch(direcao) {
		    			case "N":
		    				direcao = "E";
							break;
						case "E":
							direcao = "S";
							break;
						case "S":
							direcao = "W";
							break;
						case "W":
							direcao = "N";
							break;
    			}
    			break;
    		}
    		indiceComandoAtual++;
    	}
    	
    	this.posSonda.setX(contadorX);
    	this.posSonda.setY(contadorY);
    	this.direcaoAtual = direcao;
    	
    	return caminhoBloqueado;
	}
	
	
}
