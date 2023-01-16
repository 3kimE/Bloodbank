package application;
	





import java.sql.Connection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	
	 public static Connection C;
	
	@Override
	public void start(Stage primaryStage) {
	
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/Interfaces/Login.fxml"));
				Scene scene =  new Scene (root);

			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	
}
