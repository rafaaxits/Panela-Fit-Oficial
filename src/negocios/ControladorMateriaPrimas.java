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
			if(this.repositorio.existe(materiaPrima.getCodigo()) == false){
				this.repositorio.inserir(materiaPrima);
			} else if (this.repositorio.existe(materiaPrima.getCodigo()) == true) {
				throw new MateriaPrimaJaExisteException(materiaPrima.getCodigo());
			}
		}
	}
	public MateriaPrima buscar(int codigo) throws MateriaPrimaNaoExisteException {
		if(this.repositorio.existe(codigo) == true) {
			return this.repositorio.buscar(codigo);
		} else {
		throw new MateriaPrimaNaoExisteException();
		}
	}
	
	public void remover(MateriaPrima materiaPrima) throws MateriaPrimaNaoExisteException, MateriaPrimaInvalidaException {
	if(materiaPrima == null) {
		throw new MateriaPrimaInvalidaException();
		}
		else if(this.repositorio.materiaPrimaContem(materiaPrima) == true) {
				this.repositorio.remover(materiaPrima.getCodigo());
		}
		else if(this.repositorio.materiaPrimaContem(materiaPrima)==false) {
			throw new MateriaPrimaNaoExisteException();
		}
	}
	
	public void alterar(MateriaPrima novaMateriaPrima) throws MateriaPrimaNaoExisteException, MateriaPrimaJaExisteException,MateriaPrimaInvalidaException{
		if(novaMateriaPrima == null){
			throw new MateriaPrimaInvalidaException();
		}
		else if((novaMateriaPrima != null && this.repositorio.existe(novaMateriaPrima.getCodigo()) == true)){
			this.repositorio.alterar(novaMateriaPrima);
		}
		else if(novaMateriaPrima != null && this.repositorio.materiaPrimaContem(novaMateriaPrima) == false){
			throw new MateriaPrimaNaoExisteException();
		}
		else if(novaMateriaPrima != null && this.repositorio.materiaPrimaContem(novaMateriaPrima) == true){
			throw new MateriaPrimaJaExisteException(novaMateriaPrima.getCodigo());
		}
	}
	
	public int getQuantidade(int codigo) throws MateriaPrimaNaoExisteException {
		if(this.repositorio.existe(codigo) == true) {
		MateriaPrima materiaPrima = this.repositorio.buscar(codigo);
		return materiaPrima.getQuantidade();
		} else {
			throw new MateriaPrimaNaoExisteException();
		}
	}
	
	public List <MateriaPrima> listaMateriaPrimas(){
		return this.repositorio.listar();
	}
}
