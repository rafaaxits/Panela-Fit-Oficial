package negocios;
import java.util.ArrayList;
public class Venda {
	private int codigo;
	Cliente cliente;
	Funcionario funcionario;
	private ArrayList<ItemVenda> listaItensDeVenda;
	private int quantidade;


	public Venda(int codigo, Cliente cliente, Funcionario funcionario, ArrayList<ItemVenda> listaItensDeVenda) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.setListaItensDeVenda(new ArrayList<ItemVenda>());
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

	public ArrayList<ItemVenda> getListaItensDeVenda() {
		return listaItensDeVenda;
	}

	public void setListaItensDeVenda(ArrayList<ItemVenda> listaItensDeVenda) {
		this.listaItensDeVenda = listaItensDeVenda;
	}
	
	// n implementa serializable
}
