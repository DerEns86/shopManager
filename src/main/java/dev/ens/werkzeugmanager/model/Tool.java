package dev.ens.werkzeugmanager.model;

public class Tool extends Equipment {
    private String toolType;
    private double diameter;
    private int numberCuttingEdges;

    public Tool(String id, String name, String manufacturer, String toolType, double diameter, int numberCuttingEdges) {
        super(id, name, manufacturer);
        this.toolType = toolType;
        this.diameter = diameter;
        this.numberCuttingEdges = numberCuttingEdges;
    }

    public String getToolType() {
        return toolType;
    }

    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public int getNumberCuttingEdges() {
        return numberCuttingEdges;
    }

    public void setNumberCuttingEdges(int numberCuttingEdges) {
        this.numberCuttingEdges = numberCuttingEdges;
    }



    @Override
    public String getDetails() {
        return "type: " + toolType + ", diameter: " + diameter + "mm, numberOfCuttingEdges: " + numberCuttingEdges;
    }
}
