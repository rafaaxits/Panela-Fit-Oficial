package dados;
import beans.Fornecedor;
public interface IRepositorioFornecedor {
	public boolean cadastrarFornecedor(Fornecedor fornecedor);
	public void alterarFornecedor(Fornecedor fornAlterado, Fornecedor novoFornecedor);
	public Fornecedor buscarFornecedor(int codigo);
	public boolean removerFornecedor(int codigo);
	public boolean fornecedorExiste(int codigo);
}
