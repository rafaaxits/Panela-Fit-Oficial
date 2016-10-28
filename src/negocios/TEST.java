package negocios;
import java.time.*;

import beans.Produto;
import dados.RepositorioProduto;
import beans.Cliente;
import dados.RepositorioCliente;
import beans.Fornecedor;
import dados.RepositorioFornecedor;
import beans.Funcionario;
import dados.RepositorioFuncionario;
import beans.MateriaPrima;
import dados.RepositorioMateriaPrima;
public class TEST {

	public static void main(String[] args) {
		RepositorioCliente rep = new RepositorioCliente();
		Cliente c1 = new Cliente(3,"Rafael", "10303577495", 19, "rua pedro antonio da silva", "997457748");
		System.out.println(" "+rep.cadastrarCliente(c1));
		System.out.println(" " +rep.toString());
		System.out.println(" " +c1.toString());
		
		Cliente c2 = new Cliente(3, "zé pilinta", "10455882923", 26, "Rua Ernesto Paula Santos", "987984573");
		Cliente c3 = new Cliente(3, "zé pilinta", "66443321133", 26, "Rua Ernesto Paula Santos", "987984573");

		rep.alterarCliente(c2, c3);
		System.out.println(" " +rep.toString());
		
		System.out.println("buscando Cliente: " +rep.buscarCliente(3)); 
		System.out.println(" "+rep.removerCliente(3));
		System.out.println(" " +rep.toString());
		
		RepositorioFuncionario rep1 = new RepositorioFuncionario();
		Funcionario f1 = new Funcionario(2,4, "leleo", "26379263782", 45, "Rua domingos ferreia", "987374821");
		
		System.out.println(" "+rep1.cadastrarFuncionario(f1));
		System.out.println(" "+rep1.toString());
		
		Funcionario f2 = new Funcionario(1,4, "joaozinho", "73636276723", 32, "Rua Dom Bosco", "983726731");
		Funcionario f3 = new Funcionario(1,4, "pedrinho", "73636276723", 32, "Rua Dom Bosco", "983726731");
		
		rep1.alterarFuncionario(f2, f3);
		System.out.println(" "+rep1.toString());
		System.out.println(""+rep1.buscarFuncionario(4));
		System.out.println(" "+rep1.removerFuncionario(4));
		System.out.println(" "+rep1.toString());
		
		RepositorioFornecedor rep2 = new RepositorioFornecedor();
		Fornecedor for1 = new Fornecedor("Palmerina", "Rua paulo silva", "9983783648", 3);
		
		System.out.println("" +rep2.cadastrarFornecedor(for1));
		System.out.println("" +rep2.toString());
		System.out.println("" +rep2.buscarFornecedor(3));
		System.out.println("" +rep2.removerFornecedor(3));
		System.out.println("" +rep2.toString());
		
		RepositorioMateriaPrima rep3 = new RepositorioMateriaPrima();
		MateriaPrima p1 = new MateriaPrima("Farinha de amendoas",2,50,180);
		
		System.out.println("" +rep3.cadastrarMateriaPrima(p1));
		System.out.println("" +rep3.toString());
		System.out.println("" +rep3.buscarMateriaPrima(2));
		MateriaPrima p2 = new MateriaPrima("Farinha de castanha",2,10,30);
		MateriaPrima p3 = new MateriaPrima("Farinha de amendoas",2,10,30);
		rep3.alterarMateriaPrima(p2, p3);
		System.out.println("" +rep3.toString());
		System.out.println("" +rep3.removerMateriaPrima(2));
		System.out.println("" +rep3.toString());
		
		RepositorioProduto rep4 = new RepositorioProduto();
		LocalDate d1 = LocalDate.of(2016, 9, 23);
		Produto pro1 = new Produto("Pao fit", 200, 159, 5,10,3, d1,d1);
		
		System.out.println("" +rep4.cadastrarProduto(pro1));
		System.out.println("" +rep4.toString());
		System.out.println("" +rep4.buscarProduto(5));
		Produto pro2 = new Produto("Parfait de banana", 300, 250, 5,50,10, d1,d1);
		Produto pro3 = new Produto("Parfait de banana", 500, 250, 5,50,10, d1,d1);
		rep4.alterarProduto(pro2, pro3);
		System.out.println("" +rep4.toString());
		System.out.println("" +rep4.removerProduto(5));
		System.out.println("" +rep4.toString());
		
		
	}

}
