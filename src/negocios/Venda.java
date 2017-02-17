package negocios;

public class Venda {
	private int codigo;
	Cliente cliente;
	Funcionario funcionario;
	
	public Venda(int codigo, Cliente cliente, Funcionario funcionario){
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
}
