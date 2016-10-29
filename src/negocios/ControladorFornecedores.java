package negocios;

import beans.Fornecedor;
import dados.IRepositorioFornecedor;
import exceptions.FornecedorJaExisteException;
import exceptions.FornecedorNaoExisteException;
import java.util.List;

public class ControladorFornecedores {
	IRepositorioFornecedor repositorio;
	
	public ControladorFornecedores(IRepositorioFornecedor instanciaInterface) {
		this.repositorio = instanciaInterface;
	}
	
	public void cadastrar(Fornecedor f) throws FornecedorJaExisteException, FornecedorNaoExisteException {
		if(f == null) {
			throw new FornecedorNaoExisteException();
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
	
	public void remover(Fornecedor f) throws FornecedorNaoExisteException {
		if(f == null || this.repositorio.fornecedorExiste(f.getCodigo()) == false){
			throw new FornecedorNaoExisteException();
		}
		else{
			if(this.repositorio.fornecedorExiste(f.getCodigo()) == true){
				this.repositorio.removerFornecedor(f.getCodigo());
			}
		}
		
	}
	
	public void alterar(Fornecedor fornAlterado, Fornecedor novoFornecedor) throws FornecedorNaoExisteException, FornecedorJaExisteException {
		if(fornAlterado == null && novoFornecedor == null) {
			throw new FornecedorNaoExisteException();
		} else if((fornAlterado != null && this.repositorio.fornecedorExiste(fornAlterado.getCodigo())==true) && novoFornecedor != null) {
			this.repositorio.alterarFornecedor(fornAlterado, novoFornecedor);
		}
		else if((fornAlterado != null && this.repositorio.fornecedorExiste(fornAlterado.getCodigo()) == false)){
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