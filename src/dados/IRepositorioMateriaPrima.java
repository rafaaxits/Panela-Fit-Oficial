package dados;
import beans.MateriaPrima;
public interface IRepositorioMateriaPrima {
	
	public boolean cadastrarMateriaPrima(MateriaPrima materiaPrima);
	public void alterarMateriaPrima(MateriaPrima mpAlterada, MateriaPrima novaMateriaPrima);
	public MateriaPrima buscarMateriaPrima(int codigo);
	public boolean removerMateriaPrima(int codigo);
	public boolean mpExiste(int codigo);
}
