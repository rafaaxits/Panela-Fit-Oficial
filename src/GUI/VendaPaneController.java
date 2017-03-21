package GUI;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.xml.bind.ValidationException;

import exceptions.ClienteNaoExisteException;
import exceptions.FormatacaoInvalidaException;
import exceptions.FuncionarioNaoExisteException;
import exceptions.ProdutoNaoExisteException;
import exceptions.VendaJaExisteException;
import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import negocios.Cliente;
import negocios.Funcionario;
import negocios.ItemVenda;
import negocios.PanelaFit;
import negocios.Produto;
import negocios.Venda;
import negocios.Cliente;

public class VendaPaneController {
	
	private PanelaFit panelaFit;
	
	@FXML
	private Label lblMensagem;
	
	@FXML
	private  TabPane tbPaneVendas;
	
	@FXML 
	private Tab tabClientes;
	
	@FXML
	private Tab tabFuncionarios;
	
	@FXML
	private Tab tabProdutos;
	
	@FXML
	private Tab tabVendas;
	
	@FXML
	private TextField txtQuantidadeItem;
	
	@FXML
	private TextField txtNomeCliente;
	
	@FXML
	private TextField txtCpfCliente;
	
	@FXML
	private TextField txtCodigoCliente;
	
	@FXML
	private TextField txtNomeProduto;
	
	@FXML
	private TextField txtCodigoProduto;
	
	@FXML
	private TextField txtNomeFuncionario;
	
	@FXML
	private TextField txtCpfFuncionario;
	
	@FXML
	private TextField txtCodigoFuncionario;
	
	@FXML
	private TextField txtCodigoVenda;
	
	@FXML
	private TextField txtDataVenda;
	
	@FXML
	private TableView<Cliente> tabelaClientes;
	
	@FXML
	TableColumn<Cliente,String> colunaNomeCliente;
	
	@FXML
	TableColumn<Cliente,String> colunaCpfCliente;
	
	@FXML
	TableColumn<Cliente,String> colunaIdadeCliente;
	
	@FXML
	TableColumn<Cliente,String> colunaEnderecoCliente;
	
	@FXML
	TableColumn<Cliente,String> colunaTelefoneCliente;
	
	@FXML
	TableColumn<Cliente,String> colunaCodigoCliente;
	
	@FXML
	private TableView<Funcionario> tabelaFuncionarios;
	
	@FXML
	TableColumn<Funcionario,String> colunaNomeFuncionario;
	
	@FXML
	TableColumn<Funcionario,String> colunaCpfFuncionario;
	
	@FXML
	TableColumn<Funcionario,String> colunaIdadeFuncionario;
	
	@FXML
	TableColumn<Funcionario,String> colunaEnderecoFuncionario;
	
	@FXML
	TableColumn<Funcionario,String> colunaTelefoneFuncionario;
	
	@FXML
	TableColumn<Funcionario,String> colunaCodigoFuncionario;
	
	@FXML
	TableColumn<Funcionario,String> colunaNivelFuncionario;
	
	@FXML
	private TableView<Produto> tabelaProdutos;
	
	@FXML
	TableColumn<Produto,String> colunaNomeProduto;
	
	@FXML
	TableColumn<Produto,String> colunaCodigoProduto;
	
	@FXML
	TableColumn<Produto,String> colunaPesoProduto;
	
	@FXML
	TableColumn<Produto,String> colunaCaloriasProduto;
	
	@FXML
	TableColumn<Produto,String> colunaQuantEstoqueProduto;
	
	@FXML
	TableColumn<Produto,String> colunaPrecoProduto;
	
	@FXML
	TableColumn<Produto,String> colunaDataFabProduto;
	
	@FXML
	TableColumn<Produto,String> colunaDataValProduto;

	@FXML
	private TableView<Venda> tabelaVendas;
	
	@FXML
	TableColumn<Venda,String> colunaCodigoVenda;
	
	@FXML
	TableColumn<Venda,String> colunaCliente;
	
	@FXML
	TableColumn<Venda,String> colunaFuncionario;
	
	@FXML
	TableColumn<Venda,ArrayList<ItemVenda>> colunaListaItens;
	
	@FXML
	TableColumn<Venda,String> colunaDataVenda;
	
	@FXML
	TableColumn<Venda,Double> colunaTotal;
	
	@FXML 
	TableColumn<ItemVenda, String> colunaNomeProdutoItemVenda;
	
	@FXML
	TableColumn<ItemVenda, String> colunaQuantidadeItemVenda;
	
	@FXML
	private TableView<ItemVenda> tabelaListaitemVenda;
	
	private ObservableList<Cliente> dataCliente;
	
	private ObservableList<Funcionario> dataFuncionario;
	
	private ObservableList<Produto> dataProduto;
	
	private ObservableList<ItemVenda> dataItemVenda;
	
	private ArrayList<ItemVenda> listaItensDeVenda;
	
	private ObservableList<Venda> dataVenda;
	
	public DateTimeFormatter DATE_FORMAT = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();
	
	public void sair(ActionEvent event){
		((Node) event.getSource()).getScene().getWindow().hide();

	}
	
	public void voltarMenuPrincipal(ActionEvent event){
		((Node) event.getSource()).getScene().getWindow().hide();
		Parent parent;
			try{
				parent = FXMLLoader.load(getClass()
				          .getResource("PanelaFit.fxml"));
				Stage stage3 = new Stage();
			      Scene cena = new Scene(parent);
			      stage3.setScene(cena);
			      stage3.show();
			}catch(IOException e){
				lblMensagem.setText(e.getMessage());
			}			
	}	
	
	public void cadastrarVenda() throws ValidationException, IOException, ClienteNaoExisteException, FuncionarioNaoExisteException, VendaJaExisteException{
		if(validateFields()){
			try{
				Integer codigoCliente = new Integer (txtCodigoCliente.getText());
				Integer codigoFuncionario = new Integer (txtCodigoFuncionario.getText());
				Cliente c = panelaFit.buscarCliente(codigoCliente);
				Funcionario f = panelaFit.buscarFuncionario(codigoFuncionario);
				Integer codigoVenda = new Integer(txtCodigoVenda.getText());
				LocalDate dataVenda = LocalDate.parse(txtDataVenda.getText(), DATE_FORMAT);
				ArrayList<ItemVenda> listaDeItensDeVenda = this.listaItensDeVenda;
				Venda venda = new Venda(codigoVenda, c, f, listaDeItensDeVenda, dataVenda);
				panelaFit.cadastrarVenda(venda);
				limparForm();
				lblMensagem.setText("Venda Cadastrada");
				System.out.println(venda);
				this.listaItensDeVenda.clear();
			}catch (FormatacaoInvalidaException e){
				lblMensagem.setText(e.getMessage());
			}catch(VendaJaExisteException e){
				lblMensagem.setText(e.getMessage());
			}
			catch(DateTimeException e){
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/PopUpTela.fxml"));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.initStyle(StageStyle.UNDECORATED);
				stage.setTitle("Panela Fit");
				stage.setScene(new Scene(root1));
				stage.show();
				txtDataVenda.setStyle("-fx-background-color: red;");
			}
		}
	}
	
	@FXML
	private void initialize(){
		panelaFit = PanelaFit.getInstance();
		
		colunaNomeCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		colunaCpfCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCpf()));
		colunaIdadeCliente.setCellValueFactory(new PropertyValueFactory<Cliente,String>("idade"));
		colunaEnderecoCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEndereco()));
		colunaTelefoneCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefone()));
		colunaCodigoCliente.setCellValueFactory(new PropertyValueFactory<Cliente,String>("codigo"));
		
		colunaNomeFuncionario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		colunaCpfFuncionario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCpf()));
		colunaIdadeFuncionario.setCellValueFactory(new PropertyValueFactory<Funcionario,String>("idade"));
		colunaEnderecoFuncionario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEndereco()));
		colunaTelefoneFuncionario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefone()));
		colunaCodigoFuncionario.setCellValueFactory(new PropertyValueFactory<Funcionario,String>("codigo"));
		colunaNivelFuncionario.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("nivel"));
		
		colunaNomeProduto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		colunaCaloriasProduto.setCellValueFactory(new PropertyValueFactory<Produto,String>("Calorias"));
		colunaCodigoProduto.setCellValueFactory(new PropertyValueFactory<Produto,String>("Codigo"));
		colunaPesoProduto.setCellValueFactory(new PropertyValueFactory<Produto,String>("Peso"));
		colunaPrecoProduto.setCellValueFactory(new PropertyValueFactory<Produto,String>("Preco"));
		colunaQuantEstoqueProduto.setCellValueFactory(new PropertyValueFactory<Produto,String>("QuantEstoque"));
		colunaDataFabProduto.setCellValueFactory(new PropertyValueFactory<Produto,String>("DataFabricacao"));
		colunaDataValProduto.setCellValueFactory(new PropertyValueFactory<Produto,String>("DataValidade"));
		
		this.listaItensDeVenda = new ArrayList<ItemVenda>();
		
		dataItemVenda = FXCollections.observableArrayList();
		dataItemVenda.addAll(listaItensDeVenda);
		
		dataCliente = FXCollections.observableArrayList();
		dataCliente.addAll(panelaFit.listarClientes());
		tabelaClientes.setItems(dataCliente);
		
		dataFuncionario = FXCollections.observableArrayList();
		dataFuncionario.addAll(panelaFit.listarFuncionarios());
		tabelaFuncionarios.setItems(dataFuncionario);
		
		dataProduto = FXCollections.observableArrayList();
		dataProduto.addAll(panelaFit.listarProdutos());
		tabelaProdutos.setItems(dataProduto);
		
	}
	
	@FXML
	public void limparForm() {
		txtNomeCliente.clear();
		txtCpfCliente.clear();
		txtCodigoCliente.clear();
		txtNomeCliente.setStyle(null);
		txtCodigoCliente.setStyle(null);
		txtCpfCliente.setStyle(null);
		txtCodigoCliente.editableProperty().set(true);
		tabelaClientes.getSelectionModel().clearSelection();
		txtNomeFuncionario.clear();
		txtCpfFuncionario.clear();
		txtCodigoFuncionario.clear();
		txtNomeFuncionario.setStyle(null);
		txtCodigoFuncionario.setStyle(null);
		txtCpfFuncionario.setStyle(null);
		txtCodigoFuncionario.editableProperty().set(true);
		tabelaFuncionarios.getSelectionModel().clearSelection();
		txtNomeProduto.clear();
		txtCodigoProduto.clear();
		txtNomeProduto.setStyle(null);
		txtCodigoProduto.setStyle(null);
		txtCodigoProduto.editableProperty().set(true);
		tabelaProdutos.getSelectionModel().clearSelection();
		lblMensagem.setText(null);
		txtCodigoVenda.clear();
		txtDataVenda.clear();
		txtDataVenda.setStyle(null);
	}
	
	public void setDados(ObservableList<Cliente> dadosCliente){
			tabelaClientes.setItems(dadosCliente);
	}
	
	@FXML
	public void selecionarProduto(MouseEvent arg0){
		if(!tabelaProdutos.getSelectionModel().isEmpty()){
			Produto produtoSelecionado = tabelaProdutos.getSelectionModel().getSelectedItem();
			Integer codigo = produtoSelecionado.getCodigo();
			txtNomeProduto.setText(produtoSelecionado.getNome());
			txtCodigoProduto.setText(codigo.toString());
			txtCodigoProduto.editableProperty().set(false);
			txtNomeProduto.editableProperty().set(false);
			txtCodigoProduto.setStyle("-fx-background-color: gray;");
			txtNomeProduto.setStyle("-fx-background-color: gray;");
		}
	}
	
	@FXML
	public void buscarProduto() throws ProdutoNaoExisteException, IOException{
		Produto p;
		try{
			Integer code = new Integer(txtCodigoProduto.getText());
			p = panelaFit.buscarProduto(code);
			txtNomeProduto.setText(p.getNome());
			txtCodigoProduto.editableProperty().set(false);
			txtNomeProduto.editableProperty().set(false);
			txtCodigoProduto.setStyle("-fx-background-color: gray;");
			txtNomeProduto.setStyle("-fx-background-color: gray;");
		}catch(NumberFormatException e){
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/PopUpTela.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Panela Fit");
            stage.setScene(new Scene(root1));  
            stage.show();
		}catch(ProdutoNaoExisteException e){
			lblMensagem.setText(e.getMessage());
		}
	}
	
	@FXML
	public void selecionarCliente(MouseEvent agr0){
		if(!tabelaClientes.getSelectionModel().isEmpty()){
			Cliente clienteSelecionado = tabelaClientes.getSelectionModel().getSelectedItem();
			Integer codigo = clienteSelecionado.getCodigo();
			txtNomeCliente.setText(clienteSelecionado.getNome());
			txtCodigoCliente.setText(codigo.toString());
			txtCpfCliente.setText(clienteSelecionado.getCpf());
			txtCodigoCliente.editableProperty().set(false);
			txtNomeCliente.editableProperty().set(false);
			txtCpfCliente.editableProperty().set(false);
			txtCodigoCliente.setStyle("-fx-background-color: gray;");
			txtNomeCliente.setStyle("-fx-background-color: gray;");
			txtCpfCliente.setStyle("-fx-background-color: gray;");
			txtQuantidadeItem.setStyle(null);
		}
	}
		
	
	@FXML
	public void buscarCliente() throws ClienteNaoExisteException, IOException{
		Cliente c;
		try{
			Integer code = new Integer(txtCodigoCliente.getText());
			c = panelaFit.buscarCliente(code);
			txtNomeCliente.setText(c.getNome());
			txtCodigoCliente.editableProperty().set(false);
			txtCpfCliente.setText(c.getCpf());
			txtNomeCliente.editableProperty().set(false);
			txtCodigoCliente.setStyle("-fx-background-color: gray;");
			txtCpfCliente.editableProperty().set(false);
			txtNomeCliente.setStyle("-fx-background-color: gray;");
			txtCpfCliente.setStyle("-fx-background-color: gray;");
		}catch(NumberFormatException e){
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/PopUpTela.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Panela Fit");
            stage.setScene(new Scene(root1));  
            stage.show();
		}catch(ClienteNaoExisteException e){
			lblMensagem.setText(e.getMessage());
		}

	}
	
	@FXML
	public void selecionarFuncionario(MouseEvent arg0){
		if(!tabelaFuncionarios.getSelectionModel().isEmpty()){
			Funcionario funcionarioSelecionado = tabelaFuncionarios.getSelectionModel().getSelectedItem();
			Integer codigo = funcionarioSelecionado.getCodigo();
			txtNomeFuncionario.setText(funcionarioSelecionado.getNome());
			txtCodigoFuncionario.setText(codigo.toString());
			txtCpfFuncionario.setText(funcionarioSelecionado.getCpf());
			txtCodigoFuncionario.editableProperty().set(false);
			txtNomeFuncionario.editableProperty().set(false);
			txtCpfFuncionario.editableProperty().set(false);
			txtCodigoFuncionario.setStyle("-fx-background-color: gray;");
			txtNomeFuncionario.setStyle("-fx-background-color: gray;");
			txtCpfFuncionario.setStyle("-fx-background-color: gray;");

		}		
	}
	
	@FXML
	public void buscarFuncionario() throws FuncionarioNaoExisteException, IOException{
		Funcionario f;
		try{
			Integer code = new Integer(txtCodigoFuncionario.getText());
			f = panelaFit.buscarFuncionario(code);
			txtNomeFuncionario.setText(f.getNome());
			txtCodigoFuncionario.editableProperty().set(false);
			txtCpfFuncionario.setText(f.getCpf());
			txtNomeFuncionario.editableProperty().set(false);
			txtCodigoFuncionario.setStyle("-fx-background-color: gray;");
			txtCpfFuncionario.editableProperty().set(false);
			txtNomeFuncionario.setStyle("-fx-background-color: gray;");
			txtCpfFuncionario.setStyle("-fx-background-color: gray;");
		}catch(NumberFormatException e){
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/PopUpTela.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Panela Fit");
            stage.setScene(new Scene(root1));  
            stage.show();
		}catch(FuncionarioNaoExisteException e){
			lblMensagem.setText(e.getMessage());
		}
	}
	
	private void validateAttributes(Venda venda) throws ValidationException{
		String returnMs = "";
		Cliente cliente = venda.getCliente();
		Funcionario funcionario = venda.getFuncionario();
		Integer codigo = venda.getCodigo();
		
		if(venda.getCliente()==null){
			returnMs+= "'Cliente' ";
		}
		if(venda.getFuncionario()==null){
			returnMs+= "'Funcionario '";
		}
		if(codigo.toString()==null){
			returnMs+= "'Codigo'";
		}
		if(venda.getListaItensDeVenda()==null){
			returnMs+= "'ListaItensDeVenda' ";
		}
		if(venda.getDataDaVenda()==null){
			returnMs+= "'DataVenda' ";
		}
		if(!returnMs.isEmpty()){
			throw new ValidationException(
					String.format("Os arumentos[%s] obrigatorios estao nulos ou com valores invalidos", returnMs));
		}
	}
	
	public boolean validateFields() throws IOException{
		boolean validate = false;
		try{
			if((txtCodigoVenda.getText().isEmpty() || !txtCodigoVenda.getText().matches("[0-9][0-9][0-9][0-9][0-9]")) || 
					(txtDataVenda.getText().isEmpty() || !txtDataVenda.getText().matches("[0-9][0-9][/][0-9][0-9][/][0-9][0-9][0-9][0-9]"))){
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/PopUpTela.fxml"));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.initStyle(StageStyle.UNDECORATED);
				stage.setTitle("Panela Fit");
				stage.setScene(new Scene(root1));
				stage.show();
			}else{
				validate = true;
			}
		}catch(NumberFormatException e){
			e.getMessage();
		}
		return  validate;
	}
	
	public boolean validateListaItem() throws IOException{
		boolean validate = false;
		try{
			if(txtQuantidadeItem.getText().isEmpty() || !txtQuantidadeItem.getText().matches("[0-9]+")){
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/PopUpTela.fxml"));
	            Parent root1 = (Parent) fxmlLoader.load();
	            Stage stage = new Stage();
	            stage.initModality(Modality.APPLICATION_MODAL);
	            stage.initStyle(StageStyle.UNDECORATED);
	            stage.setTitle("Panela Fit");
	            stage.setScene(new Scene(root1));  
	            stage.show();
	            	if(txtQuantidadeItem.getText().isEmpty() || !txtQuantidadeItem.getText().isEmpty()){
	            		txtQuantidadeItem.setStyle("-fx-background-color: red;");
	            	}
			}else {
				validate=true;
			}
		}catch(NumberFormatException e){
			e.getMessage();
		}
		return validate;
	}
	
	@FXML
	public void setItemNaLista() throws IOException, ProdutoNaoExisteException{
		if(validateListaItem()){
			Integer quantidade = new Integer (txtQuantidadeItem.getText());
			Integer code = new Integer (txtCodigoProduto.getText());
			Produto produto = panelaFit.buscarProduto(code);
			ItemVenda itemVenda = new ItemVenda(produto,quantidade);
			listaItensDeVenda.add(itemVenda);
			System.out.println(listaItensDeVenda);
			colunaNomeProdutoItemVenda.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProduto().getNome()));
			colunaQuantidadeItemVenda.setCellValueFactory(new PropertyValueFactory<ItemVenda,String>("Quantidade"));
			dataItemVenda = FXCollections.observableArrayList();
			dataItemVenda.addAll(listaItensDeVenda);
			tabelaListaitemVenda.setItems(dataItemVenda);
			
		}
	}
}
