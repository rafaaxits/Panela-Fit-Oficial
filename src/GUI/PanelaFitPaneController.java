package GUI;



import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import negocios.Cliente;
import negocios.PanelaFit;


public class PanelaFitPaneController {
	private PanelaFitApp panelaFitApp;
	@FXML Button butCliente;
	@FXML Button butX;
	
	@FXML
	public void initialize()throws Exception{
		this.panelaFitApp = PanelaFitApp.getInstance();
	}
	
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

	public void sair(ActionEvent event){
		((Node) event.getSource()).getScene().getWindow().hide();

	}
	
	public void setApp(PanelaFitApp panelaFitApp){
		this.panelaFitApp=panelaFitApp;
	}
	
}
