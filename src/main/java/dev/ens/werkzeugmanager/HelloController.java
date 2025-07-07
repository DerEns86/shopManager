package dev.ens.werkzeugmanager;

import dev.ens.werkzeugmanager.db.DatabaseManager;
import dev.ens.werkzeugmanager.model.Tool;
import dev.ens.werkzeugmanager.model.Machine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.*;

public class HelloController {
    // Werkzeug-Felder
    @FXML private TextField toolNameField;
    @FXML private TextField toolTypeField;
    @FXML private TextField toolManufacturerField;
    @FXML private TextField toolDiameterField;
    @FXML private TextField toolNumberCuttingEdgesField;
    @FXML private TableView<Tool> toolTable;
    @FXML private TableColumn<Tool, String> toolNameColumn;
    @FXML private TableColumn<Tool, String> toolTypeColumn;
    @FXML private TableColumn<Tool, String> toolManufacturerColumn;
    @FXML private TableColumn<Tool, Double> toolDiameterColumn;
    @FXML private TableColumn<Tool, Integer> toolNumberCuttingEdgesColumn;

    // Maschinen-Felder
    @FXML private TextField machineNameField;
    @FXML private TextField machineTypeField;
    @FXML private TextField machineManufacturerField;
    @FXML private TextField machinePowerKwField;
    @FXML private TextField machineLocationField;
    @FXML private TableView<Machine> machineTable;
    @FXML private TableColumn<Machine, String> machineNameColumn;
    @FXML private TableColumn<Machine, String> machineTypeColumn;
    @FXML private TableColumn<Machine, String> machineManufacturerColumn;
    @FXML private TableColumn<Machine, Integer> machinePowerKwColumn;
    @FXML private TableColumn<Machine, String> machineLocationColumn;

    private final ObservableList<Tool> toolList = FXCollections.observableArrayList();
    private final ObservableList<Machine> machineList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Werkzeug-Tabellenbindung
        toolNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        toolTypeColumn.setCellValueFactory(cellData -> cellData.getValue().toolTypeProperty());
        toolManufacturerColumn.setCellValueFactory(cellData -> cellData.getValue().manufacturerProperty());
        toolDiameterColumn.setCellValueFactory(cellData -> cellData.getValue().diameterProperty().asObject());
        toolNumberCuttingEdgesColumn.setCellValueFactory(cellData -> cellData.getValue().numberCuttingEdgesProperty().asObject());
        toolTable.setItems(toolList);
        loadToolsFromDB();

        // Maschinen-Tabellenbindung
        machineNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        machineTypeColumn.setCellValueFactory(cellData -> cellData.getValue().machineTypeProperty());
        machineManufacturerColumn.setCellValueFactory(cellData -> cellData.getValue().manufacturerProperty());
        machinePowerKwColumn.setCellValueFactory(cellData -> cellData.getValue().powerKwProperty().asObject());
        machineLocationColumn.setCellValueFactory(cellData -> cellData.getValue().locationProperty());
        machineTable.setItems(machineList);
        loadMachinesFromDB();
    }

    @FXML
    protected void onAddToolClick() {
        String name = toolNameField.getText();
        String type = toolTypeField.getText();
        String manufacturer = toolManufacturerField.getText();
        double diameter = Double.parseDouble(toolDiameterField.getText());
        int numberCuttingEdges = Integer.parseInt(toolNumberCuttingEdgesField.getText());
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO tool (name, manufacturer, tool_type, diameter, number_cutting_edges) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, name);
            stmt.setString(2, manufacturer);
            stmt.setString(3, type);
            stmt.setDouble(4, diameter);
            stmt.setInt(5, numberCuttingEdges);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            int id = rs.next() ? rs.getInt(1) : -1;
            toolList.add(new Tool(id, name, manufacturer, type, diameter, numberCuttingEdges));
            toolNameField.clear(); toolTypeField.clear(); toolManufacturerField.clear(); toolDiameterField.clear(); toolNumberCuttingEdgesField.clear();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onAddMachineClick() {
        String name = machineNameField.getText();
        String type = machineTypeField.getText();
        String manufacturer = machineManufacturerField.getText();
        int powerKw = Integer.parseInt(machinePowerKwField.getText());
        String location = machineLocationField.getText();
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO machine (name, manufacturer, machine_type, power_kw, location) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, name);
            stmt.setString(2, manufacturer);
            stmt.setString(3, type);
            stmt.setInt(4, powerKw);
            stmt.setString(5, location);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            int id = rs.next() ? rs.getInt(1) : -1;
            machineList.add(new Machine(id, name, manufacturer, type, powerKw, location));
            machineNameField.clear(); machineTypeField.clear(); machineManufacturerField.clear(); machinePowerKwField.clear(); machineLocationField.clear();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadToolsFromDB() {
        toolList.clear();
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM tool")) {
            while (rs.next()) {
                toolList.add(new Tool(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("manufacturer"),
                        rs.getString("tool_type"),
                        rs.getDouble("diameter"),
                        rs.getInt("number_cutting_edges")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadMachinesFromDB() {
        machineList.clear();
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM machine")) {
            while (rs.next()) {
                machineList.add(new Machine(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("manufacturer"),
                        rs.getString("machine_type"),
                        rs.getInt("power_kw"),
                        rs.getString("location")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}