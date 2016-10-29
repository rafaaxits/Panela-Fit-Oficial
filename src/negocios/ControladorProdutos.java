package negocios;

import beans.Produto;
import dados.IRepositorioProduto;
import exceptions.ProdutoJaExisteException;
import exceptions.ProdutoNaoExisteException;
import java.time.*;
import java.util.List;

public class ControladorProdutos {
	 IRepositorioProduto repositorio;
	
	public ControladorProdutos(IRepositorioProduto instanciaInterface){
		this.repositorio = instanciaInterface;
	}


	public void cadastrar(Produto p) throws ProdutoJaExisteException, ProdutoNaoExisteException{
		if(p == null) {
			throw new ProdutoNaoExisteException();
		} else {
			if(this.repositorio.produtoExiste(p.getCodigo()) == false){
				this.repositorio.cadastrarProduto(p);
			} else if(this.repositorio.produtoExiste(p.getCodigo()) == true) {
				throw new ProdutoJaExisteException(p.getCodigo());
				
			}
		}
	}
	
	public Produto buscar(int codigo) throws ProdutoNaoExisteException {
		if(this.repositorio.produtoExiste(codigo) == true) {
		return this.repositorio.buscarProduto(codigo);
		} else {
			throw new ProdutoNaoExisteException();
		}
	}
	
	public void remover(Produto p) throws ProdutoNaoExisteException {
		if(p== null || this.repositorio.produtoExiste(p.getCodigo())==false){
			throw new ProdutoNaoExisteException();
		}else{
			if(this.repositorio.produtoExiste(p.getCodigo())==true){
				this.repositorio.removerProduto(p.getCodigo());
			}
		}
	}
	
	public void alterar(Produto produtoAlterado, Produto novoProduto) throws ProdutoNaoExisteException, ProdutoJaExisteException {
		if(produtoAlterado == null || novoProduto == null) {
			throw new ProdutoNaoExisteException();
		} 
		else if((produtoAlterado != null && this.repositorio.produtoExiste(produtoAlterado.getCodigo())==true) && novoProduto !=null){
			this.repositorio.alterarProduto(produtoAlterado, novoProduto);
		}
		else if(produtoAlterado !=null && this.repositorio.produtoExiste(produtoAlterado.getCodigo())==false){
			throw new ProdutoNaoExisteException();
		}
		else{
			throw new ProdutoJaExisteException(produtoAlterado.getCodigo());
		}
	}
	
	public LocalDate getDataFabricacao(int codigo) throws ProdutoNaoExisteException {
		if(this.repositorio.produtoExiste(codigo) == true) {
			Produto p = this.repositorio.buscarProduto(codigo);
			return p.getDataFabricacao();
		} else {
			throw new ProdutoNaoExisteException();
		}
		
	}
	
	public LocalDate getDataValidade(int codigo)  throws ProdutoNaoExisteException{
		if(this.repositorio.produtoExiste(codigo) == true){
		Produto p = this.repositorio.buscarProduto(codigo);
		return p.getDataValidade();//retornando apenas a data de validade
		}else{
			throw new ProdutoNaoExisteException();
		}
	}
	
	public List <Produto> listaProdutos(){
		return this.repositorio.listar();
	}
}