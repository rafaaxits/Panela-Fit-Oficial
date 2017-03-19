package dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import negocios.Venda;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class RepositorioVenda implements IRepositorioVenda, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6477082268000107480L;
	private ArrayList<Venda> listaVendas;
	private static RepositorioVenda instance;
	
	public RepositorioVenda(){
		this.listaVendas = new ArrayList<Venda>();
	}
	
	public static RepositorioVenda getInstance(){
		if(instance==null){
			instance = new RepositorioVenda();
			instance = lerDoArquivo();
		}
		return instance;
	}
	
	public ArrayList<Venda> getListaVendas(){
		return listaVendas;
	}
	
	private static RepositorioVenda lerDoArquivo() {
        RepositorioVenda instanciaLocal = null;
        
        File in = new File("venda.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            instanciaLocal = (RepositorioVenda) o;
        } catch (Exception e) {
            instanciaLocal = new RepositorioVenda();
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
        File out = new File("venda.dat");
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
	
	public boolean inserir(Venda venda){
		try{
			listaVendas.add(venda);
		}
		catch(Exception e){
			return false;
		}
		return true;
	}
	
	public boolean alterar(Venda novaVenda){
	ArrayList<Venda> listaRemovidos = new ArrayList<Venda>();
	boolean alt = false;
		for(Venda venda : listaVendas){
			if(venda.getCodigo() == novaVenda.getCodigo()){
				listaRemovidos.add(venda);
						alt = true;
			}
		}
		listaVendas.removeAll(listaRemovidos);
			listaVendas.add(novaVenda);
				return alt;
	}
	
	public Venda buscar(int codigo){
		for(Venda venda : listaVendas){
			if(venda.getCodigo() == codigo){
				return venda;
			}
		}
		return null;
	}
	
	public boolean remover(int codigo){
		boolean igual=false;
		for(int i=0; i<listaVendas.size();i++){
			if(listaVendas.get(i).getCodigo()==codigo){
				listaVendas.remove(i);
				igual=true;
			}
		}
		return igual;
	}
	
	public boolean vendaContem(Venda venda){
		boolean contem = false;
		if(listaVendas.contains(venda)){
			contem = true;
		}
		return contem;
	}
	
	public boolean existe(int codigo){
		int c;
		boolean x = false;
		for(Venda venda : listaVendas){
			c=venda.getCodigo();
			if(c==codigo){
				x=true;
			}
		}
		return x;
	}

	public boolean excluirVendas(){
		ArrayList<Venda> listaRemovidos = new ArrayList<Venda>();
		boolean alt = false;
			for(Venda venda : listaVendas){
					listaRemovidos.add(venda);
							alt = true;
			}
			listaVendas.removeAll(listaRemovidos);
					return alt;
	}


	public List<Venda> listar(){
		return Collections.unmodifiableList(this.listaVendas);
	}
	
	@Override
	public String toString() {
		return "RespositorioVenda [listaVendas=" + listaVendas + "]";
	}
	
}
