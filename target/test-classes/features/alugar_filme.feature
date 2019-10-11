#language: pt

Funcionalidade: Alugar Filme
	Como um usuário
	Eu quero cadastrar aluguéisde filmes
	Para controlar preços e datas de entrega
	
Cenario: Deve alugar um filme com sucesso
	Dado um filme com estoque de 2 unidades
	E que o preço de aluguel seja R$ 3
	Quando alugar
	Então o preço do aluguel será R$ 3
	E a data de entrega será em 1 dia
	E o estoque do filme será 1 unidade
	
Cenario: Não deve alugar filme sem estoque
	Dado um filme com estoque de 0 unidades
	Quando alugar
	Então não será possível por falta de estoque
	E o estoque do filme será 0 unidade
		
Cenario: Deve dar condições especiais para categoria extendida
	Dado um filme com estoque de 2 unidades
	E que o preço de aluguel seja R$ 4
	E que o tipo do aluguel seja extendido
	Quando alugar
	Então o preço do aluguel será R$ 8
	E a data de entrega será em 3 dias
	E a pontuação será de 2 pontos
	
	Cenario: Deve alugar para categoria comum
	Dado um filme com estoque de 2 unidades
	E que o preço do aluguel seja R$ 4
	E que o tipo do aluguel seja comum
	Quando alugar
	Então o preço do aluguel sera R$ 4
	E a data de entrega será em 1 dia
	E a pontuação sera de 1 pontos