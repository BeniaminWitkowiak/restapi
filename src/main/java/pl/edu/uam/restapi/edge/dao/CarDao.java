package pl.edu.uam.restapi.edge.dao;

import pl.edu.uam.restapi.edge.model.Brand;
import pl.edu.uam.restapi.edge.model.Car;
import pl.edu.uam.restapi.edge.model.EngineType;

/**
 * Created by ben_a_000 on 2016-06-07.
 */
public class CarDao extends GenericDao<Car> {


    public CarDao() {
        super();
        this.save(new Car(1, Brand.OPEL, "Corsa", EngineType.Pb, 1.0, 5.1, 2001));
        this.save(new Car(2, Brand.OPEL, "Omega", EngineType.Pb, 2.5, 9.3, 2003));
        this.save(new Car(3, Brand.OPEL, "Zafira", EngineType.ON, 2.2, 5.5, 2003));

        this.save(new Car(4, Brand.RENAULT, "Laguna", EngineType.Pb, 2.0, 7.5, 2004));
        this.save(new Car(5, Brand.RENAULT, "Megane", EngineType.Pb, 1.6, 6.5, 2002));
        this.save(new Car(6, Brand.RENAULT, "Clio", EngineType.ON, 1.2, 5.1, 2007));
    }

    public Car getById(int id) {
        return this.objects.stream().filter(car -> car.getId()==id).findFirst().orElse(null);
    }

}

