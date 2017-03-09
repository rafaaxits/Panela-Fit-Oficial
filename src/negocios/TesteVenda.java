package negocios;

import java.time.LocalDate;
import java.util.ArrayList;

public class TesteVenda {

	public static void main(String[] args) {
		LocalDate d1 = LocalDate.of(2016, 9, 23);
		Produto pro1 = new Produto("Pao fit", 200, 159, 5,10,3, d1,d1);
		Produto pro2 = new Produto("Parfait de banana", 300, 250, 6,50,10, d1,d1);
		Produto pro3 = new Produto("Parfait de maça", 500, 250, 6,50,10, d1,d1);
		
		ItemVenda item1 = new ItemVenda(pro1,3);
		ItemVenda item2 = new ItemVenda(pro2,5);
		ItemVenda item3 = new ItemVenda(pro3,2);
		
		ArrayList<ItemVenda> listaItemVenda = new ArrayList<ItemVenda>();
		listaItemVenda.add(item1);
		listaItemVenda.add(item2);
		listaItemVenda.add(item3);
		
		System.out.println("" +item1.getTotal());
		System.out.println("" +item2.getTotal());
		System.out.println("" +item3.getTotal());
		
		System.out.println("" +listaItemVenda.size());
		
		Cliente c1 = new Cliente(7, "zé pilinta", "10455882923", 26, "Rua Ernesto Paula Santos", "987984573");
		Funcionario f1 = new Funcionario(2,5, "leleo", "26379263782", 45, "Rua domingos ferreia", "987374821");

		Venda venda = new Venda(123,c1,f1,listaItemVenda, d1);
		
		System.out.println("Valor: R$ " +venda.TotalVenda(listaItemVenda));
	}

}
