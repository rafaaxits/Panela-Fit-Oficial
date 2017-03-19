package GUI;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import negocios.Cliente;
import negocios.Funcionario;
import negocios.ItemVenda;
import negocios.PanelaFit;
import negocios.Venda;

public class VendaPaneController {
	
	private PanelaFit panelaFit;
	
	@FXML
	private Label lblMensagem;

	@FXML
	private TableView<Venda> tabelaVendas;
	
	@FXML
	TableColumn<Venda,String> colunaCodigo;
	
	@FXML
	TableColumn<Cliente,Cliente> colunaCliente;
	
	@FXML
	TableColumn<Funcionario,Funcionario> colunaFuncionario;
	
	@FXML
	TableColumn<Venda,ArrayList<ItemVenda>> colunaListaItens;
	
	@FXML
	TableColumn<Venda,String> colunaDataVenda;
	
	@FXML
	TableColumn<Venda,Double> colunaTotal;
	
	private ObservableList<Venda> data;
	
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
	
	@FXML
	private void initialize(){
		panelaFit = PanelaFit.getInstance();
		
	//	colunaCodigo.setCellValueFactory(new PropertyValueFactory<Venda,String>("Codigo"));
		
		//data = FXCollections.observableArrayList();
		//data.addAll(panelaFit.listarVendas());
		//tabelaVendas.setItems(data);
		
	}
}
