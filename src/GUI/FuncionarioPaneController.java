package GUI;

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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import negocios.Cliente;
import negocios.Funcionario;
import negocios.PanelaFit;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javax.xml.bind.ValidationException;
import javafx.scene.input.MouseEvent;

import exceptions.FuncionarioJaExisteException;
import exceptions.ClienteJaExisteException;
import exceptions.ClienteNaoExisteException;
import exceptions.FormatacaoInvalidaException;
import exceptions.FuncionarioNaoExisteException;
import exceptions.FuncionarioJaExisteException;

public class FuncionarioPaneController {
	
	@FXML
	private Label lblMensagem;
	
	private PanelaFit panelaFit;
	
	private PanelaFitApp panelaFitApp;
	
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
	private TextField txtNivelFuncionario;
	
	@FXML
	private TableView<Funcionario> tabelaFuncionarios;
	
	@FXML
	TableColumn<Funcionario,String> colunaNome;
	
	@FXML
	TableColumn<Funcionario,String> colunaCpf;
	
	@FXML
	TableColumn<Funcionario,String> colunaIdade;
	
	@FXML
	TableColumn<Funcionario,String> colunaEndereco;
	
	@FXML
	TableColumn<Funcionario,String> colunaTelefone;
	
	@FXML
	TableColumn<Funcionario,String> colunaCodigo;
	
	@FXML
	TableColumn<Funcionario,String> colunaNivel;
	
	private ObservableList<Funcionario> data;
	
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
	
	public void cadastrarFuncionario() throws ValidationException, IOException, FuncionarioNaoExisteException {
		String nome, cpf, endereco, telefone;
		Integer idade = new Integer(txtIdadeFuncionario.getText());
		Integer codigo = new Integer(txtCodigoFuncionario.getText());
		Integer nivel = new Integer(txtNivelFuncionario.getText());
		nome = txtNomeFuncionario.getText();
		cpf = txtCpfFuncionario.getText();
		endereco = txtEnderecoFuncionario.getText();
		telefone = txtTelefoneFuncionario.getText();
		
		validateFields();
		
		if(!nome.equals("") && !cpf.equals("") && !idade.equals("") && !endereco.equals("") && !telefone.equals("") && !nivel.equals("") && !codigo.equals("")) {
			try {
				Funcionario aux = new Funcionario(nivel, codigo, nome, cpf, idade,  endereco, telefone);
				validateAttributes(aux);
				panelaFit.cadastrarFuncionario(aux);
				refreshTable();
				limparForm();
				lblMensagem.setText("Funcionario cadastrado");
			}catch(FormatacaoInvalidaException e){//funcionando
				lblMensagem.setText(e.getMessage());
			}catch(FuncionarioJaExisteException e){
				lblMensagem.setText(e.getMessage());
				
			}
		}
		
	}
	
	public void removerFuncionario() throws FormatacaoInvalidaException{
		try{
			Funcionario funcionarioSelecionado = tabelaFuncionarios.getSelectionModel().getSelectedItem();
			if(funcionarioSelecionado != null){
				panelaFit.removerFuncionario(funcionarioSelecionado);
				lblMensagem.setText("funcionario Removido");
				tabelaFuncionarios.getItems().remove(tabelaFuncionarios.getSelectionModel().getSelectedIndex());
				limparForm();
				refreshTable();
			}else {
				 Alert alert = new Alert(AlertType.WARNING);
		            alert.initOwner(panelaFitApp.getPrimaryStage());
		            alert.setTitle("Sem seleção");
		            alert.setHeaderText("Nenhuma conta selecionada");
		            alert.setContentText("Por favor, selecione uma conta na tabela.");

		            alert.showAndWait();
			}
		}catch(FuncionarioNaoExisteException e){
			lblMensagem.setText(e.getMessage());
		}
	}
	
	public void alterarFuncionario() throws FuncionarioNaoExisteException, FuncionarioJaExisteException, FormatacaoInvalidaException, ValidationException{
		String nome, cpf, endereco, telefone;
		Integer idade = new Integer(txtIdadeFuncionario.getText());
		Integer codigo = new Integer(txtCodigoFuncionario.getText());
		Integer nivel = new Integer(txtNivelFuncionario.getText());
		nome = txtNomeFuncionario.getText();
		cpf = txtCpfFuncionario.getText();
		endereco = txtEnderecoFuncionario.getText();
		telefone = txtTelefoneFuncionario.getText();
		
		if(!nome.equals("") && !cpf.equals("") && !idade.equals("") && 
				!endereco.equals("") && !telefone.equals("") && !nivel.equals("") && !codigo.equals("")){
			try{
				Funcionario aux = new Funcionario(nivel, codigo, nome, cpf, idade, endereco, telefone);
				validateAttributes(aux);
				panelaFit.alterarFuncionario(aux);;
				refreshTable();
				limparForm();
				lblMensagem.setText("Funcionario aletrado");
			}catch(FormatacaoInvalidaException e){//funcionando
				lblMensagem.setText(e.getMessage());
			}catch(FuncionarioJaExisteException e){
				lblMensagem.setText(e.getMessage());
			}catch(FuncionarioNaoExisteException e){
				lblMensagem.setText(e.getMessage());
			}
		}
		
	}
	
	public void setDadis(ObservableList<Funcionario> dadosFuncionario){
		tabelaFuncionarios.setItems(dadosFuncionario);
	}
	
	@FXML 
	private void initialize(){
		panelaFit = PanelaFit.getInstance();
		colunaNome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		colunaCpf.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCpf()));
		colunaIdade.setCellValueFactory(new PropertyValueFactory<Funcionario,String>("idade"));
		colunaEndereco.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEndereco()));
		colunaTelefone.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefone()));
		colunaCodigo.setCellValueFactory(new PropertyValueFactory<Funcionario,String>("codigo"));
		colunaNivel.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("nivel"));		
		data = FXCollections.observableArrayList();
		data.addAll(panelaFit.listarFuncionarios());
		tabelaFuncionarios.setItems(data);
	}
	
	@FXML
	public void limparForm(){
		txtNomeFuncionario.clear();
		txtCpfFuncionario.clear();
		txtIdadeFuncionario.clear();
		txtEnderecoFuncionario.clear();
		txtTelefoneFuncionario.clear();
		txtCodigoFuncionario.clear();
		txtNivelFuncionario.clear();
		
	}
	
	private void validateAttributes(Funcionario funcionario) throws ValidationException {
		String returnMs="";
		Integer idade = funcionario.getIdade();
		Integer codigo = funcionario.getCodigo();
		Integer nivel = funcionario.getNivel();
		if(funcionario.getNome() == null || funcionario.getNome().isEmpty()){
			returnMs += "'Nome' ";
		}
		if(funcionario.getCpf() == null || funcionario.getCpf().isEmpty()){
			returnMs += "'CPF' ";
		}
		if(idade.toString()==null || idade.toString().isEmpty()){
			returnMs += "'Idade' ";
		}
		if(funcionario.getEndereco()==null || funcionario.getEndereco().isEmpty()){
			returnMs += "'EndereÃ§o' ";
		}
		if(funcionario.getTelefone()==null || funcionario.getTelefone().isEmpty()){
			returnMs +="'Telefone' ";
		}
		if(nivel.toString() == null || nivel.toString().isEmpty()) {
			returnMs += "'Nivel' ";
		}
		if(codigo.toString()==null || codigo.toString().isEmpty()){
			returnMs +="'Codigo' ";
		}
			if(!returnMs.isEmpty()){
				throw new ValidationException(String.format("Os argumento[%s] obrigatorios estao nulos ou com valores invalidos", returnMs));
			}
		
	}
	
	private void validateFields() throws IOException {
		Parent root;
		Stage stage;
		try{
			String nome, cpf, endereco, telefone;
			Integer idade = new Integer(txtIdadeFuncionario.getText());
			Integer codigo = new Integer(txtCodigoFuncionario.getText());
			Integer nivel = new Integer(txtNivelFuncionario.getText());
			nome = txtNomeFuncionario.getText();
			cpf = txtCpfFuncionario.getText();
			endereco = txtEnderecoFuncionario.getText();
			telefone = txtTelefoneFuncionario.getText();
			
		} catch(NumberFormatException e){
			e.getMessage();
			stage = (Stage) butCadastrar.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("/GUI/PopUpTela.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
		}
		
	}
	
	@FXML 
	private void refreshTable(){
		data = FXCollections.observableArrayList();
		data.addAll(panelaFit.listarFuncionarios());
		tabelaFuncionarios.setItems(data);
	}
	
	@FXML
	public void selecionarFuncionario(MouseEvent arg0) {
		Funcionario f = tabelaFuncionarios.getSelectionModel().getSelectedItem();
        Integer codigo = f.getCodigo();
		Integer idade = f.getIdade(); 
		Integer nivel = f.getNivel();
		txtNomeFuncionario.setText(f.getNome());
        txtCpfFuncionario.setText(f.getCpf());
        txtEnderecoFuncionario.setText(f.getEndereco());
        txtTelefoneFuncionario.setText(f.getTelefone());
        txtCodigoFuncionario.setText(codigo.toString());
        txtNivelFuncionario.setText(nivel.toString());
        txtIdadeFuncionario.setText(idade.toString());
	}
	
	@FXML 
	public void buscarFuncionario() throws FuncionarioNaoExisteException {
		Funcionario f;
		Integer code = new Integer(txtCodigoFuncionario.getText());
			if(!code.toString().trim().isEmpty()){
				try{
					f = panelaFit.buscarFuncionario(code);
					Integer codigo = f.getCodigo();
					Integer nivel = f.getNivel();
					Integer idade = f.getIdade(); 
					
					txtNomeFuncionario.setText(f.getNome());
			        txtCpfFuncionario.setText(f.getCpf());
			        txtEnderecoFuncionario.setText(f.getEndereco());
			        txtTelefoneFuncionario.setText(f.getTelefone());
			        txtCodigoFuncionario.setText(codigo.toString());
			        txtNivelFuncionario.setText(nivel.toString());
			        txtIdadeFuncionario.setText(idade.toString());
				}catch(FuncionarioNaoExisteException e){
					lblMensagem.setText(e.getMessage());
				}
			}
	}
	
	
}
