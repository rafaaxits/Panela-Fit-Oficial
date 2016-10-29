package negocios;

import beans.MateriaPrima;
import dados.IRepositorioMateriaPrima;
import exceptions.MateriaPrimaJaExisteException;
import exceptions.MateriaPrimaNaoExisteException;
import java.util.List;

public class ControladorMateriaPrimas {
	 IRepositorioMateriaPrima repositorio;
	
	public ControladorMateriaPrimas(IRepositorioMateriaPrima instanciaInterface){
		this.repositorio = instanciaInterface;
	}
	
	public void cadastrar (MateriaPrima m) throws MateriaPrimaJaExisteException, MateriaPrimaNaoExisteException {
		if(m==null) {
			throw new MateriaPrimaNaoExisteException();
		} else{
			if(this.repositorio.materiaPrimaExiste(m.getCodigo()) == false){
				this.repositorio.cadastrarMateriaPrima(m);
			} else if (this.repositorio.materiaPrimaExiste(m.getCodigo()) == true) {
				throw new MateriaPrimaJaExisteException(m.getCodigo());
			}
		}
	}
	public MateriaPrima buscar(int codigo) throws MateriaPrimaNaoExisteException {
		if(this.repositorio.materiaPrimaExiste(codigo) == true) {
			return this.repositorio.buscarMateriaPrima(codigo);
		} else {
		throw new MateriaPrimaNaoExisteException();
		}
	}
	
	public void remover(MateriaPrima m) throws MateriaPrimaNaoExisteException {
	if(m==null || this.repositorio.materiaPrimaExiste(m.getCodigo())==false){
		throw new MateriaPrimaNaoExisteException();
		}else{
			if(this.repositorio.materiaPrimaExiste(m.getCodigo())==true){
				this.repositorio.removerMateriaPrima(m.getCodigo());
			}
		}
	}
	
	public void alterar(MateriaPrima materiaPrimaAlterada, MateriaPrima novaMateriaPrima) throws MateriaPrimaNaoExisteException, MateriaPrimaJaExisteException{
		if(materiaPrimaAlterada == null || novaMateriaPrima == null){
			throw new MateriaPrimaNaoExisteException();
		}
		else if((materiaPrimaAlterada != null && this.repositorio.materiaPrimaExiste(materiaPrimaAlterada.getCodigo())==true) && novaMateriaPrima != null){
			this.repositorio.alterarMateriaPrima(materiaPrimaAlterada, novaMateriaPrima);
		}
		else if(materiaPrimaAlterada != null && this.repositorio.materiaPrimaExiste(materiaPrimaAlterada.getCodigo())==false){
			throw new MateriaPrimaNaoExisteException();
		}
		else{
			throw new MateriaPrimaJaExisteException(materiaPrimaAlterada.getCodigo());
		}
	}
	
	public int getQuantidade(int codigo) throws MateriaPrimaNaoExisteException {
		if(this.repositorio.materiaPrimaExiste(codigo) == true) {
		MateriaPrima m = this.repositorio.buscarMateriaPrima(codigo);
		return m.getQuantidade();
		} else {
			throw new MateriaPrimaNaoExisteException();
		}
	}
	
	public List <MateriaPrima> listaMateriaPrimas(){
		return this.repositorio.listar();
	}
}
