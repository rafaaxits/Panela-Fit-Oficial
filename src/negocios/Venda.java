package negocios;
import java.util.ArrayList;
import java.time.*;
public class Venda {
	
	private int codigo;
	Cliente cliente;
	Funcionario funcionario;
	private ArrayList<ItemVenda> listaItensDeVenda;
	private LocalDate dataDaVenda;
	
	//data
	 // metodo gettotal que chama o gettotal de cada item.. varre a lista de itens pega o total de kd


	public Venda(int codigo, Cliente cliente, Funcionario funcionario, ArrayList<ItemVenda> listaItensDeVenda,
			LocalDate dataDaVenda) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.listaItensDeVenda = new ArrayList <ItemVenda>();
		this.dataDaVenda = dataDaVenda;
	}

	public LocalDate getDataDaVenda() {
		return dataDaVenda;
	}

	public void setDataDaVenda(LocalDate dataDaVenda) {
		this.dataDaVenda = dataDaVenda;
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
	
	public boolean equals(Venda venda){
		boolean igual= false;
			if(venda!=null){
				if(this.codigo == venda.getCodigo()){
					igual = true;
				}
			}
			return igual;
	}

	@Override
	public String toString() {
		return "Venda [codigo=" + codigo + ", cliente=" + this.getCliente()+ ", funcionario=" + this.getFuncionario()
				+ ", listaItensDeVenda=" + listaItensDeVenda + ", dataDaVenda=" + dataDaVenda + "]";
	}
	
	public double TotalVenda(ArrayList<ItemVenda> listaItensDeVenda){
		double total = 0;
		if(listaItensDeVenda!=null){
			for(ItemVenda item : listaItensDeVenda){
				total = total + item.getTotal();
		}
			return total;
	}	
		return total;
  }
//comitando essa merda 
}
