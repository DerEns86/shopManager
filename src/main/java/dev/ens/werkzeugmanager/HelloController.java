package dev.ens.werkzeugmanager;

import dev.ens.werkzeugmanager.model.Tool;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        Tool fraeser = new Tool("1", "Fräser1", "Goedde", "Fräser", 4.0, 4);
        welcomeText.setText(fraeser.getDetails());


    }
}