package negocios;

import java.util.ArrayList;

import exceptions.FormatacaoInvalidaException;

import java.io.Serializable;
import java.time.*;

public class Venda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1931621942968592228L;
	private int codigo;
	private Cliente cliente;
	private Funcionario funcionario;
	private ArrayList<ItemVenda> listaItensDeVenda;
	private LocalDate dataDaVenda;

	// data
	// metodo gettotal que chama o gettotal de cada item.. varre a lista de
	// itens pega o total de kd

	public Venda(int codigo, Cliente cliente, Funcionario funcionario, ArrayList<ItemVenda> listaItensDeVenda,
			LocalDate dataDaVenda) throws FormatacaoInvalidaException {
		super();
		this.setCodigo(codigo);
		this.setCliente(cliente);
		this.setFuncionario(funcionario);
		this.setListaItensDeVenda(listaItensDeVenda);
		this.setDataDaVenda(dataDaVenda);
	}

	public Venda() {

	}

	public LocalDate getDataDaVenda() {
		return dataDaVenda;
	}

	public void setDataDaVenda(LocalDate dataDaVenda) {
		this.dataDaVenda = dataDaVenda;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) throws FormatacaoInvalidaException {
		Integer code = codigo;
		if (code.toString().length() == 5) {
			this.codigo = codigo;
		} else {
			throw new FormatacaoInvalidaException();
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public ArrayList<ItemVenda> getListaItensDeVenda() {
		return listaItensDeVenda;
	}

	public void setListaItensDeVenda(ArrayList<ItemVenda> listaItensDeVenda) {
		this.listaItensDeVenda = listaItensDeVenda;
	}

	public boolean equals(Venda venda) {
		boolean igual = false;
		if (venda != null) {
			if (this.codigo == venda.getCodigo()) {
				igual = true;
			}
		}
		return igual;
	}

	@Override
	public String toString() {
		return "Venda [codigo=" + codigo + ", cliente=" + this.getCliente() + ", funcionario=" + this.getFuncionario()
				+ ", listaItensDeVenda=" + listaItensDeVenda + ", dataDaVenda=" + dataDaVenda + ",Total="
				+ this.calcularVenda() + "]";
	}

	public Double calcularVenda() {
		double total = 0;
		if (this.listaItensDeVenda != null) {
			for (ItemVenda item : listaItensDeVenda) {
				total = total + item.getTotal();
			}
			return total;
		}
		return total;
	}

	public boolean inserirItem(ItemVenda itemVenda) {
		boolean alt = false;
		if (itemVenda != null) {
			this.listaItensDeVenda.add(itemVenda);
			alt = true;
		}
		return alt;
	}
}
