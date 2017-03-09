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

import negocios.MateriaPrima;

import java.util.Collections;

public class RepositorioMateriaPrima implements IRepositorioMateriaPrima, Serializable{
	private ArrayList<MateriaPrima> listaMateriasPrimas;
	private static RepositorioMateriaPrima instance;
	
	public RepositorioMateriaPrima(){
		this.listaMateriasPrimas = new ArrayList<MateriaPrima>();
	}
	
	public static RepositorioMateriaPrima getInstance(){
		if(instance == null){
			instance = new RepositorioMateriaPrima();
		}
		return instance;
	}
	
	public ArrayList<MateriaPrima> getListaMateriasPrimas() {
		return listaMateriasPrimas;
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
		boolean alt = false;
	for(MateriaPrima materiaPrima : listaMateriasPrimas){	
		if(materiaPrima.getCodigo() == novaMateriaPrima.getCodigo()){
			listaMateriasPrimas.remove(materiaPrima);
				listaMateriasPrimas.add(novaMateriaPrima);
					alt = true;
			}
		}
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