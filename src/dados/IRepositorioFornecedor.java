package dados;
import java.util.List;

import negocios.Fornecedor;
public interface IRepositorioFornecedor {
	public boolean cadastrarFornecedor(Fornecedor fornecedor);
	public boolean alterarFornecedor(Fornecedor fornAlterado, Fornecedor novoFornecedor);
	public Fornecedor buscarFornecedor(int codigo);
	public boolean removerFornecedor(int codigo);
	public boolean fornecedorContem(Fornecedor fornecedor);
	public boolean fornecedorExiste(int codigo);
	public abstract List<Fornecedor> listar();
}
