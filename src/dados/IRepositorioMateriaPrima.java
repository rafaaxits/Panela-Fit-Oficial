package dados;
import beans.MateriaPrima;
import java.util.List;
public interface IRepositorioMateriaPrima {
	
	public boolean cadastrarMateriaPrima(MateriaPrima materiaPrima);
	public boolean alterarMateriaPrima(MateriaPrima mpAlterada, MateriaPrima novaMateriaPrima);
	public MateriaPrima buscarMateriaPrima(int codigo);
	public boolean removerMateriaPrima(int codigo);
	public boolean materiaPrimaExiste(int codigo);
	public abstract List <MateriaPrima> listar();
}
