package core;

import java.util.Date;

public abstract class Product implements Item {
    private int serialNumber;
    private String name;
    private final Date manufacturedOn;
    private static int currentProductionNumber = 1;


    protected Product(String name) {
        this.name = name;
        this.serialNumber = currentProductionNumber++;
        this.manufacturedOn = new Date();
    }

    public void setProductionNumber(int productionNumber) {
        this.serialNumber = productionNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public String toString() {
        return "Manufacturer :" + MANUFACTURER + "\nSerial Number :" + serialNumber + "\nDate :" + manufacturedOn + "\nName :" + name;
    }
}
