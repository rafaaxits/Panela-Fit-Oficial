package dados;
import beans.Funcionario;

public interface IRepositorioFuncionario {
	public boolean cadastrarFuncionario(Funcionario funcionario);
	public void alterarFuncionario(Funcionario funcAlterado, Funcionario novoFuncionario);
	public Funcionario buscarFuncionario(int codigo);
	public boolean removerFuncionario(int codigo);
	public boolean funcionarioExiste(int codigo);
}
