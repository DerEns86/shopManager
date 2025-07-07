package dev.ens.werkzeugmanager.model;

import javafx.beans.property.*;

public class Machine extends Equipment {
    private final StringProperty machineType = new SimpleStringProperty();
    private final IntegerProperty powerKw = new SimpleIntegerProperty();
    private final StringProperty location = new SimpleStringProperty();

    public Machine(int id, String name, String manufacturer, String machineType, int powerKw, String location) {
        super(id, name, manufacturer);
        this.machineType.set(machineType);
        this.powerKw.set(powerKw);
        this.location.set(location);
    }

    public Machine(int id, String name, String manufacturer, String machineType) {
        this(id, name, manufacturer, machineType, 0, "");
    }

    public String getMachineType() { return machineType.get(); }
    public void setMachineType(String machineType) { this.machineType.set(machineType); }
    public StringProperty machineTypeProperty() { return machineType; }

    public int getPowerKw() { return powerKw.get(); }
    public void setPowerKw(int powerKw) { this.powerKw.set(powerKw); }
    public IntegerProperty powerKwProperty() { return powerKw; }

    public String getLocation() { return location.get(); }
    public void setLocation(String location) { this.location.set(location); }
    public StringProperty locationProperty() { return location; }

    @Override
    public String getDetails() {
        return "type: " + getMachineType() + ", powerKw: " + getPowerKw() + ", location: " + getLocation();
    }
}
