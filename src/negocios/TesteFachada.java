package negocios;


public class TesteFachada {

	public static void main(String[] args)  {
		IPanelaFit panelaFit = PanelaFit.getInstance();
		
		//Testando Exceptions de clientes e tds funcionando
		/*Cliente c =  new Cliente (5, "Zé estranho", "1030358821", 19,"rua 23", "99782632632");
		panelaFit.cadastrarCliente(c);
		System.out.println("" +panelaFit.buscarCliente(5));
	
		Cliente c1 =  new Cliente (554, "Zé esquisito", "237273728", 23,"rua 55", "23767236273");
		System.out.println("" +panelaFit.listarClientes());
		panelaFit.alterarCliente(c, c1);
		System.out.println("" +panelaFit.listarClientes());

		try{
			panelaFit.cadastrarCliente(c1);
		}catch(Exception e){
			e.printStackTrace();
			System.out.print("\n");
		}

		try{
			panelaFit.removerCliente(c1);
		}catch(ClienteNaoExisteException e){
			e.printStackTrace();
			System.out.print("\n");
		}
		System.out.println("" +panelaFit.listarClientes());
		
		try{
			System.out.println("" +panelaFit.buscarCliente(5));
			}catch (ClienteNaoExisteException e){
				e.printStackTrace();
				System.out.print("\n");
			}
		
		try{
			panelaFit.removerCliente(c);
		}catch(ClienteNaoExisteException e){
			e.printStackTrace();
			System.out.print("\n");
		}
		
		Cliente c2 = new Cliente(7, "zé pilinta", "10455882923", 26, "Rua Ernesto Paula Santos", "987984573");
		Cliente c3 = null;
		try{
			panelaFit.alterarCliente(c2, c3);
		}catch(ClienteNaoExisteException e){
			e.printStackTrace();
			System.out.print("\n");
		}
	
			System.out.println(" "+panelaFit.listarClientes());*/
		
		Funcionario f1 = new Funcionario(2,5, "leleo", "26379263782", 45, "Rua domingos ferreia", "987374821");
		Funcionario f2 = new Funcionario(2,4, "joaozinho", "73636276723", 32, "Rua Dom Bosco", "983726731");
		Funcionario f3 = new Funcionario(6,4, "pedrinho", "73636276723", 32, "Rua Dom Bosco", "983726731");
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
			panelaFit.alterarFuncionario(f3, f5);//tentando alterar dois funcionarios que nao foram cadastrados e a exception apareceu 
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("\n");
		}
		
		try{
			panelaFit.alterarFuncionario(f2, f1);//Tentando alterar dois funcionarios cadastrados e a exception apareceu
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("\n");
		}
		
		try{
			panelaFit.alterarFuncionario(f2, f4);//Tentando alterar um funcionario cadastrado por um nulo, Exception apareceu
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("\n");
		}
		System.out.println(""+panelaFit.listarFuncionarios());
		
	
		System.out.println(""+panelaFit.listarFuncionarios());
		
		try{
			panelaFit.alterarFuncionario(f2,f5);//Alteração ok, Alterando um func cadastrado por outro que ainda nao estava cadastrado, após A ALTERACAO O NOVO FUNC FOI CADASTRADO, TUDO OK
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
		
	}
}