package dados;

import java.util.ArrayList;
import beans.Fornecedor;
import java.util.List;
import java.util.Collections;

public class RepositorioFornecedor implements IRepositorioFornecedor {
	private ArrayList<Fornecedor> listaFornecedores;
	private static RepositorioFornecedor instance;
	
	public RepositorioFornecedor(){
		this.listaFornecedores = new ArrayList<Fornecedor>();
	}
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
		}
		catch (Exception e){
			return false;
		}
		return true;
	}
	
	public boolean alterarFornecedor(Fornecedor fornAlterado, Fornecedor novoFornecedor) {
		boolean alt = false;
	for(Fornecedor fornecedor : listaFornecedores){	
		if(fornecedor.getCodigo() == fornAlterado.getCodigo()) {
				listaFornecedores.remove(fornecedor);
					listaFornecedores.add(novoFornecedor);				
						alt = true;
				}
			}
			return alt;
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
	
	public List<Fornecedor> listar(){
		return Collections.unmodifiableList(this.listaFornecedores);
	}
	
	@Override
	public String toString() {
		return "RepositorioFornecedor [listaFornecedores = " + listaFornecedores +"]";
	}
}