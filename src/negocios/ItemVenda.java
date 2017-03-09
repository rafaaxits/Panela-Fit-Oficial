package negocios;

public class ItemVenda {
	private Produto produto;
	int quantidade;
	/*
		multiplicar prod.getpreco e qnt
 int qntd
  metodo gettotal
	*/
	public ItemVenda(Produto produto, int quantidade) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
	public ItemVenda(){
		
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public String toString() {
		return "ItemVenda [produto=" + this.getProduto()+ ", quantidade=" + this.getQuantidade() + "]";
	} 
	
	public Double getTotal(){
		double total;
		total = produto.getPreco() * quantidade;
		return total;
	}
	// comitando essa merda
}
//n implemente serializable 