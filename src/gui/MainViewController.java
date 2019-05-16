package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.DepartmentService;

public class MainViewController implements Initializable {

	// Created a variable of a menu item Type
	@FXML
	private MenuItem menuItemSeller;
	// Created a variable of a menu item Type
	@FXML
	private MenuItem menuItemDepartment;
	// Created a variable of a menu item Type
	@FXML
	private MenuItem menuItemIndex;

	// Method to access the Seller Screen
	@FXML
	public void onMenuItemSellerAction() {
		Alerts.showAlert("Seller", "Seller Screen", null, AlertType.CONFIRMATION);
	}

	// Method to access the Department Screen
	@FXML
	public void onMenuItemDepartmentAction() {
		loadView("/gui/DepartmentView.fxml", (DepartmentController controller) -> {
			controller.SetDepartmentService(new DepartmentService());
			controller.updateTableView();
		});
	}

	// Method to access the about Screen
	@FXML
	public void onMenuItemIndexAction() {
		// Method to load the screen About.
		loadView("/gui/About.fxml", x -> {});
	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		// TODO Auto-generated method stub

	}

	// Method to load the other Screens
	private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {
			try {
				//Instantiated a new FXMLLoader receiving the absoluteName by argument.
				FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
				//Created a new VBox receiving the loader
				VBox newVBox = loader.load();
 
				//Created a new Scene reference the MainScene
				Scene mainScene = Main.getMainScene();
				//Get the Vbox of the MainView.
				VBox mainVBox =   (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

				//Create a reference to menu.
				Node mainMenu = mainVBox.getChildren().get(0);
				//Clear all the children in the VBox.
				mainVBox.getChildren().clear();
				//Add the mainMenu
				mainVBox.getChildren().add(mainMenu);
				//Add all elements of the newVBox.
				mainVBox.getChildren().addAll(newVBox.getChildren());
				
				T controller = loader.getController();
				initializingAction.accept(controller);
			}
			
		catch(IOException e){
			
		Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
	    }
	}
}
