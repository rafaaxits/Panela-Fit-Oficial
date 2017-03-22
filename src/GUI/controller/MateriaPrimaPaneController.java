package GUI.controller;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import negocios.PanelaFit;
import negocios.beans.MateriaPrima;

import java.io.IOException;
import javax.xml.bind.ValidationException;
import exceptions.FormatacaoInvalidaException;
import exceptions.MateriaPrimaNaoExisteException;
import exceptions.MateriaPrimaJaExisteException;

public class MateriaPrimaPaneController {
private PanelaFit panelaFit;
	
	@FXML 
	Button butCadastrar;
	
	@FXML
	private Label lblMensagem;
	
	@FXML
	private TextField txtNomeMateriaPrima;
	
	@FXML
	private TextField txtQuantidadeMateriaPrima;
	
	@FXML
	private TextField txtPrecoMateriaPrima;
	
	@FXML
	private TextField txtCodigoMateriaPrima;
	
	
	@FXML
	private TableView<MateriaPrima> tabelaMateriasPrimas;
	
	@FXML
	TableColumn<MateriaPrima, String> colunaNome;
	
	@FXML
	TableColumn<MateriaPrima, String> colunaQuantidade;
	
	@FXML
	TableColumn<MateriaPrima, String> colunaPreco;
	
	@FXML
	TableColumn<MateriaPrima, String> colunaCodigo;
	
	private ObservableList<MateriaPrima> data;
	
	public void sair(ActionEvent event){
		((Node) event.getSource()).getScene().getWindow().hide();

	}
	
	public void voltarMenuPrincipal(ActionEvent event){
		((Node) event.getSource()).getScene().getWindow().hide();
		Parent parent;
			try{
				parent = FXMLLoader.load(getClass()
				          .getResource("/GUI/view/PanelaFit.fxml"));
				Stage stage3 = new Stage();
			      Scene cena = new Scene(parent);
			      stage3.setScene(cena);
			      stage3.show();
			}catch(IOException e){
				lblMensagem.setText(e.getMessage());
			}			
	}	
	
	public void cadastrarMateriaPrima() throws ValidationException, IOException {
		
		if(validateFields()){
			try{
				String nome;
				Integer codigo = new Integer (txtCodigoMateriaPrima.getText());
				Integer quantidade = new Integer (txtQuantidadeMateriaPrima.getText().replace("K", "").replace("G", ""));
				Double preco = new Double(txtPrecoMateriaPrima.getText().replace("R", "").replace("$", "").replace(".", ""));
				nome = txtNomeMateriaPrima.getText();
				MateriaPrima aux = new MateriaPrima(nome, codigo, quantidade, preco);
				validateAttributes(aux);
				panelaFit.cadastrarMateriaPrima(aux);
				refreshTable();
				limparForm();
				lblMensagem.setText("MateriaPrima cadastrada");
			}catch(FormatacaoInvalidaException e){
				lblMensagem.setText(e.getMessage());
			}catch(MateriaPrimaJaExisteException e){
				lblMensagem.setText(e.getMessage());
			
			}
		}
		
	}
		
		public void removerMateriaPrima() throws  MateriaPrimaNaoExisteException, IOException, FormatacaoInvalidaException {
			MateriaPrima materiaPrimaSelecionada = tabelaMateriasPrimas.getSelectionModel().getSelectedItem();	
			
				try{
					if(materiaPrimaSelecionada != null){
					Integer codig = new Integer (materiaPrimaSelecionada.getCodigo());
					if(panelaFit.existeMateriaPrima(codig)){
						panelaFit.removerMateriaPrima(materiaPrimaSelecionada);
						tabelaMateriasPrimas.getItems().remove(tabelaMateriasPrimas.getSelectionModel().getSelectedIndex());
						limparForm();
						refreshTable();
						lblMensagem.setText("Materia Prima Removida");
						}
					}else {
						Integer code = new Integer (txtCodigoMateriaPrima.getText());
						if(panelaFit.existeMateriaPrima(code)){
							lblMensagem.setText("Materia Prima Removida");
							MateriaPrima aux = panelaFit.buscarMateriaPrima(code);
							panelaFit.removerMateriaPrima(aux);
							refreshTable();
							limparForm();	
							lblMensagem.setText("Materia Prima Removida");
						}
					  }
					}catch(MateriaPrimaNaoExisteException e){
						lblMensagem.setText(e.getMessage());
					}catch(NumberFormatException e){
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
		
		public void alterarMateriaPrima() throws MateriaPrimaNaoExisteException, ValidationException, IOException, FormatacaoInvalidaException{
			
			if(validateFields()){
				try{
					String nome;
					Integer codigo = new Integer (txtCodigoMateriaPrima.getText());
					Integer quantidade = new Integer (txtQuantidadeMateriaPrima.getText().replace("K", "").replace("G", ""));
					Double preco = new Double(txtPrecoMateriaPrima.getText().replace("R", "").replace("$", "").replace(".", ""));
					nome = txtNomeMateriaPrima.getText();
					MateriaPrima aux = new MateriaPrima(nome, codigo, quantidade, preco);
					validateAttributes(aux);
					panelaFit.alterarMateriaPrima(aux);;
					refreshTable();
					limparForm();
					lblMensagem.setText("Materia Prima aletrada");
				}catch(FormatacaoInvalidaException e){
					lblMensagem.setText(e.getMessage());
				}catch(MateriaPrimaNaoExisteException e){
					lblMensagem.setText(e.getMessage());
				}catch(NumberFormatException e){
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
		}	
		
	public void setDados(ObservableList<MateriaPrima> dadosMateriaPrima){
			tabelaMateriasPrimas.setItems(dadosMateriaPrima);
	}

	@FXML
	private void initialize(){
		
		// preco.toString();
		//txtPrecoMateriaPrima.setText(String.format("%.0f",preco));
		panelaFit = PanelaFit.getInstance();
	
		colunaNome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		colunaQuantidade.setCellValueFactory(new PropertyValueFactory<MateriaPrima, String>("quantidade"));
		colunaPreco.setCellValueFactory(new PropertyValueFactory<MateriaPrima, String>("Preco"));
		colunaCodigo.setCellValueFactory(new PropertyValueFactory<MateriaPrima, String>("codigo"));
		
		data = FXCollections.observableArrayList();
		data.addAll(panelaFit.listarMateriasPrimas());
		tabelaMateriasPrimas.setItems(data);
	}
	
	@FXML
    public void limparForm() {
		txtNomeMateriaPrima.clear();
		txtQuantidadeMateriaPrima.clear();
		txtPrecoMateriaPrima.clear();
		txtCodigoMateriaPrima.clear();
        txtCodigoMateriaPrima.editableProperty().set(true);
        txtCodigoMateriaPrima.setStyle(null);
        txtNomeMateriaPrima.setStyle(null);
        lblMensagem.setText(null);
        tabelaMateriasPrimas.getSelectionModel().clearSelection();

    }
	
	private void validateAttributes(MateriaPrima mp) throws ValidationException{
		String returnMs="";
		Integer quantidade = mp.getQuantidade();
		Integer codigo = mp.getCodigo();
		Double preco = mp.getPreco();
		if(mp.getNome() == null || mp.getNome().isEmpty()){
			returnMs += "'Nome' ";
		}
		if(quantidade.toString() == null || quantidade.toString().isEmpty()){
			returnMs += "'Quantidade' ";
		}
		if(mp.toString() == null || preco.toString().isEmpty()){
			returnMs += "'Preco' ";
		}
		if(codigo.toString() == null || codigo.toString().isEmpty()){
			returnMs +="'Codigo' ";
		}
			if(!returnMs.isEmpty()){
				throw new ValidationException(String.format("Os argumento[%s] obrigatorios estao nulos ou com valores invalidos", returnMs));
			}
	}
	
	private boolean validateFields() throws IOException{
		boolean validate=false;
		try{
			if((txtNomeMateriaPrima.getText().isEmpty() || !txtNomeMateriaPrima.getText().matches("[a-z A-Z]+")) || (txtQuantidadeMateriaPrima.getText().isEmpty() || !txtQuantidadeMateriaPrima.getText().matches("[0-9][0-9]KG")) ||
					(txtPrecoMateriaPrima.getText().isEmpty() || !txtPrecoMateriaPrima.getText().matches("[R][$][0-9][0-9][0-9]")) ||
						(txtCodigoMateriaPrima.getText().isEmpty() || !txtCodigoMateriaPrima.getText().matches("[0-9][0-9][0-9][0-9][0-9]"))) {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/view/PopUpTela.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Panela Fit");
            stage.setScene(new Scene(root1));  
            stage.show();
            	if(txtNomeMateriaPrima.getText().isEmpty() || !txtNomeMateriaPrima.getText().matches("[a-z A-Z]+")){
            		txtNomeMateriaPrima.setStyle("-fx-background-color: red;");
            	}
            
			}else{
				validate = true;
			}
		} catch(NumberFormatException e){
			e.getMessage();
			
		}
	return validate;	
	}
	
	@FXML
	private void refreshTable(){
		data = FXCollections.observableArrayList();
		data.addAll(panelaFit.listarMateriasPrimas());
		tabelaMateriasPrimas.setItems(data);
	}
	@FXML
	public void selecionarMateriaPrima(MouseEvent arg0) {
		if(!tabelaMateriasPrimas.getSelectionModel().isEmpty()){
			MateriaPrima materiaPrimaSelecionada= tabelaMateriasPrimas.getSelectionModel().getSelectedItem();
	        Integer codigo = materiaPrimaSelecionada.getCodigo();
			Integer quantidade = materiaPrimaSelecionada.getQuantidade();
			Double preco = materiaPrimaSelecionada.getPreco();
			txtNomeMateriaPrima.setText(materiaPrimaSelecionada.getNome());
	        txtQuantidadeMateriaPrima.setText(quantidade.toString());
	        txtCodigoMateriaPrima.setText(codigo.toString());
	        preco.toString();
			txtPrecoMateriaPrima.setText(String.format("%.0f",preco));
	        char [] a = txtQuantidadeMateriaPrima.getText().toCharArray();
	        String quantity = "";
	        for(int i = 0; i < a.length; i++){
	        	if(i==1){
	        		quantity += a[i]+"KG";
	        	}else{
	        		quantity += a[i];
	        	}	        }
	        txtQuantidadeMateriaPrima.setText(quantity);
	        char [] b = txtPrecoMateriaPrima.getText().toCharArray();
	        String price = "";
	        for(int i = 0; i<b.length; i++){
	        	if(i==0){
	        		price += "R$"+b[i];
	        	}else {
	        		price += b[i];
	        	}
	        }
	        txtPrecoMateriaPrima.setText(price);
	        txtCodigoMateriaPrima.editableProperty().set(false);
	        txtCodigoMateriaPrima.setStyle("-fx-background-color: gray;");
	    }
}
	
	@FXML
	public void buscarMateriaPrima() throws MateriaPrimaNaoExisteException, IOException{
		MateriaPrima mp;
		
				try{
					Integer code = new Integer(txtCodigoMateriaPrima.getText());
					mp = panelaFit.buscarMateriaPrima(code);
					Integer codigo = mp.getCodigo();
					Integer quantidade = mp.getQuantidade(); 
					Double preco = mp.getPreco();
					txtNomeMateriaPrima.setText(mp.getNome());
			        txtQuantidadeMateriaPrima.setText(quantidade.toString());
			        txtCodigoMateriaPrima.setText(codigo.toString());
			        preco.toString();
					txtPrecoMateriaPrima.setText(String.format("%.0f",preco));
			        char [] a = txtQuantidadeMateriaPrima.getText().toCharArray();
			        String quantity = "";
			        for(int i = 0; i < a.length; i++){
			        	if(i==1){
			        		quantity += a[i]+"KG";
			        	}else{
			        		quantity += a[i];
			        	}
			        }
			        txtQuantidadeMateriaPrima.setText(quantity);
			        char [] b = txtPrecoMateriaPrima.getText().toCharArray();
			        String price = "";
			        for(int i = 0; i<b.length; i++){
			        	if(i==0){
			        		price += "R$"+b[i];
			        	}else {
			        		price += b[i];
			        	}
			        }
			        txtPrecoMateriaPrima.setText(price);			        
			        txtCodigoMateriaPrima.editableProperty().set(false);
			        txtCodigoMateriaPrima.setStyle("-fx-background-color: gray;");
				}catch(NumberFormatException e) {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/view/PopUpTela.fxml"));
		            Parent root1 = (Parent) fxmlLoader.load();
		            Stage stage = new Stage();
		            stage.initModality(Modality.APPLICATION_MODAL);
		            stage.initStyle(StageStyle.UNDECORATED);
		            stage.setTitle("Panela Fit");
		            stage.setScene(new Scene(root1));  
		            stage.show();
				}catch(MateriaPrimaNaoExisteException e){
					lblMensagem.setText(e.getMessage());
				}
			}
	

}