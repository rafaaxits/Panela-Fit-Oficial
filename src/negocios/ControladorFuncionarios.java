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
	
	public void cadastrar(Funcionario f) throws FuncionarioJaExisteException, FuncionarioNaoExisteException, FuncionarioInvalidoException {
		if(f == null) {
			throw new FuncionarioInvalidoException();
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
	
	public void remover(Funcionario f) throws FuncionarioNaoExisteException, FuncionarioInvalidoException{
		if(f == null) {
			throw new FuncionarioInvalidoException();
		} 
		else if(this.repositorio.funcionarioContem(f) == true) {
				this.repositorio.removerFuncionario(f.getCodigo());	
		}
		else if(this.repositorio.funcionarioContem(f)==false){
			throw new FuncionarioNaoExisteException();
		}
	}
	
	public void alterar(Funcionario funcAlterado, Funcionario novoFuncionario) throws FuncionarioNaoExisteException, FuncionarioJaExisteException, FuncionarioInvalidoException{
		if(funcAlterado == null || novoFuncionario == null) {
			throw new FuncionarioInvalidoException();
		} 
		else if(this.repositorio.funcionarioContem(funcAlterado) == true && (novoFuncionario != null && this.repositorio.funcionarioContem(novoFuncionario)==false)) {
			this.repositorio.alterarFuncionario(funcAlterado, novoFuncionario);
		}
		else if((funcAlterado != null && this.repositorio.funcionarioContem(funcAlterado) == false)){
			throw new FuncionarioNaoExisteException();
		}
		else  {
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
	
	public List<Funcionario> listarFuncionarios(){
		return this.repositorio.listar();
	}
	
}