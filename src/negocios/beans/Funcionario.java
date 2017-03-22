package negocios.beans;

import exceptions.FormatacaoInvalidaException;

public class Funcionario extends Pessoa {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7648660323426506303L;
	private int nivel;
	private int codigo;

	public Funcionario(int nivel, int codigo, String nome, String cpf, int idade, String endereco, String telefone)
			throws FormatacaoInvalidaException {
		super(nome, cpf, idade, endereco, telefone);
		this.setNivel(nivel);
		this.setCodigo(codigo);
	}

	public Funcionario() {
		super();
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
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

	public boolean equals(Object o) {
		boolean igual = false;
		if (o instanceof Funcionario) {
			if (o != null) {
				if (this.codigo == ((Funcionario) o).getCodigo()) {
					igual = true;
				}
			}
		}
		return igual;
	}

	@Override
	public String toString() {
		return "Funcionario [nivel=" + nivel + ", codigo=" + codigo + ", nome=" + this.getNome() + ", cpf="
				+ this.getCpf() + ", idade=" + this.getIdade() + ", endereco=" + this.getEndereco() + ", telefone="
				+ this.getTelefone() + "]";
	}

}
