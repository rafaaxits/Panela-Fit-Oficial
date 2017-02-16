package negocios;

import java.time.*;
import java.util.List;

import dados.RepositorioCliente;
import dados.RepositorioFornecedor;
import dados.RepositorioFuncionario;
import dados.RepositorioMateriaPrima;
import dados.RepositorioProduto;
import exceptions.ClienteJaExisteException;
import exceptions.ClienteNaoExisteException;
import exceptions.ClienteInvalidoException;
import exceptions.FornecedorJaExisteException;
import exceptions.FornecedorNaoExisteException;
import exceptions.FornecedorInvalidoException;
import exceptions.FuncionarioJaExisteException;
import exceptions.FuncionarioNaoExisteException;
import exceptions.FuncionarioInvalidoException;
import exceptions.MateriaPrimaJaExisteException;
import exceptions.MateriaPrimaNaoExisteException;
import exceptions.MateriaPrimaInvalidaException;
import exceptions.ProdutoJaExisteException;
import exceptions.ProdutoNaoExisteException;
import exceptions.ProdutoInvalidoException;

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
	
	public void cadastrarCliente(Cliente c) throws ClienteJaExisteException, ClienteNaoExisteException, ClienteInvalidoException {
		clientes.cadastrar(c);
		
	}
	
	public void removerCliente(Cliente c) throws ClienteNaoExisteException, ClienteInvalidoException {
		clientes.remover(c);
	}
	
	public Cliente buscarCliente(int codigo) throws ClienteNaoExisteException {
		return clientes.buscar(codigo);
	}
	
	public void alterarCliente(Cliente novoCliente) throws ClienteNaoExisteException, ClienteJaExisteException, ClienteInvalidoException {
		clientes.alterar(novoCliente);
	}
	
	public List<Cliente> listarClientes(){
		return this.clientes.listaClientes();
	}
	
	//FORNECEDORES
	
	public void cadastrarFornecedor(Fornecedor f) throws FornecedorJaExisteException, FornecedorNaoExisteException, FornecedorInvalidoException{
		this.fornecedores.cadastrar(f);
	}
	
	public void removerFornecedor(Fornecedor f) throws FornecedorNaoExisteException, FornecedorInvalidoException {
		this.fornecedores.remover(f);
	}
	
	public Fornecedor buscarFornecedor(int codigo) throws FornecedorNaoExisteException {
		return this.fornecedores.buscar(codigo);
	}
	
	public void alterarFornecedor(Fornecedor novoFornecedor) throws FornecedorNaoExisteException, FornecedorJaExisteException, FornecedorInvalidoException {
		this.fornecedores.alterar(novoFornecedor);
	}
	
	public String getTelefoneFornecedor(int codigo) throws FornecedorNaoExisteException {
		return fornecedores.getTelefone(codigo);
	}
	
	public List<Fornecedor> listarFornecedores(){
		return this.fornecedores.listaFornecedores();
	}
	//FUNCIONARIO
	
	public void cadastrarFuncionario(Funcionario f) throws FuncionarioJaExisteException, FuncionarioNaoExisteException, FuncionarioInvalidoException {
		this.funcionarios.cadastrar(f);
	}
	
	public void removerFuncionario(Funcionario f) throws FuncionarioNaoExisteException, FuncionarioInvalidoException{
		this.funcionarios.remover(f);
	}
	
	public Funcionario buscarFuncionario(int codigo) throws FuncionarioNaoExisteException {
		return this.funcionarios.buscar(codigo);
	}
	
	public void alterarFuncionario(Funcionario novoFuncionario) throws FuncionarioJaExisteException, FuncionarioNaoExisteException, FuncionarioInvalidoException {
		this.funcionarios.alterar(novoFuncionario);
	}
	
	public int getNivelFuncionario(int codigo) throws FuncionarioNaoExisteException {
		return this.funcionarios.getNivel(codigo);
	}
	
	public List<Funcionario> listarFuncionarios(){
		return this.funcionarios.listarFuncionarios();
	}
	
	//MATERIAPRIMA
	
	public void cadastrarMateriaPrima(MateriaPrima m) throws MateriaPrimaJaExisteException, MateriaPrimaNaoExisteException, MateriaPrimaInvalidaException{
		this.materiaPrimas.cadastrar(m);
	}
	
	public void removerMateriaPrima(MateriaPrima m) throws MateriaPrimaNaoExisteException, MateriaPrimaInvalidaException{
		this.materiaPrimas.remover(m);
	}
	
	public MateriaPrima buscarMateriaPrima(int codigo) throws MateriaPrimaNaoExisteException {
		return this.materiaPrimas.buscar(codigo);
	}
	
	public void alterarMateriaPrima(MateriaPrima novaMateriaPrima) throws MateriaPrimaNaoExisteException, MateriaPrimaJaExisteException, MateriaPrimaInvalidaException {
		this.materiaPrimas.alterar(novaMateriaPrima);
	}
	
	public int getQuantidadeMateriaPrima(int codigo) throws MateriaPrimaNaoExisteException {
		return materiaPrimas.getQuantidade(codigo);
	}
	
	public List<MateriaPrima> listarMateriasPrimas(){
		return this.materiaPrimas.listaMateriaPrimas();
	}
	
	//PRODUTOS
	
	public void cadastrarProduto(Produto p) throws ProdutoJaExisteException, ProdutoNaoExisteException, ProdutoInvalidoException{
		this.produtos.cadastrar(p);
	}
	
	public void removerProduto(Produto p) throws ProdutoNaoExisteException, ProdutoInvalidoException {
		this.produtos.remover(p);
	}
	
	public Produto buscarProduto(int codigo) throws ProdutoNaoExisteException {
		return this.produtos.buscar(codigo);
	}
	
	public void alterarProdutos(Produto novoProduto) throws ProdutoNaoExisteException, ProdutoJaExisteException, ProdutoInvalidoException {
		this.produtos.alterar(novoProduto);
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