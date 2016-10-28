package negocios;
 
import java.time.LocalDate;

import beans.Cliente;
import beans.Fornecedor;
import beans.Funcionario;
import beans.MateriaPrima;
import beans.Produto;
import exceptions.ClienteJaExisteException;
import exceptions.ClienteNaoExisteException;
import exceptions.FornecedorNaoExisteException;
import exceptions.FuncionarioJaExisteException;
import exceptions.FuncionarioNaoExisteException;
import exceptions.MateriaPrimaJaExisteException;
import exceptions.MateriaPrimaNaoExisteException;
import exceptions.ProdutoJaExisteException;
import exceptions.ProdutoNaoExisteException;
import exceptions.FornecedorNaoExisteException;
import exceptions.FornecedorJaExisteException;

public interface IPanelaFit {
	//CADASTRAR
	public void cadastrarCliente(Cliente c) throws ClienteJaExisteException;
	
	public void cadastrarFornecedor(Fornecedor f) throws FornecedorJaExisteException;
	
	public void cadastrarFuncionario(Funcionario f) throws FuncionarioJaExisteException;

	public void cadastrarMateriaPrima(MateriaPrima m) throws MateriaPrimaJaExisteException;

	public void cadastrarProduto(Produto p) throws ProdutoJaExisteException;
	
	//REMOVER
	public void removerCliente(int codigo) throws ClienteNaoExisteException;
	
	public void removerFornecedor(int codigo);
	
	public void removerFuncionario(int codigo);
	
	public void removerMateriaPrima(int codigo);
	
	public void removerProduto(int codigo);
	
	//BUSCAR
	public Cliente buscarCliente(int codigo) throws ClienteNaoExisteException;
	
	public Fornecedor buscarFornecedor(int codigo) throws FornecedorNaoExisteException;
	
	public Funcionario buscarFuncionario(int codigo) throws FuncionarioNaoExisteException;
	
	public MateriaPrima buscarMateriaPrima(int codigo) throws MateriaPrimaNaoExisteException;
	
	public Produto buscarProduto(int codigo) throws ProdutoNaoExisteException;
	
	//ALTERAR
	public boolean alterarCliente(Cliente novoCliente);
	
	public boolean alterarFornecedor(Fornecedor novoFornecedor);
	
	public boolean alterarFuncionario(Funcionario novoFuncionario);
	
	public boolean alterarMateriaPrima(MateriaPrima novaMateriaPrima);
	
	public boolean alterarProdutos(Produto novoProduto);
	//OUTROS METODOS
	public String getTelefoneFornecedor(int codigo) throws FornecedorNaoExisteException;
	
	public int getNivelFuncionario(int codigo) throws FuncionarioNaoExisteException;
	
	public int getQuantidadeMateriaPrima(int codigo) throws MateriaPrimaNaoExisteException;
	
	public LocalDate getDataFabricacao(int codigo);
	
	public LocalDate getDataValidade(int codigo);
}
