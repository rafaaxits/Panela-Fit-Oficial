package negocios;

import java.util.List;
import dados.IRepositorioCliente;
import exceptions.ClienteJaExisteException;
import exceptions.ClienteNaoExisteException;
import exceptions.ClienteInvalidoException;

public class ControladorClientes {
	IRepositorioCliente repositorio;
	
	public ControladorClientes(IRepositorioCliente instanciaInterface){
		this.repositorio = instanciaInterface;
	}
	
	public void cadastrar(Cliente cliente) throws ClienteJaExisteException, ClienteNaoExisteException, ClienteInvalidoException {
		if(cliente == null) {
			throw new ClienteInvalidoException ();
		} else {
			if(this.repositorio.clienteExiste(cliente.getCodigo()) == false) {
			this.repositorio.cadastrarCliente(cliente);	
			} else if(this.repositorio.clienteExiste(cliente.getCodigo()) == true) {
				throw new ClienteJaExisteException(cliente.getCodigo());
			}
		}
	}
	
	public Cliente buscar(int codigo) throws ClienteNaoExisteException {
		if(this.repositorio.clienteExiste(codigo) == true) {
			return this.repositorio.buscarCliente(codigo);
		} else {
			throw new ClienteNaoExisteException();
		}
	}
	
	public void remover(Cliente cliente) throws ClienteNaoExisteException, ClienteInvalidoException {
	if(cliente == null){
		throw new ClienteInvalidoException();
	}
	else if(this.repositorio.clienteContem(cliente) == true){
			this.repositorio.removerCliente(cliente.getCodigo());	
	}
	else if(this.repositorio.clienteContem(cliente)==false){
		throw new ClienteNaoExisteException();
	}
}
	
	public void alterar(Cliente clienteAlterado, Cliente novoCliente) throws ClienteNaoExisteException, ClienteJaExisteException, ClienteInvalidoException{
		if(clienteAlterado == null || novoCliente == null) {
			throw new ClienteInvalidoException();
		} 
		else if(this.repositorio.clienteContem(clienteAlterado)==true && (novoCliente != null && this.repositorio.clienteContem(novoCliente)==false)) {
			this.repositorio.alterarCliente(clienteAlterado, novoCliente);
		}
		else if((clienteAlterado !=null && this.repositorio.clienteContem(clienteAlterado)==false)){
			throw new ClienteNaoExisteException();
		}
		else {
			throw new ClienteJaExisteException(clienteAlterado.getCodigo());
		}
}
	public List<Cliente> listaClientes(){
		return this.repositorio.listar();
	}
	
}
