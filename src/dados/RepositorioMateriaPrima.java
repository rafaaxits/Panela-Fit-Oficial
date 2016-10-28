package dados;

import java.util.ArrayList;

import beans.MateriaPrima;

public class RepositorioMateriaPrima implements IRepositorioMateriaPrima{
	private ArrayList<MateriaPrima> listaMateriasPrimas = new ArrayList<MateriaPrima>();
	private static RepositorioMateriaPrima instance;
	
	public static RepositorioMateriaPrima getInstance(){
		if(instance == null){
			instance = new RepositorioMateriaPrima();
		}
		return instance;
	}
	
	public ArrayList<MateriaPrima> getListaMateriasPrimas() {
		return listaMateriasPrimas;
	}

	public void setListaMateriasPrimas(ArrayList<MateriaPrima> listaMateriasPrimas) {
		this.listaMateriasPrimas = listaMateriasPrimas;
	}

	public boolean cadastrarMateriaPrima(MateriaPrima materiaprima) {
		try {
			listaMateriasPrimas.add(materiaprima);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public void alterarMateriaPrima(MateriaPrima mpAlterada, MateriaPrima novaMateriaPrima) {
		for(MateriaPrima m : listaMateriasPrimas) {
			if(novaMateriaPrima.getCodigo() == novaMateriaPrima.getCodigo()) {
					listaMateriasPrimas.remove(m);
					listaMateriasPrimas.add(novaMateriaPrima);
			}
		}
	}
	
	public MateriaPrima buscarMateriaPrima(int codigo) {
		for(MateriaPrima mp : listaMateriasPrimas) {
			if(mp.getCodigo() == codigo) {
				return mp;
			}
		}
		return null;
	}
	
	public boolean removerMateriaPrima(int codigo) {
		boolean igual = false;
			for(int i=0;i<listaMateriasPrimas.size();i++){
				if(listaMateriasPrimas.get(i).getCodigo() == codigo){
					listaMateriasPrimas.remove(i);
						igual = true;
			}
		}
		return igual;
	}
	
	public boolean mpExiste(int codigo) {
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
	
	@Override
	public String toString() {
		return "RepositorioMateriaPrima [listaMateriasPrimas = " + listaMateriasPrimas + "]";
			
	}
}