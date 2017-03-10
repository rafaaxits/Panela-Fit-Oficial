package negocios;

import java.io.Serializable;

public abstract class Pessoa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2717095300537543643L;
	private String nome;
	private String cpf;
	private int idade;
	private String endereco;
	private String telefone;
	
	public Pessoa(String nome, String cpf, int idade, String endereco, String telefone){
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	public Pessoa(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public boolean equals(Pessoa pessoa){
		boolean igual = false;
		if(pessoa!=null){
			if(this.cpf.equals(pessoa.getCpf())){
				igual=true;
			}
		}
		return igual;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", idade=" + idade + ", endereco=" + endereco + ", telefone="
				+ telefone + "]";
	}
	
}
