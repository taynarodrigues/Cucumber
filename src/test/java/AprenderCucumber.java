
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import cucumber.api.Transform;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class AprenderCucumber {
	

	
	@Dado("^que criei o arquivo corretamente$")
	public void queCrieiOArquivoCorretamente()  throws Throwable{
	    System.out.println("qualquer coisa");
	}

	@Quando("^executá-lo$")
	public void executáLo()  throws Throwable {
	  
	}

	
	@Então("^a especificação deve finalizar com sucesso$")
	public void aEspecificaçãoDeveFinalizarComSucesso() {

	}
	
	private int contador = 0;
	
	@Dado("^que o valor do contador é (\\d+)$")
	public void que_o_valor_do_contador_é(int arg1) throws Throwable {
		   contador = arg1;
	}

	@Quando("^eu incrementar em (\\d+)$")
	public void eu_incrementar_em(int arg1) throws Throwable {
	   contador = contador + arg1;
	}

	@Então("^o valor do contador será (\\d+)$")
	public void o_valor_do_contador_será( int arg1)  throws Throwable {

	    Assert.assertEquals(arg1, contador);
	  
	}
	
	Date entrega = new Date();
	
	@Dado("^que a entrega é dia (.*)$")
	public void que_a_entrega_é_dia(@Transform(DateConverter.class) Date data) throws Throwable {
		entrega = data;
		System.out.println(entrega);
	   
	}

	@Quando("^a entrega atrasar em (\\d+) (dia|dias|mes|meses)$")
	public void a_entrega_atrasar_em_dias(int arg1, String tempo) throws Throwable {
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(entrega);
		 if(tempo.contentEquals("dias")) {
			 cal.add(Calendar.DAY_OF_MONTH, arg1);
		 }
		 if(tempo.contentEquals("meses")) {
			 cal.add(Calendar.MONTH, arg1);
		 }
		 entrega = cal.getTime();
	}

	@Então("^a entrega será efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
	public void a_entrega_será_efetuada_em(String data) throws Throwable{
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = format.format(entrega);
		Assert.assertEquals(data, dataFormatada);
	}
	
	
	@Dado("^que o ticket( especial)? é (A.\\d{3})$")
	public void que_o_ticket_é_AF(String tipo, String arg1) throws Throwable {
	    
	}

	@Dado("^que o valor da passagem é  R\\$ (.*)$")
	public void que_o_valor_da_passagem_é_R$(Double numero) throws Throwable {
		System.out.println(numero);
	    
	}

	@Dado("^que o nome do passageiro é \"(.{5,20})\"$")
	public void que_o_nome_do_passageiro_é(String string) throws Throwable {
	    
	}

	@Dado("^que o telefone do passageiro é (9\\d{3}-\\d{4})$")
	public void que_o_telefone_do_passageiro_é(String telefone) throws Throwable{
	   
	}

	@Quando("^criar steps$")
	public void criar_steps() throws Throwable{
	   
	}

	@Então("^o teste vai funcionar$")
	public void o_teste_vai_funcionar() throws Throwable{
	    
	}
	    
}

	


