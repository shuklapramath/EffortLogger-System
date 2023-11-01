package application.login;

import application.createaccount.CreateAccount;
import application.dashboard.Dashboard;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginController {
	@FXML private Button loginButton;
	@FXML private Button createAccountButton;

	@FXML
    private void initialize() {
    	setupLoginButton();
    	setupCreateAccountButton();
    	// call functions here
    }
    
    @FXML
    private void setupLoginButton() {
    	loginButton.setOnAction(event -> {
            Dashboard dashboard = new Dashboard();
            dashboard.show((Stage) loginButton.getScene().getWindow());
        });
    }
    
    @FXML
    private void setupCreateAccountButton() {
    	createAccountButton.setOnAction(event -> {
            CreateAccount createAccount = new CreateAccount();
            createAccount.show((Stage) createAccountButton.getScene().getWindow());
        });
    }
}
