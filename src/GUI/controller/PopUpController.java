package GUI.controller;

import GUI.PopUpApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;

public class PopUpController {

	@FXML
	private Label lblMensagem;

	private PopUpApp popUpApp;

	public void setPopUp(PopUpApp popUpApp) {
		this.setPopUpApp(popUpApp);
	}

	public void sair(ActionEvent event) {
		((Node) event.getSource()).getScene().getWindow().hide();
	}

	public PopUpApp getPopUpApp() {
		return popUpApp;
	}

	public void setPopUpApp(PopUpApp popUpApp) {
		this.popUpApp = popUpApp;
	}

}
