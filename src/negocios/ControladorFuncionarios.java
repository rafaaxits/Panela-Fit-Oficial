package negocios;

import dados.IRepositorioFuncionario;
import exceptions.FuncionarioNaoExisteException;
import exceptions.FuncionarioJaExisteException;
import exceptions.FuncionarioInvalidoException;
import java.util.List;

public class ControladorFuncionarios {
	 IRepositorioFuncionario repositorio;
	
	public ControladorFuncionarios(IRepositorioFuncionario instanciaInterface) {
		if(instanciaInterface !=null){
		this.repositorio = instanciaInterface;
		}else {
		      // argumento invalido
		      IllegalArgumentException x = new IllegalArgumentException(
		          "Reposit�rio inv�lido.");
		      throw x;
		    }
	}
	
	public void cadastrar(Funcionario funcionario) throws FuncionarioJaExisteException, FuncionarioNaoExisteException, FuncionarioInvalidoException {
		if(funcionario == null) {
			throw new FuncionarioInvalidoException();
		} else {
			if(this.repositorio.existe(funcionario.getCodigo()) == false) {
				this.repositorio.inserir(funcionario);
				this.repositorio.salvarArquivo();
			} else if(this.repositorio.existe(funcionario.getCodigo()) == true) {
				throw new FuncionarioJaExisteException(funcionario.getCodigo());
			}
		}
	}
	
	public Funcionario buscar(int codigo) throws FuncionarioNaoExisteException {
		if(this.repositorio.existe(codigo) == true) {
		return this.repositorio.buscar(codigo);
		} else {
			throw new FuncionarioNaoExisteException();
		}
	}
	
	public void remover(Funcionario funcionario) throws FuncionarioNaoExisteException, FuncionarioInvalidoException{
		if(funcionario == null) {
			throw new FuncionarioInvalidoException();
		} 
		else if(this.repositorio.funcionarioContem(funcionario) == true) {
				this.repositorio.remover(funcionario.getCodigo());	
				this.repositorio.salvarArquivo();
		}
		else if(this.repositorio.funcionarioContem(funcionario) == false){
			throw new FuncionarioNaoExisteException();
		}
	}
	
	public void alterar(Funcionario novoFuncionario) throws FuncionarioNaoExisteException, FuncionarioJaExisteException, FuncionarioInvalidoException{
		if(novoFuncionario == null) {
			throw new FuncionarioInvalidoException();
		}
		else if(this.repositorio.funcionarioContem(novoFuncionario) == true) {
			throw new FuncionarioJaExisteException(novoFuncionario.getCodigo());
		}
		else if((novoFuncionario != null && this.repositorio.existe(novoFuncionario.getCodigo()) == true)) {
			this.repositorio.alterar(novoFuncionario);
			this.repositorio.salvarArquivo();
		}
		else if((this.repositorio.existe(novoFuncionario.getCodigo()) == false)){
			throw new FuncionarioNaoExisteException();
		}
		
}
	public int getNivel(int codigo) throws FuncionarioNaoExisteException {
		if(this.repositorio.existe(codigo) == true) {
			Funcionario funcionario = this.repositorio.buscar(codigo);
			return funcionario.getNivel();
		} else {
			throw new FuncionarioNaoExisteException();
		}
	}
	
	public List<Funcionario> listarFuncionarios(){
		return this.repositorio.listar();
	}
	
}