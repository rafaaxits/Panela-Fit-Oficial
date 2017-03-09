package dados;

import java.util.List;

import negocios.Cliente;

public interface IRepositorioCliente {
	
	public boolean inserir(Cliente cliente);
	public boolean alterar(Cliente novoCliente);
	public Cliente buscar(int codigo);
	public boolean remover(int codigo);
	public boolean clienteContem(Cliente cliente);
	public boolean existe(int codigo);
	public abstract List<Cliente> listar();
	void salvarArquivo();
	
}
