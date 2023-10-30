package application.newlog;

import application.dashboard.Dashboard;
import application.login.Login;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;


public class NewLog {
	
	public void show(Stage primaryStage) {
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("NewLog.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			Button dashboardButton = (Button) scene.lookup("#dashboardButton");
			
			dashboardButton.setOnAction(event -> {
                Dashboard dashboard = new Dashboard();
                dashboard.show(primaryStage);
            });
			
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
