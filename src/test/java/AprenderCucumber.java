
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class AprenderCucumber {
	

	
	@Dado("que criei o arquivo corretamente")
	public void queCrieiOArquivoCorretamente() {
	    System.out.println("qualquer coisa");
	}

	@Quando("executá-lo")
	public void executáLo() {
	  
	}

	
	@Então("a especificação deve finalizar com sucesso")
	public void aEspecificaçãoDeveFinalizarComSucesso() {

	}
	
	private int contador = 0;
	
	@Dado("que o valor do contador é {int}")
	public void que_o_valor_do_contador_é(int arg1) throws Throwable {
		   contador = arg1;
	}

	@Quando("eu incrementar em {int}")
	public void eu_incrementar_em(int arg1) throws Throwable {
	   contador = contador + arg1;
	}

	@Então("o valor do contador será {int}")
	public void o_valor_do_contador_será( int arg1)  throws Throwable {

	    Assert.assertEquals(arg1, contador);
	  
	}
	
	Date entrega = new Date();
	
	@Dado("que a entrega é dia {int}\\/{int}\\/{int}")
	public void que_a_entrega_é_dia(int dia, int mes, int ano) {
	    Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.DAY_OF_MONTH, dia);
	    cal.set(Calendar.MONTH,mes);
	    cal.set(Calendar.YEAR, ano);
	    entrega = cal.getTime();
	}

	@Quando("a entrega atrasar em {int} dias")
	public void a_entrega_atrasar_em_dias(int arg1) {
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(entrega);
		 cal.add(Calendar.DAY_OF_MONTH, arg1);
		 entrega = cal.getTime();
	}

	@Então("a entrega será efetuada em {int}\\/{int}\\/{int}")
	public void a_entrega_será_efetuada_em(int arg1, int arg2, int arg3) {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new cucumber.api.PendingException();
	}
	    
}

	


