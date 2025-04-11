package com.example.aiandautomation;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class EmployerDashboard extends Application {

    @Override
    public void start(Stage stage) {
        Label welcomeLabel = new Label("Welcome, Employer!");
        welcomeLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // Mock job postings
        ListView<String> jobPostings = new ListView<>();
        jobPostings.getItems().addAll(
                "Software Developer - Full Time",
                "Data Analyst - Internship",
                "DevOps Engineer - Remote"
        );

        // Mock applicants
        ListView<String> applicants = new ListView<>();
        applicants.getItems().addAll(
                "Alice applied for Software Developer",
                "Bob applied for Data Analyst",
                "Charlie applied for DevOps Engineer"
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

        VBox jobBox = new VBox(5, new Label("Your Job Postings:"), jobPostings);
        VBox applicantBox = new VBox(5, new Label("Applicants:"), applicants);
        VBox layout = new VBox(15, welcomeLabel, jobBox, applicantBox, logoutBtn);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 400, 500);
        stage.setScene(scene);
        stage.setTitle("Employer Dashboard");
        stage.show();
    }
}

