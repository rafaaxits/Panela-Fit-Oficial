package negocios;

import dados.IRepositorioMateriaPrima;
import exceptions.MateriaPrimaJaExisteException;
import exceptions.MateriaPrimaNaoExisteException;
import exceptions.FormatacaoInvalidaException;
import java.util.List;

public class ControladorMateriaPrimas {
	 IRepositorioMateriaPrima repositorio;
	
	public ControladorMateriaPrimas(IRepositorioMateriaPrima instanciaInterface){
		if(instanciaInterface !=null){
		this.repositorio = instanciaInterface;
		}else {
		      // argumento invalido
		      IllegalArgumentException x = new IllegalArgumentException(
		          "Reposit�rio inv�lido.");
		      throw x;
		    }
	}
	
	public void cadastrar (MateriaPrima materiaPrima) throws MateriaPrimaJaExisteException, FormatacaoInvalidaException{
		if(materiaPrima == null) {
			throw new FormatacaoInvalidaException();
		} else {
			if(this.repositorio.existe(materiaPrima.getCodigo()) == false){
				this.repositorio.inserir(materiaPrima);
				this.repositorio.salvarArquivo();
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
	
	public void remover(MateriaPrima materiaPrima) throws MateriaPrimaNaoExisteException, FormatacaoInvalidaException {
	if(materiaPrima == null) {
		throw new FormatacaoInvalidaException();
		}
		else if(this.repositorio.materiaPrimaContem(materiaPrima) == true) {
				this.repositorio.remover(materiaPrima.getCodigo());
				this.repositorio.salvarArquivo();
		}
		else if(this.repositorio.materiaPrimaContem(materiaPrima)==false) {
			throw new MateriaPrimaNaoExisteException();
		}
	}
	
	public void alterar(MateriaPrima novaMateriaPrima) throws MateriaPrimaNaoExisteException, MateriaPrimaJaExisteException,FormatacaoInvalidaException{
		if(novaMateriaPrima == null){
			throw new FormatacaoInvalidaException();
		}
		else if(this.repositorio.materiaPrimaContem(novaMateriaPrima) == true){
			throw new MateriaPrimaJaExisteException(novaMateriaPrima.getCodigo());
		}
		else if((novaMateriaPrima != null && this.repositorio.existe(novaMateriaPrima.getCodigo()) == true)){
			this.repositorio.alterar(novaMateriaPrima);
			this.repositorio.salvarArquivo();
		}
		else if((this.repositorio.existe(novaMateriaPrima.getCodigo()) == false)){
			throw new MateriaPrimaNaoExisteException();
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
	
	public boolean existe(int codigo) throws MateriaPrimaNaoExisteException{
		boolean alt=false;
			if(repositorio.existe(codigo)==true){
				alt=true;
			}else{
				throw new MateriaPrimaNaoExisteException();
			}
		return alt;
		
	}
	
	public List <MateriaPrima> listaMateriaPrimas(){
		return this.repositorio.listar();
	}
}
