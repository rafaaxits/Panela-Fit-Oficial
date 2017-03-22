package negocios.beans;

import exceptions.FormatacaoInvalidaException;

public class Cliente extends Pessoa {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7178299401781083944L;
	/**
	 * 
	 */
	private int codigo;

	public Cliente(int codigo, String nome, String cpf, int idade, String endereco, String telefone)
			throws FormatacaoInvalidaException {
		super(nome, cpf, idade, endereco, telefone);
		this.setCodigo(codigo);
	}

	public Cliente() {
		super();
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
		if (o instanceof Cliente) {
			if (o != null) {
				if (this.codigo == ((Cliente) o).getCodigo()) {
					igual = true;
				}
			}
		}
		return igual;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nome=" + this.getNome() + ", cpf=" + this.getCpf() + ", idade="
				+ this.getIdade() + ", endereco=" + this.getEndereco() + ", telefone=" + this.getTelefone() + "]";
	}

}
