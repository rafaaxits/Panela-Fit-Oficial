package dados;

import java.util.List;

import negocios.beans.Funcionario;

public interface IRepositorioFuncionario {
	public boolean inserir(Funcionario funcionario);

	public boolean alterar(Funcionario novoFuncionario);

	public Funcionario buscar(int codigo);

	public boolean remover(int codigo);

	public boolean funcionarioContem(Funcionario funcionario);

	public boolean existe(int codigo);

	public abstract List<Funcionario> listar();

	void salvarArquivo();
}
