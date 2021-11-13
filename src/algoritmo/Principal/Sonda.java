package algoritmo.Principal;

public class Sonda {
	private int inicialX, inicialY;
	private String direcaoInicial;
	
	private int atualX, atualY;
	private String direcaoAtual;
	
	private String comando;
	
	
	public Sonda(int x, int y, String direcao) {
		this.inicialX = x;
		this.inicialY = y;
		
		this.direcaoInicial = direcao;
	}
	
	public void setComando(String comando) {
		this.comando = comando;
	}
	public String getComando() {
		return this.comando;
	}
	
	public int getAtualX() {
		return this.atualX;
	}
	
	public int getAtualY() {
		return this.atualY;
	}
	
	public String getDirecaoAtual() {
		return this.direcaoAtual;
	}


	public void executaComando (int limitePlanaltoX ,int limitePlanaltoY ) {
		int contadorX = this.inicialX;
    	int contadorY = this.inicialY;
    	
    	String direcao = this.direcaoInicial;
    	
    	for(int j = 0; j < this.getComando().length(); j++) {
    		char var = this.getComando().charAt(j);
    		
    		if(var == 'M') {
    			switch(direcao) {                             
					case "N":
						if(contadorY < limitePlanaltoY) //limitadores parar nao permitir a sonda sair do planalto planejado.
							contadorY++;
						break;
					case "W":
						if(contadorX > 0)				//limitadores parar nao permitir a sonda sair do planalto planejado.
							contadorX--;
						break;
					case "E":
						if(contadorX < limitePlanaltoX) //limitadores parar nao permitir a sonda sair do planalto planejado.
							contadorX++;
						break;
					case "S":
						if(contadorY > 0)				//limitadores parar nao permitir a sonda sair do planalto planejado.
							contadorY--;
						break;
    			}
    		}
    		if(var == 'L') {
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
    		}
    		if(var == 'R') {
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
    		}
    		
    	}
    	this.atualX = contadorX;
    	this.atualY = contadorY;
    	this.direcaoAtual = direcao;
	}
	
	
}
