package negocios;

import dados.IRepositorioFornecedor;
import exceptions.FornecedorJaExisteException;
import exceptions.FornecedorNaoExisteException;
import exceptions.FornecedorInvalidoException;
import java.util.List;

public class ControladorFornecedores {
	IRepositorioFornecedor repositorio;
	
	public ControladorFornecedores(IRepositorioFornecedor instanciaInterface) {
		this.repositorio = instanciaInterface;
	}
	
	public void cadastrar(Fornecedor fornecedor) throws FornecedorJaExisteException, FornecedorNaoExisteException, FornecedorInvalidoException{
		if(fornecedor == null) {
			throw new FornecedorInvalidoException();
		} else {
			if(this.repositorio.existe(fornecedor.getCodigo()) == false) {
			this.repositorio.inserir(fornecedor);	
			} else if(this.repositorio.existe(fornecedor.getCodigo()) == true) {
				throw new FornecedorJaExisteException(fornecedor.getCodigo());
			}
		}
	}
	
	public Fornecedor buscar(int codigo) throws FornecedorNaoExisteException {
		
		if(this.repositorio.existe(codigo) == true) {
			return this.repositorio.buscar(codigo);
		} else {
			throw new FornecedorNaoExisteException();
		}
	}
	
	public void remover(Fornecedor fornecedor) throws FornecedorNaoExisteException, FornecedorInvalidoException{
		if(fornecedor == null){
			throw new FornecedorInvalidoException();
		}
		else if(this.repositorio.fornecedorContem(fornecedor) == true){
				this.repositorio.remover(fornecedor.getCodigo());
		}
		else if(this.repositorio.fornecedorContem(fornecedor)==false){
			throw new FornecedorNaoExisteException();
		}
		
	}
	
	public void alterar(Fornecedor novoFornecedor) throws FornecedorNaoExisteException, FornecedorJaExisteException, FornecedorInvalidoException {
		if(novoFornecedor == null) {
			throw new FornecedorInvalidoException();
		} 
		else if((novoFornecedor != null && this.repositorio.existe(novoFornecedor.getCodigo()))==true) {
			this.repositorio.alterar(novoFornecedor);
		}
		else if((novoFornecedor != null && this.repositorio.fornecedorContem(novoFornecedor) == false)){
			throw new FornecedorNaoExisteException();
		}
		else if(this.repositorio.fornecedorContem(novoFornecedor)==true){
			throw new FornecedorJaExisteException(novoFornecedor.getCodigo());
		}
	}
	
	public String getTelefone(int codigo) throws FornecedorNaoExisteException {
		if(this.repositorio.existe(codigo) == true) {
		Fornecedor fornecedor = this.repositorio.buscar(codigo);
		return fornecedor.getTelefone();
		} else {
			throw new FornecedorNaoExisteException();
		}	
	}
	
	public List <Fornecedor> listaFornecedores(){
		return this.repositorio.listar();
	}
}