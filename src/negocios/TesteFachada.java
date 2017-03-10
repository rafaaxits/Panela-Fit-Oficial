package negocios;

import java.time.LocalDate;
import java.util.ArrayList;

public class TesteFachada {

	public static void main(String[] args)  {
		IPanelaFit panelaFit = PanelaFit.getInstance();
		
		//CLIENTES
		
		Cliente c1 = new Cliente(8, "fulano", "13243677", 23, "Rua Jose Bras", "997755432");
		Cliente c2 = new Cliente(8, "jailton", "55332677", 54, "Av bernardo vieira", "879530099");
		Cliente c4 = new Cliente(7, "cicrano", "554433677", 19, "Rua Jose Bras", "34322111");
		Cliente c5 = null;
		System.out.println("" +panelaFit.listarClientes());

		try {
			panelaFit.cadastrarCliente(c5);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
		
		try {
			panelaFit.cadastrarCliente(c1);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
		
		try {
			panelaFit.cadastrarCliente(c1);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
		
		System.out.println("" +panelaFit.listarClientes());
		
		try {
			panelaFit.alterarCliente(c4);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
		
		
		try {
			panelaFit.alterarCliente(c5);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
		
		System.out.println("" +panelaFit.listarClientes());
		
		
	//	System.out.println("" +panelaFit.listarClientes());
		
		try {
			System.out.print("" +panelaFit.buscarCliente(3));
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
		System.out.println("\n");
		
		try {
			System.out.println("" +panelaFit.buscarCliente(8));
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("\n");
		}
		
		try {
			panelaFit.removerCliente(c2);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("\n");
		}
		
		System.out.println("" +panelaFit.listarClientes());
		
		try {
			panelaFit.removerCliente(c5);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("\n");
		}
		
		try {
			panelaFit.cadastrarCliente(c2);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("\n");
		}
		
		try {
			panelaFit.alterarCliente(c1);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
		
		System.out.println("" +panelaFit.listarClientes());
		
		//FUNCION�RIOS
		
		Funcionario f1 = new Funcionario(2,5, "leleo", "26379263782", 45, "Rua domingos ferreia", "987374821");
		Funcionario f2 = new Funcionario(2,4, "joaozinho", "73636276723", 32, "Rua Dom Bosco", "983726731");
		Funcionario f4 = null;
		Funcionario f5 = new Funcionario(9,4,"testinho", "392392838932", 65, "Rua ali perto", "3278232");
		Funcionario f6 = new Funcionario(6,7, "abestalhado", "25623562353", 78, "RUA ARE BABA", "73643647");
		try{
			panelaFit.cadastrarFuncionario(f4); //tentando cadastrar um funcionario nulo e a exception apareceu
		}catch(Exception e){
			e.printStackTrace();
			System.out.print("\n");
		}
		
		try{
			panelaFit.cadastrarFuncionario(f1);//cadastro OK
			panelaFit.cadastrarFuncionario(f2);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("\n");
		}
		
		try{
			panelaFit.cadastrarFuncionario(f1);//tentando cadastrar um funcionario que já esta cadastrado e a Exception apareceu
		}catch(Exception e){
			e.printStackTrace();
			System.out.print("\n");
		}
		
		System.out.println(""+panelaFit.listarFuncionarios());
		
		try{
			panelaFit.alterarFuncionario(f5);//tentando alterar dois funcionarios que nao foram cadastrados e a exception apareceu 
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("\n");
		}
		
		try{
			panelaFit.alterarFuncionario(f1);//Tentando alterar dois funcionarios cadastrados e a exception apareceu
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("\n");
		}
		
		try{
			panelaFit.alterarFuncionario(f4);//Tentando alterar um funcionario cadastrado por um nulo, Exception apareceu
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("\n");
		}
		System.out.println(""+panelaFit.listarFuncionarios());
		
	
		System.out.println(""+panelaFit.listarFuncionarios());
		
		try{
			panelaFit.alterarFuncionario(f5);//Alteração ok, Alterando um func cadastrado por outro que ainda nao estava cadastrado, após A ALTERACAO O NOVO FUNC FOI CADASTRADO, TUDO OK
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("\n");
		}
		System.out.println(""+panelaFit.listarFuncionarios());
		
		try{
			System.out.print("" +panelaFit.buscarFuncionario(4));//buscar OK
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("\n");
		}
		System.out.println("\n");
		try{
			System.out.print("" +panelaFit.buscarFuncionario(6));//tentando buscar um funcionario que nao existe, a Exception apareceu
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("\n");
		}
		
		try{
			panelaFit.removerFuncionario(f2);//tentando remover um funcionario que já foi removido e que nao existe mais no sistema
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("\n");
		}
		
		try{
			panelaFit.removerFuncionario(f4);// tentando remover um funcionario nulo
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("\n");
		}
		
		
		try{
			panelaFit.cadastrarFuncionario(f2); //Tentanco cadastrar um funcionario com um codigo igual a de outro funcionario do sistema.
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("\n");
		}
		
		System.out.println(""+panelaFit.listarFuncionarios());
		
		try{
			panelaFit.alterarFuncionario(f6);//tentando alterar dois funcionarios que nao foram cadastrados e a exception apareceu 
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("\n");
		}
	
//FORNECEDORES

		Fornecedor for1 = new Fornecedor("iFruit", "Av bernardo vieira", "33445123", 123);
		Fornecedor for2 = new Fornecedor("Greenfood", "Av conselheiro aguiar", "334256772", 123);
		Fornecedor for4 = new Fornecedor("Verdefruitt", "Rua jose bras", "37765123", 122);
		Fornecedor for5 = null;
	
		System.out.println("" +panelaFit.listarFornecedores());

		try {
			panelaFit.cadastrarFornecedor(for5);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
	
		try {
			panelaFit.cadastrarFornecedor(for1);
			panelaFit.cadastrarFornecedor(for2);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
	
		try {
			panelaFit.cadastrarFornecedor(for1);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
	
		System.out.println("" +panelaFit.listarFornecedores());
	
		try {
			panelaFit.alterarFornecedor(for4);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
	
		try {
			panelaFit.alterarFornecedor(for1);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
	
		try {
			panelaFit.alterarFornecedor(for5);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
	
		System.out.println("" +panelaFit.listarFornecedores());
	
		try {
			panelaFit.alterarFornecedor(for2);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
	
		System.out.println("" +panelaFit.listarFornecedores());
	
		try {
		System.out.print("" +panelaFit.buscarFornecedor(133));
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
		System.out.println("\n");
	
		try {
		System.out.println("" +panelaFit.buscarFornecedor(555));
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("\n");
		}
	
		try {
			panelaFit.removerFornecedor(for2);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("\n");
		}
	
		System.out.println("" +panelaFit.listarFornecedores());

		
		try {
			panelaFit.removerFornecedor(for5);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("\n");
		}
	
		try {
			panelaFit.cadastrarFornecedor(for2);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("\n");
		}
	
		System.out.println("" +panelaFit.listarFornecedores());

		
		//MAT�RIAS PRIMAS
		
		MateriaPrima mp1 = new MateriaPrima("MateriaPrima1", 4, 30, 100);
		MateriaPrima mp2 = new MateriaPrima("MateriaPrima2", 4, 20, 200);
		MateriaPrima mp4 = new MateriaPrima("MateriaPrima4", 5, 50, 400);
		MateriaPrima mp5 = null;
	
		System.out.println("" +panelaFit.listarMateriasPrimas());
		
		try {
			panelaFit.cadastrarMateriaPrima(mp5);
		} catch(Exception e) {
			e.printStackTrace();
		System.out.print("\n");
		}
	
		try {
			panelaFit.cadastrarMateriaPrima(mp1);
			panelaFit.cadastrarMateriaPrima(mp2);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
	
		try {
			panelaFit.cadastrarMateriaPrima(mp1);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
	
		System.out.println("" +panelaFit.listarMateriasPrimas());
	
		try {
			panelaFit.alterarMateriaPrima(mp4);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
	
		try {
			panelaFit.alterarMateriaPrima(mp1);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
	
		try {
			panelaFit.alterarMateriaPrima(mp5);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
	
		System.out.println("" +panelaFit.listarMateriasPrimas());
	
		try {
			panelaFit.alterarMateriaPrima(mp2);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
	
		System.out.println("" +panelaFit.listarMateriasPrimas());
	
		try {
		System.out.print("" +panelaFit.buscarMateriaPrima(4));
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
		System.out.println("\n");
	
		try {
		System.out.println("" +panelaFit.buscarMateriaPrima(87));
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("\n");
		}
	
		try {
			panelaFit.removerMateriaPrima(mp4);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("\n");
		}
	
		try {
			panelaFit.removerMateriaPrima(mp5);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("\n");
		}
	
		try {
			panelaFit.cadastrarMateriaPrima(mp2);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("\n");
		}
		
		//PRODUTOS
		
		LocalDate val1 = LocalDate.of(2018, 9, 23);
		LocalDate fab1 = LocalDate.of(2018, 10, 20);
		LocalDate val2 = LocalDate.of(2017, 4, 12);
		LocalDate fab2 = LocalDate.of(2017, 10, 3);
		LocalDate val3 = LocalDate.of(2018, 2, 22);
		LocalDate fab3 = LocalDate.of(2018, 4, 13);
		
		Produto p1 = new Produto("Produto1", 10, 5, 123, 50, 40, fab1, val1);
		Produto p2 = new Produto("Produto2", 4, 2, 123, 40, 60, fab2, val2);
		Produto p3 = new Produto("Produto4", 20, 77, 456, 30, 50, fab3, val3);
		Produto p4 = null;
		
		System.out.println("" +panelaFit.listarProdutos());

	
		try {
			panelaFit.cadastrarProduto(p4);
		} catch(Exception e) {
			e.printStackTrace();
		System.out.print("\n");
		}
	
		try {
			panelaFit.cadastrarProduto(p1);
			panelaFit.cadastrarProduto(p2);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
	
		try {
			panelaFit.cadastrarProduto(p1);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
	
		System.out.println("" +panelaFit.listarProdutos());
	
		try {
			panelaFit.alterarProdutos(p3);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
	
		try {
			panelaFit.alterarProdutos(p1);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
	
		try {
			panelaFit.alterarProdutos(p4);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
	
		System.out.println("" +panelaFit.listarProdutos());
	
		try {
			panelaFit.alterarProdutos(p2);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
	
		System.out.println("" +panelaFit.listarProdutos());
	
		try {
		System.out.print("" +panelaFit.buscarProduto(123));
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
		System.out.println("\n");
	
		try {
		System.out.println("" +panelaFit.buscarProduto(789));
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("\n");
		}
	
		try {
			panelaFit.removerProduto(p2);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("\n");
		}
		
		System.out.println("" +panelaFit.listarProdutos());
		
		try {
			panelaFit.removerProduto(p4);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("\n");
		}
	
		try {
			panelaFit.cadastrarProduto(p2);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("\n");
		}
		System.out.println("" +panelaFit.listarProdutos());
		
		//VENDAS
		
		LocalDate d1 = LocalDate.of(2016, 9, 23);
		
		Produto pro1 = new Produto("Pao fit", 200, 159, 5,10,3, d1,d1);
		Produto pro2 = new Produto("Parfait de banana", 300, 250, 6,50,10, d1,d1);
		Produto pro3 = new Produto("Parfait de maça", 500, 250, 6,50,10, d1,d1);
	
		ItemVenda item1 = new ItemVenda(pro1,3);
		ItemVenda item2 = new ItemVenda(pro2,5);
		ItemVenda item3 = new ItemVenda(pro3,2);
		ItemVenda item4 = new ItemVenda(p1,3);
		ItemVenda item5 = new ItemVenda(p2,5);
		ItemVenda item6 = new ItemVenda(p3,2);
		
		ArrayList<ItemVenda> listaItemVenda1 = new ArrayList<ItemVenda>();
		ArrayList<ItemVenda> listaItemVenda2 = new ArrayList<ItemVenda>();
		
		listaItemVenda1.add(item1);
		listaItemVenda1.add(item2);
		listaItemVenda1.add(item3);
		
		listaItemVenda2.add(item4);
		listaItemVenda2.add(item5);
		listaItemVenda2.add(item6);
		
		Venda venda1 = new Venda(123,c1,f1,listaItemVenda1, d1);
		Venda venda2 = new Venda(123,c2,f2,listaItemVenda2,val1);
		Venda venda3 = new Venda(776,c4,f6, listaItemVenda2, fab2);
		Venda venda4 = null;
		
		System.out.println(""+panelaFit.listarVendas());

		
		try{
			panelaFit.cadastrarVenda(venda4);
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("\n");
		}
		
		try{
			panelaFit.cadastrarVenda(venda1);
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("\n");
		}
		
		System.out.println(""+panelaFit.listarVendas());
		
		try{
			panelaFit.cadastrarVenda(venda2);
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("\n");
		}
		
		try{
			panelaFit.alterarVenda(venda3);
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("\n");
		}
		
		try{
			panelaFit.alterarVenda(venda2);
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("\n");
		}
		
		try{
			panelaFit.alterarVenda(venda4);
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("\n");
		}
		
		System.out.println(""+panelaFit.listarVendas());

		try{
			panelaFit.alterarVenda(venda2);
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("\n");
		}
		
		System.out.println(""+panelaFit.listarVendas());

		try{
			panelaFit.buscarVenda(123);
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("\n");
		}
		
		try{
			panelaFit.buscarVenda(776);
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("\n");
		}
		
		try{
			panelaFit.removerVenda(venda4);
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("\n");
		}
		
		try{
			panelaFit.removerVenda(venda3);
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("\n");
		}
		
		try{
			panelaFit.removerVenda(venda2);
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("\n");
		}
		
		System.out.println(""+panelaFit.listarVendas());
		
		try{
			panelaFit.cadastrarVenda(venda2);
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("\n");
		}

		System.out.println(""+panelaFit.listarVendas());
		
		
	}
}