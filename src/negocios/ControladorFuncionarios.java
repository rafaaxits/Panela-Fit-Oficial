package negocios;

import dados.IRepositorioFuncionario;
import exceptions.FuncionarioNaoExisteException;
import exceptions.FuncionarioJaExisteException;
import exceptions.FuncionarioInvalidoException;
import java.util.List;

public class ControladorFuncionarios {
	 IRepositorioFuncionario repositorio;
	
	public ControladorFuncionarios(IRepositorioFuncionario instanciaInterface) {
		this.repositorio = instanciaInterface;
	}
	
	public void cadastrar(Funcionario funcionario) throws FuncionarioJaExisteException, FuncionarioNaoExisteException, FuncionarioInvalidoException {
		if(funcionario == null) {
			throw new FuncionarioInvalidoException();
		} else {
			if(this.repositorio.existe(funcionario.getCodigo()) == false) {
				this.repositorio.inserir(funcionario);
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
		}
		else if(this.repositorio.funcionarioContem(funcionario) == false){
			throw new FuncionarioNaoExisteException();
		}
	}
	
	public void alterar(Funcionario funcAlterado, Funcionario novoFuncionario) throws FuncionarioNaoExisteException, FuncionarioJaExisteException, FuncionarioInvalidoException{
		if(funcAlterado == null || novoFuncionario == null) {
			throw new FuncionarioInvalidoException();
		} 
		else if(this.repositorio.funcionarioContem(funcAlterado) == true && (novoFuncionario != null && this.repositorio.funcionarioContem(novoFuncionario)==false)) {
			this.repositorio.alterar(funcAlterado, novoFuncionario);
		}
		else if((funcAlterado != null && this.repositorio.funcionarioContem(funcAlterado) == false)){
			throw new FuncionarioNaoExisteException();
		}
		else  {
			throw new FuncionarioJaExisteException(funcAlterado.getCodigo());
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