package negocios;

import java.util.List;
import dados.IRepositorioVenda;
import exceptions.VendaJaExisteException;
import exceptions.VendaNaoExisteException;
import negocios.beans.Venda;
import exceptions.FormatacaoInvalidaException;

public class ControladorVendas {
	IRepositorioVenda repositorio;

	public ControladorVendas(IRepositorioVenda instanciaInterface) {
		if (instanciaInterface != null) {
			this.repositorio = instanciaInterface;
		} else {
			// argumento invalido
			IllegalArgumentException x = new IllegalArgumentException("Reposit�rio inv�lido.");
			throw x;
		}
	}

	public void cadastrar(Venda venda) throws VendaJaExisteException, FormatacaoInvalidaException {
		if (venda == null || venda.calcularVenda() <= 0) {
			throw new FormatacaoInvalidaException();
		} else {
			if (this.repositorio.existe(venda.getCodigo()) == false) {
				this.repositorio.inserir(venda);
				this.repositorio.salvarArquivo();
			} else if (this.repositorio.existe(venda.getCodigo()) == true) {
				throw new VendaJaExisteException(venda.getCodigo());
			}
		}
	}

	public Venda buscar(int codigo) throws VendaNaoExisteException {
		if (this.repositorio.existe(codigo) == true) {
			return this.repositorio.buscar(codigo);
		} else {
			throw new VendaNaoExisteException();
		}
	}

	public void remover(Venda venda) throws VendaNaoExisteException, FormatacaoInvalidaException {
		if (venda == null) {
			throw new FormatacaoInvalidaException();
		} else if (this.repositorio.vendaContem(venda) == true) {
			this.repositorio.remover(venda.getCodigo());
			this.repositorio.salvarArquivo();
		} else if (this.repositorio.vendaContem(venda) == false) {
			throw new VendaNaoExisteException();
		}
	}

	public void alterar(Venda novaVenda) throws VendaNaoExisteException, FormatacaoInvalidaException {
		if (novaVenda == null || novaVenda.calcularVenda() <= 0) {
			throw new FormatacaoInvalidaException();
		} else if ((novaVenda != null && this.repositorio.existe(novaVenda.getCodigo()) == true)) {
			this.repositorio.alterar(novaVenda);
			this.repositorio.salvarArquivo();
		} else if ((this.repositorio.existe(novaVenda.getCodigo()) == false)) {
			throw new VendaNaoExisteException();
		}
	}

	public boolean existe(int codigo) throws VendaNaoExisteException {
		boolean alt = false;
		if (repositorio.existe(codigo)) {
			alt = true;
		} else {
			throw new VendaNaoExisteException();
		}
		return alt;
	}

	public void excluirVendas() {
		this.repositorio.excluirVendas();
		this.repositorio.salvarArquivo();
	}

	public List<Venda> listarVendas() {
		return this.repositorio.listar();
	}
}
