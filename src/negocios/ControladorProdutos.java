package negocios;

import dados.IRepositorioProduto;
import exceptions.ProdutoJaExisteException;
import exceptions.ProdutoNaoExisteException;
import exceptions.ProdutoInvalidoException;
import java.time.*;
import java.util.List;

public class ControladorProdutos {
	 IRepositorioProduto repositorio;
	
	public ControladorProdutos(IRepositorioProduto instanciaInterface){
		this.repositorio = instanciaInterface;
	}


	public void cadastrar(Produto produto) throws ProdutoJaExisteException, ProdutoNaoExisteException, ProdutoInvalidoException{
		if(produto == null) {
			throw new ProdutoInvalidoException();
		} else {
			if(this.repositorio.existe(produto.getCodigo()) == false){
				this.repositorio.inserir(produto);
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
	
	public void remover(Produto produto) throws ProdutoNaoExisteException, ProdutoInvalidoException {
		if(produto == null) {
			throw new ProdutoInvalidoException();
		}
		else if(this.repositorio.produtoContem(produto) == true) {
				this.repositorio.remover(produto.getCodigo());
		}
		else if(this.repositorio.produtoContem(produto) == false) {
			throw new ProdutoNaoExisteException();
		}
	}
	
	public void alterar(Produto produtoAlterado, Produto novoProduto) throws ProdutoNaoExisteException, ProdutoJaExisteException, ProdutoInvalidoException {
		if(produtoAlterado == null || novoProduto == null) {
			throw new ProdutoInvalidoException();
		} 
		else if(this.repositorio.produtoContem(produtoAlterado)==true && (novoProduto!=null && this.repositorio.produtoContem(produtoAlterado))== false){
			this.repositorio.alterar(produtoAlterado, novoProduto);
		}
		else if(produtoAlterado !=null && this.repositorio.produtoContem(produtoAlterado)==false){
			throw new ProdutoNaoExisteException();
		}
		else{
			throw new ProdutoJaExisteException(produtoAlterado.getCodigo());
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
	
	public List <Produto> listaProdutos(){
		return this.repositorio.listar();
	}
}