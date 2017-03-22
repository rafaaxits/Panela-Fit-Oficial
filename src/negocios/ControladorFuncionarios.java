package negocios;

import dados.IRepositorioFuncionario;
import exceptions.FuncionarioNaoExisteException;
import negocios.beans.Funcionario;
import exceptions.FuncionarioJaExisteException;
import exceptions.FormatacaoInvalidaException;
import java.util.List;

public class ControladorFuncionarios {
	IRepositorioFuncionario repositorio;

	public ControladorFuncionarios(IRepositorioFuncionario instanciaInterface) {
		if (instanciaInterface != null) {
			this.repositorio = instanciaInterface;
		} else {
			// argumento invalido
			IllegalArgumentException x = new IllegalArgumentException("Reposit�rio inv�lido.");
			throw x;
		}
	}

	public void cadastrar(Funcionario funcionario) throws FuncionarioJaExisteException, FormatacaoInvalidaException {
		if (funcionario == null) {
			throw new FormatacaoInvalidaException();
		} else {
			if (this.repositorio.existe(funcionario.getCodigo()) == false) {
				this.repositorio.inserir(funcionario);
				this.repositorio.salvarArquivo();
			} else if (this.repositorio.existe(funcionario.getCodigo()) == true) {
				throw new FuncionarioJaExisteException(funcionario.getCodigo());
			}
		}
	}

	public Funcionario buscar(int codigo) throws FuncionarioNaoExisteException {
		if (this.repositorio.existe(codigo) == true) {
			return this.repositorio.buscar(codigo);
		} else {
			throw new FuncionarioNaoExisteException();
		}
	}

	public void remover(Funcionario funcionario) throws FuncionarioNaoExisteException, FormatacaoInvalidaException {
		if (funcionario == null) {
			throw new FormatacaoInvalidaException();
		} else if (this.repositorio.funcionarioContem(funcionario) == true) {
			this.repositorio.remover(funcionario.getCodigo());
			this.repositorio.salvarArquivo();
		} else if (this.repositorio.funcionarioContem(funcionario) == false) {
			throw new FuncionarioNaoExisteException();
		}
	}

	public void alterar(Funcionario novoFuncionario) throws FuncionarioNaoExisteException, FormatacaoInvalidaException {
		if (novoFuncionario == null) {
			throw new FormatacaoInvalidaException();
		} else if ((novoFuncionario != null && this.repositorio.existe(novoFuncionario.getCodigo()) == true)) {
			this.repositorio.alterar(novoFuncionario);
			this.repositorio.salvarArquivo();
		} else if ((this.repositorio.existe(novoFuncionario.getCodigo()) == false)) {
			throw new FuncionarioNaoExisteException();
		}

	}

	public int getNivel(int codigo) throws FuncionarioNaoExisteException {
		if (this.repositorio.existe(codigo) == true) {
			Funcionario funcionario = this.repositorio.buscar(codigo);
			return funcionario.getNivel();
		} else {
			throw new FuncionarioNaoExisteException();
		}
	}

	public boolean existe(int codigo) throws FuncionarioNaoExisteException {
		boolean alt = false;
		if (repositorio.existe(codigo)) {
			alt = true;
		} else {
			throw new FuncionarioNaoExisteException();
		}
		return alt;
	}

	public List<Funcionario> listarFuncionarios() {
		return this.repositorio.listar();
	}

}