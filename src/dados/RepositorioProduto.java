package dados;

import java.util.ArrayList;
import java.util.List;

import negocios.beans.Produto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;

public class RepositorioProduto implements IRepositorioProduto, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4891963491984056414L;
	private ArrayList<Produto> listaProdutos;
	private static RepositorioProduto instance;

	public RepositorioProduto() {
		this.listaProdutos = new ArrayList<Produto>();
	}

	public static RepositorioProduto getInstance() {
		if (instance == null) {
			instance = new RepositorioProduto();
			instance = lerDoArquivo();
		}
		return instance;
	}

	public ArrayList<Produto> getListaProdutos() {
		return listaProdutos;
	}

	private static RepositorioProduto lerDoArquivo() {
		RepositorioProduto instanciaLocal = null;

		File in = new File("produtos.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioProduto) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioProduto();
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
		File out = new File("produtos.dat");
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
				try {
					oos.close();
				} catch (IOException e) {
					System.out.println("Não foi possível fechar o arquivo!");
					e.printStackTrace();
				}
			}
		}
	}

	public boolean inserir(Produto produto) {
		try {
			listaProdutos.add(produto);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean alterar(Produto novoProduto) {
		ArrayList<Produto> listaRemovidos = new ArrayList<Produto>();
		boolean alt = false;
		for (Produto produto : listaProdutos) {
			if (produto.getCodigo() == novoProduto.getCodigo()) {
				listaRemovidos.add(produto);
				alt = true;
			}
		}
		listaProdutos.removeAll(listaRemovidos);
		listaProdutos.add(novoProduto);
		return alt;
	}

	public Produto buscar(int codigo) {
		for (Produto produto : listaProdutos) {
			if (produto.getCodigo() == codigo) {
				return produto;
			}
		}
		return null;
	}

	public boolean remover(int codigo) {
		boolean igual = false;
		for (int i = 0; i < listaProdutos.size(); i++) {
			if (listaProdutos.get(i).getCodigo() == codigo) {
				listaProdutos.remove(i);
				igual = true;
			}
		}
		return igual;
	}

	public boolean produtoContem(Produto produto) {
		boolean contem = false;
		if (listaProdutos.contains(produto)) {
			contem = true;
		}
		return contem;
	}

	public boolean existe(int codigo) {
		int p;
		boolean x = false;
		for (Produto produto : listaProdutos) {
			p = produto.getCodigo();
			if (p == codigo) {
				x = true;
			}
		}
		return x;
	}

	public List<Produto> listar() {
		return Collections.unmodifiableList(this.listaProdutos);
	}

	@Override
	public String toString() {
		return "RepositorioProduto [listaProdutos = " + listaProdutos + "]";

	}

}