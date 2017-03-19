package negocios;

import dados.IRepositorioProduto;
import exceptions.ProdutoJaExisteException;
import exceptions.ProdutoNaoExisteException;
import exceptions.FormatacaoInvalidaException;
import java.time.*;
import java.util.List;

public class ControladorProdutos {
	 IRepositorioProduto repositorio;
	
	public ControladorProdutos(IRepositorioProduto instanciaInterface){
		if(instanciaInterface !=null){
		this.repositorio = instanciaInterface;
		} else {
		      // argumento invalido
		      IllegalArgumentException x = new IllegalArgumentException(
		          "Reposit�rio inv�lido.");
		      throw x;
		    }
	}


	public void cadastrar(Produto produto) throws ProdutoJaExisteException, FormatacaoInvalidaException{
		if(produto == null) {
			throw new FormatacaoInvalidaException();
		} else {
			if(this.repositorio.existe(produto.getCodigo()) == false){
				this.repositorio.inserir(produto);
				this.repositorio.salvarArquivo();
			} else if(this.repositorio.existe(produto.getCodigo()) == true) {
				throw new ProdutoJaExisteException(produto.getCodigo());
				
			}
		}
	}
	
	public Produto buscar(int codigo) throws ProdutoNaoExisteException {
		if(this.repositorio.existe(codigo) == true) {
		return this.repositorio.buscar(codigo);
		} else {
			throw new ProdutoNaoExisteException();
		}
	}
	
	public void remover(Produto produto) throws ProdutoNaoExisteException, FormatacaoInvalidaException {
		if(produto == null) {
			throw new FormatacaoInvalidaException();
		}
		else if(this.repositorio.produtoContem(produto) == true) {
				this.repositorio.remover(produto.getCodigo());
				this.repositorio.salvarArquivo();
		}
		else if(this.repositorio.produtoContem(produto) == false) {
			throw new ProdutoNaoExisteException();
		}
	}
	
	public void alterar(Produto novoProduto) throws ProdutoNaoExisteException, ProdutoJaExisteException, FormatacaoInvalidaException {
		if(novoProduto == null) {
			throw new FormatacaoInvalidaException();
		} 
		else if(this.repositorio.produtoContem(novoProduto) == true){
			throw new ProdutoJaExisteException(novoProduto.getCodigo());
		}
		else if(novoProduto != null && this.repositorio.existe(novoProduto.getCodigo()) == true){
			this.repositorio.alterar(novoProduto);
			this.repositorio.salvarArquivo();
		}
		else if(this.repositorio.existe(novoProduto.getCodigo()) == false){
			throw new ProdutoNaoExisteException();
		}		
	}
	
	public LocalDate getDataFabricacao(int codigo) throws ProdutoNaoExisteException {
		if(this.repositorio.existe(codigo) == true) {
			Produto produto = this.repositorio.buscar(codigo);
			return produto.getDataFabricacao();
		} else {
			throw new ProdutoNaoExisteException();
		}
		
	}
	
	public LocalDate getDataValidade(int codigo)  throws ProdutoNaoExisteException{
		if(this.repositorio.existe(codigo) == true) {
		Produto produto = this.repositorio.buscar(codigo);
		return produto.getDataValidade();//retornando apenas a data de validade
		}else {
			throw new ProdutoNaoExisteException();
		}
	}
	
	public boolean existe(int codigo) throws ProdutoNaoExisteException{
		boolean alt=false;
			if(repositorio.existe(codigo)){
				alt=true;
			}else{
				throw new ProdutoNaoExisteException();
			}
		return alt;
	}
	
	public List <Produto> listaProdutos(){
		return this.repositorio.listar();
	}
}