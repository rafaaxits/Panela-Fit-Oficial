package dados;

import java.util.List;

import negocios.Cliente;

public interface IRepositorioCliente {
	
	public boolean cadastrarCliente(Cliente cliente);
	public boolean alterarCliente(Cliente clienteAlterado, Cliente novoCliente);
	public Cliente buscarCliente(int codigo);
	public boolean removerCliente(int codigo);
	public boolean clienteContem(Cliente cliente);
	public boolean clienteExiste(int codigo);
	public abstract List<Cliente> listar();
	
}
