package pl.edu.uam.restapi.edge.model;

import jdk.internal.dynalink.support.AutoDiscovery;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;



/**
 * Created by ben_a_000 on 2016-06-06.
 */
@XmlRootElement
public class Car implements Serializable {
    private int id;
    private Brand brand;
    private String model;
    private EngineType engineType;
    private double engineSize;
    private double consumption;
    private int productionDate;


    public Car(){
    }

    public Car(int id, Brand brand, String model, EngineType engineType, double engineSize, double consumption, int productionDate) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.engineType = engineType;
        this.engineSize = engineSize;
        this.consumption = consumption;
        this.productionDate = productionDate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public int getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(int productionDate) {
        this.productionDate = productionDate;
    }
}
