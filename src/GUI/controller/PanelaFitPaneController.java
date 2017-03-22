package GUI.controller;

import GUI.PanelaFitApp;
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
	@FXML
	Button butX;
	@FXML
	Button butCliente;
	@FXML
	Button butFuncionario;
	@FXML
	Button butFornecedor;
	@FXML
	Button butMateriaPrima;
	@FXML
	Button butProduto;
	@FXML
	Button butVenda;

	@FXML
	public void initialize() throws Exception {
		this.setPanelaFitApp(PanelaFitApp.getInstance());
	}

	@FXML
	public void telaCliente(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == butCliente) {
				stage = (Stage) butCliente.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/ClienteTela.fxml"));
			} else {
				stage = (Stage) butCliente.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/PanelaFit.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);
			panelaFitApp.changeStage(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void telaFuncionario(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == butFuncionario) {
				stage = (Stage) butFuncionario.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/FuncionarioTela.fxml"));
			} else {
				stage = (Stage) butFuncionario.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/PanelaFit.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);
			panelaFitApp.changeStage(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void telaFornecedor(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == butFornecedor) {
				stage = (Stage) butFornecedor.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/FornecedorTela.fxml"));
			} else {
				stage = (Stage) butFornecedor.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/PnaleFit.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);
			panelaFitApp.changeStage(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void telaMateriaPrima(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == butMateriaPrima) {
				stage = (Stage) butMateriaPrima.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/MateriaPrimaTela.fxml"));
			} else {
				stage = (Stage) butFornecedor.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/PanelaFit.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);
			panelaFitApp.changeStage(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void telaProduto(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == butProduto) {
				stage = (Stage) butProduto.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/ProdutoTela.fxml"));
			} else {
				stage = (Stage) butProduto.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/PanelaFit.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);
			panelaFitApp.changeStage(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void telaVendas(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == butVenda) {
				stage = (Stage) butVenda.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/VendaTela.fxml"));
			} else {
				stage = (Stage) butVenda.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/PanelaFit.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);
			panelaFitApp.changeStage(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sair(ActionEvent event) {
		((Node) event.getSource()).getScene().getWindow().hide();

	}

	public void setApp(PanelaFitApp panelaFitApp) {
		this.setPanelaFitApp(panelaFitApp);
	}

	public PanelaFitApp getPanelaFitApp() {
		return panelaFitApp;
	}

	public void setPanelaFitApp(PanelaFitApp panelaFitApp) {
		this.panelaFitApp = panelaFitApp;
	}

}
