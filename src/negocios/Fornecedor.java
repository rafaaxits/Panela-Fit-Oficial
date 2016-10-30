package negocios;

public class Fornecedor {
	private String nomeFornecedor;
	private String enderecoFornecedor;
	private String telefone;
	private int codigo;
	
	public Fornecedor(String nomeFornecedor, String enderecoFornecedor, String telefone, int codigo) {
		this.nomeFornecedor = nomeFornecedor;
		this.enderecoFornecedor = enderecoFornecedor;
		this.telefone = telefone;
		this.codigo = codigo;
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

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
