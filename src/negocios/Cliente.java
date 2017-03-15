package negocios;

import exceptions.ClienteInvalidoException;

public class Cliente extends Pessoa{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7178299401781083944L;
	/**
	 * 
	 */
	private int codigo;
	
	public Cliente(int codigo, String nome, String cpf, int idade, String endereco, String telefone) throws ClienteInvalidoException{
		super(nome, cpf, idade, endereco, telefone);
		this.codigo = codigo;
	}
	
	public Cliente(){
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public boolean equals(Cliente cliente){
		boolean igual = false;
		if(cliente!=null){
			if(this.codigo==cliente.getCodigo()){
				igual = true;
			}
		}
		return igual;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nome=" +this.getNome()+ ", cpf=" +this.getCpf()+ ", idade=" +this.getIdade()+ ", endereco=" +this.getEndereco()+ ", telefone=" +this.getTelefone()+ "]";
	}
	

	
}
