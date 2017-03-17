package negocios;

import java.io.Serializable;

import exceptions.FormatacaoInvalidaException;

public class Fornecedor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6954277165774573425L;
	private String nomeFornecedor;
	private String enderecoFornecedor;
	private String telefone;
	private int codigo;
	
	public Fornecedor(String nomeFornecedor, String enderecoFornecedor, String telefone, int codigo) throws FormatacaoInvalidaException {
		this.setNomeFornecedor(nomeFornecedor);
		this.setEnderecoFornecedor(enderecoFornecedor);
		this.setTelefone(telefone);
		this.setCodigo(codigo);
	}
	
	public Fornecedor(){
		
	}

	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}

	public String getEnderecoFornecedor() {
		return enderecoFornecedor;
	}

	public void setEnderecoFornecedor(String enderecoFornecedor) {
		this.enderecoFornecedor = enderecoFornecedor;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) throws FormatacaoInvalidaException {
		if(telefone.length()==11){
			this.telefone = telefone;
		}else{
			throw new FormatacaoInvalidaException();
		}
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public boolean equals(Fornecedor fornecedor){
		boolean igual = false;
			if(fornecedor!=null){
				if(this.codigo==fornecedor.getCodigo()){
					igual = true;
				}
		}
		return igual;
	}

	@Override
	public String toString() {
		return "Fornecedor [nomeFornecedor=" + nomeFornecedor + ", enderecoFornecedor=" + enderecoFornecedor
				+ ", telefone=" + telefone + ", codigo=" + codigo + "]";
	}
	
	
}
