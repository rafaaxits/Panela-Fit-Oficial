package negocios;


public class TesteFachada {

	public static void main(String[] args)  {
		IPanelaFit panelaFit = PanelaFit.getInstance();
		
		//CLIENTES
		
		Cliente c1 = new Cliente(8, "fulano", "13243677", 23, "Rua Jose Bras", "997755432");
		Cliente c2 = new Cliente(8, "jailton", "55332677", 54, "Av bernardo vieira", "879530099");
		Cliente c4 = new Cliente(7, "cicrano", "554433677", 19, "Rua Jose Bras", "34322111");
		Cliente c5 = null;
		
		try {
			panelaFit.cadastrarCliente(c5);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
		
		try {
			panelaFit.cadastrarCliente(c1);
			panelaFit.cadastrarCliente(c2);
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
			panelaFit.alterarCliente(c1);
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
		
		try {
			panelaFit.alterarCliente(c2);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
		
		System.out.println("" +panelaFit.listarClientes());
		
		try {
			System.out.print("" +panelaFit.buscarCliente(3));
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n");
		}
		System.out.println("\n");
		
		try {
			System.out.println("" +panelaFit.buscarCliente(6));
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
		
		//FUNCION�RIOS
		
		Funcionario f1 = new Funcionario(2,5, "leleo", "26379263782", 45, "Rua domingos ferreia", "987374821");
		Funcionario f2 = new Funcionario(2,4, "joaozinho", "73636276723", 32, "Rua Dom Bosco", "983726731");
		Funcionario f4 = null;
		Funcionario f5 = new Funcionario(9,4,"testinho", "392392838932", 65, "Rua ali perto", "3278232");
		
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
		
	
//FORNECEDORES

		Fornecedor for1 = new Fornecedor("iFruit", "Av bernardo vieira", "33445123", 123);
		Fornecedor for2 = new Fornecedor("Greenfood", "Av conselheiro aguiar", "334256772", 123);
		Fornecedor for4 = new Fornecedor("Verdefruitt", "Rua jose bras", "37765123", 122);
		Fornecedor for5 = null;
	
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
	
		
		//MAT�RIAS PRIMAS
		
		MateriaPrima mp1 = new MateriaPrima("MateriaPrima1", 4, 30, 100);
		MateriaPrima mp2 = new MateriaPrima("MateriaPrima2", 4, 20, 200);
		MateriaPrima mp4 = new MateriaPrima("MateriaPrima4", 5, 50, 400);
		MateriaPrima mp5 = null;
	
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
			panelaFit.alterarMateriaPrima(mp4);
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
			panelaFit.removerMateriaPrima(mp2);
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
				
	}
}