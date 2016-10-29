package negocios;

import beans.Cliente;
import java.util.List;
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
			if(this.repositorio.ClienteExiste(c.getCodigo()) == false) {
			this.repositorio.cadastrarCliente(c);	
			} else if(this.repositorio.ClienteExiste(c.getCodigo()) == true) {
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
	
	public void remover(Cliente cliente) throws ClienteNaoExisteException {
	if(cliente == null || this.repositorio.ClienteExiste(cliente.getCodigo())==false){
		throw new ClienteNaoExisteException();
	}
	else{
		if(this.repositorio.ClienteExiste(cliente.getCodigo()) == true){
			this.repositorio.removerCliente(cliente.getCodigo());
		}
	}
}
	
	public void alterar(Cliente clienteAlterado, Cliente novoCliente) throws ClienteNaoExisteException, ClienteJaExisteException{
		if(clienteAlterado == null && novoCliente == null) {
			throw new ClienteNaoExisteException();
		} else if((clienteAlterado !=null && this.repositorio.ClienteExiste(clienteAlterado.getCodigo())==true) && novoCliente !=null) {
			this.repositorio.alterarCliente(clienteAlterado, novoCliente);
		}
		else if((clienteAlterado !=null && this.repositorio.ClienteExiste(clienteAlterado.getCodigo())==false) && novoCliente !=null){
			throw new ClienteNaoExisteException();
		}
		else if(clienteAlterado.equals(novoCliente)) {
			throw new ClienteJaExisteException(clienteAlterado.getCodigo());
		}
}
	public List<Cliente> listaClientes(){
		return this.repositorio.listar();
	}
	
}
