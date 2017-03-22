package GUI.controller;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import javax.xml.bind.ValidationException;
import exceptions.FormatacaoInvalidaException;
import exceptions.ProdutoJaExisteException;
import exceptions.ProdutoNaoExisteException;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import negocios.PanelaFit;
import negocios.beans.Produto;

public class ProdutoPaneController {

	private PanelaFit panelaFit;

	@FXML
	Button butCadastrar;

	@FXML
	private Label lblMensagem;

	@FXML
	private TextField txtNomeProduto;

	@FXML
	private TextField txtPesoProduto;

	@FXML
	private TextField txtCaloriasProduto;

	@FXML
	private TextField txtCodigoProduto;

	@FXML
	private TextField txtQuantEstoqueProduto;

	@FXML
	private TextField txtPrecoProduto;

	@FXML
	private TextField txtDataFab;

	@FXML
	private TextField txtDataVal;

	@FXML
	private TableView<Produto> tabelaProdutos;

	@FXML
	TableColumn<Produto, String> colunaNome;

	@FXML
	TableColumn<Produto, String> colunaCodigo;

	@FXML
	TableColumn<Produto, String> colunaPeso;

	@FXML
	TableColumn<Produto, String> colunaCalorias;

	@FXML
	TableColumn<Produto, String> colunaQuantEstoque;

	@FXML
	TableColumn<Produto, String> colunaPreco;

	@FXML
	TableColumn<Produto, String> colunaDataFab;

	@FXML
	TableColumn<Produto, String> colunaDataVal;

	public DateTimeFormatter DATE_FORMAT = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();

	private ObservableList<Produto> data;

	public void sair(ActionEvent event) {
		((Node) event.getSource()).getScene().getWindow().hide();

	}

	public void voltarMenuPrincipal(ActionEvent event) {
		((Node) event.getSource()).getScene().getWindow().hide();
		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource("/GUI/view/PanelaFit.fxml"));
			Stage stage3 = new Stage();
			Scene cena = new Scene(parent);
			stage3.setScene(cena);
			stage3.show();
		} catch (IOException e) {
			lblMensagem.setText(e.getMessage());
		}
	}

	public void cadastrarProduto() throws ValidationException, IOException {
		if (validateFields()) {
			try {
				String nome;
				Integer codigo = new Integer(txtCodigoProduto.getText());
				Integer calorias = new Integer(txtCaloriasProduto.getText());
				Integer quantEstoque = new Integer(txtQuantEstoqueProduto.getText());
				Float peso = new Float(txtPesoProduto.getText().replace("K", "").replace("G", ""));
				Double preco = new Double(txtPrecoProduto.getText().replace("R", "").replace("$", ""));
				LocalDate dataFab = LocalDate.parse(txtDataFab.getText(), DATE_FORMAT);
				LocalDate dataVal = LocalDate.parse(txtDataVal.getText(), DATE_FORMAT);
				nome = txtNomeProduto.getText();
				Produto aux = new Produto(nome, peso, calorias, codigo, quantEstoque, preco, dataFab, dataVal);
				validateAttributes(aux);
				panelaFit.cadastrarProduto(aux);
				refreshTable();
				limparForm();
				lblMensagem.setText("Produto Cadastrado");
			} catch (FormatacaoInvalidaException e) {
				lblMensagem.setText(e.getMessage());
			} catch (ProdutoJaExisteException e) {
				lblMensagem.setText(e.getMessage());
			} catch (DateTimeException e) {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/view/PopUpTela.fxml"));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.initStyle(StageStyle.UNDECORATED);
				stage.setTitle("Panela Fit");
				stage.setScene(new Scene(root1));
				stage.show();
				txtDataFab.setStyle("-fx-background-color: red;");
				txtDataVal.setStyle("-fx-background-color: red;");
			}
		}
	}

	public void removerProduto() throws FormatacaoInvalidaException, ProdutoNaoExisteException, IOException {
		Produto produtoSelecionado = tabelaProdutos.getSelectionModel().getSelectedItem();
		try {
			if (produtoSelecionado != null) {
				Integer codig = new Integer(produtoSelecionado.getCodigo());
				if (panelaFit.existeProduto(codig)) {
					panelaFit.removerProduto(produtoSelecionado);
					tabelaProdutos.getItems().remove(tabelaProdutos.getSelectionModel().getSelectedIndex());
					limparForm();
					refreshTable();
					lblMensagem.setText("Produto Removido");
				}
			} else {
				Integer code = new Integer(txtCodigoProduto.getText());
				if (panelaFit.existeProduto(code)) {
					Produto aux = panelaFit.buscarProduto(code);
					panelaFit.removerProduto(aux);
					refreshTable();
					limparForm();
					lblMensagem.setText("Produto Removido");
				}
			}
		} catch (ProdutoNaoExisteException e) {
			lblMensagem.setText(e.getMessage());
		} catch (NumberFormatException e) {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/view/PopUpTela.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setTitle("Panela Fit");
			stage.setScene(new Scene(root1));
			stage.show();
		}
	}

	public void alterarProduto()
			throws ProdutoNaoExisteException, FormatacaoInvalidaException, ValidationException, IOException {
		if (validateFields()) {
			try {
				String nome;
				Integer codigo = new Integer(txtCodigoProduto.getText());
				Integer calorias = new Integer(txtCaloriasProduto.getText());
				Integer quantEstoque = new Integer(txtQuantEstoqueProduto.getText());
				Float peso = new Float(txtPesoProduto.getText().replace("K", "").replace("G", ""));
				Double preco = new Double(txtPrecoProduto.getText().replace("R", "").replace("$", ""));
				LocalDate dataFab = LocalDate.parse(txtDataFab.getText(), DATE_FORMAT);
				LocalDate dataVal = LocalDate.parse(txtDataVal.getText(), DATE_FORMAT);
				nome = txtNomeProduto.getText();
				Produto aux = new Produto(nome, peso, calorias, codigo, quantEstoque, preco, dataFab, dataVal);
				validateAttributes(aux);
				panelaFit.alterarProduto(aux);
				refreshTable();
				limparForm();
				lblMensagem.setText("Produto alterado");
			} catch (FormatacaoInvalidaException e) {
				lblMensagem.setText(e.getMessage());
			} catch (ProdutoNaoExisteException e) {
				lblMensagem.setText(e.getMessage());
			} catch (NumberFormatException e) {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/view/PopUpTela.fxml"));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.initStyle(StageStyle.UNDECORATED);
				stage.setTitle("Panela Fit");
				stage.setScene(new Scene(root1));
				stage.show();
			} catch (DateTimeException e) {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/view/PopUpTela.fxml"));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.initStyle(StageStyle.UNDECORATED);
				stage.setTitle("Panela Fit");
				stage.setScene(new Scene(root1));
				stage.show();
				txtDataFab.setStyle("-fx-background-color: red;");
				txtDataVal.setStyle("-fx-background-color: red;");
			}
		}
	}

	public void setDados(ObservableList<Produto> dadosProduto) {
		tabelaProdutos.setItems(dadosProduto);
	}

	@FXML
	private void initialize() {
		panelaFit = PanelaFit.getInstance();
		colunaNome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		colunaCalorias.setCellValueFactory(new PropertyValueFactory<Produto, String>("Calorias"));
		colunaCodigo.setCellValueFactory(new PropertyValueFactory<Produto, String>("Codigo"));
		colunaPeso.setCellValueFactory(new PropertyValueFactory<Produto, String>("Peso"));
		colunaPreco.setCellValueFactory(new PropertyValueFactory<Produto, String>("Preco"));
		colunaQuantEstoque.setCellValueFactory(new PropertyValueFactory<Produto, String>("QuantEstoque"));
		colunaDataFab.setCellValueFactory(new PropertyValueFactory<Produto, String>("DataFabricacao"));
		colunaDataVal.setCellValueFactory(new PropertyValueFactory<Produto, String>("DataValidade"));

		data = FXCollections.observableArrayList();
		data.addAll(panelaFit.listarProdutos());
		tabelaProdutos.setItems(data);
	}

	@FXML
	public void limparForm() {
		txtNomeProduto.clear();
		txtPesoProduto.clear();
		txtCaloriasProduto.clear();
		txtPrecoProduto.clear();
		txtQuantEstoqueProduto.clear();
		txtDataFab.clear();
		txtDataVal.clear();
		txtCodigoProduto.clear();
		txtCodigoProduto.editableProperty().set(true);
		txtCodigoProduto.setStyle(null);
		txtNomeProduto.setStyle(null);
		txtCaloriasProduto.setStyle(null);
		txtQuantEstoqueProduto.setStyle(null);
		txtDataFab.setStyle(null);
		txtDataVal.setStyle(null);
		lblMensagem.setText(null);
		tabelaProdutos.getSelectionModel().clearSelection();
	}

	private void validateAttributes(Produto produto) throws ValidationException {
		String returnMs = "";
		Integer codigo = produto.getCodigo();
		Float peso = produto.getPeso();
		Integer calorias = produto.getCalorias();
		Integer quantEstoque = produto.getQuantEstoque();
		Double preco = produto.getPreco();
		if (produto.getNome() == null || produto.getNome().isEmpty()) {
			returnMs += "'Nome' ";
		}
		if (peso.toString() == null || peso.toString().isEmpty()) {
			returnMs += "'Peso' ";
		}
		if (calorias.toString() == null || calorias.toString().isEmpty()) {
			returnMs += "'Calorias '";
		}
		if (quantEstoque.toString() == null || quantEstoque.toString().isEmpty()) {
			returnMs += "'QuantidadeEstoque' ";
		}
		if (preco.toString() == null || preco.toString().isEmpty()) {
			returnMs += "'Preco' ";
		}
		if (codigo.toString() == null || codigo.toString().isEmpty()) {
			returnMs += "'Codigo' ";
		}
		if (produto.getDataFabricacao() == null) {
			returnMs += "'DataFabricacao' ";
		}
		if (produto.getDataValidade() == null) {
			returnMs += "'DataValidade' ";
		}
		if (!returnMs.isEmpty()) {
			throw new ValidationException(
					String.format("Os arumentos[%s] obrigatorios estao nulos ou com valores invalidos", returnMs));
		}

	}

	private boolean validateFields() throws IOException {
		boolean validate = false;
		try {
			if ((txtNomeProduto.getText().isEmpty() || !txtNomeProduto.getText().matches("[a-z A-Z]+"))
					|| (txtCodigoProduto.getText().isEmpty()
							|| !txtCodigoProduto.getText().matches("[0-9][0-9][0-9][0-9][0-9]"))
					|| (txtPesoProduto.getText().isEmpty() || !txtPesoProduto.getText().matches("[0-9][0-9][0-9]G"))
					|| (txtCaloriasProduto.getText().isEmpty() || !txtCaloriasProduto.getText().matches("[0-9]+"))
					|| (txtPrecoProduto.getText().isEmpty()
							|| !txtPrecoProduto.getText().matches("[R][$][0-9][0-9][0-9]"))
					|| (txtQuantEstoqueProduto.getText().isEmpty()
							|| !txtQuantEstoqueProduto.getText().matches("[0-9]+"))
					|| (txtDataFab.getText().isEmpty()
							|| !txtDataFab.getText().matches("[0-9][0-9][/][0-9][0-9][/][0-9][0-9][0-9][0-9]"))
					|| (txtDataVal.getText().isEmpty()
							|| !txtDataVal.getText().matches("[0-9][0-9][/][0-9][0-9][/][0-9][0-9][0-9][0-9]"))) {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/view/PopUpTela.fxml"));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.initStyle(StageStyle.UNDECORATED);
				stage.setTitle("Panela Fit");
				stage.setScene(new Scene(root1));
				stage.show();
				if (txtNomeProduto.getText().isEmpty() || !txtNomeProduto.getText().matches("[a-z A-Z]+")) {
					txtNomeProduto.setStyle("-fx-background-color: red;");
				}
				if (txtCaloriasProduto.getText().isEmpty() || !txtCaloriasProduto.getText().matches("[0-9]+")) {
					txtCaloriasProduto.setStyle("-fx-background-color: red;");
				}
				if (txtQuantEstoqueProduto.getText().isEmpty() || !txtQuantEstoqueProduto.getText().matches("[0-9]+")) {
					txtQuantEstoqueProduto.setStyle("-fx-background-color: red;");
				}
			} else {
				validate = true;
			}
		} catch (NumberFormatException e) {
			e.getMessage();

		}
		return validate;
	}

	@FXML
	private void refreshTable() {
		data = FXCollections.observableArrayList();
		data.addAll(panelaFit.listarProdutos());
		tabelaProdutos.setItems(data);
	}

	@FXML
	public void selecionarProduto(MouseEvent arg0) {
		if (!tabelaProdutos.getSelectionModel().isEmpty()) {
			Produto produtoSelecionado = tabelaProdutos.getSelectionModel().getSelectedItem();
			Integer codigo = produtoSelecionado.getCodigo();
			Integer calorias = produtoSelecionado.getCalorias();
			Integer quantEstoque = produtoSelecionado.getQuantEstoque();
			Float peso = produtoSelecionado.getPeso();
			Double preco = produtoSelecionado.getPreco();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			txtDataFab.setText(formatter.format(produtoSelecionado.getDataFabricacao()));
			txtDataVal.setText(formatter.format(produtoSelecionado.getDataValidade()));
			txtNomeProduto.setText(produtoSelecionado.getNome());
			txtCodigoProduto.setText(codigo.toString());
			txtCaloriasProduto.setText(calorias.toString());
			txtQuantEstoqueProduto.setText(quantEstoque.toString());
			txtPesoProduto.setText(peso.toString());
			char[] a = txtPesoProduto.getText().toCharArray();
			String pesoPesado = "";
			for (int i = 0; i < a.length; i++) {
				if (i == 4) {
					pesoPesado += a[i] + "G";
				} else {
					pesoPesado += a[i];
				}
			}
			txtPesoProduto.setText(pesoPesado);
			preco.toString();
			txtPrecoProduto.setText(String.format("%.0f", preco));
			char[] b = txtPrecoProduto.getText().toCharArray();
			String price = "";
			for (int i = 0; i < b.length; i++) {
				if (i == 0) {
					price += "R$" + b[i];
				} else {
					price += b[i];
				}
			}
			txtPrecoProduto.setText(price);
			txtCodigoProduto.editableProperty().set(false);
			txtCodigoProduto.setStyle("-fx-background-color: gray;");
		}
	}

	@FXML
	public void buscarProduto() throws ProdutoNaoExisteException, IOException {
		Produto p;
		try {
			Integer code = new Integer(txtCodigoProduto.getText());
			p = panelaFit.buscarProduto(code);
			Integer codigo = p.getCodigo();
			Integer calorias = p.getCalorias();
			Integer quantEstoque = p.getQuantEstoque();
			Float peso = p.getPeso();
			Double preco = p.getPreco();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			txtDataFab.setText(formatter.format(p.getDataFabricacao()));
			txtDataVal.setText(formatter.format(p.getDataValidade()));
			txtNomeProduto.setText(p.getNome());
			txtCodigoProduto.setText(codigo.toString());
			txtCaloriasProduto.setText(calorias.toString());
			txtQuantEstoqueProduto.setText(quantEstoque.toString());
			txtPesoProduto.setText(peso.toString());
			char[] a = txtPesoProduto.getText().toCharArray();
			String pesoPesado = "";
			for (int i = 0; i < a.length; i++) {
				if (i == 4) {
					pesoPesado += a[i] + "G";
				} else {
					pesoPesado += a[i];
				}
			}
			txtPesoProduto.setText(pesoPesado);
			preco.toString();
			txtPrecoProduto.setText(String.format("%.0f", preco));
			char[] b = txtPrecoProduto.getText().toCharArray();
			String price = "";
			for (int i = 0; i < b.length; i++) {
				if (i == 0) {
					price += "R$" + b[i];
				} else {
					price += b[i];
				}
			}
			txtPrecoProduto.setText(price);
			txtCodigoProduto.editableProperty().set(false);
			txtCodigoProduto.setStyle("-fx-background-color: gray;");
		} catch (NumberFormatException e) {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/view/PopUpTela.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setTitle("Panela Fit");
			stage.setScene(new Scene(root1));
			stage.show();
		} catch (ProdutoNaoExisteException e) {
			lblMensagem.setText(e.getMessage());
		}
	}
}
