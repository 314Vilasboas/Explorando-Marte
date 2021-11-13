package algoritmo.Principal;
import java.util.Scanner; 

public class Main {

	public static void main(String[] args) {
		
		 Scanner scanner = new Scanner(System.in); 
		 Planalto planalto;
		 int cordX, cordY, numeroSondas;
		 Sonda[] sondas;
		
		System.out.println("Digite o tamanho X e Y do planalto: ");
		cordX = scanner.nextInt();
	 	cordY = scanner.nextInt();
	 	
	 	while( (cordX <= 0 && cordY <= 0) ) {
		 	System.out.println("Digite um tamanho positivo e maior que Zero!:");
		 	cordX = scanner.nextInt();
		 	cordY = scanner.nextInt();
	 	}
		while(cordX <= 0) {
			System.out.println("Digite um tamanho positivo e maior que Zero para a coordenada X!:");
			cordX = scanner.nextInt();
		} 
		while(cordY <= 0) {
	 		System.out.println("Digite um tamanho positivo e maior que Zero para a coordenada Y!:");
	  		cordY= scanner.nextInt();
		}
	 	
	    planalto = new Planalto(cordX, cordY);
	    
	    System.out.println("Defina quantas sondas serão enviadas: ");
	    numeroSondas = scanner.nextInt();
	    /*
	     * a ideia dessas validações abaixo é para conduzir o usuário a definir um número positivo e realista de sondas.
	     * por exemplo, um planalto 2 por 2 nao ter um número desnecessariamente grande de sondas
	     *
	     */
	    while( numeroSondas <= 0 ) {
	    	 System.out.println("Quantia invalida, defina um número maior que Zero! ");
	    	 numeroSondas = scanner.nextInt();
	    }
	    while( numeroSondas > (cordX + cordY)/2 ) {
	    	System.out.printf("Defina um número dentro do capital permitido pela NASA! Digite um número igual ou menor que %s\n", (cordX + cordY)/2);
	    	numeroSondas = scanner.nextInt();
	    }
	    sondas = new Sonda[numeroSondas];
	    
	    for(int i = 0; i<numeroSondas; i++) {
	    	
	    	System.out.printf("Digite as coordenadas iniciais da sonda de número %s:\n",i+1);
	    	int iniX = scanner.nextInt();
		 	int iniY = scanner.nextInt();
		 	while( (iniX > cordX && iniY > cordY) || (iniX > cordX) || (iniY > cordY) || (iniX < 0 && iniY < 0) || (iniX < 0) || (iniY < 0) ) {
		 		System.out.println("Coordenada incorreta, por favor digite uma Coordenada válida baseada no tamanho do planalto!:");
		 		 iniX = scanner.nextInt();
			 	 iniY = scanner.nextInt();
		 	}
		 	scanner.nextLine();
		 	
		 	System.out.printf("Digite o ponto cardinal inicial da sonda de número %s (N-W-E-S):\n", i+1);
		 	String cardinal = scanner.nextLine();
		 	cardinal.toUpperCase();
		 	
		 	while( !cardinal.equals("N") && !cardinal.equals("E") && !cardinal.equals("W") && !cardinal.equals("S") ) {
		 		System.out.println("Coordenada incorreta, por favor digite uma dessas quatro opções(N-W-E-S):");
		 	    cardinal = scanner.nextLine();
		 	    cardinal.toUpperCase();
		 	}
	    	
		 	Sonda sonda = new Sonda(iniX, iniY, cardinal);
		 	
		 	String listaMov;
		 	
		 	System.out.println("Digite as ordens de movimentação para a Sonda(lembre-se: L para virar 90 graus a esquerda,"
		 			+ " R para virar 90 graus a direita, M para movimentar-se para frente):");
		
		 	listaMov = scanner.nextLine();
			listaMov.toUpperCase();
			
			
			sonda.setComando(listaMov);
			sondas[i] = sonda;
			
			
	    }
	    
	    for(int i =0; i < numeroSondas; i++) {
	    	
	    	Sonda sonda = sondas[i];
	    	
	    	sonda.executaComando(planalto.getLimiteX(), planalto.getLimiteY());
	    	
	    	System.out.printf("A sonda de número %s pousou nas coordenadas ( %s, %s, %s)!\n", i+1, sonda.getAtualX(), sonda.getAtualY(), sonda.getDirecaoAtual() );
	    	
	    	int quantidadeSondas = planalto.atualiza(sonda.getAtualX(), sonda.getAtualY());
	    	if(quantidadeSondas > 1) {
	    		System.out.println("	A sonda acima está compartilhando o espaço com outras sondas\n");
	    	}
	    }
		
	}

}
