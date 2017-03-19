package GUI;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class PanelaFitApp extends Application {
	
	private Stage primaryStage;
	private BorderPane rootScene;
	
	private static PanelaFitApp instance;
	
	public static PanelaFitApp getInstance(){
		if(instance == null){
			instance = new PanelaFitApp();
		}
		return instance;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Panela Fit");
		this.primaryStage.sizeToScene();
		this.rootScene = new BorderPane();
		
		Scene scene = new Scene(rootScene, 660, 560);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		carregarTelaPrincipal();
	}
	public static void main(String[] args) {
		launch(args);
	}
	
	public void carregarTelaPrincipal(){
		try{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(PanelaFitApp.class.getResource("/GUI/PanelaFit.fxml"));
		BorderPane pane = (BorderPane) loader.load();
		
		this.rootScene.setCenter(pane);
		PanelaFitPaneController panelaFitPaneController = loader.getController();
		panelaFitPaneController.setApp(this);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public void changeStage(Stage stage){
		this.primaryStage = stage;
	}
}


