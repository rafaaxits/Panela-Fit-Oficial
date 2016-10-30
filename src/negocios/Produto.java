package negocios;

import java.time.*;

public class Produto {
	private String nome;
	private int peso;
	private int calorias;
	private int codigo;
	private int quantEstoque;
	private double preco;
	private LocalDate dataFabricacao;
	private LocalDate dataValidade;
	
	public Produto(String nome, int peso, int calorias, int codigo, int quantEstoque, double preco, LocalDate dataFabricacao, LocalDate dataValidade){
		this.nome = nome;
		this.peso = peso;
		this.calorias = calorias;
		this.codigo = codigo;
		this.quantEstoque = quantEstoque;
		this.preco = preco;
		this.dataFabricacao = dataFabricacao;
		this.dataValidade = dataValidade;
	}
	
	public Produto (){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
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

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public boolean equals(Produto produto){
		boolean igual = false;
			if(produto!=null){
				if(this.codigo == produto.getCodigo()){
					igual = true;
				}
		}
			return igual;
	}

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", peso=" + peso + ", calorias=" + calorias + ", codigo=" + codigo
				+ ", quantEstoque=" + quantEstoque + ", preco=" + preco + ", dataFabricacao=" + dataFabricacao + ", dataValidade=" + dataValidade + "]";
	}
}