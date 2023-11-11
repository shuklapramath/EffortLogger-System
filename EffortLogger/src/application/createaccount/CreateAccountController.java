package application.createaccount;

import application.login.Login;
import dataclass.Account;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    	Account account = new Account();
    	String username = usernameTextField.getText();
    	String password = passwordTextField.getText();
    	String confirmPassword = confirmPasswordTextField.getText();
    	
    	// Check if username exists, implement username and password requirements, provide feedback for entries that don't meet requirements
    	if(InputValidator.sanitizeInput(username) || InputValidator.sanitizeInput(password) || InputValidator.sanitizeInput(confirmPassword)){
    		InputValidator.showAlert("Invalid Characters", "Only '@' and '_' are allowed.");
    		return;
    	}
    	
    	if(password.length() < 8)
    	{
    		InputValidator.showAlert("Invalid Input", "Length of password should be greater than 8 characters.");
    	}
        
     // Check for empty or invalid inputs
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || !password.equals(confirmPassword)) {
        	InputValidator.showAlert("Invalid Input", "Please check your input.");
            return;
        }
        
        if (Database.usernameExists(username)) {
        	InputValidator.showAlert("Username Exists", "Username already exists. Please choose a different username.");
            return;
        }
    	    		
    		account.setUsername(username);
    		account.setPassword(password);
    		Database.saveAccount(account);
    		
    		usernameTextField.setText("");
    		passwordTextField.setText("");
    		confirmPasswordTextField.setText("");
    }
    
    public class InputValidator {

        public static boolean sanitizeInput(String input) {
            if (input == null) {
                return false; // return empty string for null input
            }

            // Check for allowed characters, prompt for new input if other characters are detected
            if (!input.matches("[@_a-zA-Z0-9 ]*")) {
                
                return true;
            }

            return false;
        }

        private static void showAlert(String title, String content) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(content);
            alert.showAndWait();
        }
    }
}

