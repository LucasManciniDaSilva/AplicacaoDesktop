package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	//Created an attribute type Scene.
	private static Scene mainScene;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//instantiated a new FXMLLoader receiving the path of the MainView
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			//Created a new scroll pane loading the MainView
			ScrollPane scrollPane = loader.load();
			
			//Fitted the height and the width of the screen.
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);
			
			//reference of the attribute mainScene receive a new Scene.
			mainScene = new Scene(scrollPane);
			//Set the scene.
			primaryStage.setScene(mainScene);
			//Set the title
			primaryStage.setTitle("Sample JavaFX application");
			//Show the scene on the screen
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Method to get the scene.
	public static Scene getMainScene() {
		return mainScene;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}