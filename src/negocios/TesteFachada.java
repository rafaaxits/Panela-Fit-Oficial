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
		IPanelaFit panelaFit = PanelaFit.getInstance();
		
		Cliente c =  new Cliente (5, "Zé estranho", "1030358821", 19,"rua 23", "99782632632");
		panelaFit.cadastrarCliente(c);
		System.out.println("" +panelaFit.buscarCliente(5));
	
		Cliente c1 =  new Cliente (554, "Zé esquisito", "237273728", 23,"rua 55", "23767236273");
		System.out.println("" +panelaFit.listarClientes());
		panelaFit.alterarCliente(c, c1);
		System.out.println("" +panelaFit.listarClientes());

		try{
			panelaFit.cadastrarCliente(c1);
		}catch(Exception e){
			e.printStackTrace();
			System.out.print("\n");
		}

		try{
			panelaFit.removerCliente(c1);
		}catch(ClienteNaoExisteException e){
			e.printStackTrace();
			System.out.print("\n");
		}
		System.out.println("" +panelaFit.listarClientes());
		
		try{
			System.out.println("" +panelaFit.buscarCliente(5));
			}catch (ClienteNaoExisteException e){
				e.printStackTrace();
				System.out.print("\n");
			}
		
		try{
			panelaFit.removerCliente(c);
		}catch(ClienteNaoExisteException e){
			e.printStackTrace();
			System.out.print("\n");
		}
		
		Cliente c2 = new Cliente(7, "zé pilinta", "10455882923", 26, "Rua Ernesto Paula Santos", "987984573");
		Cliente c3 = null;
		try{
			panelaFit.alterarCliente(c2, c3);
		}catch(ClienteNaoExisteException e){
			e.printStackTrace();
			System.out.print("\n");
		}
	
			System.out.println(" "+panelaFit.listarClientes());
	}
}