package negocios;

import java.time.LocalDate;
import java.util.ArrayList;

import dados.RepositorioVenda;
import exceptions.FormatacaoInvalidaException;

public class TesteVenda {

	public static void main(String[] args) throws FormatacaoInvalidaException {
		LocalDate d1 = LocalDate.of(2016, 9, 23);
		LocalDate val1 = LocalDate.of(2018, 9, 23);
		LocalDate fab1 = LocalDate.of(2018, 10, 20);
		LocalDate val2 = LocalDate.of(2017, 4, 12);
		LocalDate fab2 = LocalDate.of(2017, 10, 3);
		LocalDate val3 = LocalDate.of(2018, 2, 22);
		LocalDate fab3 = LocalDate.of(2018, 4, 13);
		
		Produto pro1 = new Produto("Pao fit", 200, 159, 5,10,3, d1,d1);
		Produto pro2 = new Produto("Parfait de banana", 300, 250, 6,50,10, d1,d1);
		Produto pro3 = new Produto("Parfait de maça", 500, 250, 6,50,10, d1,d1);
		Produto p1 = new Produto("Produto1", 10, 5, 123, 50, 40, fab1, val1);
		Produto p2 = new Produto("Produto2", 4, 2, 123, 40, 60, fab2, val2);
		Produto p3 = new Produto("Produto3", 20, 77, 456, 30, 50, fab3, val3);
		
		ItemVenda item1 = new ItemVenda(pro1,3);
		ItemVenda item2 = new ItemVenda(pro2,5);
		ItemVenda item3 = new ItemVenda(pro3,2);
		ItemVenda item4 = new ItemVenda(p1,3);
		ItemVenda item5 = new ItemVenda(p2,5);
		ItemVenda item6 = new ItemVenda(p3,2);
		
		ArrayList<ItemVenda> listaItemVenda1 = new ArrayList<ItemVenda>();
		ArrayList<ItemVenda> listaItemVenda2 = new ArrayList<ItemVenda>();
		
		System.out.println("item1 total:" +item1.getTotal());
		System.out.println("item2 total:" +item2.getTotal());
		System.out.println("item3 total:" +item3.getTotal());
		System.out.println("item4 total:" +item4.getTotal());
		System.out.println("item5 total:" +item5.getTotal());
		System.out.println("item6 total:" +item6.getTotal());
		
		System.out.println("" +listaItemVenda1.size());
		
		Cliente c1 = new Cliente(7, "zé pilinta", "10455882923", 26, "Rua Ernesto Paula Santos", "987984573");
		Cliente c2 = new Cliente(8, "jailton", "55332677", 54, "Av bernardo vieira", "879530099");
		Funcionario f1 = new Funcionario(2,5, "leleo", "26379263782", 45, "Rua domingos ferreia", "987374821");
		Funcionario f2 = new Funcionario(2,4, "joaozinho", "73636276723", 32, "Rua Dom Bosco", "983726731");

		Venda venda1 = new Venda(123,c1,f1,listaItemVenda1, d1);
		Venda venda2 = new Venda(456,c2,f2,listaItemVenda2,val1);
		
		venda1.inserirItem(item1);
		venda1.inserirItem(item2);
		venda1.inserirItem(item3);
		venda2.inserirItem(item4);
		//venda2.InserirItem(item5);
		//venda2.InserirItem(item6);
		
		RepositorioVenda rep = new RepositorioVenda();
		
		System.out.println("Valor venda1: R$ " +venda1.calcularVenda());
		System.out.println("Valor venda2: R$ " +venda2.calcularVenda());
		System.out.println("" +rep.inserir(venda1));
		System.out.println(""+rep.listar());
		System.out.println("" +rep.inserir(venda2));
		System.out.println(""+rep.listar());
		System.out.println(""+rep.remover(456));
		System.out.println(""+rep.listar());


		/*IPanelaFit panelaFit = PanelaFit.getInstance();
		
		System.out.print(""+panelaFit.listarVendas());
		try{
			panelaFit.removerVenda(venda1);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("\n");
		}
		System.out.print(""+panelaFit.listarVendas());
		
		try{
			panelaFit.buscarVenda(456);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("\n");
		}
		
		try{
			panelaFit.cadastrarVenda(venda2);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("\n");
		}
		/*
		try{
			panelaFit.cadastrarVenda(venda2);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println();
		}
		
		try{
			panelaFit.buscarVenda(123);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println();
		}
		
		try{
			panelaFit.buscarVenda(123);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println();
		}

		/*try{
			panelaFit.cadastrarVenda(venda1);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println();
		}
		System.out.println("" +panelaFit.listarVendas());
	*/
		
	}

}
