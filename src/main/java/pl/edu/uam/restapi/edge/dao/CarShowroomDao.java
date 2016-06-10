package pl.edu.uam.restapi.edge.dao;

import pl.edu.uam.restapi.edge.model.Car;
import pl.edu.uam.restapi.edge.model.CarShowroom;

/**
 * Created by ben_a_000 on 2016-06-07.
 */
public class CarShowroomDao extends GenericDao<CarShowroom> {

    public CarShowroomDao() {
        super();
        this.save(new CarShowroom(11, "ul. Nowowiejskiego 11/7", "Volvo"));
        this.save(new CarShowroom(12, "os. Jana III Sobieskiego 125", "BMW"));
        this.save(new CarShowroom(13, "pl. Andersa", "Alfa Romeo, Fiat"));
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

    public void addCarToCarShowroom(Car car){
        //int result = -1;
        for(CarShowroom c : this.objects){
            if(c.getId() == 11){
                c.addCar(car);
               // result = 1;
            }
        }
        //if result - 1 then CarShowroom not found
       // return result;
    }
}
