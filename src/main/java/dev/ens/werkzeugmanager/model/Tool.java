package dev.ens.werkzeugmanager.model;

import javafx.beans.property.*;

public class Tool extends Equipment {
    private final StringProperty toolType = new SimpleStringProperty();
    private final DoubleProperty diameter = new SimpleDoubleProperty();
    private final IntegerProperty numberCuttingEdges = new SimpleIntegerProperty();

    public Tool(int id, String name, String manufacturer, String toolType, double diameter, int numberCuttingEdges) {
        super(id, name, manufacturer);
        this.toolType.set(toolType);
        this.diameter.set(diameter);
        this.numberCuttingEdges.set(numberCuttingEdges);
    }

    public String getToolType() { return toolType.get(); }
    public void setToolType(String toolType) { this.toolType.set(toolType); }
    public StringProperty toolTypeProperty() { return toolType; }

    public double getDiameter() { return diameter.get(); }
    public void setDiameter(double diameter) { this.diameter.set(diameter); }
    public DoubleProperty diameterProperty() { return diameter; }

    public int getNumberCuttingEdges() { return numberCuttingEdges.get(); }
    public void setNumberCuttingEdges(int numberCuttingEdges) { this.numberCuttingEdges.set(numberCuttingEdges); }
    public IntegerProperty numberCuttingEdgesProperty() { return numberCuttingEdges; }

    @Override
    public String getDetails() {
        return "type: " + getToolType() + ", diameter: " + getDiameter() + "mm, numberOfCuttingEdges: " + getNumberCuttingEdges();
    }
}
