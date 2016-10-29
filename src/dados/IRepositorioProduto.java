package dados;
import beans.Produto;
import java.util.List;
public interface IRepositorioProduto {
	
	public boolean cadastrarProduto(Produto produto);
	public boolean alterarProduto(Produto produtoAlterado, Produto novoProduto);
	public Produto buscarProduto(int codigo);
	public boolean removerProduto(int codigo);
	public boolean produtoExiste(int codigo);
	public abstract List<Produto> listar();
	
}
