package application.dashboard;

import javafx.stage.Stage;
import application.login.Login;
import application.newlog.NewLog;
import application.pastlogs.PastLogs;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class Dashboard {

	public void show(Stage primaryStage) {
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			Button newLogButton = (Button) scene.lookup("#newLogButton");
			
			newLogButton.setOnAction(event -> {
                NewLog newlog = new NewLog();
                newlog.show(primaryStage);
            });
			
			Button pastLogsButton = (Button) scene.lookup("#pastLogsButton");
			
			pastLogsButton.setOnAction(event -> {
                PastLogs pastLogs = new PastLogs();
                pastLogs.show(primaryStage);
            });
			
			Button logOutButton = (Button) scene.lookup("#logOutButton");
			
			logOutButton.setOnAction(event -> {
                Login login = new Login();
                login.show(primaryStage);
            });
			
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
