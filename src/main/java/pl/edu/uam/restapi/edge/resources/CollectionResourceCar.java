package pl.edu.uam.restapi.edge.resources;

import pl.edu.uam.restapi.edge.model.Car;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Created by ben_a_000 on 2016-06-07.
 */
public class CollectionResourceCar {
    private int count;
    private List<Car> result;

    public CollectionResourceCar(List<Car> result) {
        this.result = result;
        this.count = result.size();
    }

    public List<Car> getResult() {
        return result;
    }

    public void setResult(List<Car> result) {
        this.result = result;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
