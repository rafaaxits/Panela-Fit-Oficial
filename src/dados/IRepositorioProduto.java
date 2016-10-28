package dados;
import beans.Produto;
public interface IRepositorioProduto {
	
	public boolean cadastrarProduto(Produto produto);
	public void alterarProduto(Produto produtoAlterado, Produto novoProduto);
	public Produto buscarProduto(int codigo);
	public boolean removerProduto(int codigo);
	public boolean produtoExiste(int codigo);
}
