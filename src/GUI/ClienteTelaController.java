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
import javafx.scene.control.Label;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import negocios.Cliente;
import negocios.PanelaFit;
import java.io.IOException;

import javax.xml.bind.ValidationException;

import exceptions.ClienteInvalidoException;
import exceptions.ClienteNaoExisteException;
import exceptions.ClienteJaExisteException;
public class ClienteTelaController {
		
	private PanelaFit panelaFit;
	
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
					}catch(ClienteInvalidoException e){//Esta excecao nao esta funcionando
						lblMensagem.setText(e.getMessage());
					}catch(ClienteJaExisteException e){
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
		Stage stage = null;
		try{
		String nome, cpf, end, telefone;
		Integer codigo = new Integer (txtCodigoCliente.getText());
		Integer idade = new Integer (txtIdadeCliente.getText());
		nome=txtNomeCliente.getText();
		cpf=txtCpfCliente.getText();
		end=txtEndereçoCliente.getText();
		telefone=txtTelefoneCliente.getText();
		} catch(NumberFormatException e){
			 e.getMessage();
			 root = FXMLLoader.load(getClass().getResource("/GUI/PopUpTela.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
		}
		
	}
	private void refreshTable(){
		data = FXCollections.observableArrayList();
		data.addAll(panelaFit.listarClientes());
		tabelaClientes.setItems(data);
	}
}
