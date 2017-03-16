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

import negocios.Funcionario;

import java.util.Collections;

public class RepositorioFuncionario implements IRepositorioFuncionario, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1035831990401858694L;
	private ArrayList<Funcionario> listaFuncionarios;
	private static RepositorioFuncionario instance;
	
	public RepositorioFuncionario(){
		this.listaFuncionarios = new ArrayList<Funcionario>();
	}
	
	public static RepositorioFuncionario getInstance(){
		if(instance==null){
			instance = new RepositorioFuncionario();
			instance = lerDoArquivo();
		}
		return instance;
	}
	
	public ArrayList<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}
	
	 private static RepositorioFuncionario lerDoArquivo() {
	        RepositorioFuncionario instanciaLocal = null;
	        
	        File in = new File("funcionarios.dat");
	        FileInputStream fis = null;
	        ObjectInputStream ois = null;
	        try {
	            fis = new FileInputStream(in);
	            ois = new ObjectInputStream(fis);
	            Object o = ois.readObject();
	            instanciaLocal = (RepositorioFuncionario) o;
	        } catch (Exception e) {
	            instanciaLocal = new RepositorioFuncionario();
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
	        File out = new File("funcionarios.dat");
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
	
	public boolean inserir(Funcionario funcionario) {
		try{
			listaFuncionarios.add(funcionario);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public boolean alterar(Funcionario novoFuncionario) {
		boolean alt=false;	
		ArrayList<Funcionario> listaRemovidos = new ArrayList<Funcionario>();
		for(Funcionario funcionario : listaFuncionarios){
			if(funcionario.getCodigo() == novoFuncionario.getCodigo()){
				listaRemovidos.add(funcionario);
						alt = true;
				}
			}
			listaFuncionarios.removeAll(listaRemovidos);
				listaFuncionarios.add(novoFuncionario);
		return alt;
	}
	
	public Funcionario buscar(int codigo) {
		for(Funcionario funcionario : listaFuncionarios) {
			if(funcionario.getCodigo() == codigo) {
				return funcionario;
			}
		}
		return null;
	}
	
	public boolean remover(int codigo) {
		boolean igual = false;
		for(int i=0;i<listaFuncionarios.size();i++){
			if(listaFuncionarios.get(i).getCodigo()==codigo){
				listaFuncionarios.remove(i);
					igual=true;
			}
		}
	return igual;

	}
	
	public boolean funcionarioContem(Funcionario funcionario){
		boolean contem = false;
			if(listaFuncionarios.contains(funcionario)){
				contem = true;
		}
					return contem;
	}
	
	public boolean existe(int codigo) {
		int f;
		boolean x = false;
		for(Funcionario funcionario : listaFuncionarios) {
			f = funcionario.getCodigo();
			if(f == codigo) {
				x = true;
			}
		}
		return x;
	}
	
	public List <Funcionario> listar(){
		return Collections.unmodifiableList(this.listaFuncionarios);
	}
	
	@Override
	public String toString() {
		return "RepositorioFuncionario [listaFuncionarios = " + listaFuncionarios + "]";
			
	}
	
	

}