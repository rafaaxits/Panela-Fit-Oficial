package dados;
import java.util.List;

import negocios.Funcionario;
public interface IRepositorioFuncionario {
	public boolean cadastrarFuncionario(Funcionario funcionario);
	public boolean alterarFuncionario(Funcionario funcionarioAlterado, Funcionario novoFuncionario);
	public Funcionario buscarFuncionario(int codigo);
	public boolean removerFuncionario(int codigo);
	public boolean funcionarioContem(Funcionario funcionario);
	public boolean funcionarioExiste(int codigo);
	public abstract List<Funcionario> listar();
}
