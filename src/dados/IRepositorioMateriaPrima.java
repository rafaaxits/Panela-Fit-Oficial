package dados;

import java.util.List;

import negocios.beans.MateriaPrima;

public interface IRepositorioMateriaPrima {

	public boolean inserir(MateriaPrima materiaPrima);

	public boolean alterar(MateriaPrima novaMateriaPrima);

	public MateriaPrima buscar(int codigo);

	public boolean remover(int codigo);

	public boolean materiaPrimaContem(MateriaPrima materiaPrima);

	public boolean existe(int codigo);

	public abstract List<MateriaPrima> listar();

	void salvarArquivo();
}
