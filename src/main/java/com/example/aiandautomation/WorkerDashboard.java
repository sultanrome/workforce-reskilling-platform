package com.example.aiandautomation;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class WorkerDashboard extends Application {

    @Override
    public void start(Stage stage) {
        Label welcomeLabel = new Label("Welcome, Worker!");
        welcomeLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // Mock list of training programs
        ListView<String> trainingList = new ListView<>();
        trainingList.getItems().addAll(
                "Java Basics - 4 Weeks",
                "Python for Data Science - 6 Weeks",
                "Cybersecurity Fundamentals - 5 Weeks"
        );

        // Mock list of job postings
        ListView<String> jobList = new ListView<>();
        jobList.getItems().addAll(
                "Junior Java Developer - TechCorp",
                "Data Analyst Intern - DataWise",
                "IT Support Assistant - NetSecure"
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

        VBox trainingBox = new VBox(5, new Label("Available Trainings:"), trainingList);
        VBox jobBox = new VBox(5, new Label("Job Postings:"), jobList);
        VBox layout = new VBox(15, welcomeLabel, trainingBox, jobBox, logoutBtn);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 400, 500);
        stage.setScene(scene);
        stage.setTitle("Worker Dashboard");
        stage.show();
    }
}
