package dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import negocios.Cliente;

public class RepositorioCliente implements IRepositorioCliente, Serializable {
	private ArrayList<Cliente> listaClientes;
	private static RepositorioCliente instance;
	
	public RepositorioCliente(){
		this.listaClientes = new ArrayList<Cliente>();
	}
	
	public static RepositorioCliente getInstance(){
		if(instance==null){
			instance = new RepositorioCliente();
			instance = lerDoArquivo();
		}
		return instance;
	}

	
	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}
	
	 private static RepositorioCliente lerDoArquivo() {
	        RepositorioCliente instanciaLocal = null;
	        
	        File in = new File("clientes.dat");
	        FileInputStream fis = null;
	        ObjectInputStream ois = null;
	        try {
	            fis = new FileInputStream(in);
	            ois = new ObjectInputStream(fis);
	            Object o = ois.readObject();
	            instanciaLocal = (RepositorioCliente) o;
	        } catch (Exception e) {
	            instanciaLocal = new RepositorioCliente();
	        } finally {
	            if (ois != null) {
	                try {
	                    ois.close();
	                } catch (IOException e) {
	                }
	            }
	        }

	        return instanciaLocal;
	    }

	    public void salvarArquivo() {
	        if (instance == null) {
	            return;
	        }
	        File out = new File("clientes.dat");
	        FileOutputStream fos = null;
	        ObjectOutputStream oos = null;
	        
	        try {
	            fos = new FileOutputStream(out);
	            oos = new ObjectOutputStream(fos);
	            oos.writeObject(instance);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (oos != null) {
	                try { oos.close(); } catch (IOException e) {}
	            }
	        }
	    }

	public boolean inserir(Cliente cliente){
		try{
			listaClientes.add(cliente);
		}
		catch (Exception e){
			return false;
		}
		return true;
		
	}
	public boolean alterar(Cliente novoCliente) {
		boolean alt = false;
			for(Cliente cliente : listaClientes){
				if(cliente.getCodigo() == novoCliente.getCodigo()) {
					listaClientes.remove(cliente);
						listaClientes.add(novoCliente);
							alt = true;
					}
				}
			return alt;
	}
	
	public Cliente buscar(int codigo){
		for (Cliente cliente : listaClientes) {
			if(cliente.getCodigo() == codigo){
				return cliente;
			}
		}
		return null;
	}
	
	public boolean remover(int codigo){
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
	
	public boolean existe(int codigo) {
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
