package GUI;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PopUpApp  extends Application{
	private Stage primaryStage;
	private BorderPane rootScene;
	
	private static PopUpApp instance;
	
	public static PopUpApp getInstance(){
		if(instance == null){
			instance = new PopUpApp();
		}
		return instance;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Panela Fit");
		this.rootScene = new BorderPane();
		
		Scene scene = new Scene(rootScene, 200, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
				
	}
	public static void main(String [] args){
		launch(args);
	}
	public void carregarTelaPopUp(){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(PopUpApp.class.getResource("/GUI/PopUpTela.fxml"));
			BorderPane pane = (BorderPane) loader.load();
			
			this.rootScene.setCenter(pane);
			PopUpController popUpController = loader.getController();
			popUpController.setPopUp(this);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
