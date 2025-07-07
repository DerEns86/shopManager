module dev.ens.werkzeugmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens dev.ens.werkzeugmanager to javafx.fxml;
    opens dev.ens.werkzeugmanager.model to javafx.base;
    exports dev.ens.werkzeugmanager;
}