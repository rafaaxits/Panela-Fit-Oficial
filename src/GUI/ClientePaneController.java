package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import negocios.Cliente;
import negocios.PanelaFit;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javax.xml.bind.ValidationException;
import exceptions.FormatacaoInvalidaException;
import exceptions.ClienteNaoExisteException;
import exceptions.ClienteJaExisteException;
public class ClientePaneController {
		
	private PanelaFit panelaFit;
	
	private PanelaFitApp panelaFitApp;
	@FXML 
	Button butCadastrar;
	
	@FXML
	private Label lblMensagem;
	
	@FXML
	private TextField txtNomeCliente;
	
	@FXML
	private TextField txtCpfCliente;
	
	@FXML
	private TextField txtIdadeCliente;
	
	@FXML
	private TextField txtEndereçoCliente;
	
	@FXML
	private TextField txtTelefoneCliente;
	
	@FXML
	private TextField txtCodigoCliente;
	
	
	@FXML
	private TableView<Cliente> tabelaClientes;
	
	@FXML
	TableColumn<Cliente,String> colunaNome;
	
	@FXML
	TableColumn<Cliente,String> colunaCpf;
	
	@FXML
	TableColumn<Cliente,String> colunaIdade;
	
	@FXML
	TableColumn<Cliente,String> colunaEndereço;
	
	@FXML
	TableColumn<Cliente,String> colunaTelefone;
	
	@FXML
	TableColumn<Cliente,String> colunaCodigo;
	
	private ObservableList<Cliente> data;
	
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
	public void cadastrarCliente() throws ValidationException, IOException {
				String nome, cpf, end, telefone;
				Integer codigo = new Integer (txtCodigoCliente.getText());
				Integer idade = new Integer (txtIdadeCliente.getText());
				nome=txtNomeCliente.getText();
				cpf=txtCpfCliente.getText();
				end=txtEndereçoCliente.getText();
				telefone=txtTelefoneCliente.getText();
				
				validateFields();
				
				if(!nome.equals("") && !cpf.equals("") && !idade.equals("") && 
						!end.equals("") && !telefone.equals("") && !codigo.equals("")){
					try{
						Cliente aux = new Cliente(codigo, nome, cpf, idade, end, telefone);
						validateAttributes(aux);
						panelaFit.cadastrarCliente(aux);
						refreshTable();
						limparForm();
						lblMensagem.setText("Cliente cadastrado");
					}catch(FormatacaoInvalidaException e){//funcionando
						lblMensagem.setText(e.getMessage());
					}catch(ClienteJaExisteException e){
						lblMensagem.setText(e.getMessage());
					
					}
			}	
	}
	public void removerCliente() throws FormatacaoInvalidaException{
			try{
				Cliente clienteSelecionado = tabelaClientes.getSelectionModel().getSelectedItem();
				if(clienteSelecionado != null){
					panelaFit.removerCliente(clienteSelecionado);
					lblMensagem.setText("Cliente Removido");
					tabelaClientes.getItems().remove(tabelaClientes.getSelectionModel().getSelectedIndex());
					limparForm();
					refreshTable();
				}else if(clienteSelecionado == null && !txtCodigoCliente.getText().isEmpty()){
					Integer code = new Integer (txtCodigoCliente.getText());
					if(panelaFit.existeCliente(code)==true){
					Cliente aux = panelaFit.buscarCliente(code);
					panelaFit.removerCliente(aux);
					refreshTable();
					lblMensagem.setText("Cliente Removido");
					limparForm();
					
					}
				}
				else {
					 Alert alert = new Alert(AlertType.WARNING);
			            alert.initOwner(panelaFitApp.getPrimaryStage());
			            alert.setTitle("Sem seleção");
			            alert.setHeaderText("Nenhuma conta selecionada");
			            alert.setContentText("Por favor, selecione uma conta na tabela.");

			            alert.showAndWait();
				}
			}catch(ClienteNaoExisteException e){
				lblMensagem.setText(e.getMessage());
			}
		}
		
	public void alterarCliente() throws ClienteNaoExisteException, ClienteJaExisteException, FormatacaoInvalidaException, ValidationException{
		String nome, cpf, end, telefone;
		Integer codigo = new Integer (txtCodigoCliente.getText());
		Integer idade = new Integer (txtIdadeCliente.getText());
		nome=txtNomeCliente.getText();
		cpf=txtCpfCliente.getText();
		end=txtEndereçoCliente.getText();
		telefone=txtTelefoneCliente.getText();
		if(!nome.equals("") && !cpf.equals("") && !idade.equals("") && 
				!end.equals("") && !telefone.equals("") && !codigo.equals("")){
			try{
				Cliente aux = new Cliente(codigo, nome, cpf, idade, end, telefone);
				validateAttributes(aux);
				panelaFit.alterarCliente(aux);;
				refreshTable();
				limparForm();
				lblMensagem.setText("Cliente aletrado");
			}catch(FormatacaoInvalidaException e){//funcionando
				lblMensagem.setText(e.getMessage());
			}catch(ClienteJaExisteException e){
				lblMensagem.setText(e.getMessage());
			}catch(ClienteNaoExisteException e){
				lblMensagem.setText(e.getMessage());
			}
		}
	}
	public void setDados(ObservableList<Cliente> dadosCliente){
				tabelaClientes.setItems(dadosCliente);
	}
	
	@FXML
	private void initialize(){
		
		panelaFit = PanelaFit.getInstance();
		
		colunaNome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		colunaCpf.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCpf()));
		colunaIdade.setCellValueFactory(new PropertyValueFactory<Cliente,String>("idade"));
		colunaEndereço.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEndereco()));
		colunaTelefone.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefone()));
		colunaCodigo.setCellValueFactory(new PropertyValueFactory<Cliente,String>("codigo"));
		
		data = FXCollections.observableArrayList();
		data.addAll(panelaFit.listarClientes());
		tabelaClientes.setItems(data);
	}
	
	@FXML
    public void limparForm() {
		txtNomeCliente.clear();
		txtCpfCliente.clear();
		txtIdadeCliente.clear();
		txtEndereçoCliente.clear();
		txtTelefoneCliente.clear();
		txtCodigoCliente.clear();
        txtCodigoCliente.editableProperty().set(true);

    }
	
	private void validateAttributes(Cliente cliente) throws ValidationException{
		String returnMs="";
		Integer idade = cliente.getIdade();
		Integer codigo = cliente.getCodigo();
		if(cliente.getNome() == null || cliente.getNome().isEmpty()){
			returnMs += "'Nome' ";
		}
		if(cliente.getCpf() == null || cliente.getCpf().isEmpty()){
			returnMs += "'CPF' ";
		}
		if(idade.toString()==null || idade.toString().isEmpty()){
			returnMs += "'Idade' ";
		}
		if(cliente.getEndereco()==null || cliente.getEndereco().isEmpty()){
			returnMs += "'Endereço' ";
		}
		if(cliente.getTelefone()==null || cliente.getTelefone().isEmpty()){
			returnMs +="'Telefone' ";
		}
		if(codigo.toString()==null || codigo.toString().isEmpty()){
			returnMs +="'Codigo' ";
		}
			if(!returnMs.isEmpty()){
				throw new ValidationException(String.format("Os argumento[%s] obrigatorios estao nulos ou com valores invalidos", returnMs));
			}
	}
	
	private void validateFields() throws IOException{
		Parent root;
		Stage stage;
		try{
			String nome, cpf, end, telefone;
			Integer	codigo = new Integer (txtCodigoCliente.getText());
			Integer idade = new Integer (txtIdadeCliente.getText());
			nome=txtNomeCliente.getText();
			cpf=txtCpfCliente.getText();
			end=txtEndereçoCliente.getText();
			telefone=txtTelefoneCliente.getText();
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
		data.addAll(panelaFit.listarClientes());
		tabelaClientes.setItems(data);
	}
	@FXML
	public void selecionarCliente(MouseEvent arg0) {
	        Cliente c = tabelaClientes.getSelectionModel().getSelectedItem();
	        Integer codigo = c.getCodigo();
			Integer idade = c.getIdade(); 
			txtNomeCliente.setText(c.getNome());
	        txtCpfCliente.setText(c.getCpf());
	        txtEndereçoCliente.setText(c.getEndereco());
	        txtTelefoneCliente.setText(c.getTelefone());
	        txtCodigoCliente.setText(codigo.toString());
	        txtIdadeCliente.setText(idade.toString());
	        txtCodigoCliente.editableProperty().set(false);
	       
	    }
	
	@FXML
	public void buscarCliente() throws ClienteNaoExisteException{
		Cliente c;
		Integer code = new Integer(txtCodigoCliente.getText());
			if(!code.toString().trim().isEmpty()){
				try{
					c = panelaFit.buscarCliente(code);
					Integer codigo = c.getCodigo();
					Integer idade = c.getIdade(); 
					txtNomeCliente.setText(c.getNome());
			        txtCpfCliente.setText(c.getCpf());
			        txtEndereçoCliente.setText(c.getEndereco());
			        txtTelefoneCliente.setText(c.getTelefone());
			        txtCodigoCliente.setText(codigo.toString());
			        txtIdadeCliente.setText(idade.toString());
				}catch(ClienteNaoExisteException e){
					lblMensagem.setText(e.getMessage());
				}
			}
	}
}
