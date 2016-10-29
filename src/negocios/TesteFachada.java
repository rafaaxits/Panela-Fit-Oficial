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
		System.out.println("" +panelafit.listarClientes());
		panelafit.alterarCliente(c, c1);
		System.out.println("" +panelafit.listarClientes());
	
		try{
			panelafit.removerCliente(c1);
		}catch(ClienteNaoExisteException e){
			e.printStackTrace();
			System.out.print("\n");
		}
		System.out.println("" +panelafit.listarClientes());
		
		try{
			System.out.println("" +panelafit.buscarCliente(5));
			}catch (ClienteNaoExisteException e){
				e.printStackTrace();
				System.out.print("\n");
			}
		
		try{
			panelafit.removerCliente(c);
		}catch(ClienteNaoExisteException e){
			e.printStackTrace();
			System.out.print("\n");
		}
		

	}
}