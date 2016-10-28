package dados;

import beans.Cliente;
import java.util.List;

public interface IRepositorioCliente {
	
	public void cadastrarCliente(Cliente cliente);
	public boolean alterarCliente(Cliente clienteAlterado, Cliente novoCliente);
	public Cliente buscarCliente(int codigo);
	public void removerCliente(Cliente cliente);
	public boolean ClienteExiste(int codigo);
	public abstract List<Cliente> listar();
	
}
