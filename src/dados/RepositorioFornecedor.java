package dados;

import java.util.ArrayList;
import beans.Fornecedor;

public class RepositorioFornecedor implements IRepositorioFornecedor {
	private ArrayList<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();
	private static RepositorioFornecedor instance;
	
	public static RepositorioFornecedor getInstance(){
		if(instance == null){
			instance = new RepositorioFornecedor();
		}
		return instance;
	}
	
	public ArrayList<Fornecedor> getListaFornecedores() {
		return listaFornecedores;
	}
	
	public void setListaFornecedores(ArrayList<Fornecedor> listaFornecedores) {
		this.listaFornecedores = listaFornecedores;
	}
	
	public boolean cadastrarFornecedor(Fornecedor fornecedor) {
		try {
			listaFornecedores.add(fornecedor);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public void alterarFornecedor(Fornecedor fornAlterado, Fornecedor novoFornecedor) {
		for(Fornecedor f : listaFornecedores) {
				if(novoFornecedor.getCodigo() == fornAlterado.getCodigo()) {
					listaFornecedores.remove(f);
					listaFornecedores.add(novoFornecedor);
				}
			}
}
	
	public Fornecedor buscarFornecedor(int codigo) {
		for(Fornecedor fornecedor : listaFornecedores) {
			if(fornecedor.getCodigo() == codigo) {
				return fornecedor;
			}
		}
		return null;
	}
	
	public boolean removerFornecedor(int codigo) {
		boolean igual = false;
			for(int i =0;i<listaFornecedores.size();i++){
				if(listaFornecedores.get(i).getCodigo()==codigo){
					listaFornecedores.remove(i);
						igual=true;
				}
			}
		return igual;
	}
	
	public boolean fornecedorExiste(int codigo) {
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
	
	@Override
	public String toString() {
		return "RepositorioFornecedor [listaFornecedores = " + listaFornecedores +"]";
	}
}