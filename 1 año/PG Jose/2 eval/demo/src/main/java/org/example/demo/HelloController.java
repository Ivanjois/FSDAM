package org.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {

    // La anotación @FXML inyecta el componente creado en el XML dentro de esta variable
    // ¡El nombre de la variable DEBE coincidir con el fx:id del XML!
    @FXML
    private Label welcomeText;

    // Método que se ejecutará cuando se dispare el evento onAction del botón
    @FXML
    protected void onHelloButtonClick() {
        // Modificamos el nodo visual desde Java
        welcomeText.setText("¡Bienvenido al mundo de JavaFX!");
    }
}