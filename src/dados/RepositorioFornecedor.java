package dados;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import negocios.Fornecedor;

import java.util.Collections;

public class RepositorioFornecedor implements IRepositorioFornecedor, Serializable {
	private ArrayList<Fornecedor> listaFornecedores;
	private static RepositorioFornecedor instance;
	
	public RepositorioFornecedor(){
		this.listaFornecedores = new ArrayList<Fornecedor>();
	}
	public static RepositorioFornecedor getInstance(){
		if(instance == null){
			instance = new RepositorioFornecedor();
			instance = lerDoArquivo();
		}
		return instance;
	}
	
	 private static RepositorioFornecedor lerDoArquivo() {
	        RepositorioFornecedor instanciaLocal = null;
	        
	        File in = new File("fornecedores.dat");
	        FileInputStream fis = null;
	        ObjectInputStream ois = null;
	        try {
	            fis = new FileInputStream(in);
	            ois = new ObjectInputStream(fis);
	            Object o = ois.readObject();
	            instanciaLocal = (RepositorioFornecedor) o;
	        } catch (Exception e) {
	            instanciaLocal = new RepositorioFornecedor();
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
	        File out = new File("fornecedores.dat");
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
	
	public ArrayList<Fornecedor> getListaFornecedores() {
		return listaFornecedores;
	}
	
	public boolean inserir(Fornecedor fornecedor) {
		try {
			listaFornecedores.add(fornecedor);
		}
		catch (Exception e){
			return false;
		}
		return true;
	}
	
	public boolean alterar(Fornecedor novoFornecedor) {
		boolean alt = false;
	for(Fornecedor fornecedor : listaFornecedores){	
		if(fornecedor.getCodigo() == novoFornecedor.getCodigo()) {
				listaFornecedores.remove(fornecedor);
					listaFornecedores.add(novoFornecedor);				
						alt = true;
				}
			}
			return alt;
}
	
	public Fornecedor buscar(int codigo) {
		for(Fornecedor fornecedor : listaFornecedores) {
			if(fornecedor.getCodigo() == codigo) {
				return fornecedor;
			}
		}
		return null;
	}
	
	public boolean remover(int codigo) {
		boolean igual = false;
		for(int i =0;i<listaFornecedores.size();i++){
			if(listaFornecedores.get(i).getCodigo()==codigo){
				listaFornecedores.remove(i);
					igual=true;
			}
		}
	return igual;
	}
	
	public boolean fornecedorContem(Fornecedor fornecedor){
		boolean contem = false;
			if(listaFornecedores.contains(fornecedor)){
				contem=true;
			}
			return contem;
	}
	
	public boolean existe(int codigo) {
		int f;
		boolean x = false;
		for(Fornecedor fornecedor : listaFornecedores) {
			f = fornecedor.getCodigo();
			if(f == codigo) {
				x = true;
			}
		}
		return x;
	}
	
	public List<Fornecedor> listar(){
		return Collections.unmodifiableList(this.listaFornecedores);
	}
	
	@Override
	public String toString() {
		return "RepositorioFornecedor [listaFornecedores = " + listaFornecedores +"]";
	}
}