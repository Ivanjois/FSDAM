module org.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.example.demo to javafx.fxml;
    opens org.example.demo.controller to javafx.fxml;
    opens org.example.demo.model to javafx.base;

    exports org.example.demo;
}