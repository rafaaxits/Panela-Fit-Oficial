package negocios;
 
import java.time.LocalDate;
import java.util.List;

import beans.Cliente;
import beans.Fornecedor;
import beans.Funcionario;
import beans.MateriaPrima;
import beans.Produto;
import exceptions.ClienteJaExisteException;
import exceptions.ClienteNaoExisteException;
import exceptions.FornecedorJaExisteException;
import exceptions.FornecedorNaoExisteException;
import exceptions.FuncionarioJaExisteException;
import exceptions.FuncionarioNaoExisteException;
import exceptions.MateriaPrimaJaExisteException;
import exceptions.MateriaPrimaNaoExisteException;
import exceptions.ProdutoJaExisteException;
import exceptions.ProdutoNaoExisteException;

public interface IPanelaFit {
	//CADASTRAR
	public void cadastrarCliente(Cliente c) throws ClienteJaExisteException, ClienteNaoExisteException;
	
	public void cadastrarFornecedor(Fornecedor f) throws FornecedorJaExisteException, FornecedorNaoExisteException;
	
	public void cadastrarFuncionario(Funcionario f) throws FuncionarioJaExisteException, FuncionarioNaoExisteException;

	public void cadastrarMateriaPrima(MateriaPrima m) throws MateriaPrimaJaExisteException, MateriaPrimaNaoExisteException;

	public void cadastrarProduto(Produto p) throws ProdutoJaExisteException, ProdutoNaoExisteException;
	
	//REMOVER
	public void removerCliente(Cliente cliente) throws ClienteNaoExisteException;
	
	public void removerFornecedor(Fornecedor fornecedor) throws FornecedorNaoExisteException;
	
	public void removerFuncionario(Funcionario funcionario) throws FuncionarioNaoExisteException;
	
	public void removerMateriaPrima(MateriaPrima materiaprima) throws MateriaPrimaNaoExisteException;
	
	public void removerProduto(Produto produto) throws ProdutoNaoExisteException;
	
	//BUSCAR
	public Cliente buscarCliente(int codigo) throws ClienteNaoExisteException;
	
	public Fornecedor buscarFornecedor(int codigo) throws FornecedorNaoExisteException;
	
	public Funcionario buscarFuncionario(int codigo) throws FuncionarioNaoExisteException;
	
	public MateriaPrima buscarMateriaPrima(int codigo) throws MateriaPrimaNaoExisteException;
	
	public Produto buscarProduto(int codigo) throws ProdutoNaoExisteException;
	
	//ALTERAR
	public abstract void alterarCliente(Cliente clienteAlterado, Cliente novoCliente) throws ClienteNaoExisteException, ClienteJaExisteException;
	
	public abstract void alterarFornecedor(Fornecedor fornAlterado, Fornecedor novoFornecedor) throws FornecedorNaoExisteException, FornecedorJaExisteException; 
	
	public abstract void alterarFuncionario(Funcionario funcAlterado,Funcionario novoFuncionario) throws FuncionarioNaoExisteException, FuncionarioJaExisteException;
	
	public abstract void alterarMateriaPrima(MateriaPrima mpAlterada, MateriaPrima novaMateriaPrima) throws MateriaPrimaNaoExisteException, MateriaPrimaJaExisteException;
	
	public abstract void alterarProdutos(Produto produtoAlterado, Produto novoProduto) throws ProdutoNaoExisteException, ProdutoJaExisteException;

	//listar
	public abstract List<Cliente> listarClientes();
	
	public abstract List<Fornecedor> listarFornecedores();
	
	public abstract List<Funcionario> listarFuncionarios();
	
	public abstract List <MateriaPrima> listarMateriasPrimas();
	
	public abstract List<Produto> listarProdutos();
	
	//OUTROS METODOS
	public String getTelefoneFornecedor(int codigo) throws FornecedorNaoExisteException;
	
	public int getNivelFuncionario(int codigo) throws FuncionarioNaoExisteException;
	
	public int getQuantidadeMateriaPrima(int codigo) throws MateriaPrimaNaoExisteException;
	
	public LocalDate getDataFabricacao(int codigo)  throws ProdutoNaoExisteException;
	
	public LocalDate getDataValidade(int codigo)  throws ProdutoNaoExisteException;
}
