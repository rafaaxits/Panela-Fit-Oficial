package GUI;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import negocios.Fornecedor;
import negocios.PanelaFit;
import javax.xml.bind.ValidationException;
import exceptions.FormatacaoInvalidaException;
import exceptions.FornecedorNaoExisteException;
import exceptions.FornecedorJaExisteException;

public class FornecedorPaneController {
	
	private PanelaFit panelaFit;
	
	@FXML 
	Button butCadastrar;
	
	@FXML
	private Label lblMensagem;
	
	@FXML
	private TextField txtNomeFornecedor;
			
	@FXML
	private TextField txtEnderecoFornecedor;
	
	@FXML
	private TextField txtTelefoneFornecedor;
	
	@FXML
	private TextField txtCodigoFornecedor;
	
	
	@FXML
	private TableView<Fornecedor> tabelaFornecedores;
	
	@FXML
	TableColumn<Fornecedor, String> colunaNome;
		
	@FXML
	TableColumn<Fornecedor, String> colunaEndereco;
	
	@FXML
	TableColumn<Fornecedor, String> colunaTelefone;
	
	@FXML
	TableColumn<Fornecedor, String> colunaCodigo;
	
	private ObservableList<Fornecedor> data;
	
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
	
	public void cadastrarFornecedor() throws ValidationException, IOException{
		
		if(validateFields()){
			try{
				String nome, endereco, telefone;
				Integer codigo = new Integer(txtCodigoFornecedor.getText());
				nome = txtNomeFornecedor.getText();
				endereco = txtEnderecoFornecedor.getText();
				telefone = txtTelefoneFornecedor.getText();
				System.out.println(telefone);
				telefone = telefone.replace("(", "");
				System.out.println(telefone);
				telefone = telefone.replace(")", "");
				System.out.println(telefone);
				telefone = telefone.replace("-", "");
				System.out.println(telefone);
				Fornecedor aux = new Fornecedor(nome, endereco, telefone, codigo);
				validateAttributes(aux);
				panelaFit.cadastrarFornecedor(aux);
				refreshTable();
				limparForm();
				lblMensagem.setText("Fornecedor cadastrado");
			}catch(FormatacaoInvalidaException e){
				lblMensagem.setText(e.getMessage());
			}catch(FornecedorJaExisteException e){
				lblMensagem.setText(e.getMessage());
			}
	}	
	}
	
	public void removerFornecedor() throws FormatacaoInvalidaException,FornecedorNaoExisteException, IOException{
		Fornecedor fornecedorSelecionado = tabelaFornecedores.getSelectionModel().getSelectedItem();
		try{
			if(fornecedorSelecionado != null){
				Integer codig = new Integer(fornecedorSelecionado.getCodigo());
				if(panelaFit.existeFornecedor(codig)){
				panelaFit.removerFornecedor(fornecedorSelecionado);
				tabelaFornecedores.getItems().remove(tabelaFornecedores.getSelectionModel().getSelectedIndex());
				limparForm();
				refreshTable();
				lblMensagem.setText("Fornecedor Removido");
			}
		} else{
			Integer code = new Integer(txtCodigoFornecedor.getText());
				if(panelaFit.existeFornecedor(code)){
					Fornecedor aux = panelaFit.buscarFornecedor(code);
					panelaFit.removerFornecedor(aux);
					refreshTable();
					limparForm();
					lblMensagem.setText("Fornecedor Removido");
			}
		}
	}catch(FornecedorNaoExisteException e){
		lblMensagem.setText(e.getMessage());
	}catch(NumberFormatException e){
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/PopUpTela.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Panela Fit");
        stage.setScene(new Scene(root1));  
        stage.show();
	}
}
	
	public void alterarFornecedor() throws FornecedorNaoExisteException, FornecedorJaExisteException, FormatacaoInvalidaException, ValidationException, IOException{
		
		if(validateFields()){
				try{String nome, endereco, telefone;
				Integer codigo = new Integer (txtCodigoFornecedor.getText());
				nome = txtNomeFornecedor.getText();
				endereco = txtEnderecoFornecedor.getText();
				telefone = txtTelefoneFornecedor.getText();
				telefone = telefone.replace("(", "").replace(")", "").replace("-","");
				Fornecedor aux = new Fornecedor(nome, endereco, telefone, codigo);
				validateAttributes(aux);
				panelaFit.alterarFornecedor(aux);;
				refreshTable();
				limparForm();
				lblMensagem.setText("Fornecedor aletrado");
			}catch(FormatacaoInvalidaException e){
				lblMensagem.setText(e.getMessage());
			}
			catch(FornecedorJaExisteException e){
				lblMensagem.setText(e.getMessage());
			}catch(FornecedorNaoExisteException e){
				lblMensagem.setText(e.getMessage());
			}
		}
	}
	
	public void setDados(ObservableList<Fornecedor> dadosFornecedores){
		tabelaFornecedores.setItems(dadosFornecedores);
}
	
	@FXML
	private void initialize(){
		
		panelaFit = PanelaFit.getInstance();
		
		colunaNome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNomeFornecedor()));
		colunaEndereco.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEnderecoFornecedor()));
		colunaTelefone.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefone()));
		colunaCodigo.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("codigo"));
		
		data = FXCollections.observableArrayList();
		data.addAll(panelaFit.listarFornecedores());
		tabelaFornecedores.setItems(data);
	}
	
	
	
	@FXML
    private void limparForm() {
		txtNomeFornecedor.clear();
		txtEnderecoFornecedor.clear();
		txtTelefoneFornecedor.clear();
		txtCodigoFornecedor.clear();
        txtCodigoFornecedor.editableProperty().set(true);
        txtCodigoFornecedor.setStyle(null);
        txtNomeFornecedor.setStyle(null);
        lblMensagem.setText(null);
        tabelaFornecedores.getSelectionModel().clearSelection();

	}
	
	private void validateAttributes(Fornecedor fornecedor) throws ValidationException{
		String returnMs="";
		Integer codigo = fornecedor.getCodigo();
		if(fornecedor.getNomeFornecedor() == null || fornecedor.getNomeFornecedor().isEmpty()){
			returnMs += "'Nome' ";
		}
		if(fornecedor.getEnderecoFornecedor()==null || fornecedor.getEnderecoFornecedor().isEmpty()){
			returnMs += "'Endereço' ";
		}
		if(fornecedor.getTelefone()==null || fornecedor.getTelefone().isEmpty()){
			returnMs +="'Telefone' ";
		}
		if(codigo.toString()==null || codigo.toString().isEmpty()){
			returnMs +="'Codigo' ";
		}
			if(!returnMs.isEmpty()){
				throw new ValidationException(String.format("Os argumento[%s] obrigatorios estao nulos ou com valores invalidos", returnMs));
			}
	}
	
	private boolean validateFields() throws IOException{
		boolean validate=false;
		try{
			if((txtNomeFornecedor.getText().isEmpty() || !txtNomeFornecedor.getText().matches("[a-z A-Z]+")) || txtEnderecoFornecedor.getText().isEmpty() || txtCodigoFornecedor.getText().isEmpty() ||
					(txtTelefoneFornecedor.getText().isEmpty() || !txtTelefoneFornecedor.getText().matches("[(][0-9][0-9][)][0-9][0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]"))){
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/PopUpTela.fxml"));
	            Parent root1 = (Parent) fxmlLoader.load();
	            Stage stage = new Stage();
	            stage.initModality(Modality.APPLICATION_MODAL);
	            stage.initStyle(StageStyle.UNDECORATED);
	            stage.setTitle("Panela Fit");
	            stage.setScene(new Scene(root1));  
	            stage.show();
	            	if(txtNomeFornecedor.getText().isEmpty() || !txtNomeFornecedor.getText().matches("[a-z A-Z]+")){
	            		txtNomeFornecedor.setStyle("-fx-background-color: red;");
	            	}
			}else{
				lblMensagem.setText("DEU");
				validate = true;
			}
		} catch(NumberFormatException e) {
			e.getMessage();
		}
		return validate;
}
		
		@FXML
		private void refreshTable(){
			data = FXCollections.observableArrayList();
			data.addAll(panelaFit.listarFornecedores());
			tabelaFornecedores.setItems(data);
		
	}
		
		@FXML
		public void selecionarFornecedor(MouseEvent arg0) {
				Fornecedor f = tabelaFornecedores.getSelectionModel().getSelectedItem();
		        Integer codigo = f.getCodigo();
				txtNomeFornecedor.setText(f.getNomeFornecedor());
		        txtEnderecoFornecedor.setText(f.getEnderecoFornecedor());
		        txtTelefoneFornecedor.setText(f.getTelefone());
		        txtCodigoFornecedor.setText(codigo.toString());
		        char[] b = txtTelefoneFornecedor.getText().toCharArray();
		        String telefone = "";
		        for(int i=0;i<b.length;i++){
		        	if(i==0){
		        		telefone +="("+ b[i];
		        	}else if(i==1){
		        		telefone += b[i] + ")";
		        	}else if(i==6){
		        		telefone += b[i] + "-";
		        	}else{
		        		telefone += b[i];
		        	}
		        }
		        txtTelefoneFornecedor.setText(telefone);
		        txtCodigoFornecedor.editableProperty().set(false);
		        txtCodigoFornecedor.setStyle("-fx-background-color: gray;");
		       
		    }
		
		@FXML
		public void buscarFornecedor() throws FornecedorNaoExisteException, IOException{
			Fornecedor f;
			
					try{
						Integer code = new Integer(txtCodigoFornecedor.getText());
						f = panelaFit.buscarFornecedor(code);
						Integer codigo = f.getCodigo();
						txtNomeFornecedor.setText(f.getNomeFornecedor());
				        txtEnderecoFornecedor.setText(f.getEnderecoFornecedor());
				        txtTelefoneFornecedor.setText(f.getTelefone());
				        txtCodigoFornecedor.setText(codigo.toString());
				        char[] b = txtTelefoneFornecedor.getText().toCharArray();
				        String telefone = "";
				        for(int i=0;i<b.length;i++){
				        	if(i==0){
				        		telefone +="("+ b[i];
				        	}else if(i==1){
				        		telefone += b[i] + ")";
				        	}else if(i==6){
				        		telefone += b[i] + "-";
				        	}else{
				        		telefone += b[i];
				        	}
				        }
				        txtTelefoneFornecedor.setText(telefone);
				        txtCodigoFornecedor.editableProperty().set(false);
				        txtCodigoFornecedor.setStyle("-fx-background-color: gray;");
					}catch(NumberFormatException e){
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/PopUpTela.fxml"));
			            Parent root1 = (Parent) fxmlLoader.load();
			            Stage stage = new Stage();
			            stage.initModality(Modality.APPLICATION_MODAL);
			            stage.initStyle(StageStyle.UNDECORATED);
			            stage.setTitle("Panela Fit");
			            stage.setScene(new Scene(root1));  
			            stage.show();
					}
					catch(FornecedorNaoExisteException e){
						lblMensagem.setText(e.getMessage());
					}
				
		}
}
