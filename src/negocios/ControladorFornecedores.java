package negocios;

import dados.IRepositorioFornecedor;
import exceptions.FornecedorJaExisteException;
import exceptions.FornecedorNaoExisteException;
import exceptions.FormatacaoInvalidaException;
import java.util.List;

public class ControladorFornecedores {
	IRepositorioFornecedor repositorio;
	
	public ControladorFornecedores(IRepositorioFornecedor instanciaInterface) {
		if(instanciaInterface !=null){
		this.repositorio = instanciaInterface;
		} else {
		      // argumento invalido
		      IllegalArgumentException x = new IllegalArgumentException(
		          "Reposit�rio inv�lido.");
		      throw x;
		    }
	}
	
	public void cadastrar(Fornecedor fornecedor) throws FornecedorJaExisteException,  FormatacaoInvalidaException{
		if(fornecedor == null) {
			throw new FormatacaoInvalidaException();
		} else {
			if(this.repositorio.existe(fornecedor.getCodigo()) == false) {
			this.repositorio.inserir(fornecedor);	
			this.repositorio.salvarArquivo();
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
	
	public void remover(Fornecedor fornecedor) throws FornecedorNaoExisteException, FormatacaoInvalidaException{
		if(fornecedor == null){
			throw new FormatacaoInvalidaException();
		}
		else if(this.repositorio.fornecedorContem(fornecedor) == true){
				this.repositorio.remover(fornecedor.getCodigo());
				this.repositorio.salvarArquivo();
		}
		else if(this.repositorio.fornecedorContem(fornecedor)==false){
			throw new FornecedorNaoExisteException();
		}
		
	}
	
	public void alterar(Fornecedor novoFornecedor) throws FornecedorNaoExisteException, FornecedorJaExisteException, FormatacaoInvalidaException{
		if(novoFornecedor == null) {
			throw new FormatacaoInvalidaException();
		}
		else if(this.repositorio.fornecedorContem(novoFornecedor)==true){
			throw new FornecedorJaExisteException(novoFornecedor.getCodigo());
		}
		else if((novoFornecedor != null && this.repositorio.existe(novoFornecedor.getCodigo()))==true) {
			this.repositorio.alterar(novoFornecedor);
			this.repositorio.salvarArquivo();
		}
		else if((this.repositorio.existe(novoFornecedor.getCodigo()) == false)){
			throw new FornecedorNaoExisteException();
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
	
	public boolean existe(int codigo) throws FornecedorNaoExisteException{
		boolean alt = false;
			if(repositorio.existe(codigo)){
				alt=true;
			}else{
				throw new FornecedorNaoExisteException();
			}
			return alt;
	}
	
	public List <Fornecedor> listaFornecedores(){
		return this.repositorio.listar();
	}
}