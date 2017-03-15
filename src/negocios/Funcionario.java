package negocios;

import exceptions.ClienteInvalidoException;

public class Funcionario extends Pessoa {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7648660323426506303L;
	private int nivel;
	private int codigo;

	
	public Funcionario(int nivel, int codigo, String nome, String cpf, int idade, String endereco, String telefone) throws ClienteInvalidoException{
		super(nome, cpf, idade, endereco, telefone);
		this.nivel = nivel;
		this.codigo = codigo;
	}
	
	public Funcionario(){
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

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public boolean equals(Funcionario funcionario){
		boolean igual = false;
			if(funcionario!=null){
				if(this.codigo==funcionario.getCodigo()){
					igual = true;
				}
			}
		return igual;
	}

	@Override
	public String toString() {
		return "Funcionario [nivel=" + nivel + ", codigo=" + codigo + ", nome=" +this.getNome()+ ", cpf=" +this.getCpf()+ ", idade=" +this.getIdade()+ ", endereco=" +this.getEndereco()+ ", telefone=" +this.getTelefone()+ "]";
	}
	
	
}
