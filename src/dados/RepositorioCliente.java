package dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import negocios.Cliente;

public class RepositorioCliente implements IRepositorioCliente {
	private ArrayList<Cliente> listaClientes;
	private static RepositorioCliente instance;
	
	public RepositorioCliente(){
		this.listaClientes = new ArrayList<Cliente>();
	}
	
	public static RepositorioCliente getInstance(){
		if(instance==null){
			instance = new RepositorioCliente();
		}
		return instance;
	}

	
	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public boolean cadastrarCliente(Cliente cliente){
		try{
			listaClientes.add(cliente);
		}
		catch (Exception e){
			return false;
		}
		return true;
		
	}
	public boolean alterarCliente(Cliente clienteAlterado, Cliente novoCliente) {
		boolean alt = false;
			for(Cliente cliente : listaClientes){
				if(cliente.getCodigo() == clienteAlterado.getCodigo()) {
					listaClientes.remove(cliente);
						listaClientes.add(novoCliente);
							alt = true;
					}
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
	
	public boolean clienteContem(Cliente cliente){
		boolean contem = false;
		if(listaClientes.contains(cliente)){
			contem = true;
		}
		return contem;
	}
	
	public boolean clienteExiste(int codigo) {
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
