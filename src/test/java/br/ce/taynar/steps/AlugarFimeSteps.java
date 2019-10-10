package br.ce.taynar.steps;

import java.util.Calendar;
import java.util.Date;

import br.ce.taynar.entidades.Filme;
import br.ce.taynar.entidades.NotaAluguel;
import br.ce.taynar.servicos.AluguelService;
import cucumber.api.PendingException;
import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Então;
import junit.framework.Assert;

public class AlugarFimeSteps {
	
	private Filme filme;
	private AluguelService aluguel = new AluguelService();
	private NotaAluguel nota;
	private String erro;
	
	@Dado("^um filme com estoque de (\\d+) unidades$")
	public void umFilmeComEstoqueDeUnidades(int arg1) throws Throwable {
	    filme = new Filme();
	    filme.setEstoque(arg1);
	}

	@Dado("^que o preço de aluguel seja R\\$ (\\d+)$")
	public void queOPreçoDeAluguelSejaR$(int arg1) throws Throwable {
	    filme.setAluguel(arg1);
	}

	@Quando("^alugar$")
	public void alugar() throws Throwable {
		try {
			nota = aluguel.alugar(filme);
		}catch (RuntimeException e) {
			erro = e.getMessage();
		}
	   
	}

	@Então("^o preço do aluguel será R\\$ (\\d+)$")
	public void oPreçoDoAluguelSeráR$(int arg1) throws Throwable {
	    Assert.assertEquals(arg1, nota.getPreco());
	}

	@Então("^a data de entrega será no dia seguinte$")
	public void aDataDeEntregaSeráNoDiaSeguinte() throws Throwable {
	  Calendar cal = Calendar.getInstance();
	  cal.add(Calendar.DAY_OF_MONTH, 1);
	  
	  Date dataRetorno = nota.getDataEntrega();
	  Calendar calRetorno = Calendar.getInstance();
	  calRetorno.setTime(dataRetorno);
	  
	  Assert.assertEquals(cal.get(Calendar.DAY_OF_MONTH), calRetorno.get(Calendar.DAY_OF_MONTH));
	  Assert.assertEquals(cal.get(Calendar.MONTH), calRetorno.get(Calendar.MONTH));
	  Assert.assertEquals(cal.get(Calendar.YEAR), calRetorno.get(Calendar.YEAR));
	  
	}

	@Então("^o estoque do filme será (\\d+) unidade$")
	public void oEstoqueDoFilmeSeráUnidade(int arg1) throws Throwable {
	    Assert.assertEquals(arg1, filme.getEstoque());
	}
	
	@Então("^não será possível por falta de estoque$")
	public void nãoSeráPossívelPorFaltaDeEstoque() throws Throwable {
	    Assert.assertEquals("Filme sem estoque", erro);
	}


}
