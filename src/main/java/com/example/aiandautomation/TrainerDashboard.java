package com.example.aiandautomation;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TrainerDashboard extends Application {

    @Override
    public void start(Stage stage) {
        Label welcomeLabel = new Label("Welcome, Trainer!");
        welcomeLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // Mock list of courses
        ListView<String> courseList = new ListView<>();
        courseList.getItems().addAll(
                "Advanced Java Programming",
                "Data Structures & Algorithms",
                "Cloud Computing Basics"
        );

        // Mock list of enrolled workers
        ListView<String> workerList = new ListView<>();
        workerList.getItems().addAll(
                "Alice - Java Programming",
                "Bob - Data Structures",
                "Charlie - Cloud Computing"
        );

        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> {
            Main app = new Main();
            try {
                app.start(stage); // Return to login
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        VBox coursesBox = new VBox(5, new Label("Your Courses:"), courseList);
        VBox enrolledBox = new VBox(5, new Label("Enrolled Workers:"), workerList);
        VBox layout = new VBox(15, welcomeLabel, coursesBox, enrolledBox, logoutBtn);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 400, 500);
        stage.setScene(scene);
        stage.setTitle("Trainer Dashboard");
        stage.show();
    }
}

