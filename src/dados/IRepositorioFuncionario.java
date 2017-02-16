package dados;
import java.util.List;

import negocios.Funcionario;
public interface IRepositorioFuncionario {
	public boolean inserir(Funcionario funcionario);
	public boolean alterar(Funcionario funcionarioAlterado, Funcionario novoFuncionario);
	public Funcionario buscar(int codigo);
	public boolean remover(int codigo);
	public boolean funcionarioContem(Funcionario funcionario);
	public boolean existe(int codigo);
	public abstract List<Funcionario> listar();
}
