package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class PanelaFitPaneController {
	private PanelaFitApp panelaFitApp;
	@FXML Button butCliente;
	@FXML Button butX;
	@FXML Button butFuncionario;
	@FXML Button butFornecedor;
	@FXML Button butMateriaPrima;
	
	@FXML
	public void initialize()throws Exception{
		this.panelaFitApp = PanelaFitApp.getInstance();
	}
		@FXML
		public void telaCliente(ActionEvent event){
		Parent root;
		Stage stage;
			try{
				if(event.getSource()==butCliente){
					stage = (Stage) butCliente.getScene().getWindow();
					root = FXMLLoader.load(getClass().getResource("/GUI/ClienteTela.fxml"));
				}else {
					stage = (Stage) butCliente.getScene().getWindow();
					root = FXMLLoader.load(getClass().getResource("/GUI/PanelaFit.fxml"));
				}
				Scene scene = new Scene(root);
				stage.setScene(scene);
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}	
		@FXML
		public void telaFuncionario(ActionEvent event){
			Parent root;
			Stage stage;
			try{
				if(event.getSource()==butFuncionario){
					stage = (Stage) butFuncionario.getScene().getWindow();
					root = FXMLLoader.load(getClass().getResource("/GUI/FuncionarioTela.fxml"));
				}else {
					stage = (Stage) butFuncionario.getScene().getWindow();
					root = FXMLLoader.load(getClass().getResource("/GUI/PanelaFit.fxml"));
				}
				Scene scene = new Scene(root);
				stage.setScene(scene);
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		@FXML 
		public void telaFornecedor(ActionEvent event){
			Parent root;
			Stage stage;
			try{
				if(event.getSource()==butFornecedor){
					stage = (Stage) butFornecedor.getScene().getWindow();
					root = FXMLLoader.load(getClass().getResource("/GUI/FornecedorTela.fxml"));
				}else {
					stage = (Stage) butFornecedor.getScene().getWindow();
					root = FXMLLoader.load(getClass().getResource("/GUI/PnaleFit.fxml"));
				}
				Scene scene = new Scene(root);
				stage.setScene(scene);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		@FXML 
		public void telaMateriaPrima(ActionEvent event){
			Parent root;
			Stage stage;
			try{
				if(event.getSource()==butMateriaPrima){
					stage = (Stage) butMateriaPrima.getScene().getWindow();
					root = FXMLLoader.load(getClass().getResource("/GUI/MateriaPrimaTela.fxml"));
				}else {
					stage = (Stage) butFornecedor.getScene().getWindow();
					root = FXMLLoader.load(getClass().getResource("/GUI/PanelaFit.fxml"));
				}
				Scene scene = new Scene(root);
				stage.setScene(scene);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	public void sair(ActionEvent event){
		((Node) event.getSource()).getScene().getWindow().hide();

	}
	
	public void setApp(PanelaFitApp panelaFitApp){
		this.panelaFitApp=panelaFitApp;
	}
	
}

