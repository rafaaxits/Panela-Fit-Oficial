package dados;

import java.util.ArrayList;

import beans.Produto;

public class RepositorioProduto implements IRepositorioProduto{
	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	private static RepositorioProduto instance;
	
	public static RepositorioProduto getInstance(){
		if(instance==null){
			instance = new RepositorioProduto();
		}
		return instance;
	}
	
	public ArrayList<Produto> getListaProdutos() {
		return listaProdutos;
	}
	
	public void setListaProdutos(ArrayList<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	
	public boolean cadastrarProduto(Produto produto) {
		try {
			listaProdutos.add(produto);
		} catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public void alterarProduto(Produto produtoAlterado, Produto novoProduto) {
		for(Produto p : listaProdutos) {
			if(novoProduto.getCodigo() == produtoAlterado.getCodigo()) {
				listaProdutos.remove(p);
				listaProdutos.add(novoProduto);
			}
		}
	}
	
	public Produto buscarProduto(int codigo) {
		for(Produto produto : listaProdutos) {
			if(produto.getCodigo() == codigo) {
				return produto;
			}
		}
		return null;
	}
	
	public boolean removerProduto(int codigo) {
		boolean igual = false;
			for(int i=0;i<listaProdutos.size();i++){
				if(listaProdutos.get(i).getCodigo()==codigo){
					listaProdutos.remove(i);
						igual=true;
				}
			}
		return igual;
	}
	
	public boolean produtoExiste(int codigo) {
		int p;
		boolean x = false;
		for(Produto produto : listaProdutos) {
			p = produto.getCodigo();
			if(p == codigo) {
				x = true;
			}
		}
		return x;
	}
		
	@Override
	public String toString() {
		return "RepositorioProduto [listaProdutos = " + listaProdutos + "]";
			
	}
	
}