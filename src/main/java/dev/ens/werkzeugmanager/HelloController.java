package dev.ens.werkzeugmanager;

import dev.ens.werkzeugmanager.db.DatabaseManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HelloController {
    @FXML
    private Label werkzeugText;
    @FXML
    private Label maschinenText;

    @FXML
    protected void onWerkzeugButtonClick() {
    //    Tool fraeser = new Tool("1", "Fräser1", "Goedde", "Fräser", 4.0, 4);
    //    werkzeugText.setText(fraeser.getDetails());

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO tool (name, manufacturer, tool_type, diameter, number_cutting_edges) VALUES (?, ?, ?, ?, ?)")) {
            stmt.setString(1, "Fräser1");
            stmt.setString(2, "Goedde");
            stmt.setString(3, "Fräser");
            stmt.setDouble(4, 4.0);
            stmt.setInt(5, 4);
            stmt.executeUpdate();
            werkzeugText.setText("Werkzeug hinzugefügt");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onMaschinenButtonClick() {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DatabaseManager.getConnection();
            stmt = conn.prepareStatement(
                    "INSERT INTO machine (name, manufacturer, machine_type, power_kw, location) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, "Multus B300");
            stmt.setString(2, "Okuma");
            stmt.setString(3, "Mill-Turn");
            stmt.setInt(4, 50);
            stmt.setString(5, "Werk 1");
            stmt.executeUpdate();


            maschinenText.setText("Maschine hinzugefügt");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}