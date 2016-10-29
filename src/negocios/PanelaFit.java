package negocios;

import java.time.*;
import java.util.List;
import beans.Cliente;
import beans.Fornecedor;
import beans.Funcionario;
import beans.MateriaPrima;
import beans.Produto;
import dados.RepositorioCliente;
import dados.RepositorioFornecedor;
import dados.RepositorioFuncionario;
import dados.RepositorioMateriaPrima;
import dados.RepositorioProduto;
import exceptions.ClienteJaExisteException;
import exceptions.ClienteNaoExisteException;
import exceptions.FuncionarioJaExisteException;
import exceptions.FuncionarioNaoExisteException;
import exceptions.FornecedorNaoExisteException;
import exceptions.FornecedorJaExisteException;
import exceptions.MateriaPrimaNaoExisteException;
import exceptions.MateriaPrimaJaExisteException;
import exceptions.ProdutoJaExisteException;
import exceptions.ProdutoNaoExisteException;

public class PanelaFit implements IPanelaFit{
	private ControladorClientes clientes;
	private ControladorFornecedores fornecedores;
	private ControladorFuncionarios funcionarios;
	private ControladorMateriaPrimas materiaPrimas;
	private ControladorProdutos produtos;
	
	private static PanelaFit instance;
	
	private PanelaFit(){
	this.clientes = new ControladorClientes(RepositorioCliente.getInstance());
	this.fornecedores = new ControladorFornecedores(RepositorioFornecedor.getInstance());
	this.funcionarios = new ControladorFuncionarios(RepositorioFuncionario.getInstance());
	this.materiaPrimas = new ControladorMateriaPrimas(RepositorioMateriaPrima.getInstance());
	this.produtos = new ControladorProdutos(RepositorioProduto.getInstance());
	}
	
	public static PanelaFit getInstance(){
		if(instance == null){
			instance = new PanelaFit();
		}
		return instance;
	}
	
	//CLIENTES
	
	public void cadastrarCliente(Cliente c) throws ClienteJaExisteException, ClienteNaoExisteException {
		clientes.cadastrar(c);
		
	}
	
	public void removerCliente(Cliente c) throws ClienteNaoExisteException {
		clientes.remover(c);
	}
	
	public Cliente buscarCliente(int codigo) throws ClienteNaoExisteException {
		return clientes.buscar(codigo);
	}
	
	public void alterarCliente(Cliente clienteAlterado, Cliente novoCliente) throws ClienteNaoExisteException, ClienteJaExisteException {
		clientes.alterar(clienteAlterado, novoCliente);
	}
	
	public List<Cliente> listarClientes(){
		return this.clientes.listaClientes();
	}
	
	//FORNECEDORES
	
	public void cadastrarFornecedor(Fornecedor f) throws FornecedorJaExisteException, FornecedorNaoExisteException {
		this.fornecedores.cadastrar(f);
	}
	
	public void removerFornecedor(Fornecedor f) throws FornecedorNaoExisteException {
		this.fornecedores.remover(f);
	}
	
	public Fornecedor buscarFornecedor(int codigo) throws FornecedorNaoExisteException {
		return this.fornecedores.buscar(codigo);
	}
	
	public void alterarFornecedor(Fornecedor fornAlterado, Fornecedor novoFornecedor) throws FornecedorNaoExisteException, FornecedorJaExisteException {
		this.fornecedores.alterar(fornAlterado, novoFornecedor);
	}
	
	public String getTelefoneFornecedor(int codigo) throws FornecedorNaoExisteException {
		return fornecedores.getTelefone(codigo);
	}
	
	public List<Fornecedor> listarFornecedores(){
		return this.fornecedores.listaFornecedores();
	}
	//FUNCIONARIO
	
	public void cadastrarFuncionario(Funcionario f) throws FuncionarioJaExisteException, FuncionarioNaoExisteException {
		this.funcionarios.cadastrar(f);
	}
	
	public void removerFuncionario(Funcionario f) throws FuncionarioNaoExisteException {
		this.funcionarios.remover(f);
	}
	
	public Funcionario buscarFuncionario(int codigo) throws FuncionarioNaoExisteException {
		return this.funcionarios.buscar(codigo);
	}
	
	public void alterarFuncionario(Funcionario funcAlterado, Funcionario novoFuncionario) throws FuncionarioJaExisteException, FuncionarioNaoExisteException {
		this.funcionarios.alterar(funcAlterado, novoFuncionario);
	}
	
	public int getNivelFuncionario(int codigo) throws FuncionarioNaoExisteException {
		return this.funcionarios.getNivel(codigo);
	}
	
	public List<Funcionario> listarFuncionarios(){
		return this.funcionarios.listarFuncionarios();
	}
	
	//MATERIAPRIMA
	
	public void cadastrarMateriaPrima(MateriaPrima m) throws MateriaPrimaJaExisteException, MateriaPrimaNaoExisteException{
		this.materiaPrimas.cadastrar(m);
	}
	
	public void removerMateriaPrima(MateriaPrima m) throws MateriaPrimaNaoExisteException {
		this.materiaPrimas.remover(m);
	}
	
	public MateriaPrima buscarMateriaPrima(int codigo) throws MateriaPrimaNaoExisteException {
		return this.materiaPrimas.buscar(codigo);
	}
	
	public void alterarMateriaPrima(MateriaPrima mpAlterada, MateriaPrima novaMateriaPrima) throws MateriaPrimaNaoExisteException, MateriaPrimaJaExisteException {
		this.materiaPrimas.alterar(mpAlterada, novaMateriaPrima);
	}
	
	public int getQuantidadeMateriaPrima(int codigo) throws MateriaPrimaNaoExisteException {
		return materiaPrimas.getQuantidade(codigo);
	}
	
	public List<MateriaPrima> listarMateriasPrimas(){
		return this.materiaPrimas.listaMateriaPrimas();
	}
	
	//PRODUTOS
	
	public void cadastrarProduto(Produto p) throws ProdutoJaExisteException, ProdutoNaoExisteException{
		this.produtos.cadastrar(p);
	}
	
	public void removerProduto(Produto p) throws ProdutoNaoExisteException {
		this.produtos.remover(p);
	}
	
	public Produto buscarProduto(int codigo) throws ProdutoNaoExisteException {
		return this.produtos.buscar(codigo);
	}
	
	public void alterarProdutos(Produto produtoAlterado, Produto novoProduto) throws ProdutoNaoExisteException, ProdutoJaExisteException {
		this.produtos.alterar(produtoAlterado, novoProduto);
	}
	
	public LocalDate getDataFabricacao(int codigo)  throws ProdutoNaoExisteException{
		return this.produtos.getDataValidade(codigo);
	}
	
	public LocalDate getDataValidade(int codigo)  throws ProdutoNaoExisteException{
		return this.produtos.getDataValidade(codigo);
	}
	
	public List<Produto> listarProdutos(){
		return this.produtos.listaProdutos();
	}


}