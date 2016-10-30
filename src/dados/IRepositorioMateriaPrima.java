package dados;
import java.util.List;

import negocios.MateriaPrima;
public interface IRepositorioMateriaPrima {
	
	public boolean cadastrarMateriaPrima(MateriaPrima materiaPrima);
	public boolean alterarMateriaPrima(MateriaPrima materiaPrimaAlterada, MateriaPrima novaMateriaPrima);
	public MateriaPrima buscarMateriaPrima(int codigo);
	public boolean removerMateriaPrima(int codigo);
	public boolean materiaPrimaContem(MateriaPrima materiaPrima);
	public boolean materiaPrimaExiste(int codigo);
	public abstract List <MateriaPrima> listar();
}
