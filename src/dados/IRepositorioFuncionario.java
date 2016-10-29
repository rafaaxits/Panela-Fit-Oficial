package dados;
import beans.Funcionario;
import java.util.List;
public interface IRepositorioFuncionario {
	public boolean cadastrarFuncionario(Funcionario funcionario);
	public boolean alterarFuncionario(Funcionario funcAlterado, Funcionario novoFuncionario);
	public Funcionario buscarFuncionario(int codigo);
	public boolean removerFuncionario(int codigo);
	public boolean funcionarioExiste(int codigo);
	public abstract List<Funcionario> listar();
}
