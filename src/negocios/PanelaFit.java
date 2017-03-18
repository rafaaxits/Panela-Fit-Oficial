package negocios;

import java.time.*;
import java.util.List;

import dados.RepositorioCliente;
import dados.RepositorioFornecedor;
import dados.RepositorioFuncionario;
import dados.RepositorioMateriaPrima;
import dados.RepositorioProduto;
import dados.RepositorioVenda;
import exceptions.ClienteJaExisteException;
import exceptions.ClienteNaoExisteException;
import exceptions.FormatacaoInvalidaException;
import exceptions.FornecedorJaExisteException;
import exceptions.FornecedorNaoExisteException;
import exceptions.FuncionarioJaExisteException;
import exceptions.FuncionarioNaoExisteException;
import exceptions.MateriaPrimaJaExisteException;
import exceptions.MateriaPrimaNaoExisteException;
import exceptions.ProdutoJaExisteException;
import exceptions.ProdutoNaoExisteException;
import exceptions.ProdutoInvalidoException;
import exceptions.VendaInvalidaException;
import exceptions.VendaJaExisteException;
import exceptions.VendaNaoExisteException;

public class PanelaFit implements IPanelaFit{
	private ControladorClientes clientes;
	private ControladorFornecedores fornecedores;
	private ControladorFuncionarios funcionarios;
	private ControladorMateriaPrimas materiaPrimas;
	private ControladorProdutos produtos;
	private ControladorVendas vendas;
	private static PanelaFit instance;
	
	private PanelaFit(){
	this.clientes = new ControladorClientes(RepositorioCliente.getInstance());
	this.fornecedores = new ControladorFornecedores(RepositorioFornecedor.getInstance());
	this.funcionarios = new ControladorFuncionarios(RepositorioFuncionario.getInstance());
	this.materiaPrimas = new ControladorMateriaPrimas(RepositorioMateriaPrima.getInstance());
	this.produtos = new ControladorProdutos(RepositorioProduto.getInstance());
	this.vendas = new ControladorVendas(RepositorioVenda.getInstance());
	}
	
	public static PanelaFit getInstance(){
		if(instance == null){
			instance = new PanelaFit();
		}
		return instance;
	}
	
	//CLIENTES
	
	public void cadastrarCliente(Cliente c) throws ClienteJaExisteException, FormatacaoInvalidaException {
		this.clientes.cadastrar(c);
		
	}
	
	public void removerCliente(Cliente c) throws ClienteNaoExisteException, FormatacaoInvalidaException {
		this.clientes.remover(c);
	}
	
	public Cliente buscarCliente(int codigo) throws ClienteNaoExisteException {
		return clientes.buscar(codigo);
	}
	
	public void alterarCliente(Cliente novoCliente) throws ClienteNaoExisteException, ClienteJaExisteException, FormatacaoInvalidaException {
		this.clientes.alterar(novoCliente);
	}
	
	public List<Cliente> listarClientes(){
		return this.clientes.listaClientes();
	}
	
	public boolean existeCliente(int codigo) throws ClienteNaoExisteException{
		boolean alt=false;
		if(this.clientes.existe(codigo)==true){
			alt=true;
		}
		return alt;
	}
	
	//FORNECEDORES
	
	public void cadastrarFornecedor(Fornecedor f) throws FornecedorJaExisteException, FormatacaoInvalidaException{
		this.fornecedores.cadastrar(f);
	}
	
	public void removerFornecedor(Fornecedor f) throws FornecedorNaoExisteException, FormatacaoInvalidaException {
		this.fornecedores.remover(f);
	}
	
	public Fornecedor buscarFornecedor(int codigo) throws FornecedorNaoExisteException {
		return this.fornecedores.buscar(codigo);
	}
	
	public void alterarFornecedor(Fornecedor novoFornecedor) throws FornecedorNaoExisteException, FornecedorJaExisteException, FormatacaoInvalidaException {
		this.fornecedores.alterar(novoFornecedor);
	}
	
	public String getTelefoneFornecedor(int codigo) throws FornecedorNaoExisteException {
		return fornecedores.getTelefone(codigo);
	}
	
	public List<Fornecedor> listarFornecedores(){
		return this.fornecedores.listaFornecedores();
	}
	
	public boolean existeFornecedor(int codigo) throws FornecedorNaoExisteException{
		boolean alt = false;
			if(this.fornecedores.existe(codigo)==true){
				alt=true;
			}
			return alt;
	}
	//FUNCIONARIO
	
	public void cadastrarFuncionario(Funcionario f) throws FuncionarioJaExisteException, FuncionarioNaoExisteException, FormatacaoInvalidaException {
		this.funcionarios.cadastrar(f);
	}
	
	public void removerFuncionario(Funcionario f) throws FuncionarioNaoExisteException, FormatacaoInvalidaException{
		this.funcionarios.remover(f);
	}
	
	public Funcionario buscarFuncionario(int codigo) throws FuncionarioNaoExisteException {
		return this.funcionarios.buscar(codigo);
	}
	
	public void alterarFuncionario(Funcionario novoFuncionario) throws FuncionarioJaExisteException, FuncionarioNaoExisteException, FormatacaoInvalidaException{
		this.funcionarios.alterar(novoFuncionario);
	}
	
	public int getNivelFuncionario(int codigo) throws FuncionarioNaoExisteException {
		return this.funcionarios.getNivel(codigo);
	}
	
	public List<Funcionario> listarFuncionarios(){
		return this.funcionarios.listarFuncionarios();
	}
	
	public boolean existeFuncionario(int codigo)throws FuncionarioNaoExisteException{
		boolean alt = false;
		if(this.funcionarios.existe(codigo)==true){
			alt = true;
		}
		return alt;
	}
	
	//MATERIAPRIMA
	
	public void cadastrarMateriaPrima(MateriaPrima m) throws MateriaPrimaJaExisteException, FormatacaoInvalidaException{
		this.materiaPrimas.cadastrar(m);
	}
	
	public void removerMateriaPrima(MateriaPrima m) throws MateriaPrimaNaoExisteException, FormatacaoInvalidaException{
		this.materiaPrimas.remover(m);
	}
	
	public MateriaPrima buscarMateriaPrima(int codigo) throws MateriaPrimaNaoExisteException {
		return this.materiaPrimas.buscar(codigo);
	}
	
	public void alterarMateriaPrima(MateriaPrima novaMateriaPrima) throws MateriaPrimaNaoExisteException, MateriaPrimaJaExisteException, FormatacaoInvalidaException {
		this.materiaPrimas.alterar(novaMateriaPrima);
	}
	
	public int getQuantidadeMateriaPrima(int codigo) throws MateriaPrimaNaoExisteException {
		return materiaPrimas.getQuantidade(codigo);
	}
	
	public boolean existeMateriaPrima(int codigo)throws MateriaPrimaNaoExisteException{
		boolean alt = false;
		if(this.materiaPrimas.existe(codigo)==true){
			alt = true;
		}
		return alt;
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
	
	//VENDAS
	
	public void cadastrarVenda(Venda v) throws VendaJaExisteException, VendaNaoExisteException, VendaInvalidaException{
		this.vendas.cadastrar(v);
	}
	
	public void removerVenda(Venda v) throws VendaNaoExisteException, VendaInvalidaException{
		this.vendas.remover(v);
	}
	
	public Venda buscarVenda(int codigo) throws VendaNaoExisteException{
		return this.vendas.buscar(codigo);
	}
	
	public void alterarVenda(Venda novaVenda) throws VendaNaoExisteException, VendaJaExisteException, VendaInvalidaException{
		this.vendas.alterar(novaVenda);
	}
	
	public void excluirVendas(){
		this.vendas.excluirVendas();
	}
	
	public List<Venda> listarVendas(){
		return this.vendas.listarVendas();
	}

}