package dados;

import java.util.ArrayList;
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

	public boolean cadastrarCliente(Cliente cliente){
		try {
			listaClientes.add(cliente);
		} catch (Exception e){
			return false;
		}
		return true;
	}
	
	public void alterarCliente(Cliente clienteAlterado, Cliente novoCliente) {
				for(Cliente c : listaClientes) {
					if(novoCliente.getCodigo() == clienteAlterado.getCodigo()) {
						listaClientes.remove(c);
						listaClientes.add(novoCliente);
					}
				}
	}
	
	public Cliente buscarCliente(int codigo){
		for (Cliente cliente : listaClientes) {
			if(cliente.getCodigo() == codigo){
				return cliente;
			}
		}
		return null;
	}
	
	public boolean removerCliente(int codigo){
		boolean igual=false;
			for(int i=0;i<listaClientes.size();i++){
				if(listaClientes.get(i).getCodigo()==codigo){
					listaClientes.remove(i);
					igual = true;
				}
			}
		return igual;
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

	@Override
	public String toString() {
		return "RespositorioCliente [listaClientes=" + listaClientes + "]";
	}
	
	
}
