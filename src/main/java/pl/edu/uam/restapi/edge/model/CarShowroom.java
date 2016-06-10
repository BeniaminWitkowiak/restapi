package pl.edu.uam.restapi.edge.model;

import pl.edu.uam.restapi.edge.model.Car;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by ben_a_000 on 2016-06-06.
 */
public class CarShowroom {
    int id;
    String adress;
    String CarBrand;
    private List<Car> carsInCarShowroom = new ArrayList<>();
    //protected List<T> objects = new ArrayList<>();

    public CarShowroom(){
    }

    public CarShowroom(int id, String adress, String carBrand) {
        this.id = id;
        this.adress = adress;
        CarBrand = carBrand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarBrand() {
        return CarBrand;
    }

    public void setCarBrand(String carBrand) {
        CarBrand = carBrand;
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
