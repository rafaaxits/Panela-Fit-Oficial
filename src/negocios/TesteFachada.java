package negocios;

import beans.Cliente;
import beans.Fornecedor;
import beans.Funcionario;
import beans.MateriaPrima;
import beans.Produto;
import exceptions.ClienteNaoExisteException;
import exceptions.ClienteJaExisteException;

public class TesteFachada {

	public static void main(String[] args) throws ClienteNaoExisteException, ClienteJaExisteException {
		IPanelaFit panelafit = PanelaFit.getInstance();
		
		Cliente c =  new Cliente (5, "Zé estranho", "1030358821", 19,"rua 23", "99782632632");
		panelafit.cadastrarCliente(c);
		System.out.println("" +panelafit.buscarCliente(5));
		
		Cliente c1 =  new Cliente (554, "Zé esquisito", "237273728", 23,"rua 55", "23767236273");
		panelafit.cadastrarCliente(c1);
		System.out.println("" +panelafit.alterarCliente(c1));
		System.out.println("" +panelafit.buscarCliente(5));
		try {
			panelafit.removerCliente(5);
		} catch (ClienteNaoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("" +panelafit.buscarCliente(5));
		try {
			panelafit.removerCliente(554);
		} catch (ClienteNaoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("" +panelafit.buscarCliente(554));
	}

}
