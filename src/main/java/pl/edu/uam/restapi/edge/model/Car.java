package pl.edu.uam.restapi.edge.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by ben_a_000 on 2016-06-06.
 */
@XmlRootElement
public class Car implements Serializable {
    private int id;
    private String brand;
    private String model;
    private String engineType;
    private double engineSize;
    private double consumption;
    private int productionDate;


    public Car(){
    }

    public Car(int id, String brand, String model, String engineType, double engineSize, double consumption, int productionDate) {
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
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
