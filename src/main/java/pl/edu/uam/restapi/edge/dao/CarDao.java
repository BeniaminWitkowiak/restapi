package pl.edu.uam.restapi.edge.dao;

import pl.edu.uam.restapi.edge.model.Car;

/**
 * Created by ben_a_000 on 2016-06-07.
 */
public class CarDao extends GenericDao<Car> {

    public enum brand{
        AUDI, VOLKSWAGEN, BMW, SEAT, SKODA, OPEL, RENAULT, VOLVO, FIAT
    }

    public CarDao() {
        super();
        this.save(new Car(1, brand.AUDI, "Corsa", "Pb", 1.0, 5.1, 2001));
        this.save(new Car(2, "Opel", "Omega", "Pb", 2.5, 9.3, 2003));
        this.save(new Car(3, "Opel", "Zafira", "ON", 2.2, 5.5, 2003));

        this.save(new Car(4, "Reanult", "Laguna", "Pb", 2.0, 7.5, 2004));
        this.save(new Car(5, "Reanult", "Megane", "Pb", 1.6, 6.5, 2002));
        this.save(new Car(6, "Renault", "Clio", "Pb", 1.2, 5.1, 2007));
    }

    public Car getById(int id){
        for(Car c : this.objects){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }
}
