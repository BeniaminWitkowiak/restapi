package pl.edu.uam.restapi.edge.dao;

import pl.edu.uam.restapi.edge.model.Car;
import pl.edu.uam.restapi.edge.model.CarShowroom;

import java.util.List;

/**
 * Created by ben_a_000 on 2016-06-07.
 */
public class CarShowroomDao extends GenericDao<CarShowroom> {

    public CarShowroomDao() {
        super();
        this.save(new CarShowroom(11, "ul. Nowowiejskiego 11/7", "Volvo"));
        this.save(new CarShowroom(12, "os. Jana III Sobieskiego 125", "BMW"));
        this.save(new CarShowroom(13, "pl. Andersa", "Alfa Romeo"));
    }

    public CarShowroom getById(int id){
        for(CarShowroom c : this.objects){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }

    public void addCarShowroom(CarShowroom carShowroom){
        this.save(carShowroom);
    }

    public void deleteCarShowroom(int id){
        for(int i=0; i<objects.size(); i++){
            if (objects.get(i).getId() == id){
                objects.remove(i);
            }
        }
    }
    public int addCarToCarShowroom(Car car, int showroomId){
        int result = -1;
        for(CarShowroom c : this.objects){
            if(c.getId() == showroomId){

                if(c.getCarBrand().toLowerCase().equals(car.getBrand().toLowerCase())){
                    c.addCar(car);
                    result = 1;
                }else{
                    result = 0;
                }
            }
        }
        //if result - 1 then CarShowroom not found
        //IF result 0 THEN CarShowroom exists but brands do not match
        //IF result 1 THEN CarShowroom exists and brands match
        return result;
    }

    public int deleteCarFromCarshowroom(int carShowroomId, int carId){
        int result = -1;

        for(int i=0; i<objects.size(); i++){//szukamy odpowiedniego salonu
            if (objects.get(i).getId() == carShowroomId){//znalezlismy salon z ktoreog chcemy usunac samochod
                result = 0;
                List<Car> carsFromProperCarShowroom = objects.get(i).getCarsInCarShowroom();
                for(int j=0; j<carsFromProperCarShowroom.size(); j++){//szukamy w liscie wszystkich samochodow
                    if(carsFromProperCarShowroom.get(j).getId() == carId){//jesli znalezlismy nasz samochod
                        result = 1;
                        carsFromProperCarShowroom.remove(j);
                    }
                }
            }
        }
        // IF result -1 THEN carShowroon not found
        // IF result 0 THEN carshowroom found but car not found
        // IF result 1 THEN success ! ! !
        return result;
    }
}
