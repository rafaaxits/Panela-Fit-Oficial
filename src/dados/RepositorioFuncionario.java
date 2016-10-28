package dados;

import java.util.ArrayList;

import beans.Funcionario;

public class RepositorioFuncionario implements IRepositorioFuncionario {
	private ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
	private static RepositorioFuncionario instance;
	
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
		try {
			listaFuncionarios.add(funcionario);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public void alterarFuncionario(Funcionario funcAlterado, Funcionario novoFuncionario) {
			for(Funcionario f : listaFuncionarios) {
				if(novoFuncionario.getCodigo() == funcAlterado.getCodigo()) {
					listaFuncionarios.remove(f);
					listaFuncionarios.add(novoFuncionario);
				}
			}
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
	
	@Override
	public String toString() {
		return "RepositorioFuncionario [listaFuncionarios = " + listaFuncionarios + "]";
			
	}
	
	

}