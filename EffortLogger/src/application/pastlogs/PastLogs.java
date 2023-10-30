package application.pastlogs;

import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import util.Database;

public class PastLogs {

    public void show(Stage primaryStage) {

        VBox mainLayout = new VBox(15);
        mainLayout.setPadding(new Insets(20));

        Label lblTitle = new Label("Past Logs");
        lblTitle.setStyle("-fx-font-size: 24px;");
        mainLayout.getChildren().add(lblTitle);

        ComboBox<String> cbLogs = new ComboBox<>();
        cbLogs.setPromptText("Select Log to View");
        
        List<String> dates = Database.getAllDates();
        cbLogs.getItems().addAll(dates);
        
        mainLayout.getChildren().add(cbLogs);

        Button btnViewLog = new Button("View Log");
        Button btnReturnDashboard = new Button("Return to Dashboard");
        mainLayout.getChildren().addAll(btnViewLog, btnReturnDashboard);

        Label lblStartTime = new Label("Start Time: ");
        Label lblStopTime = new Label("Stop Time: ");
        Label lblTotalTime = new Label("Total Time: ");
        Label lblProjectCategory = new Label("Project Category: ");
        Label lblEffortCategory = new Label("Effort Category: ");
        mainLayout.getChildren().addAll(lblStartTime, lblStopTime, lblTotalTime, lblProjectCategory, lblEffortCategory);
        
        btnViewLog.setOnAction(e -> {
            String selectedLog = cbLogs.getValue();
            if (selectedLog != null && !selectedLog.isEmpty()) {
                String[] logDetails = Database.get(selectedLog).split(",");

                lblStartTime.setText("Start Time: " + logDetails[0]);
                lblStopTime.setText("Stop Time: " + logDetails[1]);
                lblTotalTime.setText("Total Time: " + logDetails[2].toUpperCase());
                lblProjectCategory.setText("Project Category: " + logDetails[3].toUpperCase());
                lblEffortCategory.setText("Effort Category: " + logDetails[4].toUpperCase());
            }
        });

        Scene scene = new Scene(mainLayout, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Past Logs");
        primaryStage.show();
    }

}
