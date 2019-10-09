
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
	    System.out.println(arg1);
	    System.out.println(contador);
	    System.out.println(arg1 == contador);
	}
	    
}

	


