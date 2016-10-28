package dados;

import beans.Cliente;

public interface IRepositorioCliente {
	
	public boolean cadastrarCliente(Cliente cliente);
	public void alterarCliente(Cliente clienteAlterado, Cliente novoCliente);
	public Cliente buscarCliente(int codigo);
	public boolean removerCliente(int codigo);
	public boolean ClienteExiste(int codigo);
	
}
