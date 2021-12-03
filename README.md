# Explorando-Marte

  Um programa básico, que começa pedindo ao usuário que defina o tamanho do planalto ao receber os valores dos eixos X e Y de um plano cartesiano.
Validações são feitas para evitar o uso de valores inválidos, como números negativos. O próximo passo envolve em definir o número de sondas que serão enviadas 
ao planalto em marte. É feito um pedido ao usuário de um número inteiro, o qual é validado para não ser negativo e também não ser desnecessariamente grande, 
para evitar que o número de sondas nao seja maior que o tamanho definido para o Planalto.

  Duas classes, chamadas de Planalto e Sonda, são usadas para criar e cuidar dos métodos envolvendo as Sondas e o planalto criados. A classe Sonda, cuida do
próximo passo. Onde ocorre a maior e mais importante função do usuário. O controle e comando das sondas enviadas. Métodos pedem ao usuário o local de pouso e 
uma string de comandos que será lida, caractere a caractere, para definir a movimentação da sonda no planalto. ao término dessas ações, a posição final da sonda 
é colocada em um vetor para futuro uso em uma validação.

  Para terminar, o programa demonstra na tela a posição final, a direção cardinal em que a sonda está apontando e avisa o usuário se ela compartilha do mesmo espaço que 
outra Sonda, a partir da validação que se usa do vetor anteriormente mencionado.

