package negocios;

import beans.Cliente;
import beans.Funcionario;
import dados.IRepositorioFuncionario;
import exceptions.FuncionarioNaoExisteException;
import exceptions.ClienteJaExisteException;
import exceptions.ClienteNaoExisteException;
import exceptions.FuncionarioJaExisteException;

public class ControladorFuncionarios {
	 IRepositorioFuncionario repositorio;
	
	public ControladorFuncionarios(IRepositorioFuncionario instanciaInterface) {
		this.repositorio = instanciaInterface;
	}
	
	public void cadastrar(Funcionario f) throws FuncionarioJaExisteException, FuncionarioNaoExisteException {
		if(f == null) {
			throw new FuncionarioNaoExisteException();
		} else {
			if(this.repositorio.funcionarioExiste(f.getCodigo()) == false) {
				this.repositorio.cadastrarFuncionario(f);
			} else if(this.repositorio.funcionarioExiste(f.getCodigo()) == true) {
				throw new FuncionarioJaExisteException(f.getCodigo());
			}
		}
	}
	
	public Funcionario buscar(int codigo) throws FuncionarioNaoExisteException {
		if(this.repositorio.funcionarioExiste(codigo) == true) {
		return this.repositorio.buscarFuncionario(codigo);
		} else {
			throw new FuncionarioNaoExisteException();
		}
	}
	
	public void remover(Funcionario f) throws FuncionarioNaoExisteException {
		if(f == null || this.repositorio.funcionarioExiste(f.getCodigo()) == false) {
			throw new FuncionarioNaoExisteException();
		} else {
			if(this.repositorio.funcionarioExiste(f.getCodigo()) == true) {
				this.repositorio.removerFuncionario(f.getCodigo());
			}
		}
	}
	
	public void alterar(Funcionario funcAlterado, Funcionario novoFuncionario) throws FuncionarioNaoExisteException, FuncionarioJaExisteException{
		if(funcAlterado == null && novoFuncionario == null) {
			throw new FuncionarioNaoExisteException();
		} else if((funcAlterado != null && this.repositorio.funcionarioExiste(funcAlterado.getCodigo()) == true) && novoFuncionario != null) {
			this.repositorio.alterarFuncionario(funcAlterado, novoFuncionario);
		}
		else if((funcAlterado != null && this.repositorio.funcionarioExiste(funcAlterado.getCodigo()) == false)){
			throw new FuncionarioNaoExisteException();
		}
		else if(funcAlterado.equals(novoFuncionario)) {
			throw new FuncionarioJaExisteException(funcAlterado.getCodigo());
		}
}
	public int getNivel(int codigo) throws FuncionarioNaoExisteException {
		if(this.repositorio.funcionarioExiste(codigo) == true) {
			Funcionario f = this.repositorio.buscarFuncionario(codigo);
			return f.getNivel();
		} else {
			throw new FuncionarioNaoExisteException();
		}
	}
	
}