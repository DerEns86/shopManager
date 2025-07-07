package dev.ens.werkzeugmanager.model;

import javafx.beans.property.*;

public abstract class Equipment {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty manufacturer = new SimpleStringProperty();
    private final BooleanProperty available = new SimpleBooleanProperty(true);

    public Equipment(int id, String name, String manufacturer) {
        this.id.set(id);
        this.name.set(name);
        this.manufacturer.set(manufacturer);
    }

    public int getId() { return id.get(); }
    public void setId(int id) { this.id.set(id); }
    public IntegerProperty idProperty() { return id; }

    public String getName() { return name.get(); }
    public void setName(String name) { this.name.set(name); }
    public StringProperty nameProperty() { return name; }

    public String getManufacturer() { return manufacturer.get(); }
    public void setManufacturer(String manufacturer) { this.manufacturer.set(manufacturer); }
    public StringProperty manufacturerProperty() { return manufacturer; }

    public boolean isAvailable() { return available.get(); }
    public void setAvailable(boolean available) { this.available.set(available); }
    public BooleanProperty availableProperty() { return available; }

    @Override
    public String toString() {
        return "equipment{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", available=" + isAvailable() +
                '}';
    }

    public abstract String getDetails();
}
