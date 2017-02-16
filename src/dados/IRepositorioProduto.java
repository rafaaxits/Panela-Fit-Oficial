package dados;
import java.util.List;

import negocios.Produto;
public interface IRepositorioProduto {
	
	public boolean inserir(Produto produto);
	public boolean alterar(Produto novoProduto);
	public Produto buscar(int codigo);
	public boolean remover(int codigo);
	public boolean produtoContem(Produto produto);
	public boolean existe(int codigo);
	public abstract List<Produto> listar();
	
}
