package dados;
import beans.Fornecedor;
import java.util.List;
public interface IRepositorioFornecedor {
	public boolean cadastrarFornecedor(Fornecedor fornecedor);
	public boolean alterarFornecedor(Fornecedor fornAlterado, Fornecedor novoFornecedor);
	public Fornecedor buscarFornecedor(int codigo);
	public boolean removerFornecedor(int codigo);
	public boolean fornecedorExiste(int codigo);
	public abstract List<Fornecedor> listar();
}
