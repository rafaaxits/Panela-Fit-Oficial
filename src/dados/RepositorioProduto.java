package dados;

import java.util.ArrayList;
import java.util.List;

import negocios.Produto;

import java.util.Collections;

public class RepositorioProduto implements IRepositorioProduto{
	private ArrayList<Produto> listaProdutos;
	private static RepositorioProduto instance;
	
	public RepositorioProduto(){
		this.listaProdutos = new ArrayList<Produto>();
	}
	public static RepositorioProduto getInstance(){
		if(instance==null){
			instance = new RepositorioProduto();
		}
		return instance;
	}
	
	public ArrayList<Produto> getListaProdutos() {
		return listaProdutos;
	}
	
	public boolean inserir(Produto produto) {
		try {
			listaProdutos.add(produto);
		}catch (Exception e){
			return false;
		}
		return true;
	}
	
	public boolean alterar(Produto produtoAlterado, Produto novoProduto) {
		boolean alt = false;
			for(Produto produto : listaProdutos){
				if(produto.getCodigo() == produtoAlterado.getCodigo()){
					listaProdutos.remove(produtoAlterado);
						listaProdutos.add(novoProduto);
							alt = true;
			}
		}
		return alt;
	}
	
	public Produto buscar(int codigo) {
		for(Produto produto : listaProdutos) {
			if(produto.getCodigo() == codigo) {
				return produto;
			}
		}
		return null;
	}
	
	public boolean remover(int  codigo) {
		boolean igual = false;
		for(int i=0;i<listaProdutos.size();i++){
			if(listaProdutos.get(i).getCodigo()==codigo){
				listaProdutos.remove(i);
					igual=true;
			}
		}
	return igual;
	}
	
	public boolean produtoContem(Produto produto){
		boolean contem = false;
		if(listaProdutos.contains(produto)){
			contem=true;
		}
		return contem;
	}
	
	public boolean existe(int codigo) {
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
	
	public List<Produto> listar(){
		return Collections.unmodifiableList(this.listaProdutos);
	}
		
	@Override
	public String toString() {
		return "RepositorioProduto [listaProdutos = " + listaProdutos + "]";
			
	}
	
}