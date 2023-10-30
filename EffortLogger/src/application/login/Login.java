package application.login;

import application.createaccount.CreateAccount;
import application.dashboard.Dashboard;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class Login {
	
	public void show(Stage primaryStage) {
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			Button loginButton = (Button) scene.lookup("#loginButton");
			Button createAccountButton = (Button) scene.lookup("#createAccountButton");
			
			// TODO: Implement username and password checking
			loginButton.setOnAction(event -> {
                Dashboard dashboard = new Dashboard();
                dashboard.show(primaryStage);
            });
			
			createAccountButton.setOnAction(event -> {
                CreateAccount createAccount = new CreateAccount();
                createAccount.show(primaryStage);
            });
			
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}