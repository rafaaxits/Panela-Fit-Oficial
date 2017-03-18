package negocios;
 
import java.time.LocalDate;
import java.util.List;

import exceptions.FormatacaoInvalidaException;
import exceptions.ClienteJaExisteException;
import exceptions.ClienteNaoExisteException;
import exceptions.FornecedorJaExisteException;
import exceptions.FornecedorNaoExisteException;
import exceptions.FuncionarioJaExisteException;
import exceptions.FuncionarioNaoExisteException;
import exceptions.MateriaPrimaInvalidaException;
import exceptions.MateriaPrimaJaExisteException;
import exceptions.MateriaPrimaNaoExisteException;
import exceptions.ProdutoInvalidoException;
import exceptions.ProdutoJaExisteException;
import exceptions.ProdutoNaoExisteException;
import exceptions.VendaInvalidaException;
import exceptions.VendaJaExisteException;
import exceptions.VendaNaoExisteException;

public interface IPanelaFit {
	//CADASTRAR
	public void cadastrarCliente(Cliente c) throws ClienteJaExisteException, FormatacaoInvalidaException;
	
	public void cadastrarFornecedor(Fornecedor f) throws FornecedorJaExisteException, FormatacaoInvalidaException;
	
	public void cadastrarFuncionario(Funcionario f) throws FuncionarioJaExisteException, FuncionarioNaoExisteException, FormatacaoInvalidaException;

	public void cadastrarMateriaPrima(MateriaPrima m) throws MateriaPrimaJaExisteException, MateriaPrimaNaoExisteException,MateriaPrimaInvalidaException;

	public void cadastrarProduto(Produto p) throws ProdutoJaExisteException, ProdutoNaoExisteException, ProdutoInvalidoException;
	
	public void cadastrarVenda(Venda venda) throws VendaJaExisteException, VendaNaoExisteException, VendaInvalidaException;
	
	//REMOVER
	public void removerCliente(Cliente cliente) throws ClienteNaoExisteException, FormatacaoInvalidaException;
	
	public void removerFornecedor(Fornecedor fornecedor) throws FornecedorNaoExisteException,FormatacaoInvalidaException;
	
	public void removerFuncionario(Funcionario funcionario) throws FuncionarioNaoExisteException, FormatacaoInvalidaException;
	
	public void removerMateriaPrima(MateriaPrima materiaprima) throws MateriaPrimaNaoExisteException, MateriaPrimaInvalidaException;
	
	public void removerProduto(Produto produto) throws ProdutoNaoExisteException, ProdutoInvalidoException;
	
	public void removerVenda(Venda venda) throws VendaNaoExisteException, VendaInvalidaException;
	
	//BUSCAR
	public Cliente buscarCliente(int codigo) throws ClienteNaoExisteException;
	
	public Fornecedor buscarFornecedor(int codigo) throws FornecedorNaoExisteException;
	
	public Funcionario buscarFuncionario(int codigo) throws FuncionarioNaoExisteException;
	
	public MateriaPrima buscarMateriaPrima(int codigo) throws MateriaPrimaNaoExisteException;
	
	public Produto buscarProduto(int codigo) throws ProdutoNaoExisteException;
	
	public Venda buscarVenda(int codigo) throws VendaNaoExisteException;
	
	//ALTERAR
	public abstract void alterarCliente(Cliente novoCliente) throws ClienteNaoExisteException, ClienteJaExisteException, FormatacaoInvalidaException;
	
	public abstract void alterarFornecedor(Fornecedor novoFornecedor) throws FornecedorNaoExisteException, FornecedorJaExisteException, FormatacaoInvalidaException; 
	
	public abstract void alterarFuncionario(Funcionario novoFuncionario) throws FuncionarioNaoExisteException, FuncionarioJaExisteException, FormatacaoInvalidaException;
	
	public abstract void alterarMateriaPrima(MateriaPrima novaMateriaPrima) throws MateriaPrimaNaoExisteException, MateriaPrimaJaExisteException, MateriaPrimaInvalidaException;
	
	public abstract void alterarProdutos(Produto novoProduto) throws ProdutoNaoExisteException, ProdutoJaExisteException, ProdutoInvalidoException;

	public void alterarVenda(Venda novaVenda) throws VendaNaoExisteException, VendaJaExisteException, VendaInvalidaException;
	
	//listar
	public abstract List<Cliente> listarClientes();
	
	public abstract List<Fornecedor> listarFornecedores();
	
	public abstract List<Funcionario> listarFuncionarios();
	
	public abstract List <MateriaPrima> listarMateriasPrimas();
	
	public abstract List<Produto> listarProdutos();
	
	public List<Venda> listarVendas();
	
	//OUTROS METODOS
	public String getTelefoneFornecedor(int codigo) throws FornecedorNaoExisteException;
	
	public int getNivelFuncionario(int codigo) throws FuncionarioNaoExisteException;
	
	public int getQuantidadeMateriaPrima(int codigo) throws MateriaPrimaNaoExisteException;
	
	public LocalDate getDataFabricacao(int codigo)  throws ProdutoNaoExisteException;
	
	public LocalDate getDataValidade(int codigo)  throws ProdutoNaoExisteException;
	
	public void excluirVendas();
	
	//EXISTIR
	public boolean existeCliente(int codigo)throws ClienteNaoExisteException;
	
	public boolean existeFuncionario(int codigo) throws FuncionarioNaoExisteException;
	
	public boolean existeFornecedor(int codigo)throws FornecedorNaoExisteException;
	
	public boolean existeMateriaPrima(int codigo) throws MateriaPrimaNaoExisteException;
}

