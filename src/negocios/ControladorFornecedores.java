package negocios;

import beans.Fornecedor;
import dados.IRepositorioFornecedor;
import exceptions.FornecedorJaExisteException;
import exceptions.FornecedorNaoExisteException;

public class ControladorFornecedores {
	IRepositorioFornecedor repositorio;
	
	public ControladorFornecedores(IRepositorioFornecedor instanciaInterface) {
		this.repositorio = instanciaInterface;
	}
	
	public void cadastrar(Fornecedor f) throws FornecedorJaExisteException {
		if(f == null) {
			throw new IllegalArgumentException("");
		} else {
			if(this.repositorio.fornecedorExiste(f.getCodigo()) == true) {
				this.repositorio.cadastrarFornecedor(f);
			} else if(this.repositorio.fornecedorExiste(f.getCodigo()) == false) {
				FornecedorJaExisteException c = new FornecedorJaExisteException(f.getCodigo());
				throw c;
			}
		}
	}
	
	public Fornecedor buscar(int codigo) throws FornecedorNaoExisteException {
		
		if(this.repositorio.fornecedorExiste(codigo) == true) {
			return this.repositorio.buscarFornecedor(codigo);
		} else {
			throw new FornecedorNaoExisteException(codigo);
		}
	}
	
	public void remover(Fornecedor f) throws FornecedorNaoExisteException {
		if(f == null) {
			throw new IllegalArgumentException("");
		} else {
			if(this.repositorio.fornecedorExiste(f.getCodigo()) == true) {
				this.repositorio.removerFornecedor(f.getCodigo());
			} else if(this.repositorio.fornecedorExiste(f.getCodigo()) == false) {
				FornecedorNaoExisteException r = new FornecedorNaoExisteException(f.getCodigo());
				throw r;
			}
		}
		
	}
	
	public void alterar(Fornecedor fornAlterado, Fornecedor novoFornecedor) throws FornecedorNaoExisteException {
		if(fornAlterado != null && novoFornecedor != null) {
			this.repositorio.alterarFornecedor(fornAlterado, novoFornecedor);
		} else {
			if(fornAlterado == null || novoFornecedor == null) {
				IllegalArgumentException a = new IllegalArgumentException("");
				throw a;
			}
		}
	}
	
	public String getTelefone(int codigo) throws FornecedorNaoExisteException {
		if(this.repositorio.fornecedorExiste(codigo) == true) {
		Fornecedor f = this.repositorio.buscarFornecedor(codigo);
		return f.getTelefone();
		} else {
			throw new FornecedorNaoExisteException(codigo);
		}	
	}
}