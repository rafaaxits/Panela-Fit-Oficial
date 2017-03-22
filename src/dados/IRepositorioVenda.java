package dados;

import java.util.List;

import negocios.beans.Venda;

public interface IRepositorioVenda {
	public boolean inserir(Venda venda);

	public boolean alterar(Venda novaVenda);

	public Venda buscar(int codigo);

	public boolean remover(int codigo);

	public boolean vendaContem(Venda Venda);

	public boolean existe(int codigo);

	public abstract List<Venda> listar();

	public boolean excluirVendas();

	void salvarArquivo();
}
