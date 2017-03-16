package GUI;

import java.io.IOException;

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
import negocios.Funcionario;
import negocios.PanelaFit;

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
	private TextField txtEndereçoFuncionario;
	
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
	TableColumn<Funcionario,String> colunaEndereço;
	
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
	
	public void cadastrarFuncionario(){
		
	}
	
	public void removerFuncionario(){
		
	}
	
	public void alterarFuncionario(){
		
	}
	
	public void setDadis(ObservableList<Funcionario> dadosFuncionario){
		tabelaFuncionarios.setItems(dadosFuncionario);
	}
	
	@FXML 
	private void initialize(){
		panelaFit = PanelaFit.getInstance();
	}
	
	@FXML
	public void limparForm(){
		
	}
	
	private void validateAttributes(Funcionario funcionario){
		
	}
	
	private void validateFields(){
		
	}
	
	@FXML 
	private void refreshTable(){
		
	}
	
	@FXML
	public void selecionarFuncionario(){
		
	}
	
	@FXML 
	public void buscarFuncionario(){
		
	}
	
	
}
