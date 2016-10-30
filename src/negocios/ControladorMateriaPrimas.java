package negocios;

import dados.IRepositorioMateriaPrima;
import exceptions.MateriaPrimaJaExisteException;
import exceptions.MateriaPrimaNaoExisteException;
import exceptions.MateriaPrimaInvalidaException;
import java.util.List;

public class ControladorMateriaPrimas {
	 IRepositorioMateriaPrima repositorio;
	
	public ControladorMateriaPrimas(IRepositorioMateriaPrima instanciaInterface){
		this.repositorio = instanciaInterface;
	}
	
	public void cadastrar (MateriaPrima materiaPrima) throws MateriaPrimaJaExisteException, MateriaPrimaNaoExisteException, MateriaPrimaInvalidaException{
		if(materiaPrima == null) {
			throw new MateriaPrimaInvalidaException();
		} else {
			if(this.repositorio.materiaPrimaExiste(materiaPrima.getCodigo()) == false){
				this.repositorio.cadastrarMateriaPrima(materiaPrima);
			} else if (this.repositorio.materiaPrimaExiste(materiaPrima.getCodigo()) == true) {
				throw new MateriaPrimaJaExisteException(materiaPrima.getCodigo());
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
	
	public void remover(MateriaPrima materiaPrima) throws MateriaPrimaNaoExisteException, MateriaPrimaInvalidaException {
	if(materiaPrima == null) {
		throw new MateriaPrimaInvalidaException();
		}
		else if(this.repositorio.materiaPrimaContem(materiaPrima) == true) {
				this.repositorio.removerMateriaPrima(materiaPrima.getCodigo());
		}
		else if(this.repositorio.materiaPrimaContem(materiaPrima)==false) {
			throw new MateriaPrimaNaoExisteException();
		}
	}
	
	public void alterar(MateriaPrima materiaPrimaAlterada, MateriaPrima novaMateriaPrima) throws MateriaPrimaNaoExisteException, MateriaPrimaJaExisteException,MateriaPrimaInvalidaException{
		if(materiaPrimaAlterada == null || novaMateriaPrima == null){
			throw new MateriaPrimaInvalidaException();
		}
		else if(this.repositorio.materiaPrimaContem(materiaPrimaAlterada)==true && (novaMateriaPrima!=null && this.repositorio.materiaPrimaContem(novaMateriaPrima))==false){
			this.repositorio.alterarMateriaPrima(materiaPrimaAlterada, novaMateriaPrima);
		}
		else if(materiaPrimaAlterada != null && this.repositorio.materiaPrimaContem(materiaPrimaAlterada)==false){
			throw new MateriaPrimaNaoExisteException();
		}
		else{
			throw new MateriaPrimaJaExisteException(materiaPrimaAlterada.getCodigo());
		}
	}
	
	public int getQuantidade(int codigo) throws MateriaPrimaNaoExisteException {
		if(this.repositorio.materiaPrimaExiste(codigo) == true) {
		MateriaPrima materiaPrima = this.repositorio.buscarMateriaPrima(codigo);
		return materiaPrima.getQuantidade();
		} else {
			throw new MateriaPrimaNaoExisteException();
		}
	}
	
	public List <MateriaPrima> listaMateriaPrimas(){
		return this.repositorio.listar();
	}
}
