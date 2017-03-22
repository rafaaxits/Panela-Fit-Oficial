package dados;

import java.util.List;

import negocios.beans.Fornecedor;

public interface IRepositorioFornecedor {
	public boolean inserir(Fornecedor fornecedor);

	public boolean alterar(Fornecedor novoFornecedor);

	public Fornecedor buscar(int codigo);

	public boolean remover(int codigo);

	public boolean fornecedorContem(Fornecedor fornecedor);

	public boolean existe(int codigo);

	public abstract List<Fornecedor> listar();

	void salvarArquivo();
}
