package application.newlog;

import application.dashboard.Dashboard;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class NewLogController {
	@FXML private Button dashboardButton;

	@FXML
    private void initialize() {
    	setupDashboardButton();
    	// call functions here
    }
    
	private void setupDashboardButton() {
    	dashboardButton.setOnAction(event -> {
            Dashboard dashboard = new Dashboard();
            dashboard.show((Stage) dashboardButton.getScene().getWindow());
        });
    }
}
