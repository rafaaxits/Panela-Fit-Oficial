package negocios;

import beans.Cliente;
import dados.IRepositorioCliente;
import exceptions.ClienteJaExisteException;
import exceptions.ClienteNaoExisteException;

public class ControladorClientes {
	IRepositorioCliente repositorio;
	
	public ControladorClientes(IRepositorioCliente instanciaInterface){
		this.repositorio = instanciaInterface;
	}
	
	public void cadastrar(Cliente c) throws ClienteJaExisteException, ClienteNaoExisteException {
		if(c == null) {
			throw new ClienteNaoExisteException();
		} else {
			if(this.repositorio.ClienteExiste(c.getCodigo()) == true) {
			this.repositorio.cadastrarCliente(c);	
			} else if(this.repositorio.ClienteExiste(c.getCodigo()) == false) {
				throw new ClienteJaExisteException(c.getCodigo());
				
			}
			
		}
	}
	
	public Cliente buscar(int codigo) throws ClienteNaoExisteException {
		if(this.repositorio.ClienteExiste(codigo) == true) {
			return this.repositorio.buscarCliente(codigo);
		} else {
			throw new ClienteNaoExisteException();
		}
	}
	
	public void remover(Cliente c) throws ClienteNaoExisteException {
	if(c == null) {
		throw new IllegalArgumentException("");
	} else {
		if(this.repositorio.ClienteExiste(c.getCodigo()) == true) {
			this.repositorio.removerCliente(c.getCodigo());
		} else if(this.repositorio.ClienteExiste(c.getCodigo()) == false) {
			ClienteNaoExisteException x = new ClienteNaoExisteException(c.getCodigo());
			throw x;
		}
	}
}
	
	public void alterar(Cliente clienteAlterado, Cliente novoCliente) throws ClienteNaoExisteException {
		if(clienteAlterado != null && novoCliente != null) {
			this.repositorio.alterarCliente(clienteAlterado, novoCliente);
		} else {
			if(clienteAlterado == null || novoCliente == null) {
				IllegalArgumentException x = new IllegalArgumentException("");
				throw x;
			}
	}

}
	
}
