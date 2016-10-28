package negocios;

import beans.MateriaPrima;
import dados.IRepositorioMateriaPrima;
import exceptions.MateriaPrimaJaExisteException;
import exceptions.MateriaPrimaNaoExisteException;

public class ControladorMateriaPrimas {
	 IRepositorioMateriaPrima repositorio;
	
	public ControladorMateriaPrimas(IRepositorioMateriaPrima instanciaInterface){
		this.repositorio = instanciaInterface;
	}
	
	public void cadastrar (MateriaPrima m) throws MateriaPrimaJaExisteException {
		if(m==null) {
			throw new IllegalArgumentException("");
		} else{
			if(this.repositorio.mpExiste(m.getCodigo()) == true){
				this.repositorio.cadastrarMateriaPrima(m);
			} else if (this.repositorio.mpExiste(m.getCodigo()) == false) {
				MateriaPrimaJaExisteException c = new MateriaPrimaJaExisteException(m.getCodigo());
				throw c;
			}
		}
	}
	public MateriaPrima buscar(int codigo) throws MateriaPrimaNaoExisteException {
		if(this.repositorio.mpExiste(codigo) == true) {
			return this.repositorio.buscarMateriaPrima(codigo);
		} else {
		throw new MateriaPrimaNaoExisteException(codigo);
		}
	}
	
	public void remover(MateriaPrima m) throws MateriaPrimaNaoExisteException {
		if(m == null) {
			throw new IllegalArgumentException("");
		} else {
			if(this.repositorio.mpExiste(m.getCodigo()) == true) {
				this.repositorio.removerMateriaPrima(m.getCodigo());
			} else if(this.repositorio.mpExiste(m.getCodigo()) == false) {
				MateriaPrimaNaoExisteException r = new MateriaPrimaNaoExisteException(m.getCodigo());
				throw r;
			}
		}	
	}
	
	public void alterar(MateriaPrima mpAlterada, MateriaPrima novaMateriaPrima) throws MateriaPrimaNaoExisteException {
		if(mpAlterada != null && novaMateriaPrima != null) {
			this.repositorio.alterarMateriaPrima(mpAlterada, novaMateriaPrima);
		} else {
			if(mpAlterada == null || novaMateriaPrima == null) {
				IllegalArgumentException a = new IllegalArgumentException("");
				throw a;
			}
		}
	}
	
	public int getQuantidade(int codigo) throws MateriaPrimaNaoExisteException {
		if(this.repositorio.mpExiste(codigo) == true) {
		MateriaPrima m = this.repositorio.buscarMateriaPrima(codigo);
		return m.getQuantidade();
		} else {
			throw new MateriaPrimaNaoExisteException(codigo);
		}
	}
}
