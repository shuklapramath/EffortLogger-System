package application.editlog;

import application.pastlogs.PastLogs;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EditLogController {
	@FXML private Button cancelButton;
	
	@FXML
    public void initialize() {
        setupCancelButton();
    }

	@FXML
    private void setupCancelButton() {
    	cancelButton.setOnAction(event -> {
            PastLogs pastLogs = new PastLogs();
            pastLogs.show((Stage) cancelButton.getScene().getWindow());
        });
    }

}
