package application.createaccount;

import application.login.Login;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.Database;

public class CreateAccountController {
    @FXML private Button signInButton;
    @FXML private Button createAccountButton;
    @FXML private TextField usernameTextField;
    @FXML private TextField passwordTextField;
    @FXML private TextField confirmPasswordTextField;

    @FXML
    private void initialize() {
    	setupSignInButton();
    }
    
    @FXML
    private void setupSignInButton() {
        signInButton.setOnAction(event -> {
            Login login = new Login();
            login.show((Stage) signInButton.getScene().getWindow());
        });
    }
    
    @FXML
    private void createAccount() {
    	String username = usernameTextField.getText();
    	String password = passwordTextField.getText();
    	String confirmPassword = confirmPasswordTextField.getText();
    	
    	// TODO: check if username exists, implement username and password requirements, provide feedback for entries that don't meet requirements
    	if (username != null &&
    		password != null && 
    		confirmPassword != null && 
    		!username.isEmpty() && 
    		!password.isEmpty() && 
    		!confirmPassword.isEmpty() && 
    		password.equals(confirmPassword)) {
    		
    		Database.saveAccount(username, password);
    		
    		usernameTextField.setText("");
    		passwordTextField.setText("");
    		confirmPasswordTextField.setText("");
    	}
    }
}

