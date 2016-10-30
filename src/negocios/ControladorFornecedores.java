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
			if(this.repositorio.fornecedorExiste(fornecedor.getCodigo()) == false) {
			this.repositorio.cadastrarFornecedor(fornecedor);	
			} else if(this.repositorio.fornecedorExiste(fornecedor.getCodigo()) == true) {
				throw new FornecedorJaExisteException(fornecedor.getCodigo());
			}
		}
	}
	
	public Fornecedor buscar(int codigo) throws FornecedorNaoExisteException {
		
		if(this.repositorio.fornecedorExiste(codigo) == true) {
			return this.repositorio.buscarFornecedor(codigo);
		} else {
			throw new FornecedorNaoExisteException();
		}
	}
	
	public void remover(Fornecedor fornecedor) throws FornecedorNaoExisteException, FornecedorInvalidoException{
		if(fornecedor == null){
			throw new FornecedorInvalidoException();
		}
		else if(this.repositorio.fornecedorContem(fornecedor) == true){
				this.repositorio.removerFornecedor(fornecedor.getCodigo());
		}
		else if(this.repositorio.fornecedorContem(fornecedor)==false){
			throw new FornecedorNaoExisteException();
		}
		
	}
	
	public void alterar(Fornecedor fornAlterado, Fornecedor novoFornecedor) throws FornecedorNaoExisteException, FornecedorJaExisteException, FornecedorInvalidoException {
		if(fornAlterado == null || novoFornecedor == null) {
			throw new FornecedorInvalidoException();
		} 
		else if(this.repositorio.fornecedorContem(fornAlterado)==true && (novoFornecedor != null && this.repositorio.fornecedorContem(novoFornecedor))==false) {
			this.repositorio.alterarFornecedor(fornAlterado, novoFornecedor);
		}
		else if((fornAlterado != null && this.repositorio.fornecedorContem(fornAlterado) == false)){
			throw new FornecedorNaoExisteException();
		}
		else {
			throw new FornecedorJaExisteException(fornAlterado.getCodigo());
		}
	}
	
	public String getTelefone(int codigo) throws FornecedorNaoExisteException {
		if(this.repositorio.fornecedorExiste(codigo) == true) {
		Fornecedor fornecedor = this.repositorio.buscarFornecedor(codigo);
		return fornecedor.getTelefone();
		} else {
			throw new FornecedorNaoExisteException();
		}	
	}
	
	public List <Fornecedor> listaFornecedores(){
		return this.repositorio.listar();
	}
}