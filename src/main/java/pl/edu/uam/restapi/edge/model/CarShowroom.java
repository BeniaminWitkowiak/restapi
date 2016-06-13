package pl.edu.uam.restapi.edge.model;

import java.util.*;
import java.util.List;

/**
 * Created by ben_a_000 on 2016-06-06.
 */
public class CarShowroom {
    int id;
    private String adress;
    private Brand carBrand;
    private List<Car> carsInCarShowroom = new ArrayList<>();
    //protected List<T> objects = new ArrayList<>();

    public CarShowroom(){
    }

    public CarShowroom(int id, String adress, Brand carBrand) {
        this.id = id;
        this.adress = adress;
        this.carBrand = carBrand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Brand getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(Brand carBrand) {
        this.carBrand = carBrand;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getNumberOfCars() {
        return carsInCarShowroom.size();
    }

    public List<Car> getCarsInCarShowroom() {
        return carsInCarShowroom;
    }
    public Car getCar(int position){
        return carsInCarShowroom.get(position);
    }

    public void addCar(Car car){
        carsInCarShowroom.add(car);
    }


}
