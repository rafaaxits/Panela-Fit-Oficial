package negocios;

import beans.Funcionario;
import dados.IRepositorioFuncionario;
import exceptions.FuncionarioNaoExisteException;
import exceptions.FuncionarioJaExisteException;

public class ControladorFuncionarios {
	 IRepositorioFuncionario repositorio;
	
	public ControladorFuncionarios(IRepositorioFuncionario instanciaInterface) {
		this.repositorio = instanciaInterface;
	}
	
	public void cadastrar(Funcionario f) throws FuncionarioJaExisteException{
		if(f == null) {
			throw new IllegalArgumentException("");
		} else {
			if(this.repositorio.funcionarioExiste(f.getCodigo()) == true) {
				this.repositorio.cadastrarFuncionario(f);
			} else if(this.repositorio.funcionarioExiste(f.getCodigo()) == false) {
				FuncionarioJaExisteException x = new FuncionarioJaExisteException(f.getCodigo());
				throw x;
			}
		}
	}
	
	public Funcionario buscar(int codigo) throws FuncionarioNaoExisteException {
		if(this.repositorio.funcionarioExiste(codigo) == true) {
		return this.repositorio.buscarFuncionario(codigo);
		} else {
			throw new FuncionarioNaoExisteException(codigo);
		}
	}
	
	public void remover(Funcionario f) throws FuncionarioNaoExisteException {
		if(f == null) {
			throw new IllegalArgumentException("");
		} else {
			if(this.repositorio.funcionarioExiste(f.getCodigo()) == true) {
				this.repositorio.removerFuncionario(f.getCodigo());
			}
			else if(this.repositorio.funcionarioExiste(f.getCodigo()) == false) {
				FuncionarioNaoExisteException r = new FuncionarioNaoExisteException(f.getCodigo());
				throw r;
			}
		}
	}
	
	public void alterar(Funcionario funcAlterado, Funcionario novoFuncionario) throws FuncionarioNaoExisteException {
		if(funcAlterado != null && novoFuncionario != null) {
			this.repositorio.alterarFuncionario(funcAlterado, novoFuncionario);
		} else {
			if(funcAlterado == null || novoFuncionario == null) {
				IllegalArgumentException a = new IllegalArgumentException("");
				throw a;
			}
	}
}
	public int getNivel(int codigo) throws FuncionarioNaoExisteException {
		if(this.repositorio.funcionarioExiste(codigo) == true) {
			Funcionario f = this.repositorio.buscarFuncionario(codigo);
			return f.getNivel();
		} else {
			throw new FuncionarioNaoExisteException(codigo);
		}
	}
	
}