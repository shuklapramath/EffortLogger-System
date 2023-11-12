package application.definitions;

import application.dashboard.Dashboard;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DefinitionsController {
    @FXML private Button dashboardButton;
    @FXML private ChoiceBox<String> typeChoiceBox;
    @FXML private TextField nameTextField; // Reference to the TextField
    @FXML private Button saveButton; // Reference to the Save button

    @FXML
    private void initialize() {
        setupDashboardButton();
        populateTypeChoiceBox();
        setupSaveButton(); // Setup the Save button
    }

    private void setupDashboardButton() {
        dashboardButton.setOnAction(event -> {
            Dashboard dashboard = new Dashboard();
            dashboard.show((Stage) dashboardButton.getScene().getWindow());
        });
    }

    private void populateTypeChoiceBox() {
        typeChoiceBox.getItems().addAll("Lifecycle Setup", "Project Name");
    }

    private void setupSaveButton() {
        saveButton.setOnAction(event -> {
            saveToDefinitionsFile();
        });
    }

    private void saveToDefinitionsFile() {
        String selectedType = typeChoiceBox.getValue();
        String name = nameTextField.getText();

        String relativePath = "src/database/Definitions.txt";
        File file = new File(relativePath);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(selectedType + ": " + name);
            writer.newLine();

            // Show the alert after successful save
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Save Successful");
            alert.setHeaderText(null);
            alert.setContentText("Saved Successfully");
            alert.showAndWait();
        } catch (IOException e) {
            e.printStackTrace(); // Handle exceptions appropriately
        }
    }
}
