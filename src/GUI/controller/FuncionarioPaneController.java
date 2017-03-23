package GUI.controller;

import java.io.IOException;

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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import negocios.PanelaFit;
import negocios.beans.Funcionario;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.xml.bind.ValidationException;
import javafx.scene.input.MouseEvent;
import exceptions.FuncionarioJaExisteException;
import exceptions.FormatacaoInvalidaException;
import exceptions.FuncionarioNaoExisteException;

public class FuncionarioPaneController {

	@FXML
	private Label lblMensagem;

	private PanelaFit panelaFit;

	@FXML
	Button butCadastrar;

	@FXML
	private TextField txtNomeFuncionario;

	@FXML
	private TextField txtCpfFuncionario;

	@FXML
	private TextField txtIdadeFuncionario;

	@FXML
	private TextField txtEnderecoFuncionario;

	@FXML
	private TextField txtTelefoneFuncionario;

	@FXML
	private TextField txtCodigoFuncionario;

	@FXML
	private ChoiceBox<Integer> cbNivel = new ChoiceBox<Integer>(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6));

	@FXML
	private TableView<Funcionario> tabelaFuncionarios;

	@FXML
	TableColumn<Funcionario, String> colunaNome;

	@FXML
	TableColumn<Funcionario, String> colunaCpf;

	@FXML
	TableColumn<Funcionario, String> colunaIdade;

	@FXML
	TableColumn<Funcionario, String> colunaEndereco;

	@FXML
	TableColumn<Funcionario, String> colunaTelefone;

	@FXML
	TableColumn<Funcionario, String> colunaCodigo;

	@FXML
	TableColumn<Funcionario, String> colunaNivel;

	private ObservableList<Funcionario> data;

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

	public void cadastrarFuncionario() throws ValidationException, IOException {

		if (validateFields()) {
			try {
				String nome, cpf, endereco, telefone;
				Integer idade = new Integer(txtIdadeFuncionario.getText());
				Integer codigo = new Integer(txtCodigoFuncionario.getText());
				Integer nivel = new Integer(cbNivel.getSelectionModel().getSelectedItem());
				nome = txtNomeFuncionario.getText();
				cpf = txtCpfFuncionario.getText();
				endereco = txtEnderecoFuncionario.getText();
				telefone = txtTelefoneFuncionario.getText();
				System.out.println(cpf);
				cpf = cpf.replace(".", "").replace("-", "");
				System.out.println(cpf);
				System.out.println(telefone);
				telefone = telefone.replace("(", "").replace(")", "").replace("-", "");
				System.out.println(telefone);
				Funcionario aux = new Funcionario(nivel, codigo, nome, cpf, idade, endereco, telefone);
				validateAttributes(aux);
				panelaFit.cadastrarFuncionario(aux);
				refreshTable();
				limparForm();
				lblMensagem.setText("Funcionario cadastrado");
			} catch (FormatacaoInvalidaException e) {// funcionando
				lblMensagem.setText(e.getMessage());
			} catch (FuncionarioJaExisteException e) {
				lblMensagem.setText(e.getMessage());
			}
		}

	}

	public void removerFuncionario() throws FormatacaoInvalidaException, IOException {
		Funcionario funcionarioSelecionado = tabelaFuncionarios.getSelectionModel().getSelectedItem();
		try {
			if (funcionarioSelecionado != null) {
				Integer codig = new Integer(funcionarioSelecionado.getCodigo());
				if (panelaFit.existeFuncionario(codig)) {
					panelaFit.removerFuncionario(funcionarioSelecionado);
					tabelaFuncionarios.getItems().remove(tabelaFuncionarios.getSelectionModel().getSelectedIndex());
					limparForm();
					refreshTable();
					lblMensagem.setText("Funcionario Removido");

				}
			} else {
				Integer code = new Integer(txtCodigoFuncionario.getText());
				if (panelaFit.existeFuncionario(code)) {
					Funcionario aux = panelaFit.buscarFuncionario(code);
					panelaFit.removerFuncionario(aux);
					refreshTable();
					limparForm();
					lblMensagem.setText("Funcionario Removido");
				}
			}
		} catch (FuncionarioNaoExisteException e) {
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

	public void alterarFuncionario()
			throws FuncionarioNaoExisteException, FormatacaoInvalidaException, ValidationException, IOException {
		if (validateFields()) {
			try {
				String nome, cpf, endereco, telefone;
				Integer idade = new Integer(txtIdadeFuncionario.getText());
				Integer codigo = new Integer(txtCodigoFuncionario.getText());
				Integer nivel = new Integer(cbNivel.getSelectionModel().getSelectedItem());
				nome = txtNomeFuncionario.getText();
				cpf = txtCpfFuncionario.getText();
				endereco = txtEnderecoFuncionario.getText();
				telefone = txtTelefoneFuncionario.getText();
				cpf = cpf.replace(".", "").replace("-", "");
				telefone = telefone.replace("(", "").replace(")", "").replace("-", "");
				Funcionario aux = new Funcionario(nivel, codigo, nome, cpf, idade, endereco, telefone);
				validateAttributes(aux);
				panelaFit.alterarFuncionario(aux);
				refreshTable();
				limparForm();
				lblMensagem.setText("Funcionario aletrado");
			} catch (FormatacaoInvalidaException e) {// funcionando
				lblMensagem.setText(e.getMessage());
			} catch (FuncionarioNaoExisteException e) {
				lblMensagem.setText(e.getMessage());
			}
		}

	}

	public void setDados(ObservableList<Funcionario> dadosFuncionario) {
		tabelaFuncionarios.setItems(dadosFuncionario);
	}

	@FXML
	private void initialize() {
		panelaFit = PanelaFit.getInstance();
		colunaNome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		colunaCpf.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCpf()));
		colunaIdade.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("idade"));
		colunaEndereco.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEndereco()));
		colunaTelefone.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefone()));
		colunaCodigo.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("codigo"));
		colunaNivel.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("nivel"));
		cbNivel.getItems().addAll(1, 2, 3, 4, 5, 6);
		data = FXCollections.observableArrayList();
		data.addAll(panelaFit.listarFuncionarios());
		tabelaFuncionarios.setItems(data);
	}

	@FXML
	public void limparForm() {
		txtNomeFuncionario.clear();
		txtCpfFuncionario.clear();
		txtIdadeFuncionario.clear();
		txtEnderecoFuncionario.clear();
		txtTelefoneFuncionario.clear();
		txtCodigoFuncionario.clear();
		txtCodigoFuncionario.editableProperty().set(true);
		txtCodigoFuncionario.setStyle(null);
		txtNomeFuncionario.setStyle(null);
		cbNivel.setStyle(null);
		cbNivel.getSelectionModel().clearSelection();
		lblMensagem.setText(null);
		tabelaFuncionarios.getSelectionModel().clearSelection();
	}

	private void validateAttributes(Funcionario funcionario) throws ValidationException {
		String returnMs = "";
		Integer idade = funcionario.getIdade();
		Integer codigo = funcionario.getCodigo();
		Integer nivel = funcionario.getNivel();
		if (funcionario.getNome() == null || funcionario.getNome().isEmpty()) {
			returnMs += "'Nome' ";
		}
		if (funcionario.getCpf() == null || funcionario.getCpf().isEmpty()) {
			returnMs += "'CPF' ";
		}
		if (idade.toString() == null || idade.toString().isEmpty()) {
			returnMs += "'Idade' ";
		}
		if (funcionario.getEndereco() == null || funcionario.getEndereco().isEmpty()) {
			returnMs += "'Endereço' ";
		}
		if (funcionario.getTelefone() == null || funcionario.getTelefone().isEmpty()) {
			returnMs += "'Telefone' ";
		}
		if (nivel.toString() == null || nivel.toString().isEmpty()) {
			returnMs += "'Nivel' ";
		}
		if (codigo.toString() == null || codigo.toString().isEmpty()) {
			returnMs += "'Codigo' ";
		}
		if (!returnMs.isEmpty()) {
			throw new ValidationException(
					String.format("Os argumento[%s] obrigatorios estao nulos ou com valores invalidos", returnMs));
		}

	}

	private boolean validateFields() throws IOException {
		boolean validate = false;
		try {
			if ((txtNomeFuncionario.getText().isEmpty() || !txtNomeFuncionario.getText().matches("[a-z A-Z]+"))
					|| (txtCpfFuncionario.getText().isEmpty() || !txtCpfFuncionario.getText()
							.matches("[0-9][0-9][0-9].[0-9][0-9][0-9].[0-9][0-9][0-9]-[0-9][0-9]"))
					|| (txtTelefoneFuncionario.getText().isEmpty() || !txtTelefoneFuncionario.getText()
							.matches("[(][0-9][0-9][)][0-9][0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]"))
					|| (txtIdadeFuncionario.getText().isEmpty() || !txtIdadeFuncionario.getText().matches("[0-9][0-9]"))
					|| txtEnderecoFuncionario.getText().isEmpty()
					|| (txtCodigoFuncionario.getText().isEmpty()
							|| !txtCodigoFuncionario.getText().matches("[0-9][0-9][0-9][0-9][0-9]"))
					|| cbNivel.getSelectionModel().isEmpty()) {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/view/PopUpTela.fxml"));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.initStyle(StageStyle.UNDECORATED);
				stage.setTitle("Panela Fit");
				stage.setScene(new Scene(root1));
				stage.show();
				if (txtNomeFuncionario.getText().isEmpty() || !txtNomeFuncionario.getText().matches("[a-z A-Z]+")) {
					txtNomeFuncionario.setStyle("-fx-background-color: red;");
				}
				if (cbNivel.getSelectionModel().isEmpty()) {
					cbNivel.setStyle("-fx-background-color: red;");
				}
			} else {
				lblMensagem.setText("DEU");
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
		data.addAll(panelaFit.listarFuncionarios());
		tabelaFuncionarios.setItems(data);
	}

	@FXML
	public void selecionarFuncionario(MouseEvent arg0) {
		if (!tabelaFuncionarios.getSelectionModel().isEmpty()) {
			Funcionario f = tabelaFuncionarios.getSelectionModel().getSelectedItem();
			Integer codigo = f.getCodigo();
			Integer idade = f.getIdade();
			Integer nivel = f.getNivel();
			txtNomeFuncionario.setText(f.getNome());
			txtCpfFuncionario.setText(f.getCpf());
			txtEnderecoFuncionario.setText(f.getEndereco());
			txtTelefoneFuncionario.setText(f.getTelefone());
			txtCodigoFuncionario.setText(codigo.toString());
			cbNivel.getSelectionModel().select(nivel);
			txtIdadeFuncionario.setText(idade.toString());
			char[] a = txtCpfFuncionario.getText().toCharArray();
			String cpf = "";
			for (int i = 0; i < a.length; i++) {
				if (i == 2 || i == 5) {
					cpf += a[i] + ".";
				} else if (i == 8) {
					cpf += a[i] + "-";
				} else {
					cpf += a[i];
				}
			}
			txtCpfFuncionario.setText(cpf);
			char[] b = txtTelefoneFuncionario.getText().toCharArray();
			String telefone = "";
			for (int i = 0; i < b.length; i++) {
				if (i == 0) {
					telefone += "(" + b[i];
				} else if (i == 1) {
					telefone += b[i] + ")";
				} else if (i == 6) {
					telefone += b[i] + "-";
				} else {
					telefone += b[i];
				}
			}
			txtTelefoneFuncionario.setText(telefone);
			txtCodigoFuncionario.editableProperty().set(false);
			txtCodigoFuncionario.setStyle("-fx-background-color: grey;");

		}
	}

	@FXML
	public void buscarFuncionario() throws FuncionarioNaoExisteException, IOException {
		Funcionario f;
		try {
			Integer code = new Integer(txtCodigoFuncionario.getText());
			f = panelaFit.buscarFuncionario(code);
			Integer codigo = f.getCodigo();
			Integer nivel = f.getNivel();
			Integer idade = f.getIdade();
			txtNomeFuncionario.setText(f.getNome());
			txtCpfFuncionario.setText(f.getCpf());
			txtEnderecoFuncionario.setText(f.getEndereco());
			txtTelefoneFuncionario.setText(f.getTelefone());
			txtCodigoFuncionario.setText(codigo.toString());
			cbNivel.getSelectionModel().select(nivel);
			txtIdadeFuncionario.setText(idade.toString());
			char[] a = txtCpfFuncionario.getText().toCharArray();
			String cpf = "";
			for (int i = 0; i < a.length; i++) {
				if (i == 2 || i == 5) {
					cpf += a[i] + ".";
				} else if (i == 8) {
					cpf += a[i] + "-";
				} else {
					cpf += a[i];
				}
			}
			txtCpfFuncionario.setText(cpf);
			char[] b = txtTelefoneFuncionario.getText().toCharArray();
			String telefone = "";
			for (int i = 0; i < b.length; i++) {
				if (i == 0) {
					telefone += "(" + b[i];
				} else if (i == 1) {
					telefone += b[i] + ")";
				} else if (i == 6) {
					telefone += b[i] + "-";
				} else {
					telefone += b[i];
				}
			}
			txtTelefoneFuncionario.setText(telefone);
			txtCodigoFuncionario.editableProperty().set(false);
			txtCodigoFuncionario.setStyle("-fx-background-color: grey;");
		} catch (NumberFormatException e) {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/view/PopUpTela.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setTitle("Panela Fit");
			stage.setScene(new Scene(root1));
			stage.show();
		} catch (FuncionarioNaoExisteException e) {
			lblMensagem.setText(e.getMessage());
		}

	}
}
