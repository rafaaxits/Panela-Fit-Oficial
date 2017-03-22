package negocios.beans;

import java.io.Serializable;
import java.time.*;

import exceptions.FormatacaoInvalidaException;

public class Produto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2336117108494125603L;
	private String nome;
	private float peso;
	private int calorias;
	private int codigo;
	private int quantEstoque;
	private double preco;
	private LocalDate dataFabricacao;
	private LocalDate dataValidade;

	public Produto(String nome, float peso, int calorias, int codigo, int quantEstoque, double preco,
			LocalDate dataFabricacao, LocalDate dataValidade) throws FormatacaoInvalidaException {
		this.setNome(nome);
		this.setPeso(peso);
		this.setCalorias(calorias);
		this.setCodigo(codigo);
		this.setQuantEstoque(quantEstoque);
		this.setPreco(preco);
		this.setDataFabricacao(dataFabricacao);
		this.setDataValidade(dataValidade);
	}

	public Produto() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
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

	public int getQuantEstoque() {
		return quantEstoque;
	}

	public void setQuantEstoque(int quantEstoque) {
		this.quantEstoque = quantEstoque;
	}

	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(LocalDate dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public boolean equals(Object o) {
		boolean igual = false;
		if (o instanceof Produto) {
			if (o != null) {
				if (this.codigo == ((Produto) o).getCodigo()) {
					igual = true;
				}
			}
		}
		return igual;
	}

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", peso=" + peso + ", calorias=" + calorias + ", codigo=" + codigo
				+ ", quantEstoque=" + quantEstoque + ", preco=" + preco + ", dataFabricacao=" + dataFabricacao
				+ ", dataValidade=" + dataValidade + "]";
	}
}