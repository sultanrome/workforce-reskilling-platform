module com.example.aiandautomation {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.aiandautomation to javafx.fxml;
    exports com.example.aiandautomation;
}