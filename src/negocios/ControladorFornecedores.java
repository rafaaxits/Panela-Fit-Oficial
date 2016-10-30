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
	
	public void cadastrar(Fornecedor f) throws FornecedorJaExisteException, FornecedorNaoExisteException, FornecedorInvalidoException{
		if(f == null) {
			throw new FornecedorInvalidoException();
		} else {
			if(this.repositorio.fornecedorExiste(f.getCodigo()) == false) {
			this.repositorio.cadastrarFornecedor(f);	
			} else if(this.repositorio.fornecedorExiste(f.getCodigo()) == true) {
				throw new FornecedorJaExisteException(f.getCodigo());
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
	
	public void remover(Fornecedor f) throws FornecedorNaoExisteException, FornecedorInvalidoException{
		if(f == null){
			throw new FornecedorInvalidoException();
		}
		else if(this.repositorio.fornecedorContem(f) == true){
				this.repositorio.removerFornecedor(f.getCodigo());
		}
		else if(this.repositorio.fornecedorContem(f)==false){
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
		Fornecedor f = this.repositorio.buscarFornecedor(codigo);
		return f.getTelefone();
		} else {
			throw new FornecedorNaoExisteException();
		}	
	}
	
	public List <Fornecedor> listaFornecedores(){
		return this.repositorio.listar();
	}
}