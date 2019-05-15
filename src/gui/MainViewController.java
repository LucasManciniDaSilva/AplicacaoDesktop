package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable {

	
	@FXML
	private MenuItem menuItemSeller;
	
	@FXML
	private MenuItem menuItemDepartment;
	
	@FXML
	private MenuItem menuItemIndex;
	
	@FXML
	public void onMenuItemSellerAction() {
		Alerts.showAlert("Seller", "Seller Screen", null, AlertType.CONFIRMATION);
	}
	
	@FXML
	public void onMenuItemDepartmentAction() {
		Alerts.showAlert("Department", "Department Screen", null, AlertType.CONFIRMATION);
	}
	
	@FXML
	public void onMenuItemIndexAction() {
		Alerts.showAlert("Index", "Index Screen", null, AlertType.CONFIRMATION);
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
