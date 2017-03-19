package negocios;

import java.io.Serializable;

import exceptions.FormatacaoInvalidaException;

public class MateriaPrima implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8964722476015528996L;
	private String nome;
	private int codigo;
	private int quantidade;
	private double preco;

	public MateriaPrima(String nome, int codigo, int quantidade, double preco) throws FormatacaoInvalidaException{
		this.setNome(nome);
		this.setCodigo(codigo);
		this.setQuantidade(quantidade);
		this.setPreco(preco);
	}
	
	public MateriaPrima(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo)throws FormatacaoInvalidaException{
		Integer code = codigo;
			if(code.toString().length()==5){
				this.codigo = codigo;
		}else{
			throw new FormatacaoInvalidaException();
		}
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) throws FormatacaoInvalidaException {
		Integer aux = new Integer(quantidade);
		if(aux.toString().length()==2){
		this.quantidade = quantidade;
		} else{
			throw new FormatacaoInvalidaException();
		}
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public boolean equals(MateriaPrima materiaprima){
		boolean igual = false;
			if(materiaprima!=null){
				if(this.codigo==materiaprima.getCodigo()){
					igual = true;
			}			
		}
			return igual;
	}

	@Override
	public String toString() {
		return "MateriaPrima [nome=" + nome + ", codigo=" + codigo + ", quantidade=" + quantidade + ", preco=" + preco
				+ "]";
	}


	
	
}
