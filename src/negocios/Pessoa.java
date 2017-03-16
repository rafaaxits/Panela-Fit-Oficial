package negocios;

import java.io.Serializable;

import exceptions.FormatacaoInvalidaException;

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
	
	public Pessoa(String nome, String cpf, int idade, String endereco, String telefone) throws FormatacaoInvalidaException{
		super();
		this.setNome(nome);;
		this.setCpf(cpf);
		this.setIdade(idade);
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

	public void setCpf(String cpf) throws FormatacaoInvalidaException {
		if(cpf.length() == 11){
		this.cpf = cpf;
		}else {
			throw new FormatacaoInvalidaException ();
		}
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

	public void setTelefone(String telefone) throws FormatacaoInvalidaException {
		if(telefone.length() >= 10 && telefone.length() <= 11){
		this.telefone = telefone;
		}else{
			throw new FormatacaoInvalidaException();
		}
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
