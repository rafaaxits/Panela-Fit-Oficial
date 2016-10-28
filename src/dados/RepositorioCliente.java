package dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import beans.Cliente;

public class RepositorioCliente implements IRepositorioCliente {
	private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	private static RepositorioCliente instance;
	
	public static RepositorioCliente getInstance(){
		if(instance==null){
			instance = new RepositorioCliente();
		}
		return instance;
	}

	
	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public void cadastrarCliente(Cliente cliente){
		if(cliente !=null){
			if(listaClientes.contains(cliente) == false){
				listaClientes.add(cliente);
			}
		}
		
	}
	public boolean alterarCliente(Cliente clienteAlterado, Cliente novoCliente) {
			boolean alt = false;
				if(listaClientes.contains(clienteAlterado)) {
					listaClientes.remove(clienteAlterado);
						listaClientes.add(novoCliente);
							alt = true;
					
				}
			return alt;
	}
	
	public Cliente buscarCliente(int codigo){
		for (Cliente cliente : listaClientes) {
			if(cliente.getCodigo() == codigo){
				return cliente;
			}
		}
		return null;
	}
	
	public void removerCliente(Cliente cliente){
			if(listaClientes.contains(cliente)){
				listaClientes.remove(cliente);
			}
	}
	
	public boolean ClienteExiste(int codigo) {
		int c;
		boolean x = false;
		for(Cliente cliente : listaClientes) {
			c = cliente.getCodigo();
			if(c == codigo) {
				x = true;
			}
		}
		return x;
	}

	public List<Cliente> listar(){
		return Collections.unmodifiableList(this.listaClientes);
	}
	
	@Override
	public String toString() {
		return "RespositorioCliente [listaClientes=" + listaClientes + "]";
	}
	
	
}
