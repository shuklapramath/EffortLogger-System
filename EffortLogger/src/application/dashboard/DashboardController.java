package application.dashboard;

import application.login.Login;
import application.newlog.NewLog;
import application.pastlogs.PastLogs;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DashboardController {
	@FXML private Button newLogButton;
	@FXML private Button pastLogsButton;
	@FXML private Button logOutButton;

	@FXML
    private void initialize() {
    	setupNewLogButton();
    	setupPastLogsButton();
    	logOutButton();
    	// call functions here
    }
    
    @FXML
    private void setupNewLogButton() {
    	newLogButton.setOnAction(event -> {
            NewLog newLog = new NewLog();
            newLog.show((Stage) newLogButton.getScene().getWindow());
        });
    }
    
    @FXML
    private void setupPastLogsButton() {
    	pastLogsButton.setOnAction(event -> {
            PastLogs pastLogs = new PastLogs();
            pastLogs.show((Stage) pastLogsButton.getScene().getWindow());
        });
    }
    
    @FXML
    private void logOutButton() {
    	logOutButton.setOnAction(event -> {
            Login login = new Login();
            login.show((Stage) logOutButton.getScene().getWindow());
        });
    }
    
    // create additional functionality
}
