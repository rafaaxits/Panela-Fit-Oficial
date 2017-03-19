package negocios;
import java.time.*;

import dados.RepositorioProduto;
import exceptions.FormatacaoInvalidaException;
import dados.RepositorioCliente;
import dados.RepositorioFornecedor;
import dados.RepositorioFuncionario;
import dados.RepositorioMateriaPrima;
public class TEST {

	public static void main(String[] args) throws FormatacaoInvalidaException {
		RepositorioCliente rep = new RepositorioCliente();
		Cliente c1 = new Cliente(32121,"Rafael", "10303577495", 19, "rua pedro antonio da silva", "92974577418");
		rep.inserir(c1);
		System.out.println(" " +rep.listar());
		
		Cliente c2 = new Cliente(7, "zé pilinta", "10455882923", 26, "Rua Ernesto Paula Santos", "987984573");
		Cliente c3 = new Cliente(9, "zé ruela", "66443321133", 26, "Rua Ernesto Paula Santos", "987984573");
		
		System.out.println("" +rep.inserir(c2));
		System.out.println(" " +rep.listar());
		System.out.println(""+rep.alterar(c3));
		System.out.println("buscando Cliente: " +rep.buscar(9)); 
		System.out.println(" " +rep.listar());
		System.out.println("" +rep.remover(9));
		System.out.println(" " +rep.listar());
		
		
		RepositorioFuncionario rep1 = new RepositorioFuncionario();
		Funcionario f1 = new Funcionario(2,5, "leleo", "26379263782", 45, "Rua domingos ferreia", "987374821");
		
		System.out.println(" "+rep1.inserir(f1));
		System.out.println(" "+rep1.listar());
		
		Funcionario f2 = new Funcionario(1,4, "joaozinho", "73636276723", 32, "Rua Dom Bosco", "983726731");
		Funcionario f3 = new Funcionario(1,4, "pedrinho", "73636276723", 32, "Rua Dom Bosco", "983726731");
		
		rep1.inserir(f2);
		System.out.println(" "+rep1.listar());
		System.out.println(""+rep1.alterar(f3));
		System.out.println(" "+rep1.buscar(4));
		System.out.println(" "+rep1.listar());
		System.out.println(" "+rep1.remover(4));
		System.out.println(" "+rep1.listar());
		
		
		RepositorioFornecedor rep2 = new RepositorioFornecedor();
		Fornecedor for1 = new Fornecedor("Palmerina", "Rua paulo silva", "9983783648", 3);
		
		System.out.println("" +rep2.inserir(for1));
		System.out.println("" +rep2.listar());
		System.out.println("" +rep2.buscar(3));
		System.out.println("" +rep2.remover(3));
		System.out.println("" +rep2.toString());
		Fornecedor for2 = new Fornecedor("Paulinha","Rua eNERTOS", "8273827382", 5);
		Fornecedor for3 = new Fornecedor("karlos","Rua esudgusgusd", "7346746734", 5);
		
		rep2.inserir(for2);
		System.out.println("" +rep2.listar());
		System.out.println(" "+rep2.alterar(for3));
		System.out.println("" +rep2.listar());
		rep2.remover(5);
		System.out.println("" +rep2.listar());
		
		
		RepositorioMateriaPrima rep3 = new RepositorioMateriaPrima();
		MateriaPrima p1 = new MateriaPrima("Farinha de amendoas",2,50,180);
		
		System.out.println("" +rep3.inserir(p1));
		System.out.println("" +rep3.listar());
		System.out.println("" +rep3.buscar(2));
		MateriaPrima p2 = new MateriaPrima("Farinha de castanha",4,10,30);
		MateriaPrima p3 = new MateriaPrima("Farinha de arroz",4,10,30);
		rep3.inserir(p2);
		System.out.println("" +rep3.listar());
		rep3.alterar(p3);
		System.out.println("" +rep3.listar());
		System.out.println("" +rep3.remover(4));
		System.out.println("" +rep3.listar());
		
		
		RepositorioProduto rep4 = new RepositorioProduto();
		LocalDate d1 = LocalDate.of(2016, 9, 23);
		Produto pro1 = new Produto("Pao fit", 200, 159, 5,10,3, d1,d1);
		
		System.out.println("" +rep4.inserir(pro1));
		System.out.println("" +rep4.listar());
		System.out.println("" +rep4.buscar(5));
		Produto pro2 = new Produto("Parfait de banana", 300, 250, 6,50,10, d1,d1);
		Produto pro3 = new Produto("Parfait de maça", 500, 250, 6,50,10, d1,d1);
		rep4.inserir(pro2);
		System.out.println("" +rep4.listar());
		rep4.alterar(pro3);
		System.out.println("" +rep4.listar());;
		System.out.println("" +rep4.remover(5));
		System.out.println("" +rep4.toString());
		

	}

}
