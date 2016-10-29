package dados;

import beans.Cliente;
import java.util.List;

public interface IRepositorioCliente {
	
	public boolean cadastrarCliente(Cliente cliente);
	public boolean alterarCliente(Cliente clienteAlterado, Cliente novoCliente);
	public Cliente buscarCliente(int codigo);
	public boolean removerCliente(int codigo);
	public boolean ClienteExiste(int codigo);
	public abstract List<Cliente> listar();
	
}
