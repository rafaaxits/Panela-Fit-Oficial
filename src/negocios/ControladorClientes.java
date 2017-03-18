package negocios;

import java.util.List;
import dados.IRepositorioCliente;
import exceptions.ClienteJaExisteException;
import exceptions.ClienteNaoExisteException;
import exceptions.FormatacaoInvalidaException;

public class ControladorClientes {
	IRepositorioCliente repositorio;
	
	public ControladorClientes(IRepositorioCliente instanciaInterface){
		if(instanciaInterface !=null){
		this.repositorio = instanciaInterface;
		} else {
		      // argumento invalido
		      IllegalArgumentException x = new IllegalArgumentException(
		          "Reposit�rio inv�lido.");
		      throw x;
		    }
	}
	
	public void cadastrar(Cliente cliente) throws ClienteJaExisteException, FormatacaoInvalidaException {
		if(cliente == null) {
			throw new FormatacaoInvalidaException ();
		} else {
			if(this.repositorio.existe(cliente.getCodigo()) == false) {
			this.repositorio.inserir(cliente);	
			this.repositorio.salvarArquivo();
			} else if(this.repositorio.existe(cliente.getCodigo()) == true) {
				throw new ClienteJaExisteException(cliente.getCodigo());
			}
		}
	}
	
	public Cliente buscar(int codigo) throws ClienteNaoExisteException {
		if(this.repositorio.existe(codigo) == true) {
			return this.repositorio.buscar(codigo);
		} else{
			throw new ClienteNaoExisteException();
		}
	}
	
	public void remover(Cliente cliente) throws ClienteNaoExisteException, FormatacaoInvalidaException {
	if(cliente == null){
		throw new FormatacaoInvalidaException();
	}
	else if(this.repositorio.clienteContem(cliente) == true){
			this.repositorio.remover(cliente.getCodigo());	
			this.repositorio.salvarArquivo();
	}
	else if(this.repositorio.clienteContem(cliente)==false){
		throw new ClienteNaoExisteException();
	}
}
	
	public void alterar(Cliente novoCliente) throws ClienteNaoExisteException, ClienteJaExisteException, FormatacaoInvalidaException{
		if(novoCliente == null) {
			throw new FormatacaoInvalidaException();
		} 
		else if (this.repositorio.clienteContem(novoCliente)==true) {
			throw new ClienteJaExisteException(novoCliente.getCodigo());
		}
		else if((novoCliente != null && this.repositorio.existe(novoCliente.getCodigo())==true)) {
			this.repositorio.alterar(novoCliente);
			this.repositorio.salvarArquivo();
		}
		else if((this.repositorio.existe(novoCliente.getCodigo())==false)){
			throw new ClienteNaoExisteException();
		}
		
}
	public boolean existe(int codigo) throws ClienteNaoExisteException{
		boolean alt=false;
			if(repositorio.existe(codigo)==true){
				alt=true;
			}else{
				throw new ClienteNaoExisteException();
			}
		return alt;
		
	}
	
	public List<Cliente> listaClientes(){
		return this.repositorio.listar();
	}
	
}
