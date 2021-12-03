package algoritmo.Principal;
import java.util.Arrays;
import java.util.Scanner; 
// necessidade de inicial e final para as coords da sonda, Validar o pouso, a movimentacao e o final(sobre colisoes) e criar a classe posicao que encapsula X e Y.
public class Main {

	public static void main(String[] args) {
		
		 Scanner scanner = new Scanner(System.in); 
		 Planalto planalto;	
		 int cordX, cordY, numeroSondas;
		 Sonda[] sondas;
		 
		 boolean caminhoInterrompido;
		
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
		 	
		 	if(planalto.posicaoLivre(iniX, iniY) == true) {
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
				caminhoInterrompido = sonda.executaComando(planalto);
				if(caminhoInterrompido) {
					System.out.printf("Trajeto interrompido por perigo de colisão a frente, sonda de número %s imobilizada.\n\n", i + 1);
				}
				planalto.atualiza(sonda.getPosX(), sonda.getPosY());
				sondas[i] = sonda;
				
		 	}else {
		 		System.out.println("Lançamento abortado para sonda atual, espaco lotado."); 			
		 		int indiceSonda = 0;
		 		
		 		for(int j = 0; j<sondas.length; j++) {
		 			Sonda sonda = sondas[j];
		 			if(sonda != null && sonda.getPosX() == iniX && sonda.getPosY() == iniY)
		 				indiceSonda = j;
		 		}
		 		
		 		System.out.printf("Sonda número %s já ocupa esse local do planalto.\n\n", indiceSonda+1);
		 		
		 		//procurar na lista de sondas qual ocupa esse espaco
		 		//imprimir qual sonda ocupa o espaco
		 		
		 	}
		 			
	    }
	    
	    for(int i =0; i < sondas.length; i++) {
	    	
	    	Sonda sonda = sondas[i];
	    	
	    	
	    	//arrumar o print final que mostra todas as posicoes das sondas enviadas
	    	if(sonda != null) {
	    		System.out.printf("A sonda de número %s pousou nas coordenadas ( %s, %s, %s)!\n", i+1, sonda.getPosX(), sonda.getPosY(), sonda.getDirecaoAtual() );
	    	}else {
	    		System.out.printf("O envio da sonda de número %s foi abortada!\n", i+1);
	    	}
	    	
	    }
		
	}

}
