package application.createaccount;

import application.login.Login;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CreateAccountController {
    @FXML private Button signInButton;

    @FXML
    private void initialize() {
    	setupSignInButton();
    	// call functions here
    }
    
    @FXML
    private void setupSignInButton() {
        signInButton.setOnAction(event -> {
            Login login = new Login();
            login.show((Stage) signInButton.getScene().getWindow());
        });
    }
    
    // create additional functionality
}

