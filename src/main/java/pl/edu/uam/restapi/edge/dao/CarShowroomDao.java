package pl.edu.uam.restapi.edge.dao;

import pl.edu.uam.restapi.edge.excepction.CustomNotFoundException;
import pl.edu.uam.restapi.edge.model.Brand;
import pl.edu.uam.restapi.edge.model.Car;
import pl.edu.uam.restapi.edge.model.CarShowroom;

import java.util.List;

/**
 * Created by ben_a_000 on 2016-06-07.
 */
public class CarShowroomDao extends GenericDao<CarShowroom> {

    public CarShowroomDao() {
        super();
        this.save(new CarShowroom(11, "ul. Nowowiejskiego 11/7", Brand.AUDI));
        this.save(new CarShowroom(12, "os. Jana III Sobieskiego 125", Brand.BMW));
        this.save(new CarShowroom(13, "pl. Andersa", Brand.FIAT));
    }

    public CarShowroom getById(int id){
        return this.objects.stream().filter(carShowroom -> carShowroom.getId() == id).findFirst().orElse(null);
    }

    public CarShowroom addCarShowroom(CarShowroom carShowroom){
        this.save(carShowroom);
        return carShowroom;
    }

    public void deleteCarShowroom(int id){
        for(int i=0; i<objects.size(); i++){
            if (objects.get(i).getId() == id){
                objects.remove(i);
            }
        }
    }
    public void addCarToCarShowroom(Car car, int showroomId) {
        CarShowroom carShowroom = this.getById(showroomId);
        if (carShowroom == null) {
            throw new CustomNotFoundException(0, "There is no carShowroom with id"+showroomId);
        }

        if(carShowroom.getCarBrand() != car.getBrand()){
            //inny error lepiej
            throw new CustomNotFoundException(0, "The car showroom brand '" + carShowroom.getCarBrand() + "' does not match car barnd '" + car.getBrand() + "'");
        }

        carShowroom.addCar(car);
    }

    public CarShowroom deleteCarFromCarshowroom(int carShowroomId, int carId) {
        CarShowroom carShowroom = this.getById(carShowroomId);

        if (carShowroom == null) {
            throw new CustomNotFoundException(0, "There is no carShowroom with id" + carShowroomId);
        }

        List<Car> carsInCarShowroom = carShowroom.getCarsInCarShowroom();
        for(int j = 0; j< carsInCarShowroom.size(); j++) {//szukamy w liscie wszystkich samochodow
            if (carsInCarShowroom.get(j).getId() == carId) {//jesli znalezlismy nasz samochod
                carsInCarShowroom.remove(j);
            }
        }
        return carShowroom;
    }
}
