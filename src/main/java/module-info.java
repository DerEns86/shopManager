module dev.ens.werkzeugmanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens dev.ens.werkzeugmanager to javafx.fxml;
    exports dev.ens.werkzeugmanager;
}