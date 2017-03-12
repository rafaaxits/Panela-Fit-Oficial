package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import negocios.Cliente;
import negocios.PanelaFit;
import java.io.IOException;
import exceptions.ClienteInvalidoException;
import exceptions.ClienteNaoExisteException;
import exceptions.ClienteJaExisteException;
public class ClienteTelaController {
		
	private PanelaFit panelaFit = PanelaFit.getInstance();
	
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
	TableColumn<Cliente,Integer> colunaIdade;
	
	@FXML
	TableColumn<Cliente,String> colunaEndereço;
	
	@FXML
	TableColumn<Cliente,String> colunaTelefone;
	
	@FXML
	TableColumn<Cliente,Integer> colunaCodigo;
	
	
	
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
		public void cadastrarCliente() {
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
						panelaFit.cadastrarCliente(aux);
						txtNomeCliente.clear();
						txtCpfCliente.clear();
						txtIdadeCliente.clear();
						txtEndereçoCliente.clear();
						txtTelefoneCliente.clear();
						txtCodigoCliente.clear();
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
	
	private void initialize(){
		colunaNome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		colunaCpf.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCpf()));
		//colunaIdade.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getIdade()));
		colunaEndereço.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEndereco()));
		colunaTelefone.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefone()));
		//colunaCodigo.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getCodigo()));
		
		//tabelaClientes.getSelectionModel().selectedItemProperty().addListener(observable, oldValue, newValue) -> mostrarDetalhesConta(new Value));
	}
	
}
