package com.example.aiandautomation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage; 

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    public List<User> users = new ArrayList<>(); // In-memory user store

    @Override
    public void start(Stage primaryStage) {
        showLoginScreen(primaryStage);
    }

    public void showLoginScreen(Stage stage) {
        Label title = new Label("Login");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        ComboBox<String> roleBox = new ComboBox<>();
        roleBox.getItems().addAll("Worker", "Trainer", "Employer");
        roleBox.setPromptText("Select Role");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Label message = new Label();

        Button loginBtn = new Button("Login");
        Button registerBtn = new Button("Register");

        VBox layout = new VBox(10, title, roleBox, usernameField, passwordField, loginBtn, registerBtn, message);
        layout.setStyle("-fx-padding: 20;");
        Scene scene = new Scene(layout, 300, 320);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();

        loginBtn.setOnAction(_ -> {
            String role = roleBox.getValue();
            String username = usernameField.getText();
            String password = passwordField.getText();

            User found = findUser(username, password, role);
            if (found != null) {
                switch (role) {
                    case "Worker":
                        new WorkerDashboard().start(stage);
                        break;
                    case "Trainer":
                        new TrainerDashboard().start(stage);
                        break;
                    case "Employer":
                        new EmployerDashboard().start(stage);
                        break;
                }
            } else {
                message.setText("Invalid credentials or role.");
            }
        });

        registerBtn.setOnAction(_ -> showRegisterScreen(stage));
    }

    public void showRegisterScreen(Stage stage) {
        Label title = new Label("Register");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        ComboBox<String> roleBox = new ComboBox<>();
        roleBox.getItems().addAll("Worker", "Trainer", "Employer");
        roleBox.setPromptText("Select Role");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Choose a Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Choose a Password");

        Label message = new Label();

        Button registerBtn = new Button("Register");
        Button backBtn = new Button("Back to Login");

        VBox layout = new VBox(10, title, roleBox, usernameField, passwordField, registerBtn, backBtn, message);
        layout.setStyle("-fx-padding: 20;");
        Scene scene = new Scene(layout, 300, 320);
        stage.setScene(scene);
        stage.setTitle("Register");

        registerBtn.setOnAction(_ -> {
            String role = roleBox.getValue();
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (username.isEmpty() || password.isEmpty() || role == null) {
                message.setText("All fields required.");
                return;
            }

            if (userExists(username)) {
                message.setText("Username already exists.");
            } else {
                users.add(new User(username, password, role));
                message.setText("Registration successful!");
            }
        });

        backBtn.setOnAction(_ -> showLoginScreen(stage));
    }

    public boolean userExists(String username) {
        return users.stream().anyMatch(u -> u.getUsername().equals(username));
    }

    public User findUser(String username, String password, String role) {
        return users.stream()
                .filter(u -> u.getUsername().equals(username)
                        && u.getPassword().equals(password)
                        && u.getRole().equals(role))
                .findFirst()
                .orElse(null);
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Inner User class for storing user data
    public static class User {
        public
        String username, password, role;

        public User(String username, String password, String role) {
            this.username = username;
            this.password = password;
            this.role = role;
        }

        public String getUsername() { return username; }

        public String getPassword() { return password; }

        public String getRole() { return role; }
    }
}