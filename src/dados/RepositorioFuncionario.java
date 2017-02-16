package dados;

import java.util.ArrayList;
import java.util.List;

import negocios.Funcionario;

import java.util.Collections;

public class RepositorioFuncionario implements IRepositorioFuncionario {
	private ArrayList<Funcionario> listaFuncionarios;
	private static RepositorioFuncionario instance;
	
	public RepositorioFuncionario(){
		this.listaFuncionarios = new ArrayList<Funcionario>();
	}
	
	public static RepositorioFuncionario getInstance(){
		if(instance==null){
			instance = new RepositorioFuncionario();
		}
		return instance;
	}
	
	public ArrayList<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
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
		for(Funcionario funcionario : listaFuncionarios){
			if(funcionario.getCodigo() == novoFuncionario.getCodigo()){
				listaFuncionarios.remove(funcionario);
					listaFuncionarios.add(novoFuncionario);
						alt = true;
				}
			}
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