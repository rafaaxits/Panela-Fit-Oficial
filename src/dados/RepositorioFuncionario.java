package dados;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import beans.Funcionario;

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
	
	public void setListaFuncionarios(ArrayList<Funcionario> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}
	
	public boolean cadastrarFuncionario(Funcionario funcionario) {
		try{
			listaFuncionarios.add(funcionario);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public boolean alterarFuncionario(Funcionario funcAlterado, Funcionario novoFuncionario) {
		boolean alt=false;	
		for(Funcionario funcionario : listaFuncionarios){
			if(funcionario.getCodigo() == funcAlterado.getCodigo()){
				listaFuncionarios.remove(funcionario);
					listaFuncionarios.add(novoFuncionario);
						alt = true;
				}
			}
			return alt;
	}
	
	public Funcionario buscarFuncionario(int codigo) {
		for(Funcionario funcionario : listaFuncionarios) {
			if(funcionario.getCodigo() == codigo) {
				return funcionario;
			}
		}
		return null;
	}
	
	public boolean removerFuncionario(int codigo) {
		boolean igual = false;
		for(int i=0;i<listaFuncionarios.size();i++){
			if(listaFuncionarios.get(i).getCodigo()==codigo){
				listaFuncionarios.remove(i);
					igual=true;
			}
		}
	return igual;

	}
	
	public boolean funcionarioExiste(int codigo) {
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