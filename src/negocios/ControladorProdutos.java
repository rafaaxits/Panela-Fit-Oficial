package negocios;

import beans.Produto;
import dados.IRepositorioProduto;
import exceptions.ProdutoJaExisteException;
import exceptions.ProdutoNaoExisteException;
import java.time.*;

public class ControladorProdutos {
	 IRepositorioProduto repositorio;
	
	public ControladorProdutos(IRepositorioProduto instanciaInterface){
		this.repositorio = instanciaInterface;
	}


	public void cadastrar(Produto p) throws ProdutoJaExisteException {
		if(p == null) {
			throw new IllegalArgumentException("");
		} else {
			if(this.repositorio.produtoExiste(p.getCodigo()) == true){
				this.repositorio.cadastrarProduto(p);
			} else if(this.repositorio.produtoExiste(p.getCodigo()) == false) {
				ProdutoJaExisteException c = new ProdutoJaExisteException(p.getCodigo());
				throw c;
			}
		}
	}
	
	public Produto buscar(int codigo) throws ProdutoNaoExisteException {
		if(this.repositorio.produtoExiste(codigo) == true) {
		return this.repositorio.buscarProduto(codigo);
		} else {
			throw new ProdutoNaoExisteException(codigo);
		}
	}
	
	public void remover(Produto p) throws ProdutoNaoExisteException {
		if(p == null) {
		throw new IllegalArgumentException("");
		} else {
			if(this.repositorio.produtoExiste(p.getCodigo()) == true) {
				this.repositorio.removerProduto(p.getCodigo());
			} else if(this.repositorio.produtoExiste(p.getCodigo()) == false) {
				ProdutoNaoExisteException r = new ProdutoNaoExisteException(p.getCodigo());
				throw r;
			}
		}
	}
	
	public void alterar(Produto produtoAlterado, Produto novoProduto) throws ProdutoNaoExisteException {
		if(produtoAlterado != null && novoProduto != null) {
			this.repositorio.alterarProduto(produtoAlterado, novoProduto);
		} else {
			if(produtoAlterado == null || novoProduto == null) {
				IllegalArgumentException a = new IllegalArgumentException("");
				throw a;
			}
		}
	}
	
	public LocalDate getDataFabricacao(int codigo) throws ProdutoNaoExisteException {
		if(this.repositorio.produtoExiste(codigo) == true) {
			Produto p = this.repositorio.buscarProduto(codigo);
			return p.getDataFabricacao();
		} else {
			throw new ProdutoNaoExisteException(codigo);
		}
		
	}
	
	public LocalDate getDataValidade(int codigo){
		Produto p = this.repositorio.buscarProduto(codigo);
		return p.getDataValidade();//retornando apenas a data de validade
	}
}