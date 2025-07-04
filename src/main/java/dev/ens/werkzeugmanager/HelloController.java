package dev.ens.werkzeugmanager;

import dev.ens.werkzeugmanager.model.Machine;
import dev.ens.werkzeugmanager.model.Tool;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label werkzeugText;
    @FXML
    private Label maschinenText;

    @FXML
    protected void onWerkzeugButtonClick() {
        Tool fraeser = new Tool("1", "Fräser1", "Goedde", "Fräser", 4.0, 4);
        werkzeugText.setText(fraeser.getDetails());

    }

    @FXML
    protected void onMaschinenButtonClick() {
        Machine maschine1 = new Machine("1","Multus B300", "Okuma", "Mill-Turn", 50, "Werk 1");
        maschinenText.setText(maschine1.getDetails());
    }
}