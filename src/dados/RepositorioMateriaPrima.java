package dados;

import java.util.ArrayList;
import java.util.List;

import negocios.beans.MateriaPrima;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;

public class RepositorioMateriaPrima implements IRepositorioMateriaPrima, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3344583844646641935L;
	private ArrayList<MateriaPrima> listaMateriasPrimas;
	private static RepositorioMateriaPrima instance;
	
	public RepositorioMateriaPrima(){
		this.listaMateriasPrimas = new ArrayList<MateriaPrima>();
	}
	
	public static RepositorioMateriaPrima getInstance(){
		if(instance == null){
			instance = new RepositorioMateriaPrima();
			instance = lerDoArquivo();
		}
		return instance;
	}
	
	public ArrayList<MateriaPrima> getListaMateriasPrimas() {
		return listaMateriasPrimas;
	}
	
	 private static RepositorioMateriaPrima lerDoArquivo() {
	        RepositorioMateriaPrima instanciaLocal = null;
	        
	        File in = new File("materiasprimas.dat");
	        FileInputStream fis = null;
	        ObjectInputStream ois = null;
	        try {
	            fis = new FileInputStream(in);
	            ois = new ObjectInputStream(fis);
	            Object o = ois.readObject();
	            instanciaLocal = (RepositorioMateriaPrima) o;
	        } catch (Exception e) {
	            instanciaLocal = new RepositorioMateriaPrima();
	        } finally {
	            if (ois != null) {
	                try {
	                    ois.close();
	                } catch (IOException e) {
	                	System.out.println("Não foi possível fechar o arquivo!");
	                    e.printStackTrace();
	                }
	            }
	        }

	        return instanciaLocal;
	    }

	    public void salvarArquivo() {
	        if (instance == null) {
	            return;
	        }
	        File out = new File("materiasprimas.dat");
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
	                try { oos.close(); } catch (IOException e) {
	                	System.out.println("Não foi possível fechar o arquivo!");
	                    e.printStackTrace();
	                }
	            }
	        }
	    }


	public boolean inserir(MateriaPrima materiaPrima) {
		try{
			listaMateriasPrimas.add(materiaPrima);
		}catch (Exception e){
			return false;
		}
		return true;
	}
	
	public boolean alterar(MateriaPrima novaMateriaPrima) {
ArrayList<MateriaPrima> listaRemovidos = new ArrayList<MateriaPrima>();
	boolean alt = false;
		for(MateriaPrima materiaPrima : listaMateriasPrimas){	
			if(materiaPrima.getCodigo() == novaMateriaPrima.getCodigo()){
				listaRemovidos.add(materiaPrima);
						alt = true;
				}
		}
		listaMateriasPrimas.removeAll(listaRemovidos);
			listaMateriasPrimas.add(novaMateriaPrima);
				return alt;
	}
	
	public MateriaPrima buscar(int codigo) {
		for(MateriaPrima mp : listaMateriasPrimas) {
			if(mp.getCodigo() == codigo) {
				return mp;
			}
		}
		return null;
	}
	
	public boolean remover(int codigo) {
		boolean igual = false;
		for(int i=0;i<listaMateriasPrimas.size();i++){
			if(listaMateriasPrimas.get(i).getCodigo() == codigo){
				listaMateriasPrimas.remove(i);
					igual = true;
		}
	}
	return igual;
	}
	
	public boolean materiaPrimaContem(MateriaPrima materiaPrima){
		boolean contem = false;
		if(listaMateriasPrimas.contains(materiaPrima)){
			contem=true;
		}
		return contem;
	}
	
	public boolean existe(int codigo) {
		int m;
		boolean x = false;
		for(MateriaPrima mp : listaMateriasPrimas) {
			m = mp.getCodigo();
			if(m == codigo) {
				x = true;
			}
		}
		return x;
	}
	
	public List<MateriaPrima> listar(){
		return Collections.unmodifiableList(this.listaMateriasPrimas);
	}
	
	@Override
	public String toString() {
		return "RepositorioMateriaPrima [listaMateriasPrimas = " + listaMateriasPrimas + "]";
			
	}
}