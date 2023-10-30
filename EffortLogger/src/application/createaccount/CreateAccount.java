package application.createaccount;

import application.login.Login;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;


public class CreateAccount {
	
	// TODO: Set up username and password database ("profiles.txt")
	public void show(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			Button signInButton = (Button) scene.lookup("#signInButton");
			
			signInButton.setOnAction(event -> {
                Login login = new Login();
                login.show(primaryStage);
            });
			

		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}