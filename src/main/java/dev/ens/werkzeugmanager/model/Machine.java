package dev.ens.werkzeugmanager.model;

public class Machine extends Equipment{
    private String machineType;
    private int powerKw;
    private String location;

    public Machine(String id, String name, String manufacturer, String machineType, int powerKw, String location) {
        super(id, name, manufacturer);
        this.machineType = machineType;
        this.powerKw = powerKw;
        this.location = location;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public int getPowerKw() {
        return powerKw;
    }

    public void setPowerKw(int powerKw) {
        this.powerKw = powerKw;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String getDetails() {
        return "type: " + machineType + ", powerKw: " + powerKw + ", location: " + location;
    }
}
